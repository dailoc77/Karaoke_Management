package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GiaoDien.*;
import connectDB.connectDB;
import testbutton.Buttontest;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.border.LineBorder;

import DAO.QLDV_DAO;
import DAO.QLPH_DAO;
import Entity.DichVu;
import Entity.Phong;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;


public class GD_QLDichVu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	private JLabel lblClock;
	private Timer timer;
	private JButton jButton;
	private JTextField textField_madv;
	private JTextField textField_tenDV;
	private JTextField textField_giaDV;
	private JTextField textField_chuthich;
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
            java.util.logging.Logger.getLogger(GD_QLDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QLDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QLDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QLDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_QLDichVu frame = new GD_QLDichVu();
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
	public GD_QLDichVu() {
//		initComponents();
		setBackground(Color.WHITE);
		setTitle("Giao Diện Quản Lý Dịch Vụ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//goi data
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
		
		JPanel left_QLDV = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		left_QLDV.setBackground(new Color(255, 255, 255, 180));
		left_QLDV.setBounds(0, 148, 294, 465);
		left_QLDV.setOpaque(false);
		contentPane.add(left_QLDV);
		left_QLDV.setLayout(null);
		
		textField_madv = new JTextField();
		textField_madv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_madv.setBounds(10, 41, 150, 30);
		textField_madv.setBorder(null);
		left_QLDV.add(textField_madv);
		textField_madv.setColumns(10);
		
		JLabel lblmaDV = new JLabel("Mã Dịch Vụ");
		lblmaDV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblmaDV.setBounds(10, 27, 85, 13);
		left_QLDV.add(lblmaDV);
		
		textField_tenDV = new JTextField();
		textField_tenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tenDV.setColumns(10);
		textField_tenDV.setBorder(null);
		textField_tenDV.setBounds(10, 126, 230, 30);
		left_QLDV.add(textField_tenDV);
		
		JLabel lbltenDV = new JLabel("Tên Dịch Vụ");
		lbltenDV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltenDV.setBounds(10, 112, 85, 13);
		left_QLDV.add(lbltenDV);
		
		textField_giaDV = new JTextField();
		textField_giaDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_giaDV.setColumns(10);
		textField_giaDV.setBorder(null);
		textField_giaDV.setBounds(10, 209, 230, 30);
		left_QLDV.add(textField_giaDV);
		
		JLabel lblgiaDV = new JLabel("Giá Dịch Vụ");
		lblgiaDV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblgiaDV.setBounds(10, 195, 85, 13);
		left_QLDV.add(lblgiaDV);
		
		textField_chuthich = new JTextField();
		textField_chuthich.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_chuthich.setColumns(10);
		textField_chuthich.setBorder(null);
		textField_chuthich.setBounds(10, 299, 230, 30);
		left_QLDV.add(textField_chuthich);
		
		JLabel lblchuthich = new JLabel("Chú Thích");
		lblchuthich.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblchuthich.setBounds(10, 285, 85, 13);
		left_QLDV.add(lblchuthich);
		
		testbutton.Buttontest btnthem = new testbutton.Buttontest();
		btnthem.setText("Thêm");
		btnthem.setForeground(new Color(255, 255, 255));
		btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnthem.setBackground(new Color(90, 167, 167));
		btnthem.setBounds(10, 359, 100, 48);
		btnthem.setRippleColor(new Color(255, 255, 255));
		btnthem.setShadowColor(new Color(0,0,0));
		
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnthemActionPerformed(e);
			}
		});
		left_QLDV.add(btnthem);
		
		testbutton.Buttontest btnsua = new testbutton.Buttontest();
		btnsua.setText("Sửa");
		btnsua.setForeground(Color.WHITE);
		btnsua.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnsua.setBackground(new Color(226, 211, 107));
		btnsua.setBounds(164, 359, 100, 48);
		btnsua.setRippleColor(new Color(255, 255, 255));
		btnsua.setShadowColor(new Color(0,0,0));
		
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnsuaActionPerformed(e);
			}
		});
		left_QLDV.add(btnsua);
		
		testbutton.Buttontest btnlammoi = new testbutton.Buttontest();
		btnlammoi.setText("Làm mới");
		btnlammoi.setForeground(Color.WHITE);
		btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnlammoi.setBackground(new Color(51, 83, 158));
		btnlammoi.setBounds(164, 413, 100, 48);
		btnlammoi.setRippleColor(new Color(255, 255, 255));
		btnlammoi.setShadowColor(new Color(0,0,0));
		
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnlammoiActionPerformed(e);
			}
		});
		left_QLDV.add(btnlammoi);
		
		testbutton.Buttontest btnxoa = new testbutton.Buttontest();
		btnxoa.setText("Xóa");
		btnxoa.setForeground(Color.WHITE);
		btnxoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnxoa.setBackground(new Color(254, 122, 21));
		btnxoa.setBounds(10, 413, 100, 48);
		btnxoa.setRippleColor(new Color(255, 255, 255));
		btnxoa.setShadowColor(new Color(0,0,0));
		
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnxoaActionPerformed(e);
			}
		});
		left_QLDV.add(btnxoa);
		
		
		
