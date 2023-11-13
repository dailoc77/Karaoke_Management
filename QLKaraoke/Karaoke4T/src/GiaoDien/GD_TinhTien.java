package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.QLPH_DAO;
import Entity.Phong;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import testbutton.Buttontest;
import javax.swing.JCheckBox;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GD_TinhTien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txt_tienNhan;
	private boolean isXuatHoaDon = false;
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
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GD_Main_NV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_Main_NV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_Main_NV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_Main_NV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
		setBounds(100, 100, 814, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl_txt_tinhTien = new JPanel();
		pnl_txt_tinhTien.setBackground(new Color(0, 88, 176));
		pnl_txt_tinhTien.setBounds(0, 0, 806, 96);
		contentPane.add(pnl_txt_tinhTien);
		pnl_txt_tinhTien.setLayout(null);
		
		lbl_tenPhongTT = new JLabel("TÍNH TIỀN");
		lbl_tenPhongTT.setForeground(new Color(255, 255, 255));
		lbl_tenPhongTT.setBounds(271, 25, 276, 49);
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ tên KH :");
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
		lblNewLabel_1_4.setBounds(415, 141, 129, 20);
		contentPane.add(lblNewLabel_1_4);
		
		lbl_gioNhanPhong = new JLabel("17:30");
		lbl_gioNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_gioNhanPhong.setBounds(544, 141, 238, 20);
		contentPane.add(lbl_gioNhanPhong);
		
		JLabel lblNewLabel_1_5 = new JLabel("Giờ trả phòng :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(415, 186, 121, 20);
		contentPane.add(lblNewLabel_1_5);
		
		lbl_gioTraPhong = new JLabel("18:30");
		lbl_gioTraPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_gioTraPhong.setBounds(533, 186, 238, 20);
		contentPane.add(lbl_gioTraPhong);
		
		JLabel lblNewLabel_1_6 = new JLabel("Tổng thời lượng :");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(415, 233, 129, 20);
		contentPane.add(lblNewLabel_1_6);
		
		lbl_tongThoiLuong = new JLabel("60 phút");
		lbl_tongThoiLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongThoiLuong.setBounds(556, 233, 238, 20);
		contentPane.add(lbl_tongThoiLuong);
		
		JLabel lblNewLabel_1_7 = new JLabel("Tiền dịch vụ :");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_7.setBounds(415, 348, 129, 20);
		contentPane.add(lblNewLabel_1_7);
		
		lbl_tienDichVu = new JLabel("75.000 VND");
		lbl_tienDichVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tienDichVu.setBounds(554, 348, 97, 20);
		contentPane.add(lbl_tienDichVu);
		
		JLabel lblNewLabel_1_8 = new JLabel("Tiền phòng :");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_8.setBounds(415, 403, 97, 20);
		contentPane.add(lblNewLabel_1_8);
		
		lbl_tienPhong = new JLabel("200.000 VND");
		lbl_tienPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tienPhong.setBounds(554, 403, 97, 20);
		contentPane.add(lbl_tienPhong);
		
		JLabel lblNewLabel_1_9 = new JLabel("Tổng cộng :");
		lblNewLabel_1_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_9.setBounds(415, 455, 97, 20);
		contentPane.add(lblNewLabel_1_9);
		
		lbl_tongCong = new JLabel("275.000 VND");
		lbl_tongCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongCong.setBounds(554, 455, 97, 20);
		contentPane.add(lbl_tongCong);
		
		table = new JTable();
		table.setBounds(41, 463, 729, -179);
		contentPane.add(table);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Tiền nhận :");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_7_1.setBounds(60, 348, 91, 20);
		contentPane.add(lblNewLabel_1_7_1);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("Tiền thừa :");
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_7_2.setBounds(60, 408, 129, 20);
		contentPane.add(lblNewLabel_1_7_2);
		
		txt_tienNhan = new JTextField();
		txt_tienNhan.setBounds(160, 345, 115, 31);
		contentPane.add(txt_tienNhan);
		txt_tienNhan.setColumns(10);
		contentPane.add(txt_tienNhan);
		
		testbutton.Buttontest quayLai = new testbutton.Buttontest();
		quayLai.setBorder(null);
		quayLai.setText("Quay lại");
		quayLai.setForeground(Color.WHITE);
		quayLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		quayLai.setBackground(new Color(0, 128, 255));
		quayLai.setBounds(60, 531, 97, 48);
		quayLai.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				GD_TraPhong gdtraphong = new GD_TraPhong();
				gdtraphong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdtraphong.setVisible(true);
				dispose();
			}
		});
	    contentPane.add(quayLai);
	    quayLai.setLayout(null);
	     
	    Buttontest btntstThanhTon = new Buttontest();
	    btntstThanhTon.setText("THANH TOÁN");
	    btntstThanhTon.setForeground(Color.WHITE);
	    btntstThanhTon.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btntstThanhTon.setBorder(null);
	    btntstThanhTon.setBackground(new Color(255, 60, 60));
	    btntstThanhTon.setBounds(544, 531, 115, 48);
