package GiaoDien;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.QLKH_DAO;
import DAO.QLPH_DAO;
import Entity.KhachHang;
import Entity.Phong;
import connectDB.connectDB;
import testbutton.Buttontest;

public class GD_ThuePhong extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	
	private JTextField textFieldTenKhach;
	private JTextField textFieldSDT;
	private JTextField textFieldCMND;
	private JTextField textFieldDiaChi;
	private JTextField textFieldSoLuongNguoi;
	
	private String soLuongNguoi;
	private String trangThaiPhong;
	private  JRadioButton rdbtnNAM,rdbtnNU;
	private boolean isSelected = false;
	private testbutton.Buttontest btnthuephong, btnhuyphong;
	
	private String maPhong,tenKH,sdt,cmnd,diaChi,songuoi;
	private float giaTien;
	
	private long lastClickTime = 0;
	
	private List<Phong> phongList = new ArrayList<Phong>();
	QLPH_DAO ds = new QLPH_DAO();
	QLKH_DAO dskh = new QLKH_DAO();
	JPanel pnl_danhsachphonghat = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GD_ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThuePhong frame = new GD_ThuePhong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//
	/**
	 * Create the frame.
	 */
	public GD_ThuePhong (){
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Giao Diện Thuê Phòng");
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		connectDB.getInstance().connect();
		loadData();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//		 Ho tro -----------------------
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://thach1311.github.io/huongDan/").toURI());
				}
				catch(Exception ex){}
			}
		});
		
		
				
		btnNewButton.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/iconHoTro.png")));
		btnNewButton.setBounds(304, 10, 49, 50);
		contentPane.add(btnNewButton);
		