//		JPanel panel_dsdv = new JPanel();
//		panel_dsdv.setBackground(new Color(255, 255, 255));
//		scrollPane_DSDV.setViewportView(panel_dsdv);
//		panel_dsdv.setLayout(new GridLayout(0, 5, 10, 10));
//		
//		JPanel dv1 = new JPanel();
//		dv1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//		});
//		dv1.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv1.setBackground(new Color(255, 255, 255));
//		panel_dsdv.add(dv1);
//		dv1.setLayout(null);
//		
//		JLabel lblprice_dv1 = new JLabel("15K/Lon");
//		lblprice_dv1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv1.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv1.setBounds(39, 115, 85, 35);
//		dv1.add(lblprice_dv1);
//		
//		JLabel lblname_dv1 = new JLabel("Bia SaiGon");
//		lblname_dv1.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv1.setBounds(39, 98, 85, 35);
//		dv1.add(lblname_dv1);
//		
//		JLabel lblicon_dv1 = new JLabel("");
//		lblicon_dv1.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/BiaSaiGon 1.png")));
//		lblicon_dv1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv1.setBounds(0, 0, 162, 121);
//		dv1.add(lblicon_dv1);
//		
//		JPanel dv2 = new JPanel();
//		dv2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv2.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv2.setBackground(new Color(255, 255, 255));
//		dv2.setPreferredSize(new Dimension(150, 150));
//		panel_dsdv.add(dv2);
//		dv2.setLayout(null);
//		
//		JLabel lblprice_dv2 = new JLabel("18K/Lon");
//		lblprice_dv2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv2.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv2.setBounds(36, 115, 85, 35);
//		dv2.add(lblprice_dv2);
//		
//		JLabel lblname_dv2 = new JLabel("Bia Tiger");
//		lblname_dv2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv2.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv2.setBounds(36, 98, 85, 35);
//		dv2.add(lblname_dv2);
//		
//		JLabel lblicon_dv2 = new JLabel("");
//		lblicon_dv2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv2.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/BiaTiger 1.png")));
//		lblicon_dv2.setBounds(0, 0, 162, 133);
//		dv2.add(lblicon_dv2);
//		
//		JPanel dv3 = new JPanel();
//		dv3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv3.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv3.setPreferredSize(new Dimension(150, 150));
//		dv3.setBackground(Color.WHITE);
//		panel_dsdv.add(dv3);
//		dv3.setLayout(null);
//		
//		JLabel lblprice_dv3 = new JLabel("18K/Lon");
//		lblprice_dv3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv3.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv3.setBounds(36, 115, 85, 35);
//		dv3.add(lblprice_dv3);
//		
//		JLabel lblname_dv3 = new JLabel("Bia Ruby");
//		lblname_dv3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv3.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv3.setBounds(36, 98, 85, 35);
//		dv3.add(lblname_dv3);
//		
//		JLabel lblicon_dv3 = new JLabel("");
//		lblicon_dv3.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/BiaRuby 1.png")));
//		lblicon_dv3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv3.setBounds(0, 0, 162, 133);
//		dv3.add(lblicon_dv3);
//		
//		JPanel dv4 = new JPanel();
//		dv4.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv4.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv4.setPreferredSize(new Dimension(150, 150));
//		dv4.setBackground(Color.WHITE);
//		panel_dsdv.add(dv4);
//		dv4.setLayout(null);
//		
//		JLabel lblprice_dv4 = new JLabel("75K/Chai");
//		lblprice_dv4.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv4.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv4.setBounds(40, 115, 85, 35);
//		dv4.add(lblprice_dv4);
//		
//		JLabel lblname_dv4 = new JLabel("Rượu SoJu");
//		lblname_dv4.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv4.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv4.setBounds(40, 98, 85, 35);
//		dv4.add(lblname_dv4);
//		
//		JLabel lblicon_dv4 = new JLabel("");
//		lblicon_dv4.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/RuouSoJu.png")));
//		lblicon_dv4.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv4.setBounds(0, 0, 162, 126);
//		dv4.add(lblicon_dv4);
//		
//		JPanel dv5 = new JPanel();
//		dv5.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv5.setPreferredSize(new Dimension(150, 150));
//		dv5.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv5.setBackground(Color.WHITE);
//		panel_dsdv.add(dv5);
//		dv5.setLayout(null);
//		
//		JLabel lblprice_dv5 = new JLabel("200K/Combo");
//		lblprice_dv5.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv5.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv5.setBounds(0, 115, 162, 35);
//		dv5.add(lblprice_dv5);
//		
//		JLabel lblname_dv5 = new JLabel("Combo Trái Cây 1");
//		lblname_dv5.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv5.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv5.setBounds(0, 98, 162, 35);
//		dv5.add(lblname_dv5);
//		
//		JLabel lblicon_dv5 = new JLabel("");
//		lblicon_dv5.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay1.png")));
//		lblicon_dv5.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv5.setBounds(0, 0, 162, 125);
//		dv5.add(lblicon_dv5);
//		
//		JPanel dv6 = new JPanel();
//		dv6.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv6.setPreferredSize(new Dimension(150, 150));
//		dv6.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv6.setBackground(Color.WHITE);
//		panel_dsdv.add(dv6);
//		dv6.setLayout(null);
//		
//		JLabel lblprice_dv6 = new JLabel("250K/Combo");
//		lblprice_dv6.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv6.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv6.setBounds(0, 115, 162, 35);
//		dv6.add(lblprice_dv6);
//		
//		JLabel lblname_dv6 = new JLabel("Combo Trái Cây 2");
//		lblname_dv6.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv6.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv6.setBounds(0, 98, 162, 35);
//		dv6.add(lblname_dv6);
//		
//		JLabel lblicon_dv6 = new JLabel("");
//		lblicon_dv6.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay2_1.png")));
//		lblicon_dv6.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv6.setBounds(0, 10, 162, 130);
//		dv6.add(lblicon_dv6);
//		
//		JPanel dv7 = new JPanel();
//		dv7.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv7.setPreferredSize(new Dimension(150, 150));
//		dv7.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv7.setBackground(Color.WHITE);
//		panel_dsdv.add(dv7);
//		dv7.setLayout(null);
//		
//		JLabel lblprice_dv7 = new JLabel("250K/Combo");
//		lblprice_dv7.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv7.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv7.setBounds(0, 115, 162, 35);
//		dv7.add(lblprice_dv7);
//		
//		JLabel lblname_dv7 = new JLabel("Combo Trái Cây 3");
//		lblname_dv7.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv7.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv7.setBounds(0, 98, 162, 35);
//		dv7.add(lblname_dv7);
//		
//		JLabel lblicon_dv7 = new JLabel("");
//		lblicon_dv7.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay3.png")));
//		lblicon_dv7.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv7.setBounds(0, 0, 162, 150);
//		dv7.add(lblicon_dv7);
//		
//		JPanel dv8 = new JPanel();
//		dv8.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv8.setPreferredSize(new Dimension(150, 150));
//		dv8.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv8.setBackground(Color.WHITE);
//		panel_dsdv.add(dv8);
//		dv8.setLayout(null);
//		
//		JLabel lblprice_dv8 = new JLabel("250K/Combo");
//		lblprice_dv8.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv8.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv8.setBounds(0, 115, 162, 35);
//		dv8.add(lblprice_dv8);
//		
//		JLabel lblname_dv8 = new JLabel("Combo Trái Cây 4");
//		lblname_dv8.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv8.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv8.setBounds(0, 98, 162, 35);
//		dv8.add(lblname_dv8);
//		
//		JLabel lblicon_dv8 = new JLabel("");
//		lblicon_dv8.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv8.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay4.png")));
//		lblicon_dv8.setBounds(0, 0, 162, 140);
//		dv8.add(lblicon_dv8);
//		
//		JPanel dv9 = new JPanel();
//		dv9.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv9.setPreferredSize(new Dimension(150, 150));
//		dv9.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv9.setBackground(Color.WHITE);
//		panel_dsdv.add(dv9);
//		dv9.setLayout(null);
//		
//		JLabel lblprice_dv9 = new JLabel("250K/Combo");
//		lblprice_dv9.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv9.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv9.setBounds(0, 115, 162, 35);
//		dv9.add(lblprice_dv9);
//		
//		JLabel lblname_dv9 = new JLabel("Combo Trái Cây 5");
//		lblname_dv9.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv9.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv9.setBounds(0, 98, 162, 35);
//		dv9.add(lblname_dv9);
//		
//		JLabel lblicon_dv9 = new JLabel("");
//		lblicon_dv9.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay5.png")));
//		lblicon_dv9.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv9.setBounds(0, 0, 162, 150);
//		dv9.add(lblicon_dv9);
//		
//		JPanel dv10 = new JPanel();
//		dv10.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv10.setPreferredSize(new Dimension(150, 150));
//		dv10.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv10.setBackground(Color.WHITE);
//		panel_dsdv.add(dv10);
//		dv10.setLayout(null);
//		
//		JLabel lblprice_dv10 = new JLabel("15K/Chai");
//		lblprice_dv10.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv10.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv10.setBounds(0, 115, 162, 35);
//		dv10.add(lblprice_dv10);
//		
//		JLabel lblname_dv10 = new JLabel("Sting");
//		lblname_dv10.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv10.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv10.setBounds(0, 98, 162, 35);
//		dv10.add(lblname_dv10);
//		
//		JLabel lblicon_dv10 = new JLabel("");
//		lblicon_dv10.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/Sting.png")));
//		lblicon_dv10.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv10.setBounds(0, 0, 162, 124);
//		dv10.add(lblicon_dv10);
//		
//		JPanel dv11 = new JPanel();
//		dv11.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		dv11.setPreferredSize(new Dimension(150, 150));
//		dv11.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv11.setBackground(Color.WHITE);
//		panel_dsdv.add(dv11);
//		dv11.setLayout(null);
//		
//		JLabel lblprice_dv11 = new JLabel("15K/Lon");
//		lblprice_dv11.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv11.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv11.setBounds(0, 115, 162, 35);
//		dv11.add(lblprice_dv11);
//		
//		JLabel lblname_dv11 = new JLabel("RedBull");
//		lblname_dv11.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv11.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv11.setBounds(0, 98, 162, 35);
//		dv11.add(lblname_dv11);
//		
//		JLabel lblicon_dv11 = new JLabel("");
//		lblicon_dv11.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/RedBull.png")));
//		lblicon_dv11.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv11.setBounds(0, 0, 162, 124);
//		dv11.add(lblicon_dv11);
//		
//		JPanel dv12 = new JPanel();
//		dv12.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//		});
//		dv12.setPreferredSize(new Dimension(150, 150));
//		dv12.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dv12.setBackground(Color.WHITE);
//		panel_dsdv.add(dv12);
//		dv12.setLayout(null);
//		
//		JLabel lblprice_dv12 = new JLabel("15K/Chai");
//		lblprice_dv12.setHorizontalAlignment(SwingConstants.CENTER);
//		lblprice_dv12.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblprice_dv12.setBounds(0, 115, 162, 35);
//		dv12.add(lblprice_dv12);
//		
//		JLabel lblname_dv12 = new JLabel("Nước Suối");
//		lblname_dv12.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv11.setHorizontalAlignment(SwingConstants.CENTER);
//		lblname_dv12.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblname_dv12.setBounds(0, 98, 162, 35);
//		dv12.add(lblname_dv12);
//		
//		JLabel lblicon_dv12 = new JLabel("");
//		lblicon_dv12.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/Satori.png")));
//		lblicon_dv12.setHorizontalAlignment(SwingConstants.CENTER);
//		lblicon_dv12.setBounds(0, 0, 162, 124);
//		dv12.add(lblicon_dv12);
		
		JButton jButton_1 = new JButton("Đăng Xuất");
		jButton_1.setBounds(990, 10, 150, 50);
		jButton_1.setFont(new Font("Tahoma ", Font.BOLD, 14));
		jButton_1.setBackground(new Color(255, 0, 0));
		jButton_1.setForeground(Color.WHITE);
		
			jButton_1.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
			jButton_1.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
			jButton_1.setContentAreaFilled(false);
			jButton_1.setFocusPainted(false);
			jButton_1.setOpaque(true);
			contentPane.add(jButton_1);
			
					jButton_1.addMouseListener(new MouseAdapter() {
					    @Override
					    public void mouseEntered(MouseEvent e) {
					        jButton_1.setBackground(Color.BLACK);
					    }
			
					    @Override
					    public void mouseExited(MouseEvent e) {
					        jButton_1.setBackground(new Color(255, 0, 0));
					    }
					});
					
							jButton_1.addActionListener(new ActionListener() {
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
			}
		});
        btndichvu.setBorder(null);
        btndichvu.setText("Dịch Vụ");
        btndichvu.setForeground(Color.WHITE);
        btndichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndichvu.setBackground(new Color(128, 128,128, 150));
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
				gdtk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdtk.setVisible(true);
				dispose();
			}
		});
        btntaikhoan.setBorder(null);
        btntaikhoan.setText("Tài Khoản");
        btntaikhoan.setForeground(Color.WHITE);
        btntaikhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
        btntaikhoan.setBackground(new Color(0, 0, 0, 150));
        btntaikhoan.setBounds(695, 70, 232, 87);
		contentPane.add(btntaikhoan);
		btntaikhoan.setLayout(null);
		
        testbutton.Buttontest btnthongke = new testbutton.Buttontest();
        btnthongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_ThongKeHoaDon gdtk = new GD_ThongKeHoaDon();
				gdtk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdtk.setVisible(true);
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
		
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_TaiKhoan.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/370.png")));
		lblNewLabel.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblNewLabel);
	
		JLabel lblhinhnen = new JLabel("");
		lblhinhnen.setHorizontalAlignment(SwingConstants.CENTER);
		lblhinhnen.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/370.png")));
		lblhinhnen.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblhinhnen);
	}
	protected void btnxoaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void btnlammoiActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void btnsuaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void btnthemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
            // Cập nhật thời gian
            updateClock();
        }
	}
	
	private void loadData() {
		QLDV_DAO ds = new QLDV_DAO();
		ArrayList<DichVu> listDV = ds.docbang();
		draw(listDV);
	}
	
	private void draw(ArrayList<DichVu> listdv) {
		JPanel Right_QLDV = new JPanel();
		Right_QLDV.setBorder(null);
		Right_QLDV.setBackground(new Color(255, 255, 255, 150));
		Right_QLDV.setBounds(291, 148, 870, 465);
		contentPane.add(Right_QLDV);
		Right_QLDV.setLayout(null);
		
		JScrollPane scrollPane_DSDV = new JScrollPane();
		scrollPane_DSDV.setBounds(0, 25, 870, 440);
		scrollPane_DSDV.setBackground(new Color(255, 255, 255, 0));
		Right_QLDV.add(scrollPane_DSDV);
		
		JPanel panel_dsdv = new JPanel();
		panel_dsdv.setBackground(new Color(192, 192, 192));
		scrollPane_DSDV.setViewportView(panel_dsdv);
		panel_dsdv.setLayout(new GridLayout(0, 5, 10, 10));
    	for(DichVu dv : listdv) {
    		//load label cha
    		JLabel lbl_dichvu = new JLabel();
    		lbl_dichvu.setBackground(new Color(255, 255, 255));
    		lbl_dichvu.setBorder(LineBorder.createBlackLineBorder());
    		panel_dsdv.add(lbl_dichvu);
    		lbl_dichvu.setLayout(null);

    		
    		//load label gia
    		JLabel lbl_price = new JLabel(dv.getGiaDichVu() + "/1 cái");
    		lbl_price.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_price.setFont(new Font("Tahoma", Font.BOLD, 11));
//    		lbl_price.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lbl_price.setBounds(39, 115, 85, 35);
    		lbl_dichvu.add(lbl_price);
    		
    		//load ten dich vu
    		JLabel lbl_name = new JLabel(dv.getTenDichVu());
    		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 13));
    		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_name.setBounds(39, 98, 85, 35);
    		lbl_dichvu.add(lbl_name);
    		
    		//load hinh anh
    		JLabel lbl_hinhanh = new JLabel("");
    		lbl_hinhanh.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/BiaSaiGon 1.png")));
    		lbl_hinhanh.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_hinhanh.setBounds(0, 0, 162, 121);
    		lbl_dichvu.add(lbl_hinhanh);
    		
    		lbl_dichvu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					textField_madv.setText(" " + dv.getMaDichVu());
					textField_tenDV.setText(" " + dv.getTenDichVu());
					textField_giaDV.setText(" " + dv.getGiaDichVu());
				}
			});
    		
		}
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
	
	//dong ho
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
        
        String time = String.format("%02d:%02d:%02d %s  %02d/%02d/%04d", hour, minute, second, ampm, day, month, year);
        lblClock.setText(time);
    }
}

