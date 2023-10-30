package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.JScrollPane;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.GridLayout;

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;

public class GD_DatDichVu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	private DefaultTableModel model;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DatDichVu frame = new GD_DatDichVu();
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
	public GD_DatDichVu() {
		setBackground(Color.WHITE);
		setTitle("Đặt Dịch Vụ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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

        timer = new Timer(0, this);
        timer.start();
		
		JPanel datphong = new JPanel();
		datphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		datphong.setBorder(null);
		datphong.setBackground(new Color(0, 0, 0, 150));
		datphong.setBounds(0, 70, 232, 80);
		contentPane.add(datphong);
		datphong.setLayout(null);
		
		JLabel lbldatphong = new JLabel("Đặt Phòng");
		lbldatphong.setForeground(Color.WHITE);
		lbldatphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldatphong.setHorizontalAlignment(SwingConstants.CENTER);
		lbldatphong.setBounds(0, 0, 232, 80);
		datphong.add(lbldatphong);
		
		JPanel thuephong = new JPanel();
		thuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thuephong.setLayout(null);
		thuephong.setBorder(null);
		thuephong.setBackground(new Color(0, 0, 0, 150));
		thuephong.setBounds(229, 70, 232, 80);
		contentPane.add(thuephong);
		
		JLabel lblthuephong = new JLabel("Thuê Phòng");
		lblthuephong.setHorizontalAlignment(SwingConstants.CENTER);
		lblthuephong.setForeground(Color.WHITE);
		lblthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthuephong.setBounds(0, 0, 232, 80);
		thuephong.add(lblthuephong);
		
		JPanel datdichvu = new JPanel();
		datdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		datdichvu.setLayout(null);
		datdichvu.setBorder(null);
		datdichvu.setBackground(new Color(0, 0, 0, 150));
		datdichvu.setBounds(462, 70, 232, 80);
		contentPane.add(datdichvu);
		
		JLabel lbltdatdichvu = new JLabel("Đặt Dịch Vụ");
		lbltdatdichvu.setHorizontalAlignment(SwingConstants.CENTER);
		lbltdatdichvu.setForeground(Color.WHITE);
		lbltdatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltdatdichvu.setBounds(0, 0, 232, 80);
		datdichvu.add(lbltdatdichvu);
		
		JPanel khachhang = new JPanel();
		khachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		khachhang.setLayout(null);
		khachhang.setBorder(null);
		khachhang.setBackground(new Color(0, 0, 0, 150));
		khachhang.setBounds(695, 70, 232, 80);
		contentPane.add(khachhang);
		
		JLabel lbltkhachhang = new JLabel("Khách Hàng");
		lbltkhachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lbltkhachhang.setForeground(Color.WHITE);
		lbltkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltkhachhang.setBounds(0, 0, 232, 80);
		khachhang.add(lbltkhachhang);
		
		JPanel thongke = new JPanel();
		thongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thongke.setLayout(null);
		thongke.setBorder(null);
		thongke.setBackground(new Color(0, 0, 0, 150));
		thongke.setBounds(928, 70, 233, 80);
		contentPane.add(thongke);
		
		JLabel lblthongke = new JLabel("Thống Kê");
		lblthongke.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongke.setForeground(Color.WHITE);
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthongke.setBounds(0, 0, 232, 80);
		thongke.add(lblthongke);
		
		JPanel DangXuat = new JPanel();
		DangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		DangXuat.setBorder(null);
		DangXuat.setBackground(new Color(255, 0, 0));
		DangXuat.setBounds(988, 10, 150, 50);
		contentPane.add(DangXuat);
		DangXuat.setLayout(null);
		
		JLabel lblDangXuat = new JLabel("Đăng Xuất");
		lblDangXuat.setForeground(new Color(255, 255, 255));
		lblDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangXuat.setBounds(0, 0, 150, 50);
		DangXuat.add(lblDangXuat);
		
		JPanel Left_DatDichVu = new JPanel();
		Left_DatDichVu.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(192, 192, 192), null));
		Left_DatDichVu.setBackground(new Color(255, 255, 255, 100));
		Left_DatDichVu.setBounds(0, 146, 464, 467);
		contentPane.add(Left_DatDichVu);
		Left_DatDichVu.setLayout(null);
		
		JScrollPane scrollPane_dsDV = new JScrollPane();
		scrollPane_dsDV.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_dsDV.setBounds(0, 50, 464, 417);
		Left_DatDichVu.add(scrollPane_dsDV);
		
		JPanel List = new JPanel();
		scrollPane_dsDV.setViewportView(List);
		List.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel dv01 = new JPanel();
		dv01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv01.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv01.setPreferredSize(new Dimension(150, 150));
		dv01.setBackground(new Color(255, 255, 255));
		List.add(dv01);
		dv01.setLayout(null);
		
		JLabel lblname_Dv_1 = new JLabel("Bia SaiGon");
		lblname_Dv_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_1.setBounds(0, 89, 150, 40);
		dv01.add(lblname_Dv_1);
		
		JLabel lblprice_Dv_1 = new JLabel("15K/Lon");
		lblprice_Dv_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv_1.setBounds(0, 110, 150, 40);
		dv01.add(lblprice_Dv_1);
		
		JLabel lbl_icon_dv1 = new JLabel("");
		lbl_icon_dv1.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/BiaSaiGon 1.png")));
		lbl_icon_dv1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_icon_dv1.setBounds(0, 0, 150, 113);
		dv01.add(lbl_icon_dv1);
		
		JPanel dv02 = new JPanel();
		dv02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv02.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv02.setPreferredSize(new Dimension(150, 150));
		dv02.setBackground(Color.WHITE);
		List.add(dv02);
		dv02.setLayout(null);
		
		JLabel lblname_Dv_2 = new JLabel("Bia Tiger");
		lblname_Dv_2.setBounds(35, 97, 82, 19);
		lblname_Dv_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		dv02.add(lblname_Dv_2);
		
		JLabel lblprice_Dv_2 = new JLabel("18K/Lon");
		lblprice_Dv_2.setBounds(40, 121, 66, 19);
		lblprice_Dv_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		dv02.add(lblprice_Dv_2);
		
		JLabel lblicon_Dv_2 = new JLabel("");
		lblicon_Dv_2.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/BiaTiger 1.png")));
		lblicon_Dv_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_2.setBounds(0, 0, 150, 111);
		dv02.add(lblicon_Dv_2);
		
		JPanel dv03 = new JPanel();
		dv03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv03.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv03.setPreferredSize(new Dimension(150, 150));
		dv03.setBackground(Color.WHITE);
		List.add(dv03);
		dv03.setLayout(null);
		
		JLabel lblname_Dv_3 = new JLabel("Bia Ruby");
		lblname_Dv_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_3.setBounds(28, 98, 82, 19);
		dv03.add(lblname_Dv_3);
		
		JLabel lblprice_Dv_2_1 = new JLabel("18K/Lon");
		lblprice_Dv_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv_2_1.setBounds(37, 121, 66, 19);
		dv03.add(lblprice_Dv_2_1);
		
		JLabel lblicon_Dv_3 = new JLabel("");
		lblicon_Dv_3.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/BiaRuby 1.png")));
		lblicon_Dv_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_3.setBounds(10, 10, 130, 107);
		dv03.add(lblicon_Dv_3);
		
		JPanel dv04 = new JPanel();
		dv04.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv04.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv04.setPreferredSize(new Dimension(150, 150));
		dv04.setBackground(Color.WHITE);
		List.add(dv04);
		dv04.setLayout(null);
		
		JLabel lblname_Dv_4 = new JLabel("Rượu SoJu");
		lblname_Dv_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_4.setBounds(31, 97, 82, 19);
		dv04.add(lblname_Dv_4);
		
		JLabel lblprice_Dv_4 = new JLabel("75K/Chai");
		lblprice_Dv_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv_4.setBounds(25, 121, 93, 19);
		dv04.add(lblprice_Dv_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/RuouSoJu.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 150, 107);
		dv04.add(lblNewLabel_1);
		
		JPanel dv05 = new JPanel();
		dv05.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv05.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv05.setPreferredSize(new Dimension(150, 150));
		dv05.setBackground(Color.WHITE);
		List.add(dv05);
		dv05.setLayout(null);
		
		JLabel lblname_Dv_5 = new JLabel("Combo Trái Cây 1");
		lblname_Dv_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_5.setBounds(0, 97, 150, 19);
		dv05.add(lblname_Dv_5);
		
		JLabel lblprice_Dv_5 = new JLabel("200K/Combo");
		lblprice_Dv_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv_5.setBounds(10, 121, 130, 19);
		dv05.add(lblprice_Dv_5);
		
		JLabel lblicon_Dv_5 = new JLabel("");
		lblicon_Dv_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_5.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/ComboTraiCay1.png")));
		lblicon_Dv_5.setBounds(10, -1, 124, 117);
		dv05.add(lblicon_Dv_5);
		
		JPanel dv06 = new JPanel();
		dv06.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv06.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv06.setPreferredSize(new Dimension(150, 150));
		dv06.setBackground(Color.WHITE);
		List.add(dv06);
		dv06.setLayout(null);
		
		JLabel lblname_Dv_6 = new JLabel("Combo Trái Cây 2");
		lblname_Dv_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_6.setBounds(0, 97, 150, 19);
		dv06.add(lblname_Dv_6);
		
		JLabel lblprice_Dv_ = new JLabel("250K/Combo");
		lblprice_Dv_.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv_.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv_.setBounds(10, 121, 130, 19);
		dv06.add(lblprice_Dv_);
		
		JLabel lblicon_Dv_6 = new JLabel("");
		lblicon_Dv_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_6.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/ComboTraiCay2_1.png")));
		lblicon_Dv_6.setBounds(10, 10, 130, 130);
		dv06.add(lblicon_Dv_6);
		
		JPanel dv07 = new JPanel();
		dv07.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv07.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv07.setPreferredSize(new Dimension(150, 150));
		dv07.setBackground(Color.WHITE);
		List.add(dv07);
		dv07.setLayout(null);
		
		JLabel lblname_Dv_7 = new JLabel("Combo Trái Cây 3");
		lblname_Dv_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_7.setBounds(0, 91, 150, 19);
		dv07.add(lblname_Dv_7);
		
		JLabel lblprice_Dv__7 = new JLabel("250K/Combo");
		lblprice_Dv__7.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv__7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv__7.setBounds(0, 120, 150, 19);
		dv07.add(lblprice_Dv__7);
		
		JLabel lblicon_Dv_7 = new JLabel("");
		lblicon_Dv_7.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/ComboTraiCay3.png")));
		lblicon_Dv_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_7.setBounds(0, 0, 150, 129);
		dv07.add(lblicon_Dv_7);
		
		JPanel dv08 = new JPanel();
		dv08.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv08.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv08.setPreferredSize(new Dimension(150, 150));
		dv08.setBackground(Color.WHITE);
		List.add(dv08);
		dv08.setLayout(null);
		
		JLabel lblname_Dv_8 = new JLabel("Combo Trái Cây 4");
		lblname_Dv_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_8.setBounds(0, 92, 150, 19);
		dv08.add(lblname_Dv_8);
		
		JLabel lblprice_Dv__8 = new JLabel("250K/Combo");
		lblprice_Dv__8.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv__8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv__8.setBounds(0, 121, 150, 19);
		dv08.add(lblprice_Dv__8);
		
		JLabel lblicon_Dv8 = new JLabel("");
		lblicon_Dv8.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv8.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/ComboTraiCay4.png")));
		lblicon_Dv8.setBounds(22, 10, 107, 90);
		dv08.add(lblicon_Dv8);
		
		JPanel dv09 = new JPanel();
		dv09.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv09.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv09.setPreferredSize(new Dimension(150, 150));
		dv09.setBackground(Color.WHITE);
		List.add(dv09);
		dv09.setLayout(null);
		
		JLabel lblname_Dv_9 = new JLabel("Combo Trái Cây 5");
		lblname_Dv_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_9.setBounds(0, 92, 150, 19);
		dv09.add(lblname_Dv_9);
		
		JLabel lblprice_Dv__9 = new JLabel("250K/Combo");
		lblprice_Dv__9.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv__9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv__9.setBounds(0, 121, 150, 19);
		dv09.add(lblprice_Dv__9);
		
		JLabel lblicon_Dv_9 = new JLabel("");
		lblicon_Dv_9.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/ComboTraiCay5.png")));
		lblicon_Dv_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_9.setBounds(0, 0, 150, 110);
		dv09.add(lblicon_Dv_9);
		
		JPanel dv10 = new JPanel();
		dv10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv10.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv10.setPreferredSize(new Dimension(150, 150));
		dv10.setBackground(Color.WHITE);
		List.add(dv10);
		dv10.setLayout(null);
		
		JLabel lblname_Dv_10 = new JLabel("Sting");
		lblname_Dv_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_10.setBounds(0, 95, 150, 19);
		dv10.add(lblname_Dv_10);
		
		JLabel lblprice_Dv__10 = new JLabel("15K/Chai");
		lblprice_Dv__10.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv__10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv__10.setBounds(0, 121, 150, 19);
		dv10.add(lblprice_Dv__10);
		
		JLabel lblicon_Dv_10 = new JLabel("");
		lblicon_Dv_10.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/Sting.png")));
		lblicon_Dv_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_10.setBounds(0, 0, 150, 110);
		dv10.add(lblicon_Dv_10);
		
		JPanel dv11 = new JPanel();
		dv11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv11.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv11.setPreferredSize(new Dimension(150, 150));
		dv11.setBackground(Color.WHITE);
		List.add(dv11);
		dv11.setLayout(null);
		
		JLabel lblname_Dv_11 = new JLabel("Red Bull");
		lblname_Dv_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_11.setBounds(0, 95, 150, 19);
		dv11.add(lblname_Dv_11);
		
		JLabel lblprice_Dv__11 = new JLabel("15K/Lon");
		lblprice_Dv__11.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv__11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv__11.setBounds(0, 121, 150, 19);
		dv11.add(lblprice_Dv__11);
		
		JLabel lblicon_Dv_11 = new JLabel("");
		lblicon_Dv_11.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/RedBull.png")));
		lblicon_Dv_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_11.setBounds(0, 0, 150, 110);
		dv11.add(lblicon_Dv_11);
		
		JPanel dv12 = new JPanel();
		dv12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv12.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv12.setPreferredSize(new Dimension(150, 150));
		dv12.setBackground(Color.WHITE);
		List.add(dv12);
		dv12.setLayout(null);
		
		JLabel lblname_Dv_12 = new JLabel("Nước Suối");
		lblname_Dv_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_Dv_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_Dv_12.setBounds(0, 95, 150, 19);
		dv12.add(lblname_Dv_12);
		
		JLabel lblprice_Dv__12 = new JLabel("15K/Chai");
		lblprice_Dv__12.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_Dv__12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_Dv__12.setBounds(0, 121, 150, 19);
		dv12.add(lblprice_Dv__12);
		
		JLabel lblicon_Dv_12 = new JLabel("");
		lblicon_Dv_12.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/Satori.png")));
		lblicon_Dv_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_Dv_12.setBounds(0, 0, 150, 110);
		dv12.add(lblicon_Dv_12);
		
		JPanel Box_dsdv = new JPanel();
		Box_dsdv.setBackground(new Color(0, 0, 0, 130));
		Box_dsdv.setBounds(0, 10, 464, 42);
		Left_DatDichVu.add(Box_dsdv);
		Box_dsdv.setLayout(null);
		
		JLabel lblDS_DV = new JLabel("Danh Sách Dịch Vụ");
		lblDS_DV.setBounds(10, 5, 454, 37);
		lblDS_DV.setForeground(Color.WHITE);
		lblDS_DV.setFont(new Font("Tahoma", Font.BOLD, 15));
		Box_dsdv.add(lblDS_DV);
		
		
		JPanel Right_DatDichVu = new JPanel();
		Right_DatDichVu.setBackground(new Color(255, 255, 255, 100));
		Right_DatDichVu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), null));
		Right_DatDichVu.setBounds(462, 146, 699, 467);
		contentPane.add(Right_DatDichVu);
		Right_DatDichVu.setLayout(null);
		
		JComboBox comboBox_chonPhong = new JComboBox();
		comboBox_chonPhong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_chonPhong.setBackground(new Color(255, 255, 255));
		comboBox_chonPhong.setBounds(10, 48, 96, 28);
		Right_DatDichVu.add(comboBox_chonPhong);
		
		JLabel lblchonphong = new JLabel("Chọn Phòng");
		lblchonphong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblchonphong.setBounds(10, 10, 96, 28);
		Right_DatDichVu.add(lblchonphong);
		
		JButton btnDatDV = new JButton("Đặt Dịch Vụ");
		btnDatDV.setBackground(new Color(199, 56, 102));
		btnDatDV.setForeground(new Color(255, 255, 255));
		btnDatDV.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatDV.setBounds(527, 26, 150, 50);
		btnDatDV.setBorder(null);
		Right_DatDichVu.add(btnDatDV);
		
		JScrollPane scrollPane_DSDVdadat = new JScrollPane();
		scrollPane_DSDVdadat.setBounds(0, 86, 699, 371);
		Right_DatDichVu.add(scrollPane_DSDVdadat);
		
		table_1 = new JTable();
		table_1.setBorder(null);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane_DSDVdadat.setViewportView(table_1);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã DV");
		model.addColumn("Tên Dịch Vụ");
		model.addColumn("Đơn Giá");
		model.addColumn("Số Lượng");
		model.addColumn("Thêm");
		model.addColumn("Bớt");
		model.addColumn("Xóa");
		table_1.setModel(model);
		
		JLabel lblChucVu = new JLabel("QL");
		lblChucVu.setForeground(Color.WHITE);
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChucVu.setBounds(894, 10, 45, 27);
		contentPane.add(lblChucVu);
		
		JLabel lblten = new JLabel("Nguyễn Văn C");
		lblten.setForeground(Color.WHITE);
		lblten.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblten.setBounds(834, 33, 193, 27);
		contentPane.add(lblten);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/370.png")));
		lblNewLabel.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblNewLabel);
		
	}

	@Override
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