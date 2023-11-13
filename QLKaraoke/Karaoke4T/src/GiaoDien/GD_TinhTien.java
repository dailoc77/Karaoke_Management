package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.QLPH_DAO;
import Entity.Phong;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import testbutton.Buttontest;
import javax.swing.JCheckBox;

public class GD_TinhTien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txt_tienNhan;
	JLabel lbl_tenPhongTT;
	JLabel lbl_sdtKH;
	JLabel lbl_tenKH;
	JLabel lbl_tenNV;
	JLabel lbl_gioNhanPhong;
	JLabel lbl_gioTraPhong;
	JLabel lbl_tongThoiLuong;
	JLabel lbl_tienDichVu;
	JLabel lbl_tienPhong;
	JLabel lbl_tongCong;
	JCheckBox cbox_xuatHoaDon;
	JLabel lbl_tienThua;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_TinhTien frame = new GD_TinhTien();
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
	public GD_TinhTien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl_txt_tinhTien = new JPanel();
		pnl_txt_tinhTien.setBackground(new Color(0, 88, 176));
		pnl_txt_tinhTien.setBounds(0, 0, 804, 83);
		contentPane.add(pnl_txt_tinhTien);
		pnl_txt_tinhTien.setLayout(null);
		
		lbl_tenPhongTT = new JLabel("");
		lbl_tenPhongTT.setForeground(new Color(255, 255, 255));
		lbl_tenPhongTT.setBounds(239, 23, 317, 49);
		pnl_txt_tinhTien.add(lbl_tenPhongTT);
		lbl_tenPhongTT.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel lblNewLabel_1 = new JLabel("SĐT Khách :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(60, 141, 97, 20);
		contentPane.add(lblNewLabel_1);
		
		lbl_sdtKH = new JLabel("0123456789");
		lbl_sdtKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_sdtKH.setBounds(160, 141, 97, 20);
		contentPane.add(lbl_sdtKH);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ và KH :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(60, 186, 115, 20);
		contentPane.add(lblNewLabel_1_2);
		
		lbl_tenKH = new JLabel("Trương Đại Lộc");
		lbl_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenKH.setBounds(160, 186, 194, 20);
		contentPane.add(lbl_tenKH);
		
		JLabel lblNewLabel_1_3 = new JLabel("Họ tên NV:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(60, 233, 97, 20);
		contentPane.add(lblNewLabel_1_3);
		
		lbl_tenNV = new JLabel("Nguyễn Văn C");
		lbl_tenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenNV.setBounds(160, 233, 194, 20);
		contentPane.add(lbl_tenNV);
		
		JLabel lblNewLabel_1_4 = new JLabel("Giờ nhận phòng :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(465, 141, 129, 20);
		contentPane.add(lblNewLabel_1_4);
		
		lbl_gioNhanPhong = new JLabel("17:30");
		lbl_gioNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_gioNhanPhong.setBounds(604, 141, 190, 20);
		contentPane.add(lbl_gioNhanPhong);
		
		JLabel lblNewLabel_1_5 = new JLabel("Giờ trả phòng :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(465, 186, 115, 20);
		contentPane.add(lblNewLabel_1_5);
		
		lbl_gioTraPhong = new JLabel("18:30");
		lbl_gioTraPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_gioTraPhong.setBounds(604, 186, 190, 20);
		contentPane.add(lbl_gioTraPhong);
		
		JLabel lblNewLabel_1_6 = new JLabel("Tổng thời lượng :");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(465, 233, 129, 20);
		contentPane.add(lblNewLabel_1_6);
		
		lbl_tongThoiLuong = new JLabel("60 phút");
		lbl_tongThoiLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongThoiLuong.setBounds(604, 233, 97, 20);
		contentPane.add(lbl_tongThoiLuong);
		
		JLabel lblNewLabel_1_7 = new JLabel("Tiền dịch vụ :");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_7.setBounds(465, 486, 129, 20);
		contentPane.add(lblNewLabel_1_7);
		
		lbl_tienDichVu = new JLabel("75.000 VND");
		lbl_tienDichVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tienDichVu.setBounds(604, 486, 97, 20);
		contentPane.add(lbl_tienDichVu);
		
		JLabel lblNewLabel_1_8 = new JLabel("Tiền phòng :");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_8.setBounds(465, 541, 97, 20);
		contentPane.add(lblNewLabel_1_8);
		
		lbl_tienPhong = new JLabel("200.000 VND");
		lbl_tienPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tienPhong.setBounds(604, 541, 97, 20);
		contentPane.add(lbl_tienPhong);
		
		JLabel lblNewLabel_1_9 = new JLabel("Tổng cộng :");
		lblNewLabel_1_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_9.setBounds(465, 593, 97, 20);
		contentPane.add(lblNewLabel_1_9);
		
		lbl_tongCong = new JLabel("275.000 VND");
		lbl_tongCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongCong.setBounds(604, 593, 97, 20);
		contentPane.add(lbl_tongCong);
		
		table = new JTable();
		table.setBounds(41, 463, 729, -179);
		contentPane.add(table);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Tiền nhận :");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_7_1.setBounds(60, 486, 91, 20);
		contentPane.add(lblNewLabel_1_7_1);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("Tiền thừa :");
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_7_2.setBounds(60, 546, 129, 20);
		contentPane.add(lblNewLabel_1_7_2);
		
		txt_tienNhan = new JTextField();
		txt_tienNhan.setBounds(160, 488, 86, 20);
		contentPane.add(txt_tienNhan);
		txt_tienNhan.setColumns(10);
		
		testbutton.Buttontest quayLai = new testbutton.Buttontest();
		quayLai.setBorder(null);
		quayLai.setText("Quay lại");
		quayLai.setForeground(Color.WHITE);
		quayLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		quayLai.setBackground(new Color(0, 128, 255));
		quayLai.setBounds(60, 669, 91, 48);
	    contentPane.add(quayLai);
	    quayLai.setLayout(null);
	     
	    Buttontest btntstThanhTon = new Buttontest();
	    btntstThanhTon.setText("THANH TOÁN");
	    btntstThanhTon.setForeground(Color.WHITE);
	    btntstThanhTon.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btntstThanhTon.setBorder(null);
	    btntstThanhTon.setBackground(new Color(255, 60, 60));
	    btntstThanhTon.setBounds(604, 669, 97, 48);
	    contentPane.add(btntstThanhTon);
	     
	    cbox_xuatHoaDon = new JCheckBox("Xuất hóa đơn");
	    cbox_xuatHoaDon.setBounds(465, 683, 115, 23);
	    contentPane.add(cbox_xuatHoaDon);
	    
	    lbl_tienThua = new JLabel("");
	    lbl_tienThua.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lbl_tienThua.setBounds(160, 546, 194, 20);
	    contentPane.add(lbl_tienThua);
	}
	
//	public void hienThiThongTinPhong(String maPhong) {
//		QLPH_DAO ds = new QLPH_DAO();
//		ArrayList<Phong> listPhong = ds.docbang();
//		
//		
//	}
}
