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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.*;
import Entity.*;
import connectDB.connectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;

import javax.swing.JTextField;

import javax.swing.JScrollPane;

import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ScrollPaneConstants;

public class GD_PhongHat extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	private JTextField txtMaPhong, txt_TinhTrang;
	private JTextField txtTenPhong;
	
	private JComboBox<String> cbB_loaiPhong;
	private JComboBox<String> cbB_TrangThai;
	DefaultTableModel model;

	private QLPH_DAO dsp = new QLPH_DAO();
//	JComboBox cbB_loaiPhong = new JComboBox<String>();
//	JComboBox cbB_giaPhong 
//	JComboBox cbB_soNguoi = new JComboBox<String>();
//	JComboBox cbB_trangThaiPhong = new JComboBox<String>();
	JPanel pnl_danhsachphonghat = new JPanel();
	private JTextField txt_soNguoi;
	private final Action action_1 = new SwingAction_1();

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
            java.util.logging.Logger.getLogger(GD_PhongHat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_PhongHat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_PhongHat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_PhongHat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_PhongHat frame = new GD_PhongHat();
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
	public GD_PhongHat() {
//		initComponents();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		setTitle("Giao Diện Phòng Hát");
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
		
		JLabel lblquanly = new JLabel("QL:");
		lblquanly.setForeground(Color.WHITE);
		lblquanly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblquanly.setBounds(878, -20, 232, 80);
		contentPane.add(lblquanly);
		
		JLabel lbltenql = new JLabel("Nguyễn Văn A");
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
          /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
        
        
        txtMaPhong = new JTextField();
        txtMaPhong.setEnabled(false);
        txtMaPhong.setBounds(25, 37, 236, 25);
        pnl_thongtinkhachhang.add(txtMaPhong);
        txtMaPhong.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Nhập Mã Phòng");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(25, 10, 107, 33);
        pnl_thongtinkhachhang.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nhập Tên Phòng");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(25, 72, 121, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_1);
        
        txtTenPhong = new JTextField();
        txtTenPhong.setBounds(25, 89, 236, 25);
        pnl_thongtinkhachhang.add(txtTenPhong);
        txtTenPhong.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Loại Phòng");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(25, 124, 93, 25);
        pnl_thongtinkhachhang.add(lblNewLabel_2);
        
        testbutton.Buttontest btnxoa = new testbutton.Buttontest();
		btnxoa.setText("Xóa");
		btnxoa.setForeground(SystemColor.text);
		btnxoa.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnxoa.setBackground(new Color(254, 122, 21));
		btnxoa.setRippleColor(new Color(255, 255, 255));
		btnxoa.setShadowColor(new Color(0,0,0));
		btnxoa.setBounds(23, 410, 109, 43);
		btnxoa.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				btnxoaActionPerformed(e);
				String maKH = txtMaPhong.getText();
				dsp.deleteCustomerByCustomerId(maKH);
//				loadData();
			}
		});
        pnl_thongtinkhachhang.add(btnxoa);
        
		testbutton.Buttontest btnLmMi = new testbutton.Buttontest();
	    btnLmMi.setText("Làm mới");
		btnLmMi.setForeground(SystemColor.text);
		btnLmMi.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLmMi.setBackground(new Color(51, 83, 158));
		btnLmMi.setRippleColor(new Color(255, 255, 255));
		btnLmMi.setShadowColor(new Color(0,0,0));
		btnLmMi.setBounds(168, 410, 109, 43);
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLmMiActionPerformed(e);
				refresh();
			}
		});
        pnl_thongtinkhachhang.add(btnLmMi);
        

        cbB_loaiPhong = new JComboBox<String>();
        cbB_loaiPhong.setBounds(25, 147, 121, 25);
        pnl_thongtinkhachhang.add(cbB_loaiPhong);
        loadComBoBoxLoaiPhong();

        
        JLabel lblNewLabel_2_1 = new JLabel("Trạng Thái");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_1.setBounds(25, 182, 93, 19);
        pnl_thongtinkhachhang.add(lblNewLabel_2_1);
        

        cbB_TrangThai = new JComboBox<String>();
        cbB_TrangThai.setBounds(25, 200, 121, 25);
        pnl_thongtinkhachhang.add(cbB_TrangThai);
        loadComBoBoxTrangThai();


