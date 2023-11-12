package GiaoDien;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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


import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.QLDV_DAO;
import DAO.QLNV_DAO;
import DAO.QLPH_DAO;
import Entity.DichVu;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.Phong;
import Entity.TaiKhoanNhanVien;
import Entity.TrangThaiPhong;
import connectDB.connectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import testbutton.*;

public class GD_PhongHat extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	private JTextField txtMaPhong;
	private JTextField txtTenPhong;
	private JTextField textField_2;

	private JTextField textField_3;
	private JComboBox<String> comboBoxLoaiPhong;
	private JComboBox<String> comboBoxGiaTien;
	private JTextField textFieldTrangThai;

	private JTextField txt_chuThich;
	DefaultTableModel model;
	private JTable table;
	private List<Phong> phongList = new ArrayList<Phong>();
	JComboBox cbB_loaiPhong = new JComboBox<String>();
	JComboBox cbB_giaPhong = new JComboBox<String>();
	JComboBox cbB_soNguoi = new JComboBox<String>();
	JComboBox cbB_trangThaiPhong = new JComboBox<String>();
	JPanel pnl_danhsachphonghat = new JPanel();
	private JTextField txt_soNguoi;

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
        
        txt_chuThich = new JTextField();
        txt_chuThich.setBounds(25, 317, 236, 25);
        pnl_thongtinkhachhang.add(txt_chuThich);
        txt_chuThich.setColumns(10);
        
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
			public void actionPerformed(ActionEvent e) {
				btnxoaActionPerformed(e);
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
			}
		});
        pnl_thongtinkhachhang.add(btnLmMi);
        
        JLabel lblNewLabel_3_1 = new JLabel("Chú thích");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1.setBounds(25, 293, 93, 25);
        pnl_thongtinkhachhang.add(lblNewLabel_3_1);
        

        comboBoxLoaiPhong = new JComboBox();
        comboBoxLoaiPhong.setBounds(25, 147, 121, 25);
        pnl_thongtinkhachhang.add(comboBoxLoaiPhong);
        loadComBoBoxLoaiPhong();


        JComboBox cbB_loaiPhong = new JComboBox();
        cbB_loaiPhong.setBounds(25, 147, 121, 25);
        pnl_thongtinkhachhang.add(cbB_loaiPhong);

        
        JLabel lblNewLabel_2_1 = new JLabel("Giá Phòng");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_1.setBounds(25, 182, 93, 19);
        pnl_thongtinkhachhang.add(lblNewLabel_2_1);
        

        comboBoxGiaTien = new JComboBox();
        comboBoxGiaTien.setBounds(25, 200, 121, 25);
        pnl_thongtinkhachhang.add(comboBoxGiaTien);
        loadComBoBoxGiaPhong();


        JComboBox cbB_giaPhong = new JComboBox();
        cbB_giaPhong.setBounds(25, 200, 121, 25);
        pnl_thongtinkhachhang.add(cbB_giaPhong);




        
        JLabel lblNewLabel_2_1_1 = new JLabel("Trạng Thái Phòng");
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_1_1.setBounds(25, 233, 121, 25);
        pnl_thongtinkhachhang.add(lblNewLabel_2_1_1);
        

        testbutton.Buttontest btnthem = new testbutton.Buttontest();
        btnthem.setText("Thêm");
		btnthem.setRippleColor(new Color(255, 255, 255));
		btnthem.setShadowColor(new Color(0,0,0));
		btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnthem.setForeground(SystemColor.text);
		btnthem.setBackground(new Color(90, 167, 167));
		btnthem.setBounds(23, 357, 109, 43);
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				btnthemActionPerformed(e);
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
			}
		});
        pnl_thongtinkhachhang.add(btnsua);
        

        textFieldTrangThai = new JTextField();
        textFieldTrangThai.setColumns(10);
        textFieldTrangThai.setBounds(25, 258, 236, 25);
        pnl_thongtinkhachhang.add(textFieldTrangThai);

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
        
        
        
        
        
        
        
