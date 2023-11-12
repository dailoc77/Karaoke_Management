package GiaoDien;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
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
import java.util.List;
import java.util.Vector;

import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.*;
import Entity.*;
import connectDB.connectDB;
import test.dao;
import test.en;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
public class GD_QLNhanVien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtten;
	private JTextField txtsdt;
//	private JTextField textField_2;
	private JRadioButton rdbtnNAM;
	private JRadioButton rdbtnNU;
	private JTextField txtcmnd;
	private JTextField txtdc;
	private JTable table;
	DefaultTableModel model;
	private JLabel lblClock;
	private Timer timer;
	private JTextField txtns;
	private JTextField textFieldTrangThaiLamViec;
	private String TrangThaiLamViec[] = {"Đang làm","Nghĩ việc","Tạm nghĩ việc"};
	private JComboBox<String> cbLoaiNhanVien;
	private JComboBox<String> cbtrangthai;
	private LoaiNhanVien_DAO dslnv;
	QLNV_DAO ds = new QLNV_DAO();
	QLTK_DAO dstk = new QLTK_DAO();
	private JTextField txtMaNV;
	private JTextField txt_MaTK;

	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GD_QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_QLNhanVien frame = new GD_QLNhanVien();
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
	public GD_QLNhanVien() {
		
		try {
			connectDB.getInstance().connect();
			loadTable();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		dslnv = new LoaiNhanVien_DAO();
		

//		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		setResizable(false);
		setTitle("Giao Diện Nhân Viên");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel jpanel = new JPanel();
		jpanel.setBounds(0, 70, 232, 80);
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
//		Clock ---------------------------------
		JPanel box_clock = new JPanel();
		box_clock.setBounds(34, 10, 260, 50);
        box_clock.setBorder(new LineBorder(Color.BLACK));
        contentPane.add(box_clock);
        box_clock.setLayout(null);

        lblClock = new JLabel();
        lblClock.setHorizontalAlignment(SwingConstants.CENTER);
        lblClock.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblClock.setBounds(0, 0, 260, 50);
        lblClock.setOpaque(true);
        lblClock.setBackground(Color.WHITE);
        box_clock.add(lblClock);

        timer = new Timer(0, this);
        timer.start();
		
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
		
		
        testbutton.Buttontest btnphonghat = new testbutton.Buttontest();
        btnphonghat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_PhongHat gdphonghat = new GD_PhongHat();
				gdphonghat.setVisible(true);
				dispose();
			}
		});
        btnphonghat.setBorder(null);
        btnphonghat.setText("Phòng Hát");
        btnphonghat.setForeground(Color.WHITE);
        btnphonghat.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnphonghat.setBackground(new Color(0, 0, 0, 150));
        btnphonghat.setBounds(0, 70, 232, 87);
		contentPane.add(btnphonghat);
		btnphonghat.setLayout(null);
		
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

			}
		});
        btnnhanvien.setBorder(null);
        btnnhanvien.setText("Nhân Viên");
        btnnhanvien.setForeground(Color.WHITE);
        btnnhanvien.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnnhanvien.setBackground(new Color(128, 128, 128, 150));
        btnnhanvien.setBounds(465, 70, 232, 87);
		contentPane.add(btnnhanvien);
		btnnhanvien.setLayout(null);
		
        testbutton.Buttontest btntaikhoan = new testbutton.Buttontest();
        btntaikhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_TaiKhoan taikhoan = new GD_TaiKhoan();
				taikhoan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				taikhoan.setVisible(true);
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
		
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		panel.setOpaque(false);
		panel.setBounds(-2, 151, 1173, 172);
		panel.setBackground(new Color(255, 255, 255,200));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập Họ Tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 159, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(156, 90, 145, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số CMND");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(372, 90, 92, 23);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Địa Chỉ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(563, 91, 55, 20);
		panel.add(lblNewLabel_1_4);
		
		txtten = new JTextField();
		txtten.setBounds(10, 37, 173, 27);
		panel.add(txtten);
		txtten.setColumns(10);
		
		//rad button
		JRadioButton rdbtnNAM = new JRadioButton("Nam");
		rdbtnNAM.setBounds(281, 37, 67, 23);
		rdbtnNAM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNAM.setOpaque(false);
		rdbtnNAM.setContentAreaFilled(false);
		rdbtnNAM.setFocusPainted(false);
		panel.add(rdbtnNAM);
	
		
		JRadioButton rdbtnNU = new JRadioButton("Nữ");
		rdbtnNU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNU.setBounds(350, 37, 55, 23);
		rdbtnNU.setOpaque(false);
		panel.add(rdbtnNU);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNAM);
		bg.add(rdbtnNU);
		panel.add(rdbtnNAM);
		panel.add(rdbtnNU);
		//radbuton//
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(156, 123, 173, 27);
		panel.add(txtsdt);
		
		txtcmnd = new JTextField();
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(369, 123, 152, 27);
		panel.add(txtcmnd);
		
		txtdc = new JTextField();
		txtdc.setColumns(10);
		txtdc.setBounds(563, 121, 270, 27);
		panel.add(txtdc);
		
		//button them
		testbutton.Buttontest btnthem = new testbutton.Buttontest();
		btnthem.setText("Thêm");
		btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnthem.setForeground(SystemColor.text);
		btnthem.setBackground(new Color(90, 167, 167));
		btnthem.setRippleColor(new Color(255, 255, 255));
		btnthem.setShadowColor(new Color(0,0,0));
		btnthem.setBounds(859, 26, 128, 48);

		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnthemActionPerformed(e);
			}
		});
		panel.add(btnthem);
		
		
		//button xoa
		testbutton.Buttontest btnxoa = new testbutton.Buttontest();
		btnxoa.setText("Xóa");
		btnxoa.setForeground(SystemColor.text);
		btnxoa.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnxoa.setBackground(new Color(254, 122, 21));
		btnxoa.setBounds(859, 112, 128, 48);
		btnxoa.setRippleColor(new Color(255, 255, 255));
		btnxoa.setShadowColor(new Color(0,0,0));
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnxoaActionPerformed(e);
			}
		});
		panel.add(btnxoa);
		
		//button sua
		testbutton.Buttontest btnsua = new testbutton.Buttontest();
		btnsua.setText("Sửa");
		btnsua.setForeground(SystemColor.text);
		btnsua.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnsua.setBackground(new Color(226, 211, 107));
		btnsua.setBounds(1018, 26, 128, 48);
		btnsua.setRippleColor(new Color(255, 255, 255));
		btnsua.setShadowColor(new Color(0,0,0));
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnsuaActionPerformed(e);
			}
		});
		panel.add(btnsua);
		
		//button lammoi
		testbutton.Buttontest btnLmMi = new testbutton.Buttontest();
	    btnLmMi.setText("Làm mới");
		btnLmMi.setForeground(SystemColor.text);
		btnLmMi.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLmMi.setBackground(new Color(51, 83, 158));
		btnLmMi.setBounds(1018, 112, 128, 48);
		btnLmMi.setRippleColor(new Color(255, 255, 255));
		btnLmMi.setShadowColor(new Color(0,0,0));
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lammoi();
			}
		});
		panel.add(btnLmMi);
		
		txtns = new JTextField();
		txtns.setColumns(10);
		txtns.setBounds(422, 37, 92, 27);
		panel.add(txtns);
		
		JLabel lblNewLabel_1_2 = new JLabel("Năm Sinh");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(422, 10, 79, 28);
		panel.add(lblNewLabel_1_2);
		
		

		
		cbLoaiNhanVien = new JComboBox<>();
		cbLoaiNhanVien.setBounds(548, 37, 104, 27);
		panel.add(cbLoaiNhanVien);
		loadComBoBox();
		
		
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Loại NV");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(538, 10, 79, 28);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Trạng Thái Làm Việc");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(674, 10, 159, 28);
		panel.add(lblNewLabel_1_2_1_1);
		
		textFieldTrangThaiLamViec = new JTextField();
		textFieldTrangThaiLamViec.setColumns(10);
		textFieldTrangThaiLamViec.setBounds(676, 40, 173, 27);
		panel.add(textFieldTrangThaiLamViec);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(10, 123, 128, 24);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lbl_manv = new JLabel("Mã Nhân Viên");
		lbl_manv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_manv.setBounds(10, 91, 104, 20);
		panel.add(lbl_manv);
		
