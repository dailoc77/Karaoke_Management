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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import Entity.UserInfo;
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
	
	private String soLuongNguoi,phone,ktraPhone,duLieu;
	private String trangThaiPhong;
	private  JRadioButton rdbtnNAM,rdbtnNU;
	private boolean isSelected = false;
	private testbutton.Buttontest btnthuephong, btnhuyphong;
	
	private String maPhong,tenKH,sdt,cmnd,diaChi,songuoi;
	private float giaTien;
	
	private long lastClickTime = 0;
	
	private String maKhachHang;
	
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
		
//		--------------------------- MAN HINH----------------------------
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
		
		
//		---------------------------------HO TRO -----------------------
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
		
//		-----------------------------------MENU--------------------------------------------------
		
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
//  --------------------------------------------------------------------------
        
        //-----------------LEFT 
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
        textFieldTenKhach.setEditable(false);
        textFieldTenKhach.setEnabled(false);
        textFieldTenKhach.setBounds(25, 55, 236, 25);
        pnl_thongtinkhachhang.add(textFieldTenKhach);
        textFieldTenKhach.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Tên Khách Hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(27, 24, 107, 33);
        pnl_thongtinkhachhang.add(lblNewLabel);
        
        // rad button
        rdbtnNAM = new JRadioButton("Nam");
        rdbtnNAM.setEnabled(false);
        rdbtnNAM.setBounds(25, 115, 109, 23);
        rdbtnNAM.setOpaque(false);
		rdbtnNAM.setContentAreaFilled(false);
		rdbtnNAM.setFocusPainted(false);
        pnl_thongtinkhachhang.add(rdbtnNAM);
        
        rdbtnNU = new JRadioButton("Nữ");
        rdbtnNU.setEnabled(false);
        rdbtnNU.setBounds(152, 115, 109, 23);
        rdbtnNU.setOpaque(false);
        pnl_thongtinkhachhang.add(rdbtnNU);
        
        ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNAM);bg.add(rdbtnNU);
		pnl_thongtinkhachhang.add(rdbtnNAM);pnl_thongtinkhachhang.add(rdbtnNU);
		// rad button
		 
        JLabel lblNewLabel_1 = new JLabel("Số điện thoại");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(25, 163, 93, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_1);
        
        textFieldSDT = new JTextField();
        textFieldSDT.setBounds(25, 187, 236, 25);
        textFieldSDT.setColumns(10);
<<<<<<< Updated upstream
=======
        pnl_thongtinkhachhang.add(textFieldSDT);
>>>>>>> Stashed changes
        textFieldSDT.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				if(textFieldSDT.getText().equals("")) {
					textFieldTenKhach.setText("");
					textFieldCMND.setText("");
					textFieldDiaChi.setText("");
				}
				else {
					String a = "";
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
<<<<<<< Updated upstream
=======

        JButton btnTimKiemSDT = new JButton("");
        btnTimKiemSDT.setIcon(new ImageIcon(GD_ThuePhong.class.getResource("/Imgs/search.png")));
        btnTimKiemSDT.setBounds(271, 187, 53, 25);
        pnl_thongtinkhachhang.add(btnTimKiemSDT);
        btnTimKiemSDT.addMouseListener(new MouseListener() {
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
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				System.out.print(ktraPhone);
				phone = textFieldSDT.getText();
				if (phone.matches("^0[1-9]\\d{8}$") == false) {
					  JOptionPane.showMessageDialog(null, "Số điện thoại di động bắt đầu bằng 09 cuối cùng là 7 chữ số.");
				  }
				else
				{
//					
					  timSoDienThoai(phone);
					  if (textFieldTenKhach.getText().equals("")) {
						  JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng vui lòng thêm khách hàng");
						  GD_QuanLyKhachHang kh = new GD_QuanLyKhachHang();
						  	kh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						  	kh.setVisible(true);
							dispose();
					  }
					  else {
						  JOptionPane.showMessageDialog(null, "Tìm thấy khách hàng ");

					  }
				}
			}
		});
		
        
>>>>>>> Stashed changes
        
        textFieldCMND = new JTextField();
        textFieldCMND.setEditable(false);
        textFieldCMND.setEnabled(false);
        textFieldCMND.setBounds(25, 238, 236, 25);
        pnl_thongtinkhachhang.add(textFieldCMND);
        textFieldCMND.setColumns(10);
        
        textFieldDiaChi = new JTextField();
        textFieldDiaChi.setEditable(false);
        textFieldDiaChi.setEnabled(false);
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
        textFieldSoLuongNguoi.setEnabled(false);
        textFieldSoLuongNguoi.setColumns(10);
        textFieldSoLuongNguoi.setBounds(150, 332, 111, 25);
        pnl_thongtinkhachhang.add(textFieldSoLuongNguoi);