//        JButton btnChonPhongHat = new JButton("");
//        btnChonPhongHat.setBounds(66, 110, 88, 85);
//        btnChonPhongHat.setBackground(new Color(168, 168, 168));
//        btnChonPhongHat.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        pnl_danhsachphonghat.add(btnChonPhongHat);
        
        
        
//        JButton btnChonPhongHat2 = new JButton("");
//        btnChonPhongHat2.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        btnChonPhongHat2.setBounds(213, 110, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat2);
//        
//        JButton btnChonPhongHat3 = new JButton("");
//        btnChonPhongHat3.setFont(new Font("Tahoma", Font.PLAIN, 11));
//        btnChonPhongHat3.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        btnChonPhongHat3.setBounds(360, 110, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat3);
//        
//        JButton btnChonPhongHat4 = new JButton("");
//        btnChonPhongHat4.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro_with_crown.png")));
//        btnChonPhongHat4.setBounds(518, 110, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat4);
//        
//        JButton btnChonPhongHat5 = new JButton("");
//        btnChonPhongHat5.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        btnChonPhongHat5.setBounds(679, 110, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat5);
//        
//        JButton btnChonPhongHat6 = new JButton("");
//        btnChonPhongHat6.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        btnChonPhongHat6.setBounds(66, 252, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat6);
//        
//        JButton btnChonPhongHat7 = new JButton("");
//        btnChonPhongHat7.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        btnChonPhongHat7.setBounds(213, 252, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat7);
//        
//        JButton btnChonPhongHat8 = new JButton("");
//        btnChonPhongHat8.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        btnChonPhongHat8.setBounds(360, 252, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat8);
//        
//        JButton btnChonPhongHat9 = new JButton("");
//        btnChonPhongHat9.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        btnChonPhongHat9.setBounds(518, 252, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat9);
//        
//        JButton btnChonPhongHat10 = new JButton("");
//        btnChonPhongHat10.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
//        btnChonPhongHat10.setBounds(679, 252, 88, 85);
//        pnl_danhsachphonghat.add(btnChonPhongHat10);
        
//        JLabel lbl_p101 = new JLabel("P101");
//        lbl_p101.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101.setBounds(76, 195, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p101);
//        
//        JLabel lbl_p102 = new JLabel("P102");
//        lbl_p102.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p102.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p102.setBounds(223, 195, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p102);
//        
//        JLabel lbl_p103 = new JLabel("P103");
//        lbl_p103.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p103.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p103.setBounds(370, 195, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p103);
//        
//        JLabel lbl_p104 = new JLabel("P104");
//        lbl_p104.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p104.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p104.setBounds(528, 195, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p104);
//        
//        JLabel lbl_p105 = new JLabel("P105");
//        lbl_p105.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p105.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p105.setBounds(689, 195, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p105);
//        
//        JLabel lbl_p106 = new JLabel("P106");
//        lbl_p106.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p106.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p106.setBounds(76, 337, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p106);
//        
//        JLabel lbl_p107 = new JLabel("P107");
//        lbl_p107.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p107.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p107.setBounds(223, 337, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p107);
//        
//        JLabel lbl_p108 = new JLabel("P108");
//        lbl_p108.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p108.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p108.setBounds(370, 337, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p108);
//        
//        JLabel lbl_p109 = new JLabel("P109");
//        lbl_p109.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p109.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p109.setBounds(528, 337, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p109);
//        
//        JLabel lbl_p1010 = new JLabel("P101");
//        lbl_p1010.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p1010.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p1010.setBounds(689, 337, 69, 28);
//        pnl_danhsachphonghat.add(lbl_p1010);
//        
//        JLabel lbl_p101_1 = new JLabel("Phòng Thường");
//        lbl_p101_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1.setBounds(54, 214, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1);
//        
//        JLabel lbl_p101_1_1 = new JLabel("Phòng Thường");
//        lbl_p101_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_1.setBounds(201, 214, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_1);
//        
//        JLabel lbl_p101_1_1_1 = new JLabel("Phòng Thường");
//        lbl_p101_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_1_1.setBounds(351, 214, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_1_1);
//        
//        JLabel lbl_p101_1_1_1_1 = new JLabel("Phòng VIP");
//        lbl_p101_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_1_1_1.setBounds(505, 214, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_1_1_1);
//        
//        JLabel lbl_p101_1_1_1_1_1 = new JLabel("Phòng Thường");
//        lbl_p101_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_1_1_1_1.setBounds(665, 214, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_1_1_1_1);
//        
//        JLabel lbl_p101_1_2 = new JLabel("Phòng Thường");
//        lbl_p101_1_2.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_2.setBounds(56, 354, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_2);
//        
//        JLabel lbl_p101_1_2_1 = new JLabel("Phòng Thường");
//        lbl_p101_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_2_1.setBounds(203, 354, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_2_1);
//        
//        JLabel lbl_p101_1_2_1_1 = new JLabel("Phòng Thường");
//        lbl_p101_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_2_1_1.setBounds(347, 354, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_2_1_1);
//        
//        JLabel lbl_p101_1_2_1_1_1 = new JLabel("Phòng Thường");
//        lbl_p101_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_2_1_1_1.setBounds(505, 354, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_2_1_1_1);
//        
//        JLabel lbl_p101_1_2_1_1_1_1 = new JLabel("Phòng Thường");
//        lbl_p101_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lbl_p101_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lbl_p101_1_2_1_1_1_1.setBounds(665, 354, 118, 28);
//        pnl_danhsachphonghat.add(lbl_p101_1_2_1_1_1_1);
       
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
//		table = new JTable();
//        JScrollPane scrollPane = new JScrollPane(table);
//        pnl_danhsachphonghat.add(scrollPane);
//        scrollPane.setBounds(0, 97, 839, 200);
//        
//        pnl_danhsachphonghat.add(scrollPane);
//        
//        model = new DefaultTableModel();
//		model.addColumn("Mã Phòng");
//		model.addColumn("Số người");
//		model.addColumn("Tên phòng");
//		model.addColumn("Trạng thái phòng");
//		model.addColumn("Loại phòng");
//        
//        table.setBounds(10, 331, 819, -223);
//        table.setModel(model);
//        
//        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
//        scrollPane.setRowHeaderView(scrollBar);
//		
//		connectDB.getInstance().connect();
//		loadData();
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
	