//		txt_MaTK = new JTextField();
//		txt_MaTK.setBounds(204, 37, 67, 27);
//		panel.add(txt_MaTK);
//		txt_MaTK.setColumns(10);
		
//		JLabel lblNewLabel_2 = new JLabel("Mã Tài Khoản");
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_2.setBounds(190, 10, 111, 28);
//		panel.add(lblNewLabel_2);
		
		
		//talbe
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 323, 1161, 290);
		// Set the component orientation to RIGHT_TO_LEFT
		
		contentPane.add(scrollPane);
		
	    model = new DefaultTableModel();
		model.addColumn("Mã NV");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Năm Sinh");
		model.addColumn("Số CMND");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Trạng Thái Làm Việc");
		model.addColumn("Địa Chỉ");
		model.addColumn("Loại nhân viên");
//		model.addColumn("Mã tài khoản");

		table.setModel(model);
		
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
		scrollPane.setRowHeaderView(scrollBar);
		
//         -------------------------------
//		JLabel lblavatar = new JLabel("");
//		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
//		lblavatar.setIcon(new ImageIcon(GD_TaiKhoan.class.getResource("/Imgs/t1 1.png")));
//		lblavatar.setBounds(90, -444, 1333, 957);
//		contentPane.add(lblavatar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1161, 613);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/Imgs/370.png")));

		
		connectDB.getInstance().connect();
		updateTableData();
			
		
	}
	