<<<<<<< Updated upstream
        
        textFieldSoLuongNguoi.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
=======
>>>>>>> Stashed changes
        
        
//        BUTTON THUE PHONG
        btnthuephong = new testbutton.Buttontest();      
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(new Color(245,245,245));
        btnthuephong.setBackground(new Color(90, 167, 167));
        btnthuephong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnthuephong.setRippleColor(new Color(255, 255, 255));
        btnthuephong.setShadowColor(new Color(0,0,0));
<<<<<<< Updated upstream
        btnthuephong.setBounds(25, 410, 109, 43);
        btnthuephong.setEnabled(false);
        btnthuephong.addActionListener(new ActionListener() {
        	
        	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnthemActionPerformed();
			}
        });
			
        
        pnl_thongtinkhachhang.add(btnthuephong);
        // button huy thue phong
=======
        btnthuephong.setBounds(25, 410, 109, 43);       
        btnthuephong.setEnabled(false);
        btnthuephong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tenKH = textFieldTenKhach.getText();
				if (tenKH.equals("")) {
					JOptionPane.showMessageDialog(null,"Lỗi thuê vì không có thông tin khách hàng");
				}
				else {
					
					loadPhieuDatPhong(e);
					LocalDateTime currentDateTime = LocalDateTime.now();
					
					// Định dạng ngày giờ theo ý muốn
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					
					// Chuyển đổi thành chuỗi
					String formattedDateTime = currentDateTime.format(formatter);
					
					// In ra màn hình
					System.out.println("Ngày giờ hiện tại: " + formattedDateTime);
					System.out.print(maKhachHang);
					System.out.print(maPhong);
					taoPhieuDatPhong(formattedDateTime,maKhachHang,maPhong);
				}
				
				
			}
        });
        
        pnl_thongtinkhachhang.add(btnthuephong);
        
//-------------------------------------------------------------------------
        
// ------------------------------------------button huy thue phong 
        
>>>>>>> Stashed changes
        btnhuyphong = new testbutton.Buttontest();
        btnhuyphong.setText("Hủy Phòng");
        btnhuyphong.setForeground(new Color(245,245,245));
        btnhuyphong.setBackground(new Color(255, 85, 85));
        btnhuyphong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnhuyphong.setRippleColor(new Color(255, 255, 255));
        btnhuyphong.setShadowColor(new Color(0,0,0));
        btnhuyphong.setBounds(168, 410, 109, 43);
        btnhuyphong.setEnabled(false);       
        btnhuyphong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Huy ma kh : " + maKhachHang);
				// TODO Auto-generated method stubc
				tenKH = textFieldTenKhach.getText();
				if (tenKH.equals("")) {
					JOptionPane.showMessageDialog(null,"Không có thông tin khách hàng muốn hủy phòng hát");
				}
				else {
					xoaPhieuDatPhong(maKhachHang,maPhong);
					capNhatTrangThaiBanThanhTrong(maPhong);
					JOptionPane.showMessageDialog(null,"Hủy phòng hát thành công");
				}
			}
		});
        pnl_thongtinkhachhang.add(btnhuyphong);
        
<<<<<<< Updated upstream
        JButton btnTimKiemSDT = new JButton("");
        btnTimKiemSDT.setIcon(new ImageIcon(GD_ThuePhong.class.getResource("/Imgs/search.jpg")));
        btnTimKiemSDT.setBounds(271, 187, 53, 25);
        pnl_thongtinkhachhang.add(btnTimKiemSDT);
        
        
        
        btnTimKiemSDT.addMouseListener(new MouseListener() {
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
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				if(textFieldSDT.getText().equals("")) {
					textFieldTenKhach.setText("");
					textFieldCMND.setText("");
					textFieldDiaChi.setText("");
					rdbtnNAM.setVisible(false);
					rdbtnNU.setVisible(false);
				}
				else {
					String a = "";
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				System.out.print(ktraPhone);
				phone = textFieldSDT.getText();
				if (phone.matches("^0[1-9]\\d{8}$") == false) {
					  JOptionPane.showMessageDialog(null, "Số điện thoại di động bắt đầu bằng 09 cuối cùng là 7 chữ số.");
				  }
				else
				{
//					
					  timSoDienThoai(phone);
					  if (textFieldTenKhach.getText().equals("")) {
						  JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng vui lòng thêm khách hàng");
						  GD_QuanLyKhachHang kh = new GD_QuanLyKhachHang();
						  	kh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						  	kh.setVisible(true);
							dispose();
					  }
					  else {
						  JOptionPane.showMessageDialog(null, "Tìm thấy khách hàng ");

					  }
				}
			}
		});
		

        
        