//	private Phong reverSPFromTextField() {
////		String maph = txtMaPhong.getText().toString();
////		String tenph = txtTenPhong.getText().toString();
////		LoaiPhong tenlp = (LoaiPhong) cbB_loaiPhong.getSelectedItem();
////		String songuoi = (String) cbB_soNguoi.getSelectedItem();
////		Double giaphong = (Double) cbB_soNguoi.getSelectedItem();
////		TrangThaiPhong trangthaiphong = (TrangThaiPhong) cbB_trangThaiPhong.getSelectedItem();
////		String chuthichphong = txt_chuThich.getText().toString();
////		return new Phong(maph,songuoi,tenph,tenlp.getTenLoaiPhong(),giaphong,trangthaiphong.getTenTrangThai(),chuthichphong);
//	}

//	protected void btnthemActionPerformed(ActionEvent e) {
//		Phong ph = reverSPFromTextField();
//		if(dstk.create(tk)) {
//			Object [] rowData = {txtMaTK.getText(), txtTaiKhoan.getText(), txtmk.getText(), txtTenNV.getText()};
//			model.addRow(rowData);
//			JOptionPane.showMessageDialog(this, "Thêm Tài Khoản Thành Công");
//			lammoi();
//		}
//		loadTable();
//	}
	
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
                String columnName = resultSet.getString("tenLoaiPhong");
                comboBoxLoaiPhong.addItem(columnName);
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    public void loadComBoBoxGiaPhong() {

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
                String columnName = resultSet.getString("giaTien");
                comboBoxGiaTien.addItem(columnName);
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
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
		scrollPane_DSPH.setBounds(0, 25, 870, 440);
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
    		
//
//    		
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
    		
    		pnl_phonghat.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtMaPhong.setText(ph.getMaPhong());
					txtTenPhong.setText(ph.getTenPhong());
					txt_soNguoi.setText(ph.getSoNguoi());
					txt_chuThich.setText(ph.getChuThichPhong());
				}
			});
    	}
	}

}