//        JComboBox cbB_giaPhong = new JComboBox();
//        cbB_giaPhong.setBounds(25, 200, 121, 25);
//        pnl_thongtinkhachhang.add(cbB_giaPhong);




        
        JLabel lblNewLabel_2_1_1 = new JLabel("Tình Trạng Phòng");
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_1_1.setBounds(25, 233, 121, 25);
        pnl_thongtinkhachhang.add(lblNewLabel_2_1_1);
        

        testbutton.Buttontest btnthem = new testbutton.Buttontest();
        btnthem.setAction(action_1);
        btnthem.setText("Thêm");
		btnthem.setRippleColor(new Color(255, 255, 255));
		btnthem.setShadowColor(new Color(0,0,0));
		btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnthem.setForeground(SystemColor.text);
		btnthem.setBackground(new Color(90, 167, 167));
		btnthem.setBounds(23, 357, 109, 43);
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnthemActionPerformed(e);
				loadData();
			}
		});
        pnl_thongtinkhachhang.add(btnthem);
        
        testbutton.Buttontest btnsua = new testbutton.Buttontest();
        btnsua.setText("Sửa");
		btnsua.setRippleColor(new Color(255, 255, 255));
		btnsua.setShadowColor(new Color(0,0,0));
		btnsua.setForeground(SystemColor.text);
		btnsua.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnsua.setBackground(new Color(226, 211, 107));
		btnsua.setBounds(168, 357, 109, 43);
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnsuaActionPerformed(e);
				Phong ph = layfields();
				dsp.update(ph);
				JOptionPane.showMessageDialog(null, "Sửa thông tin Phòng thành công!");