=======

        
//        -----------------------------------------MENU-------------------------------------------------------
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		
//		JLabel lblavatar = new JLabel("");
//		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
//		lblavatar.setIcon(new ImageIcon(GD_Main_QL.class.getResource("/Imgs/t1 1.png")));
//		lblavatar.setBounds(90, -444, 1333, 957);
//		contentPane.add(lblavatar);
=======

>>>>>>> Stashed changes
		
		JLabel lb_hinhnen = new JLabel("");
		lb_hinhnen.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/370.png")));
		lb_hinhnen.setBounds(-40, -182, 1333, 957);
		contentPane.add(lb_hinhnen);
//----------------------------------------------------------------------------------------------------------		
		
<<<<<<< Updated upstream
//		String ten = textFieldTenKhach.getText();
//		String sdt = textFieldDiaChi.getText();
//		String cccd = textFieldCMND.getText();
//		String dch = textFieldDiaChi.getText();
//		tenKH = textFieldTenKhach.getText();
//		System.out.print(maPhong+tenKH+sdt+cmnd+diaChi+songuoi);
		
=======
>>>>>>> Stashed changes
		
	}
	
//	--------------------------------------HAM XU LY ----------------------------------------------------------------------
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
    
    
//   LOAD DATA 
    private void loadData() {
    	
		QLPH_DAO ds = new QLPH_DAO();
		ArrayList<Phong> listPhong = ds.docbang();
		draw(listPhong);
	}
	
    
// LOAD DANH SACH PHONG HAT
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
    		
    		
<<<<<<< Updated upstream
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
=======
    		
