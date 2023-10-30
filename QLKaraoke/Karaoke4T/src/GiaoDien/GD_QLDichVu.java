package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GiaoDien.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;


import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Calendar;

import javax.swing.border.LineBorder;
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
		setBackground(Color.WHITE);
		setTitle("Giao Diện Quản Lý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel left_QLDV = new JPanel();
		left_QLDV.setBorder(null);
		left_QLDV.setBackground(new Color(255, 255, 255, 100));
		left_QLDV.setBounds(0, 148, 294, 465);
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
		
		JButton btnthem = new JButton("Thêm");
		btnthem.setForeground(new Color(255, 255, 255));
		btnthem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthem.setBackground(new Color(90, 167, 167));
		btnthem.setBounds(10, 359, 100, 30);
		btnthem.setBorder(null);
		btnthem.setBorder(BorderFactory.createLineBorder(Color.getColor(null, new Color(90, 167, 167)), 1, true));
		btnthem.setContentAreaFilled(false);
		btnthem.setFocusPainted(false);
		btnthem.setOpaque(true);
		btnthem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnthem.setBackground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnthem.setBackground(new Color(90, 167, 167));
            }
        });
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		left_QLDV.add(btnthem);
		
		JButton btnsua = new JButton("Sửa");
		btnsua.setForeground(Color.WHITE);
		btnsua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsua.setBackground(new Color(226, 211, 107));
		btnsua.setBounds(164, 359, 100, 30);
		btnsua.setBorder(null);
		btnsua.setBorder(BorderFactory.createLineBorder(Color.getColor(null, new Color(226, 211, 107)), 1, true));
		btnsua.setContentAreaFilled(false);
		btnsua.setFocusPainted(false);
		btnsua.setOpaque(true);
		btnsua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnsua.setBackground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnsua.setBackground(new Color(226, 211, 107));
            }
        });
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		left_QLDV.add(btnsua);
		
		JButton btnlammoi = new JButton("Làm mới");
		btnlammoi.setForeground(Color.WHITE);
		btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnlammoi.setBackground(new Color(51, 83, 158));
		btnlammoi.setBounds(164, 413, 100, 30);
		btnlammoi.setBorder(null);
		btnlammoi.setBorder(BorderFactory.createLineBorder(Color.getColor(null, new Color(51, 83, 158)), 1, true));
		btnlammoi.setContentAreaFilled(false);
		btnlammoi.setFocusPainted(false);
		btnlammoi.setOpaque(true);
		btnlammoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnlammoi.setBackground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnlammoi.setBackground(new Color(51, 83, 158));
            }
        });
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		left_QLDV.add(btnlammoi);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.setForeground(Color.WHITE);
		btnxoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnxoa.setBackground(new Color(254, 122, 21));
		btnxoa.setBounds(10, 413, 100, 30);
		btnxoa.setBorder(null);
		btnxoa.setBorder(BorderFactory.createLineBorder(Color.getColor(null, new Color(254, 122, 21)), 1, true));
		btnxoa.setContentAreaFilled(false);
		btnxoa.setFocusPainted(false);
		btnxoa.setOpaque(true);
		btnxoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnxoa.setBackground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnxoa.setBackground(new Color(254, 122, 21));
            }
        });
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		left_QLDV.add(btnxoa);
		
		
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
		panel_dsdv.setBackground(new Color(255, 255, 255));
		scrollPane_DSDV.setViewportView(panel_dsdv);
		panel_dsdv.setLayout(new GridLayout(0, 5, 10, 10));
		
		JPanel dv1 = new JPanel();
		dv1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		dv1.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv1.setBackground(new Color(255, 255, 255));
		panel_dsdv.add(dv1);
		dv1.setLayout(null);
		
		JLabel lblprice_dv1 = new JLabel("15K/Lon");
		lblprice_dv1.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv1.setBounds(39, 115, 85, 35);
		dv1.add(lblprice_dv1);
		
		JLabel lblname_dv1 = new JLabel("Bia SaiGon");
		lblname_dv1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv1.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv1.setBounds(39, 98, 85, 35);
		dv1.add(lblname_dv1);
		
		JLabel lblicon_dv1 = new JLabel("");
		lblicon_dv1.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/BiaSaiGon 1.png")));
		lblicon_dv1.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv1.setBounds(0, 0, 162, 121);
		dv1.add(lblicon_dv1);
		
		JPanel dv2 = new JPanel();
		dv2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv2.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv2.setBackground(new Color(255, 255, 255));
		dv2.setPreferredSize(new Dimension(150, 150));
		panel_dsdv.add(dv2);
		dv2.setLayout(null);
		
		JLabel lblprice_dv2 = new JLabel("18K/Lon");
		lblprice_dv2.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv2.setBounds(36, 115, 85, 35);
		dv2.add(lblprice_dv2);
		
		JLabel lblname_dv2 = new JLabel("Bia Tiger");
		lblname_dv2.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv2.setBounds(36, 98, 85, 35);
		dv2.add(lblname_dv2);
		
		JLabel lblicon_dv2 = new JLabel("");
		lblicon_dv2.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv2.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/BiaTiger 1.png")));
		lblicon_dv2.setBounds(0, 0, 162, 133);
		dv2.add(lblicon_dv2);
		
		JPanel dv3 = new JPanel();
		dv3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv3.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv3.setPreferredSize(new Dimension(150, 150));
		dv3.setBackground(Color.WHITE);
		panel_dsdv.add(dv3);
		dv3.setLayout(null);
		
		JLabel lblprice_dv3 = new JLabel("18K/Lon");
		lblprice_dv3.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv3.setBounds(36, 115, 85, 35);
		dv3.add(lblprice_dv3);
		
		JLabel lblname_dv3 = new JLabel("Bia Ruby");
		lblname_dv3.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv3.setBounds(36, 98, 85, 35);
		dv3.add(lblname_dv3);
		
		JLabel lblicon_dv3 = new JLabel("");
		lblicon_dv3.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/BiaRuby 1.png")));
		lblicon_dv3.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv3.setBounds(0, 0, 162, 133);
		dv3.add(lblicon_dv3);
		
		JPanel dv4 = new JPanel();
		dv4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv4.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv4.setPreferredSize(new Dimension(150, 150));
		dv4.setBackground(Color.WHITE);
		panel_dsdv.add(dv4);
		dv4.setLayout(null);
		
		JLabel lblprice_dv4 = new JLabel("75K/Chai");
		lblprice_dv4.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv4.setBounds(40, 115, 85, 35);
		dv4.add(lblprice_dv4);
		
		JLabel lblname_dv4 = new JLabel("Rượu SoJu");
		lblname_dv4.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv4.setBounds(40, 98, 85, 35);
		dv4.add(lblname_dv4);
		
		JLabel lblicon_dv4 = new JLabel("");
		lblicon_dv4.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/RuouSoJu.png")));
		lblicon_dv4.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv4.setBounds(0, 0, 162, 126);
		dv4.add(lblicon_dv4);
		
		JPanel dv5 = new JPanel();
		dv5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv5.setPreferredSize(new Dimension(150, 150));
		dv5.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv5.setBackground(Color.WHITE);
		panel_dsdv.add(dv5);
		dv5.setLayout(null);
		
		JLabel lblprice_dv5 = new JLabel("200K/Combo");
		lblprice_dv5.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv5.setBounds(0, 115, 162, 35);
		dv5.add(lblprice_dv5);
		
		JLabel lblname_dv5 = new JLabel("Combo Trái Cây 1");
		lblname_dv5.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv5.setBounds(0, 98, 162, 35);
		dv5.add(lblname_dv5);
		
		JLabel lblicon_dv5 = new JLabel("");
		lblicon_dv5.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay1.png")));
		lblicon_dv5.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv5.setBounds(0, 0, 162, 125);
		dv5.add(lblicon_dv5);
		
		JPanel dv6 = new JPanel();
		dv6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv6.setPreferredSize(new Dimension(150, 150));
		dv6.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv6.setBackground(Color.WHITE);
		panel_dsdv.add(dv6);
		dv6.setLayout(null);
		
		JLabel lblprice_dv6 = new JLabel("250K/Combo");
		lblprice_dv6.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv6.setBounds(0, 115, 162, 35);
		dv6.add(lblprice_dv6);
		
		JLabel lblname_dv6 = new JLabel("Combo Trái Cây 2");
		lblname_dv6.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv6.setBounds(0, 98, 162, 35);
		dv6.add(lblname_dv6);
		
		JLabel lblicon_dv6 = new JLabel("");
		lblicon_dv6.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay2_1.png")));
		lblicon_dv6.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv6.setBounds(0, 10, 162, 130);
		dv6.add(lblicon_dv6);
		
		JPanel dv7 = new JPanel();
		dv7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv7.setPreferredSize(new Dimension(150, 150));
		dv7.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv7.setBackground(Color.WHITE);
		panel_dsdv.add(dv7);
		dv7.setLayout(null);
		
		JLabel lblprice_dv7 = new JLabel("250K/Combo");
		lblprice_dv7.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv7.setBounds(0, 115, 162, 35);
		dv7.add(lblprice_dv7);
		
		JLabel lblname_dv7 = new JLabel("Combo Trái Cây 3");
		lblname_dv7.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv7.setBounds(0, 98, 162, 35);
		dv7.add(lblname_dv7);
		
		JLabel lblicon_dv7 = new JLabel("");
		lblicon_dv7.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay3.png")));
		lblicon_dv7.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv7.setBounds(0, 0, 162, 150);
		dv7.add(lblicon_dv7);
		
		JPanel dv8 = new JPanel();
		dv8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv8.setPreferredSize(new Dimension(150, 150));
		dv8.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv8.setBackground(Color.WHITE);
		panel_dsdv.add(dv8);
		dv8.setLayout(null);
		
		JLabel lblprice_dv8 = new JLabel("250K/Combo");
		lblprice_dv8.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv8.setBounds(0, 115, 162, 35);
		dv8.add(lblprice_dv8);
		
		JLabel lblname_dv8 = new JLabel("Combo Trái Cây 4");
		lblname_dv8.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv8.setBounds(0, 98, 162, 35);
		dv8.add(lblname_dv8);
		
		JLabel lblicon_dv8 = new JLabel("");
		lblicon_dv8.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv8.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay4.png")));
		lblicon_dv8.setBounds(0, 0, 162, 140);
		dv8.add(lblicon_dv8);
		
		JPanel dv9 = new JPanel();
		dv9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv9.setPreferredSize(new Dimension(150, 150));
		dv9.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv9.setBackground(Color.WHITE);
		panel_dsdv.add(dv9);
		dv9.setLayout(null);
		
		JLabel lblprice_dv9 = new JLabel("250K/Combo");
		lblprice_dv9.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv9.setBounds(0, 115, 162, 35);
		dv9.add(lblprice_dv9);
		
		JLabel lblname_dv9 = new JLabel("Combo Trái Cây 5");
		lblname_dv9.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv9.setBounds(0, 98, 162, 35);
		dv9.add(lblname_dv9);
		
		JLabel lblicon_dv9 = new JLabel("");
		lblicon_dv9.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/ComboTraiCay5.png")));
		lblicon_dv9.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv9.setBounds(0, 0, 162, 150);
		dv9.add(lblicon_dv9);
		
		JPanel dv10 = new JPanel();
		dv10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv10.setPreferredSize(new Dimension(150, 150));
		dv10.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv10.setBackground(Color.WHITE);
		panel_dsdv.add(dv10);
		dv10.setLayout(null);
		
		JLabel lblprice_dv10 = new JLabel("15K/Chai");
		lblprice_dv10.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv10.setBounds(0, 115, 162, 35);
		dv10.add(lblprice_dv10);
		
		JLabel lblname_dv10 = new JLabel("Sting");
		lblname_dv10.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv10.setBounds(0, 98, 162, 35);
		dv10.add(lblname_dv10);
		
		JLabel lblicon_dv10 = new JLabel("");
		lblicon_dv10.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/Sting.png")));
		lblicon_dv10.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv10.setBounds(0, 0, 162, 124);
		dv10.add(lblicon_dv10);
		
		JPanel dv11 = new JPanel();
		dv11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dv11.setPreferredSize(new Dimension(150, 150));
		dv11.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv11.setBackground(Color.WHITE);
		panel_dsdv.add(dv11);
		dv11.setLayout(null);
		
		JLabel lblprice_dv11 = new JLabel("15K/Lon");
		lblprice_dv11.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv11.setBounds(0, 115, 162, 35);
		dv11.add(lblprice_dv11);
		
		JLabel lblname_dv11 = new JLabel("RedBull");
		lblname_dv11.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv11.setBounds(0, 98, 162, 35);
		dv11.add(lblname_dv11);
		
		JLabel lblicon_dv11 = new JLabel("");
		lblicon_dv11.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/RedBull.png")));
		lblicon_dv11.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv11.setBounds(0, 0, 162, 124);
		dv11.add(lblicon_dv11);
		
		JPanel dv12 = new JPanel();
		dv12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		dv12.setPreferredSize(new Dimension(150, 150));
		dv12.setBorder(new LineBorder(new Color(0, 0, 0)));
		dv12.setBackground(Color.WHITE);
		panel_dsdv.add(dv12);
		dv12.setLayout(null);
		
		JLabel lblprice_dv12 = new JLabel("15K/Chai");
		lblprice_dv12.setHorizontalAlignment(SwingConstants.CENTER);
		lblprice_dv12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprice_dv12.setBounds(0, 115, 162, 35);
		dv12.add(lblprice_dv12);
		
		JLabel lblname_dv12 = new JLabel("Nước Suối");
		lblname_dv12.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv11.setHorizontalAlignment(SwingConstants.CENTER);
		lblname_dv12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname_dv12.setBounds(0, 98, 162, 35);
		dv12.add(lblname_dv12);
		
		JLabel lblicon_dv12 = new JLabel("");
		lblicon_dv12.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/Satori.png")));
		lblicon_dv12.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon_dv12.setBounds(0, 0, 162, 124);
		dv12.add(lblicon_dv12);
		
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
		
		JPanel phonghat = new JPanel();
		phonghat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		phonghat.setBorder(null);
		phonghat.setBackground(new Color(0, 0, 0, 150));
		phonghat.setBounds(0, 70, 232, 80);
		contentPane.add(phonghat);
		phonghat.setLayout(null);
		
		JLabel lblphonghat = new JLabel("Phòng Hát");
		lblphonghat.setForeground(Color.WHITE);
		lblphonghat.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblphonghat.setHorizontalAlignment(SwingConstants.CENTER);
		lblphonghat.setBounds(0, 0, 232, 80);
		phonghat.add(lblphonghat);
		
		JPanel dichvu = new JPanel();
		dichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dichvu.setLayout(null);
		dichvu.setBorder(null);
		dichvu.setBackground(new Color(0, 0, 0, 150));
		dichvu.setBounds(229, 70, 232, 80);
		contentPane.add(dichvu);
		
		JLabel lbldichvu = new JLabel("Dịch Vụ");
		lbldichvu.setHorizontalAlignment(SwingConstants.CENTER);
		lbldichvu.setForeground(Color.WHITE);
		lbldichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldichvu.setBounds(0, 0, 232, 80);
		dichvu.add(lbldichvu);
		
		JPanel nhanvien = new JPanel();
		nhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		nhanvien.setLayout(null);
		nhanvien.setBorder(null);
		nhanvien.setBackground(new Color(0, 0, 0, 150));
		nhanvien.setBounds(462, 70, 232, 80);
		contentPane.add(nhanvien);
		
		JLabel lblnhanvien = new JLabel("Nhân Viên");
		lblnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lblnhanvien.setForeground(Color.WHITE);
		lblnhanvien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblnhanvien.setBounds(0, 0, 232, 80);
		nhanvien.add(lblnhanvien);
		
		JPanel taikhoan = new JPanel();
		taikhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		taikhoan.setLayout(null);
		taikhoan.setBorder(null);
		taikhoan.setBackground(new Color(0, 0, 0, 150));
		taikhoan.setBounds(695, 70, 232, 80);
		contentPane.add(taikhoan);
		
		JLabel lbltaikhoan = new JLabel("Tài Khoản");
		lbltaikhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lbltaikhoan.setForeground(Color.WHITE);
		lbltaikhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltaikhoan.setBounds(0, 0, 232, 80);
		taikhoan.add(lbltaikhoan);
		
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
		
		JLabel lblChucVu = new JLabel("QL");
		lblChucVu.setForeground(new Color(255, 255, 255));
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChucVu.setBounds(894, 10, 45, 27);
		contentPane.add(lblChucVu);
		
		JLabel lblten = new JLabel("Nguyễn Văn C");
		lblten.setForeground(new Color(255, 255, 255));
		lblten.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblten.setBounds(834, 33, 193, 27);
		contentPane.add(lblten);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/370.png")));
		lblNewLabel.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblNewLabel);

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
		lblavatar.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
	
		JLabel lblhinhnen = new JLabel("");
		lblhinhnen.setHorizontalAlignment(SwingConstants.CENTER);
		lblhinhnen.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/370.png")));
		lblhinhnen.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblhinhnen);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
            // Cập nhật thời gian
            updateClock();
        }
	}
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