//	    btntstThanhTon.addActionListener(new ActionListener() {
//			private void printToPDF() {
//				// TODO Auto-generated method stub
//				 Document document = new Document();
//				    try {
//				        // chon noi de save fild pdf
//				        PdfWriter.getInstance(document, new FileOutputStream("HoaDonTinhTien_" + soLanThanhToan + ".pdf"));
//				        document.open();
//				        // set font
//				        BaseFont unicodeFont = BaseFont.createFont("Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//				        com.itextpdf.text.Font vietnameseFont = new com.itextpdf.text.Font(unicodeFont, 12, com.itextpdf.text.Font.BOLD);
//				        // Add content to the PDF document
//				        document.add(new Paragraph("THÔNG TIN TÍNH TIỀN", vietnameseFont));
//				        document.add(new Paragraph(lbl_tenPhongTT.getText(), vietnameseFont));
//				        document.add(new Paragraph("SĐT Khách: " + lbl_sdtKH.getText(), vietnameseFont));
//				        document.add(new Paragraph("Họ tên KH: " + lbl_tenKH.getText(), vietnameseFont));
//				        document.add(new Paragraph("Họ tên NV: " + lbl_tenNV.getText(), vietnameseFont));
//				        document.add(new Paragraph("Giờ nhận phòng: " + lbl_gioNhanPhong.getText(), vietnameseFont));
//				        document.add(new Paragraph("Giờ trả phòng: " +lbl_gioTraPhong.getText(), vietnameseFont));
//				        document.add(new Paragraph("Tổng thời lượng: " + lbl_tongThoiLuong.getText(), vietnameseFont));
//				        document.add(new Paragraph("Tiền dịch vụ: " + lbl_tienDichVu.getText(), vietnameseFont));
//				        document.add(new Paragraph("Tiền phòng: " + lbl_tienPhong.getText(), vietnameseFont));
//				        document.add(new Paragraph("TỔNG CỘNG: " + lbl_tongCong.getText(), vietnameseFont));
//				        document.add(new Paragraph("Tiền nhận: " + txt_tienNhan.getText(), vietnameseFont));
//				        document.add(new Paragraph("Tiền thừa: " + lbl_tienThua.getText(), vietnameseFont));
//				        // Close the document
//				        document.close();
//				        // Display a message indicating successful PDF creation
//				        JOptionPane.showMessageDialog(contentPane, "ĐÃ XUẤT FILE PDF!", "Success", JOptionPane.PLAIN_MESSAGE);
//				    } catch (Exception e) {
//				        e.printStackTrace();
//				        JOptionPane.showMessageDialog(contentPane, "KHÔNG XUẤT ĐƯỢC FILE PDF!", "Error", JOptionPane.PLAIN_MESSAGE);
//				    }
//			}
	    btntstThanhTon.addActionListener(new ActionListener() {
            private void printToPDF() {
            	Document document = new Document();
                try {
                    // Sử dụng thời gian hiện tại để tạo tên file duy nhất
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                    String fileName = "HoaDon_" + dateFormat.format(new Date()) + ".pdf";

                    PdfWriter.getInstance(document, new FileOutputStream(fileName));
                    document.open();

                    BaseFont unicodeFont = BaseFont.createFont("Tahoma Regular font.ttf", BaseFont.IDENTITY_H,
                            BaseFont.EMBEDDED);
                    com.itextpdf.text.Font vietnameseFont = new com.itextpdf.text.Font(unicodeFont, 12,
                            com.itextpdf.text.Font.BOLD);

                    // Add content to the PDF document
                    addContent(document, vietnameseFont);

                    // Close the document
                    document.close();
                    // Display a message indicating successful PDF creation
                    JOptionPane.showMessageDialog(contentPane, "ĐÃ XUẤT FILE PDF!", "Success",
                            JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "KHÔNG XUẤT ĐƯỢC FILE PDF!", "Error",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
			private void addContent(Document document, com.itextpdf.text.Font vietnameseFont) throws DocumentException {
				// TODO Auto-generated method stub
				// Add content to the PDF document
                document.add(new Paragraph("THÔNG TIN TÍNH TIỀN", vietnameseFont));
                document.add(new Paragraph(lbl_tenPhongTT.getText(), vietnameseFont));
                document.add(new Paragraph("SĐT Khách: " + lbl_sdtKH.getText(), vietnameseFont));
                document.add(new Paragraph("Họ tên KH: " + lbl_tenKH.getText(), vietnameseFont));
                document.add(new Paragraph("Họ tên NV: " + lbl_tenNV.getText(), vietnameseFont));
                document.add(new Paragraph("Giờ nhận phòng: " + lbl_gioNhanPhong.getText(), vietnameseFont));
                document.add(new Paragraph("Giờ trả phòng: " + lbl_gioTraPhong.getText(), vietnameseFont));
                document.add(new Paragraph("Tổng thời lượng: " + lbl_tongThoiLuong.getText(), vietnameseFont));
                document.add(new Paragraph("Tiền dịch vụ: " + lbl_tienDichVu.getText(), vietnameseFont));
                document.add(new Paragraph("Tiền phòng: " + lbl_tienPhong.getText(), vietnameseFont));
                document.add(new Paragraph("TỔNG CỘNG: " + lbl_tongCong.getText(), vietnameseFont));
                document.add(new Paragraph("Tiền nhận: " + txt_tienNhan.getText(), vietnameseFont));
                document.add(new Paragraph("Tiền thừa: " + lbl_tienThua.getText(), vietnameseFont));
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        if (isXuatHoaDon) {
		            printToPDF();
		        } else {
		            JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn Xuất hóa đơn.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
	    contentPane.add(btntstThanhTon);
	     
	    cbox_xuatHoaDon = new JCheckBox("Xuất hóa đơn");
	    cbox_xuatHoaDon.setBounds(415, 545, 115, 23);
	    cbox_xuatHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isXuatHoaDon = cbox_xuatHoaDon.isSelected();
			}
		});
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
