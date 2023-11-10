package GiaoDien;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import testbutton.Buttontest;

public class GD_ChiTietPhong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietPhong frame = new GD_ChiTietPhong();
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
	public GD_ChiTietPhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 658);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl_chitietphong = new JPanel();
		pnl_chitietphong.setBackground(new Color(133, 133, 194));
		pnl_chitietphong.setBounds(0, 0, 1159, 66);
		contentPane.add(pnl_chitietphong);
		pnl_chitietphong.setLayout(null);
		
		JLabel lbl_chiTietPhong = new JLabel("Chi tiết phòng");
		lbl_chiTietPhong.setForeground(new Color(255, 255, 255));
		lbl_chiTietPhong.setBounds(460, 11, 214, 45);
		pnl_chitietphong.add(lbl_chiTietPhong);
		lbl_chiTietPhong.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JPanel pnl_thongtinphong = new JPanel();
		pnl_thongtinphong.setBackground(new Color(230, 230, 230));
		pnl_thongtinphong.setBounds(10, 77, 546, 485);
		contentPane.add(pnl_thongtinphong);
		pnl_thongtinphong.setLayout(null);
		
		JPanel pnl_thongtinphongtxt = new JPanel();
		pnl_thongtinphongtxt.setBounds(10, 11, 526, 39);
		pnl_thongtinphong.add(pnl_thongtinphongtxt);
		
		JLabel lblNewLabel = new JLabel("Thông tin phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnl_thongtinphongtxt.add(lblNewLabel);
		
		JLabel lbl_iconmicro = new JLabel("");
		lbl_iconmicro.setIcon(new ImageIcon(GD_ChiTietPhong.class.getResource("/Imgs/Mic.png")));
		lbl_iconmicro.setBounds(307, 47, 70, 81);
		pnl_thongtinphong.add(lbl_iconmicro);
		
		JLabel lbl_tenphong = new JLabel("Phòng ...");
		lbl_tenphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_tenphong.setBounds(186, 73, 111, 25);
		pnl_thongtinphong.add(lbl_tenphong);
		
		JPanel pnl_showthongtin = new JPanel();
		pnl_showthongtin.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		pnl_showthongtin.setBackground(new Color(230, 230, 230));
		pnl_showthongtin.setBounds(52, 139, 434, 215);
		pnl_thongtinphong.add(pnl_showthongtin);
		pnl_showthongtin.setLayout(null);
		
		JLabel lbl_trangthaiphong = new JLabel("Trạng thái phòng :");
		lbl_trangthaiphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_trangthaiphong.setBounds(25, 11, 164, 25);
		pnl_showthongtin.add(lbl_trangthaiphong);
		
		JLabel lbl_loaiphong = new JLabel("Loại phòng :");
		lbl_loaiphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_loaiphong.setBounds(25, 57, 164, 25);
		pnl_showthongtin.add(lbl_loaiphong);
		
		JLabel lbl_soluongnguoi = new JLabel("Số lượng người :");
		lbl_soluongnguoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_soluongnguoi.setBounds(25, 112, 164, 25);
		pnl_showthongtin.add(lbl_soluongnguoi);
		
		JLabel lbl_giatien = new JLabel("Giá tiền/h :");
		lbl_giatien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_giatien.setBounds(25, 168, 164, 25);
		pnl_showthongtin.add(lbl_giatien);
		
		JLabel lblNewLabel_1 = new JLabel("Chuyển phòng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 365, 111, 25);
		pnl_thongtinphong.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(126, 377, 364, 2);
		pnl_thongtinphong.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Phòng số:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(28, 412, 93, 25);
		pnl_thongtinphong.add(lblNewLabel_2);
		
		JComboBox cbB_chonphong = new JComboBox();
		cbB_chonphong.setBounds(126, 415, 272, 22);
		pnl_thongtinphong.add(cbB_chonphong);
		
		
		testbutton.Buttontest btnchuyenphong = new testbutton.Buttontest();
		btnchuyenphong.setBounds(408, 412, 111, 39);
		pnl_thongtinphong.add(btnchuyenphong);
        btnchuyenphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
        btnchuyenphong.setBorder(null);
        btnchuyenphong.setText("Chuyển");
        btnchuyenphong.setForeground(Color.WHITE);
        btnchuyenphong.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnchuyenphong.setBackground(new Color(128, 128, 255));
		btnchuyenphong.setLayout(null);
		
		JPanel pnl_hoadontam = new JPanel();
		pnl_hoadontam.setBackground(new Color(230, 230, 230));
		pnl_hoadontam.setBounds(566, 77, 583, 485);
		contentPane.add(pnl_hoadontam);
		pnl_hoadontam.setLayout(null);
		
		JPanel pnl_hoadontamtxt = new JPanel();
		pnl_hoadontamtxt.setBounds(10, 11, 563, 39);
		pnl_hoadontam.add(pnl_hoadontamtxt);
		
		JLabel lbl_hoadontam = new JLabel("Hóa đơn tạm");
		lbl_hoadontam.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnl_hoadontamtxt.add(lbl_hoadontam);
		
		JLabel lbl_sdtKH = new JLabel("SĐT Khách Hàng:");
		lbl_sdtKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_sdtKH.setBounds(20, 73, 148, 15);
		pnl_hoadontam.add(lbl_sdtKH);
		
		JLabel lbl_tenkhach = new JLabel("Tên Khách Hàng:");
		lbl_tenkhach.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tenkhach.setBounds(20, 99, 148, 15);
		pnl_hoadontam.add(lbl_tenkhach);
		
		JLabel lbl_tennhanvien = new JLabel("Tên Nhân Viên:");
		lbl_tennhanvien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tennhanvien.setBounds(20, 125, 148, 15);
		pnl_hoadontam.add(lbl_tennhanvien);
		
		JLabel lbl_mahoadon = new JLabel("Mã Hóa Đơn:");
		lbl_mahoadon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_mahoadon.setBounds(312, 73, 148, 15);
		pnl_hoadontam.add(lbl_mahoadon);
		
		JLabel lblNewLabel_3_4 = new JLabel("Giờ Vào:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(312, 99, 148, 15);
		pnl_hoadontam.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Thời Lượng:");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(312, 125, 148, 15);
		pnl_hoadontam.add(lblNewLabel_3_5);
		
		table = new JTable();
		table.setBounds(10, 151, 563, 199);
		pnl_hoadontam.add(table);
		
		JLabel lblNewLabel_3 = new JLabel("Mã giảm giá");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 374, 82, 17);
		pnl_hoadontam.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(102, 374, 121, 20);
		pnl_hoadontam.add(textField);
		textField.setColumns(10);
		
		Buttontest btntstKimTra = new Buttontest();
		btntstKimTra.setText("Kiểm tra");
		btntstKimTra.setForeground(Color.WHITE);
		btntstKimTra.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntstKimTra.setBorder(null);
		btntstKimTra.setBackground(new Color(128, 128, 255));
		btntstKimTra.setBounds(233, 361, 111, 39);
		pnl_hoadontam.add(btntstKimTra);
		
		JLabel lbl_chietkhau = new JLabel("Chiết khẩu:");
		lbl_chietkhau.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_chietkhau.setBounds(10, 409, 148, 15);
		pnl_hoadontam.add(lbl_chietkhau);
		
		JLabel lbl_vat = new JLabel("Thuế VAT:");
		lbl_vat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_vat.setBounds(10, 435, 148, 15);
		pnl_hoadontam.add(lbl_vat);
		
		JLabel lbl_tiendichvu = new JLabel("Tiền dịch vụ:");
		lbl_tiendichvu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tiendichvu.setBounds(312, 411, 148, 15);
		pnl_hoadontam.add(lbl_tiendichvu);
		
		JLabel lbl_tienphong = new JLabel("Tiền phòng:");
		lbl_tienphong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tienphong.setBounds(312, 435, 148, 15);
		pnl_hoadontam.add(lbl_tienphong);
		
		Buttontest btntstCpNhtDch = new Buttontest();
		btntstCpNhtDch.setText("Cập nhật dịch vụ");
		btntstCpNhtDch.setForeground(Color.WHITE);
		btntstCpNhtDch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btntstCpNhtDch.setBorder(null);
		btntstCpNhtDch.setBackground(new Color(128, 128, 255));
		btntstCpNhtDch.setBounds(389, 361, 184, 39);
		pnl_hoadontam.add(btntstCpNhtDch);
		
		JLabel lbl_tongcong = new JLabel("Tổng tiền:");
		lbl_tongcong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tongcong.setBounds(312, 461, 148, 15);
		pnl_hoadontam.add(lbl_tongcong);
		
		Buttontest btntstTnhTin = new Buttontest();
		btntstTnhTin.setText("Tính tiền");
		btntstTnhTin.setForeground(Color.WHITE);
		btntstTnhTin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btntstTnhTin.setBorder(null);
		btntstTnhTin.setBackground(new Color(0, 198, 50));
		btntstTnhTin.setBounds(1011, 572, 111, 39);
		contentPane.add(btntstTnhTin);
		
		Buttontest btntstQuayLi = new Buttontest();
		btntstQuayLi.setText("Quay lại");
		btntstQuayLi.setForeground(Color.WHITE);
		btntstQuayLi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btntstQuayLi.setBorder(null);
		btntstQuayLi.setBackground(new Color(19, 142, 234));
		btntstQuayLi.setBounds(37, 572, 111, 39);
		contentPane.add(btntstQuayLi);
		
	}
}