//    		DANH SACH PHONG BAN
    		if (ph.getTrangThaiPhong().getMaTrangThai().equals("TTP001")) {
	
	        		//load hinh anh
	        		JLabel lbl_hinhanh = new JLabel("");
	        		lbl_hinhanh.setHorizontalAlignment(SwingConstants.CENTER);
	        		lbl_hinhanh.setBounds(50, 50, 88, 85);
	        		pn_phonghat.add(lbl_hinhanh);
	        		
	        		LineBorder labelBorder = new LineBorder(Color.BLACK, 5);
	    	        lbl_hinhanh.setBorder(labelBorder);
	        		lbl_hinhanh.addMouseListener(new MouseListener() {
	    				
	        			    				
	    				@Override
	    				public void mouseClicked(MouseEvent e) {
	    					// TODO Auto-generated method stub
	    					maPhong =  ph.getMaPhong();
	    					tenKH = textFieldTenKhach.getText();
	    					sdt = textFieldSDT.getText();
	    					cmnd = textFieldCMND.getText();
	    					diaChi = textFieldDiaChi.getText();
	    					songuoi = textFieldSoLuongNguoi.getText();
	
	    					btnthuephong.setEnabled(false);
	    					btnhuyphong.setEnabled(true);       
	    					
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
	    					
	    					
	    					
	
	    					isSelected = !isSelected;
	    					if (isSelected) {
	    					    LineBorder labelBorder = new LineBorder(Color.RED, 5);
	    					    lbl_hinhanh.setBorder(labelBorder);
	
	    					    String duLieu = textFieldSoLuongNguoi.getText().trim();
	
	    					    if (!duLieu.isEmpty()) {
	    					        try {
	    					            int soLuongNguoi = Integer.parseInt(duLieu);
	    					            if (soLuongNguoi > Integer.parseInt(ph.getSoNguoi())) {
	    					                JOptionPane.showMessageDialog(null, "Số lượng người vượt mức cho phép");
	    					            } else {
	    					            	JOptionPane.showMessageDialog(null, "Số lượng người phù hợp");
	    					            }
	    					        } catch (NumberFormatException e1) {
	//    					            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
	    					        }
	    					    } else {
	//    					        JOptionPane.showMessageDialog(null, "Input is empty. Please enter a valid number.");
	    					    }
	    					} else {
	    					    LineBorder labelBorder = new LineBorder(Color.BLACK, 5);
	    					    lbl_hinhanh.setBorder(labelBorder);
	    					}
	
	
	    				            
	    					
	    					 
	    					 
	    					  long clickTime = System.currentTimeMillis();
	
	    	                    if (clickTime - lastClickTime <= 500) { // Check if the click interval is less than 500 milliseconds (adjust as needed)
//	    	                    	phone = textFieldSDT.getText();
//	    	                    	System.out.print(maPhong);
	    	                    	
	    	                    	 GD_ChiTietPhong chitiet = new GD_ChiTietPhong();
	    	                    	 chitiet.setVisible(true);
	    	                    	 chitiet.setLocationRelativeTo(null);
	    	                    	 chitiet.loadChiTietPhong(maPhong);
	    	                    	 chitiet.loadChiTietKhachHangDaDatPhong(maPhong);
	    	     		            dispose();
	    	                    }
	
	    	                    lastClickTime = clickTime;
	    					 
	
	    				}
>>>>>>> Stashed changes

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

<<<<<<< Updated upstream
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
					
					
					

					isSelected = !isSelected;
					if (isSelected) {
					    LineBorder labelBorder = new LineBorder(Color.RED, 5);
					    lbl_hinhanh.setBorder(labelBorder);

					    String duLieu = textFieldSoLuongNguoi.getText().trim();

					    if (!duLieu.isEmpty()) {
					        try {
					            int soLuongNguoi = Integer.parseInt(duLieu);
					            if (soLuongNguoi > Integer.parseInt(ph.getSoNguoi())) {
					                JOptionPane.showMessageDialog(null, "Số lượng người vượt mức cho phép");
					            } else {
					            	JOptionPane.showMessageDialog(null, "Số lượng người phù hợp");
					            }
					        } catch (NumberFormatException e1) {
//					            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
					        }
					    } else {
//					        JOptionPane.showMessageDialog(null, "Input is empty. Please enter a valid number.");
					    }
					} else {
					    LineBorder labelBorder = new LineBorder(Color.BLACK, 5);
					    lbl_hinhanh.setBorder(labelBorder);
					}

=======
						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
	    			}); 
	        
	        		//phan loai phong
	        		if(ph.getLoaiPhong().getTenLoaiPhong().equals("Phòng Thường")) {
	        			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro_gray.png")));
	        		}
	        		
	        		else {
	        			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro_crown_gray.png")));
	        		}
	        		
	        		
	        	}
    		
