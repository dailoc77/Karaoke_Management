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
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

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

import DAO.QLPH_DAO;
import DAO.TinhTien_DAO;
import Entity.PhieuDatPhong;
import Entity.Phong;
import connectDB.connectDB;
import testbutton.Buttontest;

public class GD_TraPhong extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private testbutton.Buttontest btnthuephong, btnhuyphong;

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
            java.util.logging.Logger.getLogger(GD_TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_TraPhong frame = new GD_TraPhong();
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
	public GD_TraPhong (){
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Giao Diện Trả Phòng");
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		connectDB.getInstance().connect();
		loadData();
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
				GD_ThuePhong gdthuephong = new GD_ThuePhong();
				gdthuephong.setVisible(true);
				dispose();
			}
		});
        btnthuephong.setBorder(null);
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(Color.WHITE);
        btnthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthuephong.setBackground(new Color(0,0,0, 150));
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
			}
		});
        btntstTrPhng.setBorder(null);
        btntstTrPhng.setText("Trả Phòng");
        btntstTrPhng.setForeground(Color.WHITE);
        btntstTrPhng.setFont(new Font("Tahoma", Font.BOLD, 20));
        btntstTrPhng.setBackground(new Color(128, 128, 128, 150));
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
		
		JLabel lb_hinhnen = new JLabel("");
		lb_hinhnen.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/370.png")));
		lb_hinhnen.setBounds(-40, -176, 1333, 957);
		contentPane.add(lb_hinhnen);
		
	}
	
	private void loadData() {
		QLPH_DAO ds = new QLPH_DAO();
		ArrayList<Phong> listPhong = ds.docbang();
		draw(listPhong);
	}
	
	private void draw(ArrayList<Phong> listph) {
		JPanel pnl_danhsachphonghat = new JPanel();
		pnl_danhsachphonghat.setBorder(null);
		pnl_danhsachphonghat.setBackground(new Color(255, 255, 255, 150));
		pnl_danhsachphonghat.setBounds(0, 148, 1161, 465);
		pnl_danhsachphonghat.setLayout(null);
		contentPane.add(pnl_danhsachphonghat);
		
		JScrollPane scrollPane_DSPH = new JScrollPane();
		scrollPane_DSPH.setBounds(149, 0, 871, 465);
		scrollPane_DSPH.setBackground(new Color(255, 255, 255, 0));
		pnl_danhsachphonghat.add(scrollPane_DSPH);
		
		JPanel panel_dsph = new JPanel();
		panel_dsph.setBackground(new Color(255, 255, 255));
		scrollPane_DSPH.setViewportView(panel_dsph);
		panel_dsph.setLayout(new GridLayout(0, 5, -50, 0));
    	for(Phong ph : listph) {
    		if(ph.getTrangThaiPhong().getMaTrangThai().equals("TTP001")) {
    			//load label cha
        		JPanel pn_phonghat = new JPanel();
        		pn_phonghat.setBackground(new Color(255, 255, 255, 0));

//        		pn_phonghat.setBorder(LineBorder.createBlackLineBorder());
        		pn_phonghat.setLayout(null);
        		pn_phonghat.setPreferredSize(new Dimension(200,200));
        		panel_dsph.add(pn_phonghat);
    //
//        		
//        		//load suc chua
        		JLabel lbl_succhua = new JLabel("Sức chứa : " + ph.getSoNguoi());
        		lbl_succhua.setHorizontalAlignment(SwingConstants.CENTER);
        		lbl_succhua.setFont(new Font("Tahoma", Font.BOLD, 11));
        		lbl_succhua.setForeground(new Color(255,0,0));
        		lbl_succhua.setBounds(55, 130, 80, 35);
        		pn_phonghat.add(lbl_succhua);
        		
        		//load ten phong
        		JLabel lbl_tenphong = new JLabel(ph.getTenPhong());
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
        			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro_gray.png")));
        		}else {
        			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro_crown_gray.png")));
        		} 
        		
        		JPanel pnl_chuaNutTraPhong = new JPanel();
        		pnl_chuaNutTraPhong.setBackground(new Color(255,255,255));
        		pnl_chuaNutTraPhong.setBounds(50, 180, 100, 40);
        		pn_phonghat.add(pnl_chuaNutTraPhong);
        		
        		 pn_phonghat.addMouseListener(new MouseAdapter() {
        			 JButton btnTraPhong = new JButton("Trả phòng");
        	            @Override
        	            public void mouseEntered(MouseEvent e) {
        	            	btnTraPhong.setBounds(50, 180, 100, 25);
        	            	btnTraPhong.setBackground(new Color(255,0,0,70));
        	            	btnTraPhong.setForeground(new Color(255,255,255));
        	                btnTraPhong.setVisible(true);
        	                pnl_chuaNutTraPhong.add(btnTraPhong);
        	                
        	            }
        	            
        	            @Override
        	            public void mouseClicked(MouseEvent e) {
        	            	GD_TinhTien gd_tinhtien = new GD_TinhTien();
        	            	TinhTien_DAO dsPDP = new TinhTien_DAO();
        	            	ArrayList<PhieuDatPhong> pdps = dsPDP.docbang();
        	            	for(PhieuDatPhong pdp : pdps) {
        	            		gd_tinhtien.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	            	gd_tinhtien.setVisible(true);
            	            	gd_tinhtien.lbl_sdtKH.setText(pdp.getSdtKH().getSDT());
            	            	gd_tinhtien.lbl_tenKH.setText(pdp.getTenKH().getTenKH());
            	            	gd_tinhtien.lbl_tenNV.setText(pdp.getTenNV().getTenNV());
            	            	gd_tinhtien.lbl_gioNhanPhong.setText(pdp.getThoiGianNhanPhong());
            	            	gd_tinhtien.lbl_tenPhongTT.setText("TÍNH TIỀN : "+ ph.getTenPhong());
            					dispose();
        	            	}
        	            	
        	            	
        	            }

        	            @Override
        	            public void mouseExited(MouseEvent e) {
        	            	pnl_chuaNutTraPhong.add(btnTraPhong);
        	                btnTraPhong.setVisible(false);
        	            }
        	     });
    		}
    		
    	}
	}
	
	private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         GD_Main_NV mainnv=new GD_Main_NV();
         mainnv.setVisible(true);
    }
//	
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
}