//	private String layGioiTinh(Boolean rdbtnNam , Boolean rdbtnNu) {
//		String gt = "";
//		if(rdbtnNam.TRUE) {
//			gt = "Nam";
//		}
//		if(rdbtnNu.TRUE) {
//			gt = "Nữ";
//		}
//		
//		return gt;
//	}
	
	private NhanVien reverSPFromTextField() {
		String maNV = txtMaNV.getText().toString();
		String ten = txtten.getText().toString();
		String gt = "";
		String ngaySinh = txtns.getText().toString();
		String cmnd = txtcmnd.getText().toString();
		String sdt = txtsdt.getText().toString();
		String trangThaiLamViec = textFieldTrangThaiLamViec.getText().toString();
		String dc = txtdc.getText().toString();
		LoaiNhanVien loainv = new LoaiNhanVien("",cbLoaiNhanVien.getSelectedItem().toString());
		TaiKhoanNhanVien maTK = new TaiKhoanNhanVien(txt_MaTK.getText().toString(), null, null, null);
//		return new NhanVien(maNV,ten,gt,ngaySinh,cmnd,sdt,trangThaiLamViec,dc,loainv,maTK);
		return new NhanVien(maNV,ten,gt,ngaySinh,cmnd,sdt,trangThaiLamViec,dc,loainv,maTK);
	}
	
	
	
	protected void btnsuaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void btnxoaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void btnthemActionPerformed(ActionEvent e) {
		QLNV_DAO dsnv = new QLNV_DAO();
		int maxMaNV = dsnv.getMaxMaNV();
//		int maxMaTK = dstk.getMaxMaTaiKhoan();
		
		maxMaNV++;
//		maxMaTK++;

		txtMaNV.setText("NVAA" + String.format("%03d", maxMaNV));
		NhanVien nv = reverSPFromTextField();
//		ArrayList<TaiKhoanNhanVien> tknv = dstk.laytheomatk(nv.get);
//		String maTK = tknv.getMaTK().getMaTaiKhoan();
//		maTK = "TK" + String.format("%03d", maxMaTK);
		String gt = "";
		if(dsnv.create(nv)) {
			if(rdbtnNAM.isSelected()) {
				gt = "Nam";
			}
			if(rdbtnNU.isSelected()) {
				gt = "Nữ";
			}
			Object [] rowData = {txtMaNV.getText(),txtten.getText(),gt,txtns.getText(),txtcmnd.getText(),txtsdt.getText(),textFieldTrangThaiLamViec.getText(),txtdc.getText(),nv.getLNV().getTenLNV()};
//			Object [] rowData = {txtMaNV.getText(),txtten.getText(),gt,txtns.getText(),txtcmnd.getText(),txtsdt.getText(),textFieldTrangThaiLamViec.getText(),txtdc.getText(),nv.getLNV().getTenLNV(),nv.getMaTK().getMaTaiKhoan()};
			model.addRow(rowData);
			JOptionPane.showMessageDialog(this, "Thêm Nhân Viên Thành Công");
			lammoi();
		}
//		table.setModel(model);
//		updateTableData();
		loadTable();
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

//    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//         GD_Main_QL mainql=new GD_Main_QL();
//         mainql.setVisible(true);
//    }

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

	
	
	private void updateTableData() {
		QLNV_DAO ds = new QLNV_DAO();
		ArrayList<NhanVien> ls = ds.doctubang();
		for(NhanVien s : ls) {
//			String [] rowData = {s.getMaNV(), s.getTenNV(),s.getGioiTinh(), s.getNgaySinh(), s.getCMND(),s.getSDT(), s.getTrangThaiLamViec() , s.getMaDC(),s.getLNV().getTenLNV(), s.getMaTK().getMaTaiKhoan()+""};
			String [] rowData = {s.getMaNV(), s.getTenNV(),s.getGioiTinh(), s.getNgaySinh(), s.getCMND(),s.getSDT(), s.getTrangThaiLamViec() , s.getMaDC(),s.getLNV().getTenLNV()};

			model.addRow(rowData);
			table.setModel(model);
		}
		
	}
	

	public void loadComBoBox() {

		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "SELECT * FROM LoaiNhanVien";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName = resultSet.getString("tenLNV");
                cbLoaiNhanVien.addItem(columnName);
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
	public void loadTable() {
		QLNV_DAO dsnv = new QLNV_DAO();
		model.setRowCount(0);
			for(NhanVien s : dsnv.doctubang()) {
			Object  rowData[] = {s.getMaNV(),s.getTenNV(),s.getGioiTinh(),s.getNgaySinh(),s.getCMND(),s.getSDT(),s.getTrangThaiLamViec(),s.getMaDC(),s.getLNV().getTenLNV()};

//			Object  rowData[] = {s.getMaNV(), s.getTenNV(),s.getGioiTinh(), s.getNgaySinh(), s.getCMND(),s.getSDT(), s.getTrangThaiLamViec() , s.getMaDC(), s.getTenLNV().getTenLNV(),s.getMaTK().getMaTaiKhoan()};

			model.addRow(rowData);

		}
	}
	
//	public void mouseClicked(MouseEvent e) {
//		int row = table.getSelectedRow();
//		txtMaNV.setText(table.getValueAt(row, 0).toString());
//		txtten.setText(table.getValueAt(row,2).toString());
//		r.setText(table.getValueAt(row, 3).toString());
//		txtmk.setText(table.getValueAt(row, 4).toString());
//	}
	
	
	public void lammoi() {
		txtcmnd.setText("");
		txtten.setText("");
		txtns.setText("");
		txtsdt.setText("");
		txtdc.setText("");
		textFieldTrangThaiLamViec.setText("");
		
//		bg.clearSelection();

	}
}