//    		DANH SACH PHONG TRONG
    		if (ph.getTrangThaiPhong().getMaTrangThai().equals("TTP003")) {
    			
        		//load hinh anh
        		JLabel lbl_hinhanh = new JLabel("");
        		lbl_hinhanh.setHorizontalAlignment(SwingConstants.CENTER);
        		lbl_hinhanh.setBounds(50, 50, 88, 85);
        		pn_phonghat.add(lbl_hinhanh);
        		
        		LineBorder labelBorder = new LineBorder(Color.BLACK, 5);
    	        lbl_hinhanh.setBorder(labelBorder);
        		lbl_hinhanh.addMouseListener(new MouseListener() {
    			
    				@Override
    				public void mouseClicked(MouseEvent e) {
    					// TODO Auto-generated method stub
    					sdt = textFieldSDT.getText();
    					maPhong =  ph.getMaPhong();
    					tenKH = textFieldTenKhach.getText();
    					cmnd = textFieldCMND.getText();
    					diaChi = textFieldDiaChi.getText();
    					songuoi = textFieldSoLuongNguoi.getText();
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
//    					
    					
    					
    					
>>>>>>> Stashed changes

    					
    					btnhuyphong.setEnabled(false);    
//    					Neu sdt trong thi loi
    					if (sdt.equals("")) {
    						JOptionPane.showMessageDialog(null,"Vui lòng nhập số điện thoại mới chọn được phòng");
    					}
//    					Neu co sdt thi thuc hien duoc
    					else {
    						btnthuephong.setEnabled(true);
    						
//        					Onclick
        					isSelected = !isSelected;
        					if (isSelected) {
	        					    LineBorder labelBorder = new LineBorder(Color.RED, 5);
	        					    lbl_hinhanh.setBorder(labelBorder);
	
	        					    String duLieu = textFieldSoLuongNguoi.getText().trim();
	        					   if (duLieu.equals("")) {
	        						   JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng người");
	        					   }
	        					    
	        					   else {
	        						   if (!duLieu.isEmpty()) {
	           					        try {
	           					            int soLuongNguoi = Integer.parseInt(duLieu);
	           					            if (soLuongNguoi > Integer.parseInt(ph.getSoNguoi())) {
	           					                JOptionPane.showMessageDialog(null, "Số lượng người vượt mức cho phép");
	           					            } else {
	           					            	JOptionPane.showMessageDialog(null, "Số lượng người phù hợp");
	           					            }
	           					        } catch (NumberFormatException e1) {
//	           					            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
	           					        }
	           					    } 
	        					 }
        					   
        					   
        					   
        					}
        					
        					else {
        					    LineBorder labelBorder = new LineBorder(Color.BLACK, 5);
        					    lbl_hinhanh.setBorder(labelBorder);
        					}
        					
        					
        					
    					}
    					
    					
// 					 Double click
					  long clickTime = System.currentTimeMillis();

	                    if (clickTime - lastClickTime <= 500) { // Check if the click interval is less than 500 milliseconds (adjust as needed)
<<<<<<< Updated upstream
	                    	 GD_ChiTietPhong chitiet = new GD_ChiTietPhong();
	                    	 chitiet.setVisible(true);
	                    	 chitiet.setLocationRelativeTo(null);
	                    	 System.out.print(maPhong);
	                    	 chitiet.loadChiTietPhong(maPhong);
	     		            dispose();
	     		            
=======
	                    	phone = textFieldSDT.getText();  	                    	
	   	                    	 GD_ChiTietPhong chitiet = new GD_ChiTietPhong();
	   	                    	 chitiet.setVisible(true);
	   	                    	 chitiet.setLocationRelativeTo(null);
	   	                    	 chitiet.loadChiTietPhong(maPhong);
	   	     		            dispose();
>>>>>>> Stashed changes
	     		           
	                    }

	                    lastClickTime = clickTime;
    				
    				}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
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
    	

	}
	
<<<<<<< Updated upstream
	public void btnthemActionPerformed() {
=======
//	LOAD PHIEU DAT PHONG
	public void loadPhieuDatPhong(ActionEvent e) {
>>>>>>> Stashed changes
		GD_PhieuDatPhong phieuDatPhong = new GD_PhieuDatPhong();
		phieuDatPhong.setVisible(true);
		phieuDatPhong.setLocationRelativeTo(null);
		
		phieuDatPhong.loadPhieuDatPhongTuDuLieuNhap(maPhong, tenKH, sdt, cmnd, diaChi, songuoi, giaTien);
        dispose();
	}
	
<<<<<<< Updated upstream
	
=======
// LÀM MỚI
>>>>>>> Stashed changes
	public void lammoi() {
		if(textFieldSDT.getText().equals("")) {
			textFieldTenKhach.setText("");
			textFieldCMND.setText("");
			textFieldDiaChi.setText("");
<<<<<<< Updated upstream
		}
	}

=======
			textFieldSoLuongNguoi.setText("");
		}
	}

//	HÀM TÌM SỐ ĐIỆN THOẠI KH
	
>>>>>>> Stashed changes
    public void timSoDienThoai(String phone) {
		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "select * from KhachHang\r\n"
            			+ "where SDT = ? ";
            
            
            PreparedStatement statement = connection.prepareStatement(sql);
       
            statement.setString(1, phone);
            ResultSet resultSet = statement.executeQuery();
            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName1 = resultSet.getString("tenKH");
                String columnName2 = resultSet.getString("gioiTinh");
                String columnName3 = resultSet.getString("CMND");
                String columnName4 = resultSet.getString("DiaChi");
                String columnName5 = resultSet.getString("SDT");
<<<<<<< Updated upstream
=======
                String columnName6 = resultSet.getString("maKH");
                
>>>>>>> Stashed changes
                
                textFieldTenKhach.setText(columnName1);
                textFieldTenKhach.setEnabled(true);
                
                textFieldCMND.setText(columnName3);
                textFieldCMND.setEnabled(true);
                
                textFieldDiaChi.setText(columnName4);
                textFieldDiaChi.setEnabled(true);
                
                if (columnName2.equals("Nam")) {
                	rdbtnNAM.setEnabled(true);
                	rdbtnNAM.setSelected(true);
                }
                else {
                	rdbtnNU.setEnabled(true);
                	rdbtnNU.setSelected(true);
                }
                	
                textFieldSoLuongNguoi.setEnabled(true);               
                          
                
<<<<<<< Updated upstream
            }

            
            
=======
                maKhachHang = columnName6;
            }

            
