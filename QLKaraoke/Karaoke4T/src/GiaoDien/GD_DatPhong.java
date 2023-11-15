package GiaoDien;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.*;
import Entity.*;
import connectDB.connectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class GD_DatPhong extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
            java.util.logging.Logger.getLogger(GD_DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DatPhong frame = new GD_DatPhong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GD_DatPhong() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		setTitle("Giao Diện Đặt Phòng");
		
		contentPane = new JPanel();
		connectDB.getInstance().connect();
		loadData();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblquanly = new JLabel("NV:");
		lblquanly.setForeground(Color.WHITE);
		lblquanly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblquanly.setBounds(878, -20, 232, 80);
		contentPane.add(lblquanly);
		
		JLabel lbltenql = new JLabel();
		lbltenql.setForeground(Color.WHITE);
		lbltenql.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltenql.setBounds(833, 6, 232, 80);
		lbltenql.setText(UserInfo.getTenNhanVien());
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
		
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_Main_QL.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
		
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
        
        
        textField = new JTextField();
        textField.setBounds(25, 55, 236, 25);
        pnl_thongtinkhachhang.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Tên Khách Hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(27, 24, 107, 33);
        pnl_thongtinkhachhang.add(lblNewLabel);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
        rdbtnNewRadioButton.setBounds(25, 98, 109, 23);
        rdbtnNewRadioButton.setOpaque(false);
		rdbtnNewRadioButton.setContentAreaFilled(false);
		rdbtnNewRadioButton.setFocusPainted(false);
        pnl_thongtinkhachhang.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
        rdbtnNewRadioButton_1.setBounds(152, 98, 109, 23);
        rdbtnNewRadioButton_1.setOpaque(false);
        pnl_thongtinkhachhang.add(rdbtnNewRadioButton_1);
        
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);
		pnl_thongtinkhachhang.add(rdbtnNewRadioButton);pnl_thongtinkhachhang.add(rdbtnNewRadioButton_1);
        
        JLabel lblNewLabel_1 = new JLabel("Số Điện Thoại");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(25, 128, 93, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(25, 153, 236, 25);
        pnl_thongtinkhachhang.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(25, 214, 236, 25);
        pnl_thongtinkhachhang.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(25, 275, 236, 25);
        pnl_thongtinkhachhang.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("CMND");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(25, 189, 60, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(25, 250, 60, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_3);
        
        testbutton.Buttontest btnDatPhong = new testbutton.Buttontest();
        btnDatPhong.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnDatPhong.setText("Đặt Phòng");
        btnDatPhong.setForeground(new Color(245,245,245));
        btnDatPhong.setBackground(new Color(90, 167, 167));
        btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnDatPhong.setRippleColor(new Color(255, 255, 255));
        btnDatPhong.setShadowColor(new Color(0,0,0));
        btnDatPhong.setBounds(25, 410, 109, 43);
        pnl_thongtinkhachhang.add(btnDatPhong);
        
        btnDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_PhieuDatPhong phieuDatPhong = new GD_PhieuDatPhong();
				phieuDatPhong.setVisible(true);
				phieuDatPhong.setLocationRelativeTo(null);
	            dispose();
			}
		});
        
        testbutton.Buttontest btnHuyDatPhong = new testbutton.Buttontest();
        btnHuyDatPhong.setText("Hủy Đặt");
        btnHuyDatPhong.setForeground(new Color(245,245,245));
        btnHuyDatPhong.setBackground(new Color(255, 85, 85));
        btnHuyDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHuyDatPhong.setBounds(168, 410, 109, 43);
        btnHuyDatPhong.setRippleColor(new Color(255, 255, 255));
        btnHuyDatPhong.setShadowColor(new Color(0,0,0));
        pnl_thongtinkhachhang.add(btnHuyDatPhong);
        
        JLabel lblNewLabel_11 = new JLabel("Số lượng người :");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_11.setBounds(25, 311, 109, 21);
        pnl_thongtinkhachhang.add(lblNewLabel_11);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(152, 311, 109, 25);
        pnl_thongtinkhachhang.add(textField_4);
        
        JLabel lbGioNhanPhong = new JLabel("Giờ nhận phòng hát");
        lbGioNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbGioNhanPhong.setBounds(25, 348, 151, 21);
        pnl_thongtinkhachhang.add(lbGioNhanPhong);
        
        String gio[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
        JComboBox comboBoxGio = new JComboBox<String>(gio);
        comboBoxGio.setBounds(25, 377, 80, 22);
        pnl_thongtinkhachhang.add(comboBoxGio);
        
        String[] phut = IntStream.rangeClosed(0, 60)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        JComboBox comboBoxPhutNhanPhong = new JComboBox<>(phut);
        comboBoxPhutNhanPhong.setBounds(152, 377, 69, 22);
        pnl_thongtinkhachhang.add(comboBoxPhutNhanPhong);
        
        JLabel lblNewLabel_5 = new JLabel("Giờ");
        lblNewLabel_5.setBounds(115, 380, 25, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_5);
        
        JLabel lblNewLabel_5_1 = new JLabel("Phút");
        lblNewLabel_5_1.setBounds(231, 381, 49, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_5_1);
		
        testbutton.Buttontest btndatphong1 = new testbutton.Buttontest();
        btndatphong1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
        btndatphong1.setBorder(null);
        btndatphong1.setText("Đặt Phòng");
        btndatphong1.setForeground(Color.WHITE);
        btndatphong1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatphong1.setBackground(new Color(128,128,128, 150));
        btndatphong1.setBounds(0, 70, 199, 87);
		contentPane.add(btndatphong1);
		btndatphong1.setLayout(null);
		
		//Danh sach phong hat
        
        testbutton.Buttontest btnthuephong = new testbutton.Buttontest();
        btnthuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_ThuePhong gdthuephong = new GD_ThuePhong();
				gdthuephong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdthuephong.setVisible(true);
				dispose();
			}
		});
        btnthuephong.setBorder(null);
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(Color.WHITE);
        btnthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthuephong.setBackground(new Color(0, 0, 0, 150));
        btnthuephong.setBounds(195, 70, 196, 87);
		contentPane.add(btnthuephong);
		btnthuephong.setLayout(null);
		
        testbutton.Buttontest btndatdichvu = new testbutton.Buttontest();
        btndatdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatDichVu gddatdv = new GD_DatDichVu();
				gddatdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gddatdv.setVisible(true);
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
				GD_QuanLyKhachHang gdkhachhang = new GD_QuanLyKhachHang();
				gdkhachhang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdkhachhang.setVisible(true);
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
		
		JLabel lb_hinhnen = new JLabel("");
		lb_hinhnen.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/370.png")));
		lb_hinhnen.setBounds(-40, -176, 1333, 957);
		contentPane.add(lb_hinhnen);
		
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
//
//    		
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
    		lbl_hinhanh.setBorder(LineBorder.createBlackLineBorder());
    		
    		//phan loai phong
    		if(ph.getLoaiPhong().getTenLoaiPhong().equals("Phòng Thường")) {
    			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro.png")));
    		}else {
    			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro_with_crown.png")));
    		}
    	}
	}
}