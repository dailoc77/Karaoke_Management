package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
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
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GD_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
		initComponents();
		setBackground(Color.WHITE);
		setTitle("Đặt Dịch Vụ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(null);

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
		
        testbutton.Buttontest btndatphong1 = new testbutton.Buttontest();
        btndatphong1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatPhong gddatphong = new GD_DatPhong();
				gddatphong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gddatphong.setVisible(true);
				dispose();
			}
		});
        btndatphong1.setBorder(null);
        btndatphong1.setText("Đặt Phòng");
        btndatphong1.setForeground(Color.WHITE);
        btndatphong1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatphong1.setBackground(new Color(0,0,0,150));
        btndatphong1.setBounds(0, 70, 199, 87);
		contentPane.add(btndatphong1);
		btndatphong1.setLayout(null);
		
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

			}
		});
        btndatdichvu.setBorder(null);
        btndatdichvu.setText("Đặt Dịch Vụ");
        btndatdichvu.setForeground(Color.WHITE);
        btndatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatdichvu.setBackground(new Color(128,128,128, 150));
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
		
		JPanel DangXuat = new JPanel();
		DangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
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
		
		
		JPanel Right_DatDichVu = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		Right_DatDichVu.setBackground(new Color(255, 255, 255, 100));
		Right_DatDichVu.setBounds(462, 146, 699, 467);
		Right_DatDichVu.setOpaque(false);
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
		
		testbutton.Buttontest btnDatDV = new testbutton.Buttontest();
		btnDatDV.setText("Đặt Dịch Vụ");
		btnDatDV.setBackground(new Color(199, 56, 102));
		btnDatDV.setForeground(new Color(255, 255, 255));
		btnDatDV.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatDV.setBounds(527, 26, 150, 50);
		btnDatDV.setRippleColor(new Color(255, 255, 255));
		btnDatDV.setShadowColor(new Color(0,0,0));
		btnDatDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDatDVActionPerformed(e);
			}
		});
		Right_DatDichVu.add(btnDatDV);
		
		JScrollPane scrollPane_DSDVdadat = new JScrollPane();

		scrollPane_DSDVdadat.setBounds(0, 86, 699, 371);
		scrollPane_DSDVdadat.setBackground(new Color(255, 255, 255));

		scrollPane_DSDVdadat.setBounds(0, 86, 699, 381);

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
		
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/370.png")));
		lblNewLabel.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblNewLabel);
		
	}

	protected void btnDatDVActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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