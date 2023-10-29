package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.UIManager;

public class QuanLyKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhachHang frame = new QuanLyKhachHang();
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
	
	
	
	public QuanLyKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel datphong = new JPanel();
		datphong.setBounds(0, 70, 232, 80);
//		datphong.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//			}
//		});
		
		datphong.setBorder(null);
		datphong.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(datphong);
		datphong.setLayout(null);
		
		JLabel lbldatphong = new JLabel("Đặt Phòng");
		lbldatphong.setForeground(Color.WHITE);
		lbldatphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldatphong.setHorizontalAlignment(SwingConstants.CENTER);
		lbldatphong.setBounds(0, 0, 232, 80);
		datphong.add(lbldatphong);
		
		JPanel thuephong = new JPanel();
		thuephong.setBounds(229, 70, 232, 80);
		thuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thuephong.setLayout(null);
		thuephong.setBorder(null);
		thuephong.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(thuephong);
		
		JLabel lblthuephong = new JLabel("Thuê Phòng");
		lblthuephong.setHorizontalAlignment(SwingConstants.CENTER);
		lblthuephong.setForeground(Color.WHITE);
		lblthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthuephong.setBounds(0, 0, 232, 80);
		thuephong.add(lblthuephong);
		
		JPanel datdichvu = new JPanel();
		datdichvu.setBounds(462, 70, 232, 80);
		datdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		datdichvu.setLayout(null);
		datdichvu.setBorder(null);
		datdichvu.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(datdichvu);
		
		JLabel lbltdatdichvu = new JLabel("Đặt Dịch Vụ");
		lbltdatdichvu.setHorizontalAlignment(SwingConstants.CENTER);
		lbltdatdichvu.setForeground(Color.WHITE);
		lbltdatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltdatdichvu.setBounds(0, 0, 232, 80);
		datdichvu.add(lbltdatdichvu);
		
		JPanel khachhang = new JPanel();
		khachhang.setBounds(695, 70, 232, 80);
		khachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		khachhang.setLayout(null);
		khachhang.setBorder(null);
		khachhang.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(khachhang);
		
		JLabel lbltkhachhang = new JLabel("Khách Hàng");
		lbltkhachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lbltkhachhang.setForeground(Color.WHITE);
		lbltkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltkhachhang.setBounds(0, 0, 232, 80);
		khachhang.add(lbltkhachhang);
		
		JPanel thongke = new JPanel();
		thongke.setBounds(928, 70, 233, 80);
		thongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thongke.setLayout(null);
		thongke.setBorder(null);
		thongke.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(thongke);
		
		JLabel lblthongke = new JLabel("Thống Kê");
		lblthongke.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongke.setForeground(Color.WHITE);
		
		
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthongke.setBounds(0, 0, 232, 80);
		thongke.add(lblthongke);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 149, 1161, 101);
		panel.setBackground(new Color(255, 255, 255,150));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập họ và tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(31, 26, 159, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(31, 64, 145, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(372, 26, 135, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số CMND");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(373, 64, 92, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Địa chỉ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(661, 67, 55, 14);
		panel.add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setBounds(179, 22, 145, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBackground(UIManager.getColor("CheckBox.highlight"));
		rdbtnNewRadioButton.setBounds(700, 26, 21, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBounds(767, 26, 21, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Nam");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(661, 27, 33, 12);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Nữ");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(740, 26, 21, 14);
		panel.add(lblNewLabel_1_6);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 63, 145, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(475, 22, 145, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(475, 60, 145, 27);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(726, 60, 202, 27);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("Thêm ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(90, 167, 167));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(958, 24, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnXa_1 = new JButton("Xóa");
		btnXa_1.setForeground(SystemColor.text);
		btnXa_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXa_1.setBackground(new Color(254, 122, 21));
		btnXa_1.setBounds(958, 62, 89, 23);
		panel.add(btnXa_1);
		
		JButton btnXa = new JButton("Sửa");
		btnXa.setForeground(SystemColor.text);
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXa.setBackground(new Color(226, 211, 107));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXa.setBounds(1057, 24, 89, 23);
		panel.add(btnXa);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setForeground(SystemColor.text);
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLmMi.setBackground(new Color(51, 83, 158));
		btnLmMi.setBounds(1057, 62, 89, 23);
		panel.add(btnLmMi);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		table.setBounds(0, 250, 1161, 363);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1161, 613);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/Imgs/370.png")));
		
		table_1 = new JTable();
		table_1.setBounds(391, 261, -308, 77);
		contentPane.add(table_1);
	}
}