>>>>>>> Stashed changes
            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
<<<<<<< Updated upstream
=======
    
    
 // HÀM CHUYỀN TRẠNG THÁI TRỐNG -> BẬN 
    public void capNhatTrangThaiTrongThanhBan(String maPhong) {
        // Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để cập nhật dữ liệu
            String sql = "UPDATE Phong SET maTTP = 'TTP001' WHERE maPhong = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Thiết lập giá trị tham số cho mã phòng
            statement.setString(1, maPhong);

            // Thực hiện câu lệnh UPDATE
            int rowsAffected = statement.executeUpdate();

           
            // Đóng các tài nguyên
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
// HÀM CHUYỀN TRẠNG THÁI BẬN -> TRỐNG
    public void capNhatTrangThaiBanThanhTrong(String maPhong) {
        // Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để cập nhật dữ liệu
            String sql = "UPDATE Phong SET maTTP = 'TTP003' WHERE maPhong = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Thiết lập giá trị tham số cho mã phòng
            statement.setString(1, maPhong);

            // Thực hiện câu lệnh UPDATE
            int rowsAffected = statement.executeUpdate();

           
            // Đóng các tài nguyên
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
 // HÀM TAO PHIEU DAT PHONG 
    public void taoPhieuDatPhong(String thoiGian,String maKhachHang, String maPhong) {
    // Thông tin kết nối đến cơ sở dữ liệu
    String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
    String username = "sa";
    String password = "123";

    try {
        // Kết nối đến cơ sở dữ liệu
        Connection connection = DriverManager.getConnection(url, username, password);

        // Lấy mã PDP hiện tại từ cơ sở dữ liệu
        String sqlGetMaxMaPDP = "SELECT MAX(maPDP) FROM [dbo].[PhieuDatPhong]";
        PreparedStatement statementGetMaxMaPDP = connection.prepareStatement(sqlGetMaxMaPDP);
        ResultSet resultSet = statementGetMaxMaPDP.executeQuery();

        String maPDP = "PDPAA001"; // Mã mặc định nếu không có dữ liệu trong bảng

        if (resultSet.next()) {
            // Nếu có dữ liệu, tăng giá trị của mã PDP
            String maxMaPDP = resultSet.getString(1);
            if (maxMaPDP != null) {
                int numberPart = Integer.parseInt(maxMaPDP.substring(5)); // Lấy phần số từ mã hiện tại
                numberPart++; // Tăng giá trị
                maPDP = "PDPAA" + String.format("%03d", numberPart); // Format mã mới
            }
        }

        // Thực hiện câu lệnh INSERT
        String sql = "INSERT INTO [dbo].[PhieuDatPhong] " +
                "([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        // Thiết lập giá trị tham số
        statement.setString(1, maPDP);
        statement.setString(2, thoiGian); // thoiGianDangKyDatPhong
        statement.setString(3, thoiGian); // thoiGianNhanPhong
        statement.setString(4, "Bình thường");
        statement.setString(5, maKhachHang);
        statement.setString(6, "NVAA0045"); // Bạn cần cập nhật mã NV một cách đúng đắn
        statement.setString(7, maPhong);

        // Thực hiện câu lệnh INSERT
        int rowsAffected = statement.executeUpdate();

        // Đóng các tài nguyên
        resultSet.close();
        statementGetMaxMaPDP.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
 }
    
    
    
    
    // HÀM TAO PHIEU DAT PHONG 
       public void xoaPhieuDatPhong(String maKhachHang, String maPhong) {
       // Thông tin kết nối đến cơ sở dữ liệu
       String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
       String username = "sa";
       String password = "123";

       try {
           // Kết nối đến cơ sở dữ liệu
           Connection connection = DriverManager.getConnection(url, username, password);

           
           // Thực hiện câu lệnh INSERT
           String sql = "delete from PhieuDatPhong\r\n"
           		+ "where maKH = ? and maPhong = ? ";

           PreparedStatement statement = connection.prepareStatement(sql);

           // Thiết lập giá trị tham số
           statement.setString(1, maKhachHang);
           statement.setString(2, maPhong); // thoiGianDangKyDatPhong
          
           
           // Đóng các tài nguyên
           statement.close();
           connection.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }
>>>>>>> Stashed changes
}