//				loadData();
			}
		});
        pnl_thongtinkhachhang.add(btnsua);
        

        txt_TinhTrang = new JTextField();
        txt_TinhTrang.setColumns(10);
        txt_TinhTrang.setBounds(25, 258, 236, 25);
        pnl_thongtinkhachhang.add(txt_TinhTrang);

        JLabel lblavatar = new JLabel("");
        lblavatar.setBounds(318, -591, 1149, 957);
        pnl_thongtinkhachhang.add(lblavatar);
        lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
        lblavatar.setIcon(new ImageIcon(GD_TaiKhoan.class.getResource("/Imgs/t1 1.png")));
        
        JLabel lblNewLabel_3 = new JLabel("Số người");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(177, 124, 67, 25);
        pnl_thongtinkhachhang.add(lblNewLabel_3);
        
        txt_soNguoi = new JTextField();
        txt_soNguoi.setBounds(176, 147, 112, 24);
        pnl_thongtinkhachhang.add(txt_soNguoi);
        txt_soNguoi.setColumns(10);

		
        testbutton.Buttontest btnphonghat = new testbutton.Buttontest();
        btnphonghat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
        btnphonghat.setBorder(null);
        btnphonghat.setText("Phòng Hát");
        btnphonghat.setForeground(Color.WHITE);
        btnphonghat.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnphonghat.setBackground(new Color(128, 128, 128, 150));
        btnphonghat.setBounds(0, 70, 232, 87);
		contentPane.add(btnphonghat);
		btnphonghat.setLayout(null);
		
		//Danh sach phong hat
		
		
		pnl_danhsachphonghat.setBackground(new Color(255, 255, 255, 200));
		pnl_danhsachphonghat.setBounds(322, 148, 839, 463);
        contentPane.add(pnl_danhsachphonghat);
        pnl_danhsachphonghat.setLayout(null);
        
        JLabel lblNewLabel_8 = new JLabel("Tầng 1:");
        lblNewLabel_8.setBounds(38, 61, 69, 14);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
        pnl_danhsachphonghat.add(lblNewLabel_8);
         
       
		testbutton.Buttontest btndichvu = new testbutton.Buttontest();
        btndichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_QLDichVu gdqldv = new GD_QLDichVu();
				gdqldv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdqldv.setVisible(true);
				dispose();
			}
		});
        btndichvu.setBorder(null);
        btndichvu.setText("Dịch Vụ");
        btndichvu.setForeground(Color.WHITE);
        btndichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndichvu.setBackground(new Color(0, 0, 0, 150));
        btndichvu.setBounds(230, 70, 239, 87);
		contentPane.add(btndichvu);
		btndichvu.setLayout(null);
		
        testbutton.Buttontest btnnhanvien = new testbutton.Buttontest();
        btnnhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_QLNhanVien gdqlnv = new GD_QLNhanVien();
				gdqlnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdqlnv.setVisible(true);
				dispose();
			}
		});
        btnnhanvien.setBorder(null);
        btnnhanvien.setText("Nhân Viên");
        btnnhanvien.setForeground(Color.WHITE);
        btnnhanvien.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnnhanvien.setBackground(new Color(0, 0, 0, 150));
        btnnhanvien.setBounds(465, 70, 232, 87);
		contentPane.add(btnnhanvien);
		btnnhanvien.setLayout(null);
		
        testbutton.Buttontest btntaikhoan = new testbutton.Buttontest();
        btntaikhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_TaiKhoan gdtk = new GD_TaiKhoan();
				gdtk.setVisible(true);
				dispose();
			}
		});
        btntaikhoan.setBorder(null);
        btntaikhoan.setText("Tài Khoản");
        btntaikhoan.setForeground(Color.WHITE);
        btntaikhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
        btntaikhoan.setBackground(new Color(0,0,0, 150));
        btntaikhoan.setBounds(695, 70, 232, 87);
		contentPane.add(btntaikhoan);
		btntaikhoan.setLayout(null);
		
        testbutton.Buttontest btnthongke = new testbutton.Buttontest();
        btnthongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	            GD_ThongKeHoaDon thongkehoadon = new GD_ThongKeHoaDon();
	            thongkehoadon.setVisible(true);
	            dispose();
			}
		});
        btnthongke.setBorder(null);
        btnthongke.setText("Thống Kê");
        btnthongke.setForeground(Color.WHITE);
        btnthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthongke.setBackground(new Color(0, 0, 0, 150));
        btnthongke.setBounds(925, 70, 232, 87);
		contentPane.add(btnthongke);
		btnthongke.setLayout(null);
		
		JLabel lb_hinhnen = new JLabel("");
		lb_hinhnen.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/370.png")));
		lb_hinhnen.setBounds(-40, -176, 1333, 957);
		contentPane.add(lb_hinhnen);

		//Tao Bang

	}

	protected void btnLmMiActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void btnxoaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void btnsuaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private Phong layfields() {
		loadComBoBoxLoaiPhong();
		loadComBoBoxTrangThai();
		String maph = txtMaPhong.getText();
		String songuoi = txt_soNguoi.getText();
		String ten = txtTenPhong.getText();
		String tinhTrang = txt_TinhTrang.getText();
		LoaiPhong lp = new LoaiPhong(cbB_loaiPhong.getSelectedItem()+"", null, 0);
		TrangThaiPhong ttp = new TrangThaiPhong(cbB_TrangThai.getSelectedItem()+"", null);
		Phong p = new Phong(maph, songuoi, ten, tinhTrang, lp, ttp);
		return p;
	}
	
	private void btnthemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		int maxMaKH = dsp.getMaxMaPH();
//		maxMaKH++;
//		
//	    
//	    // Gán giá trị mới cho ô nhập liệu mã kh
//		txtMaPhong.setText("P" + String.format("%03d", maxMaKH));
		
		int maPhongCounter = dsp.getMaxMaPH();
		maPhongCounter++;
		
		txtMaPhong.setText("P" + String.format("%03d", maPhongCounter));
		Phong p = layfields();
		
		dsp.create(p);
		
		loadData();
		
	}
	