//		------------------------------------------
		JLabel lblquanly = new JLabel("NV:");
		lblquanly.setForeground(Color.WHITE);
		lblquanly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblquanly.setBounds(878, -20, 232, 80);
		contentPane.add(lblquanly);
		
		JLabel lbltenql = new JLabel("Nguyễn Văn C");
		lbltenql.setForeground(Color.WHITE);
		lbltenql.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltenql.setBounds(833, 6, 232, 80);
		contentPane.add(lbltenql);
		
		JButton jButton = new JButton("Đăng Xuất");
		jButton.setBounds(980, 13, 135, 42);
		jButton.setFont(new Font("Tahoma ", Font.BOLD, 14));
		jButton.setBackground(new Color(255, 0, 0));
		jButton.setForeground(Color.WHITE);
		
		jButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
        jButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
        jButton.setContentAreaFilled(false);
        jButton.setFocusPainted(false);
        jButton.setOpaque(true);
		contentPane.add(jButton);

		jButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        jButton.setBackground(Color.BLACK);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        jButton.setBackground(new Color(255, 0, 0));
		    }
		});

		jButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            GD_Login lg = new GD_Login();
		            lg.setVisible(true);
		            lg.setLocationRelativeTo(null);
		            dispose();
		        }
		    }
		});
		
		JPanel box_clock = new JPanel();
        box_clock.setBackground(new Color(255, 255, 255));
        box_clock.setBounds(34, 10, 260, 50);
        contentPane.add(box_clock);
        box_clock.setLayout(null);

        lblClock = new JLabel();
        lblClock.setHorizontalAlignment(SwingConstants.CENTER);
        lblClock.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblClock.setBounds(10, 0, 240, 50);
        lblClock.setForeground(Color.BLACK);
        box_clock.add(lblClock);

        timer = new Timer(0,this);
        timer.start();
        
        //Giao dien thong tin khach hang`
        JPanel pnl_thongtinkhachhang = new JPanel() {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        pnl_thongtinkhachhang.setOpaque(false);
        pnl_thongtinkhachhang.setBackground(new Color(255, 255, 255, 200));
        pnl_thongtinkhachhang.setBounds(0, 148, 329, 463);
        contentPane.add(pnl_thongtinkhachhang);
        pnl_thongtinkhachhang.setLayout(null);
        
        textFieldTenKhach = new JTextField();
        textFieldTenKhach.setBounds(25, 55, 236, 25);
        pnl_thongtinkhachhang.add(textFieldTenKhach);
        textFieldTenKhach.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Tên Khách Hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(27, 24, 107, 33);
        pnl_thongtinkhachhang.add(lblNewLabel);
        
        // rad button
        rdbtnNAM = new JRadioButton("Nam");
        rdbtnNAM.setBounds(25, 115, 109, 23);
        rdbtnNAM.setOpaque(false);
		rdbtnNAM.setContentAreaFilled(false);
		rdbtnNAM.setFocusPainted(false);
        pnl_thongtinkhachhang.add(rdbtnNAM);
        
        rdbtnNU = new JRadioButton("Nữ");
        rdbtnNU.setBounds(152, 115, 109, 23);
        rdbtnNU.setOpaque(false);
        pnl_thongtinkhachhang.add(rdbtnNU);
        
        ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNAM);bg.add(rdbtnNU);
		pnl_thongtinkhachhang.add(rdbtnNAM);pnl_thongtinkhachhang.add(rdbtnNU);
		// rad button
		 
        JLabel lblNewLabel_1 = new JLabel("Số Điện Thoại");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(25, 171, 93, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_1);
        
        textFieldSDT = new JTextField();
        textFieldSDT.setBounds(25, 187, 236, 25);
        pnl_thongtinkhachhang.add(textFieldSDT);
        textFieldSDT.setColumns(10);
        
        textFieldCMND = new JTextField();
        textFieldCMND.setBounds(25, 238, 236, 25);
        pnl_thongtinkhachhang.add(textFieldCMND);
        textFieldCMND.setColumns(10);
        
        textFieldDiaChi = new JTextField();
        textFieldDiaChi.setBounds(25, 291, 236, 25);
        pnl_thongtinkhachhang.add(textFieldDiaChi);
        textFieldDiaChi.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("CMND");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(25, 219, 60, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(25, 274, 60, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_3);
        
        JLabel lblNewLabel_11 = new JLabel("Số lượng người :");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_11.setBounds(25, 333, 109, 21);
        pnl_thongtinkhachhang.add(lblNewLabel_11);
        
        textFieldSoLuongNguoi = new JTextField();
        textFieldSoLuongNguoi.setColumns(10);
        textFieldSoLuongNguoi.setBounds(150, 332, 111, 25);
        pnl_thongtinkhachhang.add(textFieldSoLuongNguoi);
               
        
        //button thue phong
        btnthuephong = new testbutton.Buttontest();
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(new Color(245,245,245));
        btnthuephong.setBackground(new Color(90, 167, 167));
        btnthuephong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnthuephong.setRippleColor(new Color(255, 255, 255));
        btnthuephong.setShadowColor(new Color(0,0,0));
        btnthuephong.setBounds(25, 410, 109, 43);
        pnl_thongtinkhachhang.add(btnthuephong);
        
        btnthuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_PhieuDatPhong phieuDatPhong = new GD_PhieuDatPhong();
				phieuDatPhong.setVisible(true);
				phieuDatPhong.setLocationRelativeTo(null);
				
				phieuDatPhong.loadPhieuDatPhongTuDuLieuNhap(maPhong, tenKH, sdt, cmnd, diaChi, songuoi, giaTien);
	            dispose();
	            
			}
		});
        // button huy thue phong
        btnhuyphong = new testbutton.Buttontest();
        btnhuyphong.setText("Hủy Phòng");
        btnhuyphong.setForeground(new Color(245,245,245));
        btnhuyphong.setBackground(new Color(255, 85, 85));
        btnhuyphong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnhuyphong.setBounds(168, 410, 109, 43);
        btnhuyphong.setRippleColor(new Color(255, 255, 255));
        btnhuyphong.setShadowColor(new Color(0,0,0));
        pnl_thongtinkhachhang.add(btnhuyphong);
        
		
        testbutton.Buttontest btndatphong1 = new testbutton.Buttontest();
        btndatphong1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatPhong gddatphong = new GD_DatPhong();
				gddatphong.setVisible(true);
				dispose();
			}
		});
        btndatphong1.setBorder(null);
        btndatphong1.setText("Đặt Phòng");
        btndatphong1.setForeground(Color.WHITE);
        btndatphong1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatphong1.setBackground(new Color(0,0,0, 150));
        btndatphong1.setBounds(0, 70, 199, 87);
		contentPane.add(btndatphong1);
		btndatphong1.setLayout(null);
		

        testbutton.Buttontest btnthuephong = new testbutton.Buttontest();
        btnthuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
        btnthuephong.setBorder(null);
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(Color.WHITE);
        btnthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthuephong.setBackground(new Color(128,128,128, 150));
        btnthuephong.setBounds(195, 70, 196, 87);
		contentPane.add(btnthuephong);
		btnthuephong.setLayout(null);
		
		testbutton.Buttontest btndatdichvu = new testbutton.Buttontest();
        btndatdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatDichVu gddv = new GD_DatDichVu();
				gddv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gddv.setVisible(true);
				dispose();
			}
		});
        btndatdichvu.setBorder(null);
        btndatdichvu.setText("Đặt Dịch Vụ");
        btndatdichvu.setForeground(Color.WHITE);
        btndatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatdichvu.setBackground(new Color(0, 0, 0, 150));
        btndatdichvu.setBounds(385, 70, 196, 87);
		contentPane.add(btndatdichvu);
		btndatdichvu.setLayout(null);
		
		testbutton.Buttontest btntstTrPhng = new testbutton.Buttontest();
        btntstTrPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_TraPhong gdtraphong = new GD_TraPhong();
				gdtraphong.setVisible(true);
				dispose();
			}
		});
        btntstTrPhng.setBorder(null);
        btntstTrPhng.setText("Trả Phòng");
        btntstTrPhng.setForeground(Color.WHITE);
        btntstTrPhng.setFont(new Font("Tahoma", Font.BOLD, 20));
        btntstTrPhng.setBackground(new Color(0,0,0, 150));
        btntstTrPhng.setBounds(577, 70, 196, 87);
        contentPane.add(btntstTrPhng);
        btntstTrPhng.setLayout(null);
		
        testbutton.Buttontest btnkhachhang = new testbutton.Buttontest();
        btnkhachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_QuanLyKhachHang gdqlykhachhang = new GD_QuanLyKhachHang();
				gdqlykhachhang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdqlykhachhang.setVisible(true);
				dispose();
			}
		});
        btnkhachhang.setBorder(null);
        btnkhachhang.setText("Khách Hàng");
        btnkhachhang.setForeground(Color.WHITE);
        btnkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnkhachhang.setBackground(new Color(0, 0, 0, 150));
        btnkhachhang.setBounds(770, 70, 196, 87);
		contentPane.add(btnkhachhang);
		btnkhachhang.setLayout(null);
		
		testbutton.Buttontest btnthongke = new testbutton.Buttontest();
        btnthongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_ThongKeKhachHang thongkekhachhang = new GD_ThongKeKhachHang();
				thongkekhachhang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				thongkekhachhang.setVisible(true);
				dispose();
			}
		});
        btnthongke.setBorder(null);
        btnthongke.setText("Thống Kê");
        btnthongke.setForeground(Color.WHITE);
        btnthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthongke.setBackground(new Color(0, 0, 0, 150));
        btnthongke.setBounds(963, 70, 196, 87);
		contentPane.add(btnthongke);
		btnthongke.setLayout(null);
		
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_Main_QL.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
		
		JLabel lb_hinhnen = new JLabel("");
		lb_hinhnen.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/370.png")));
		lb_hinhnen.setBounds(-40, -176, 1333, 957);
		contentPane.add(lb_hinhnen);
		
