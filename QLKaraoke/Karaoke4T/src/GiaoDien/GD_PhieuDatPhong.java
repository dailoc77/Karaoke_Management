package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GD_PhieuDatPhong extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_PhieuDatPhong frame = new GD_PhieuDatPhong();
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
	public GD_PhieuDatPhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SỐ PHÒNG : ");
		lblNewLabel.setBounds(188, 11, 152, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lbl_TenKH = new JLabel("Tên Khách Hàng :");
		lbl_TenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_TenKH.setBounds(97, 88, 114, 16);
		contentPane.add(lbl_TenKH);
		
		JLabel lbl_SDT = new JLabel("Số Điện Thoại :");
		lbl_SDT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_SDT.setBounds(97, 129, 114, 16);
		contentPane.add(lbl_SDT);
		
		JLabel lbl_CMND = new JLabel("CMND :");
		lbl_CMND.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_CMND.setBounds(97, 167, 57, 16);
		contentPane.add(lbl_CMND);
		
		JLabel lbl_DiaChi = new JLabel("Địa Chỉ :");
		lbl_DiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_DiaChi.setBounds(97, 205, 62, 16);
		contentPane.add(lbl_DiaChi);
		
		JLabel lbl_SoNguoi = new JLabel("Số Người :");
		lbl_SoNguoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_SoNguoi.setBounds(420, 88, 76, 16);
		contentPane.add(lbl_SoNguoi);
		
		JLabel lbl_GiaTien = new JLabel("Giá Tiền :");
		lbl_GiaTien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_GiaTien.setBounds(420, 129, 76, 16);
		contentPane.add(lbl_GiaTien);
		
		JButton btn_quayLai = new JButton("Quay lại");
		btn_quayLai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatPhong datphong = new GD_DatPhong();
	            datphong.setVisible(true);
	            datphong.setLocationRelativeTo(null);
	            dispose();
			}
		});
		btn_quayLai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_quayLai.setForeground(new Color(255, 255, 255));
		btn_quayLai.setBackground(new Color(0, 128, 255));
		btn_quayLai.setBounds(110, 260, 131, 49);
		contentPane.add(btn_quayLai);
		
		
		JButton btn_xacNhan = new JButton("Xác nhận");
		btn_xacNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatPhong datphong = new GD_DatPhong();
	            datphong.setVisible(true);
	            datphong.setLocationRelativeTo(null);
	            dispose();
			}
		});
		btn_xacNhan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_xacNhan.setForeground(Color.WHITE);
		btn_xacNhan.setBackground(new Color(0, 166, 0));
		btn_xacNhan.setBounds(356, 260, 131, 49);
		contentPane.add(btn_xacNhan);
		
		JLabel lbl_TenPhong = new JLabel("");
		lbl_TenPhong.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_TenPhong.setBounds(337, 11, 76, 29);
		contentPane.add(lbl_TenPhong);
	}
}