//	private void initComponents() {
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosing(java.awt.event.WindowEvent evt) {
//                formWindowClosing(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 400, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 300, Short.MAX_VALUE)
//        );
//
//        pack();
//    }
//
//    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//         GD_Main_QL mainql=new GD_Main_QL();
//         mainql.setVisible(true);
//    }

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
    
    
    public void loadComBoBoxLoaiPhong() {

		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "SELECT * FROM LoaiPhong";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName = resultSet.getString("maLP");
                cbB_loaiPhong.addItem(columnName);
                
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    public void loadComBoBoxTrangThai() {

		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "SELECT * FROM TrangThaiPhong";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName = resultSet.getString("maTTP");
                cbB_TrangThai.addItem(columnName);
              
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
		Right_QL_PHONG.setBounds(332, 148, 829, 465);
		contentPane.add(Right_QL_PHONG);
		Right_QL_PHONG.setLayout(null);
		
		JScrollPane scrollPane_DSPH = new JScrollPane();
		scrollPane_DSPH.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_DSPH.setBounds(0, 25, 829, 440);
		scrollPane_DSPH.setBackground(new Color(255, 255, 255, 0));
		Right_QL_PHONG.add(scrollPane_DSPH);
		
		JPanel panel_dsph = new JPanel();
		panel_dsph.setBackground(new Color(192, 192, 192));
		scrollPane_DSPH.setViewportView(panel_dsph);
		panel_dsph.setLayout(new GridLayout(0, 5, -50, 20));
    	for(Phong ph : listph) {
    		//load label cha
    		JPanel pnl_phonghat = new JPanel();
    		pnl_phonghat.setBackground(new Color(255, 255, 255, 0));
    		pnl_phonghat.setLayout(null);
//    		pnl_phonghat.setBorder(LineBorder.createBlackLineBorder());
    		pnl_phonghat.setPreferredSize(new Dimension(200, 200));
    		panel_dsph.add(pnl_phonghat);
   		
//    		//load suc chua
    		JLabel lbl_succhua = new JLabel("Sức chứa : " + ph.getSoNguoi());
    		lbl_succhua.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_succhua.setFont(new Font("Tahoma", Font.BOLD, 11));
    		lbl_succhua.setForeground(new Color(255,0,0));
    		lbl_succhua.setBounds(55, 130, 85, 35);
    		pnl_phonghat.add(lbl_succhua);
    		
    		//load ten phong
    		JLabel lbl_tenphong = new JLabel(ph.getTenPhong());
    		lbl_tenphong.setFont(new Font("Tahoma", Font.BOLD, 13));
    		lbl_tenphong.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_tenphong.setBounds(55, 145, 85, 35);
    		pnl_phonghat.add(lbl_tenphong);
    		
    		//load hinh anh
    		JLabel lbl_hinhanh = new JLabel("");
    		lbl_hinhanh.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_hinhanh.setBounds(50, 50, 88, 85);
    		lbl_hinhanh.setBorder(LineBorder.createBlackLineBorder());
    		pnl_phonghat.add(lbl_hinhanh);
    		
    		//phan loai phong
    		if(ph.getLoaiPhong().getTenLoaiPhong().equals("Phòng Thường")) {
    			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro.png")));
    		}else {
    			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro_with_crown.png")));
    		}
//    		if(ph.getTrangThaiPhong().getTenTrangThai().trim().equals("Phòng Trống")) {
//    			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro.png")));
//    		}else {
//    			lbl_hinhanh.setIcon(new ImageIcon(GD_PhongHat.class.getResource("/Imgs/micro_gray.png")));
//    		}
    		
    		
    		pnl_phonghat.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtMaPhong.setText(ph.getMaPhong());
					txtTenPhong.setText(ph.getTenPhong());
					txt_soNguoi.setText(ph.getSoNguoi());
					cbB_loaiPhong.setSelectedItem(ph.getLoaiPhong().getMaLoaiPhong()+"");
					cbB_TrangThai.setSelectedItem(ph.getTrangThaiPhong().getMaTrangThai()+"");
					txt_TinhTrang.setText(ph.getTinTrangPhong());
					
				}
			});
    	}
	}
	public void loadTable() {
		model.setRowCount(0);
		ArrayList<Phong> list = dsp.docbang();
		list.forEach(x->{
			model.addRow(new Object[] {x.getMaPhong(), x.getSoNguoi(), x.getTenPhong(), x.getTinTrangPhong(), x.getLoaiPhong(), x.getTrangThaiPhong()});
		});
	}
	public void refresh() {
		txtMaPhong.setText("");
		txtTenPhong.setText("");
		txt_soNguoi.setText("");
		txt_TinhTrang.setText("");
		loadData();
	}


	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}