//		String ten = textFieldTenKhach.getText();
//		String sdt = textFieldDiaChi.getText();
//		String cccd = textFieldCMND.getText();
//		String dch = textFieldDiaChi.getText();
		tenKH = textFieldTenKhach.getText();
		System.out.print(maPhong+tenKH+sdt+cmnd+diaChi+songuoi);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
            // Cập nhật thời gian
            updateClock();
        }
	}
    private void updateClock() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        
        String ampm;
        if (hour >= 12) {
            ampm = "PM";
            if (hour > 24) {
                hour -= 12;
            }
        } else {
            ampm = "AM";
            if (hour == 0) {
                hour = 12;
            }
        }
        
        String time = String.format("%02d:%02d:%02d %s  %04d/%02d/%02d", hour, minute, second, ampm, year, month, day);
        lblClock.setText(time);
	}
    
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         GD_Main_NV mainnv=new GD_Main_NV();
         mainnv.setVisible(true);
    }
    private void loadData() {
		QLPH_DAO ds = new QLPH_DAO();
		ArrayList<Phong> listPhong = ds.docbang();
		draw(listPhong);
	}
	
	private void draw(ArrayList<Phong> listph) {
		JPanel Right_QL_PHONG = new JPanel();
		Right_QL_PHONG.setBorder(null);
		Right_QL_PHONG.setBackground(new Color(255, 255, 255, 150));
		Right_QL_PHONG.setBounds(328, 148, 833, 465);
		Right_QL_PHONG.setLayout(null);
		contentPane.add(Right_QL_PHONG);
		
		JScrollPane scrollPane_DSPH = new JScrollPane();
		scrollPane_DSPH.setBounds(0, 0, 833, 465);
		scrollPane_DSPH.setBackground(new Color(255, 255, 255, 0));
		Right_QL_PHONG.add(scrollPane_DSPH);
		
		JPanel panel_dsph = new JPanel();
		panel_dsph.setBackground(new Color(255, 255, 255));
		scrollPane_DSPH.setViewportView(panel_dsph);
		panel_dsph.setLayout(new GridLayout(0, 5, -50, 0));
    	for(Phong ph : listph) {
    		//load label cha
    		JPanel pn_phonghat = new JPanel();
    		pn_phonghat.setBackground(new Color(255, 255, 255, 0));

//    		pn_phonghat.setBorder(LineBorder.createBlackLineBorder());
    		pn_phonghat.setLayout(null);
    		pn_phonghat.setPreferredSize(new Dimension(200,200));
    		panel_dsph.add(pn_phonghat);

//    		//load suc chua
    		JLabel lbl_succhua = new JLabel("Sức chứa : " + ph.getSoNguoi());
    		lbl_succhua.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_succhua.setFont(new Font("Tahoma", Font.BOLD, 11));
    		lbl_succhua.setForeground(new Color(255,0,0));
    		lbl_succhua.setBounds(55, 130, 80, 35);
    		pn_phonghat.add(lbl_succhua);
    		
    		//load ten phong
    		JLabel lbl_tenphong = new JLabel(ph.getMaPhong());
    		lbl_tenphong.setFont(new Font("Tahoma", Font.BOLD, 13));
    		lbl_tenphong.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_tenphong.setBounds(55, 145, 80, 35);
    		pn_phonghat.add(lbl_tenphong);
    		
    		//load hinh anh
    		JLabel lbl_hinhanh = new JLabel("");
    		lbl_hinhanh.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_hinhanh.setBounds(50, 50, 88, 85);
    		pn_phonghat.add(lbl_hinhanh);
    		
    		LineBorder labelBorder = new LineBorder(Color.BLACK, 5);
	        lbl_hinhanh.setBorder(labelBorder);
    		lbl_hinhanh.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseExited(MouseEvent e) {				
				}
				
				@Override
<<<<<<< Updated upstream
				public void mouseEntered(MouseEvent e) {		
=======
				public void mouseEntered(MouseEvent e) {
					
>>>>>>> Stashed changes
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					maPhong =  ph.getMaPhong();
					tenKH = textFieldTenKhach.getText();
					sdt = textFieldSDT.getText();
					cmnd = textFieldCMND.getText();
					diaChi = textFieldDiaChi.getText();
					songuoi = textFieldSoLuongNguoi.getText();
//					System.out.print(maPhong);
					
					if (ph.getLoaiPhong().getTenLoaiPhong().equals("Phòng Thường")) {
						giaTien = 100000;
					}
					else {
						giaTien = 180000;
					}
					String gt = "";
					if(rdbtnNAM.isSelected()) {
						gt = "Nam";
					}
					if(rdbtnNU.isSelected()) {
						gt = "Nu";
					}
					
					 btnthemActionPerformed(tenKH,sdt,cmnd,diaChi,gt);
//					btnthemActionPerformed(tenKH,sdt,cmnd,diaChi,gt);
					
//					System.out.print(giaTien);
//					System.out.print("GDThue"+maPhong);

					isSelected = !isSelected;
					 if (isSelected) {
					        LineBorder labelBorder = new LineBorder(Color.RED, 5);
					        lbl_hinhanh.setBorder(labelBorder);
					    } else {
					    	 	LineBorder labelBorder = new LineBorder(Color.BLACK, 5);
						        lbl_hinhanh.setBorder(labelBorder);
					    }	
<<<<<<< Updated upstream
=======
				            
					
					 
					 
					  long clickTime = System.currentTimeMillis();

	                    if (clickTime - lastClickTime <= 500) { // Check if the click interval is less than 500 milliseconds (adjust as needed)
	                    	 GD_ChiTietPhong chitiet = new GD_ChiTietPhong();
	                    	 chitiet.setVisible(true);
	                    	 chitiet.setLocationRelativeTo(null);
	                    	 System.out.print(maPhong);
	                    	 chitiet.loadChiTietPhong(maPhong);
	     		            dispose();
	     		            
	     		           btnthemActionPerformed(tenKH,sdt,cmnd,diaChi,gt);
	                    }

	                    lastClickTime = clickTime;
					 
>>>>>>> Stashed changes
				}
			}); 
    
    		//phan loai phong
    		if(ph.getLoaiPhong().getTenLoaiPhong().equals("Phòng Thường")) {
    			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro.png")));
    		}
    		
    		else {
    			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro_with_crown.png")));
    		}
    		
    		
    	}
    	

	}
	
	
	
	public void loadTrangThai(String trangthai) {

        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "select maTTP from TrangThaiPhong";
            
            
            PreparedStatement statement = connection.prepareStatement(sql);
       
            ResultSet resultSet = statement.executeQuery();
            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName1 = resultSet.getString("maTTP");
                trangthai = columnName1;
//                System.out.print(trangthai);
            }
           
    		
            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	protected void btnthemActionPerformed(String ten,String sdt,String cccd,String dch,String gt) {
	  
		 // Các biến dữ liệu đã được khai báo ở trên

        // Thực hiện kết nối đến cơ sở dữ liệu
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T"; // Thay đổi URL kết nối tùy thuộc vào loại cơ sở dữ liệu bạn đang sử dụng
        String username = "sa";
        String password = "123";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Chuẩn bị câu lệnh SQL để chèn dữ liệu
            String sql = "INSERT INTO KhachHang (maKH,gioiTinh,tenKH,SDT,CMND,diaChi) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            	 int maxMaKH = dskh.getMaxMaKH();
 			     maxMaKH++;
 			    			
	 			JTextField matxt = new JTextField();
	 			matxt.setText("KHAA" + String.format("%03d", maxMaKH));
	 			String ma = matxt.getText().toString();
			
			
				
                preparedStatement.setString(1, ma);
                preparedStatement.setString(2, gt);
                preparedStatement.setString(3, ten);
                preparedStatement.setString(4, sdt);
                preparedStatement.setString(5, cccd);
                preparedStatement.setString(6, dch);

                // Thực hiện câu lệnh SQL chèn dữ liệu
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Dữ liệu đã được chèn thành công!");
                } else {
                    System.out.println("Có lỗi xảy ra khi chèn dữ liệu.");
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
	
	}
		
}
