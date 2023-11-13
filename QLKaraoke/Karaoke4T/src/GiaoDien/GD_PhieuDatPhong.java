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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GD_PhieuDatPhong extends JFrame {

	private JPanel contentPane;
	private JLabel  lblSoPhong,lbl_DiaChi,lbl_CMND,lbl_SDT,lbl_TenKH,lbl_GiaTien,lbl_SoNguoi;
	private String tpm;
	private String soluongnguoi;
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
            java.util.logging.Logger.getLogger(GD_PhieuDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_PhieuDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_PhieuDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_PhieuDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
		
		lblSoPhong = new JLabel("SỐ PHÒNG: ");
		lblSoPhong.setBounds(188, 11, 299, 29);
		lblSoPhong.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblSoPhong);
		
		lbl_TenKH = new JLabel("Tên Khách Hàng :");
		lbl_TenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_TenKH.setBounds(97, 88, 229, 16);
		contentPane.add(lbl_TenKH);
		
		lbl_SDT = new JLabel("Số Điện Thoại :");
		lbl_SDT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_SDT.setBounds(97, 129, 229, 16);
		contentPane.add(lbl_SDT);
		
		lbl_CMND = new JLabel("CMND :");
		lbl_CMND.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_CMND.setBounds(97, 167, 243, 16);
		contentPane.add(lbl_CMND);
		
		lbl_DiaChi = new JLabel("Địa Chỉ :");
		lbl_DiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_DiaChi.setBounds(97, 205, 399, 16);
		contentPane.add(lbl_DiaChi);
		
		lbl_SoNguoi = new JLabel("Số Người :");
		lbl_SoNguoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_SoNguoi.setBounds(420, 88, 176, 16);
		contentPane.add(lbl_SoNguoi);
		
		lbl_GiaTien = new JLabel("Giá Tiền :");
		lbl_GiaTien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_GiaTien.setBounds(420, 129, 150, 16);
		contentPane.add(lbl_GiaTien);
		
		JButton btn_quayLai = new JButton("Đóng");
		btn_quayLai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				GD_Main_NV mainnv = new GD_Main_NV();
//				mainnv.setVisible(true);
//				mainnv.setLocationRelativeTo(null);
//	            dispose();
				
				GD_ThuePhong tp = new GD_ThuePhong();
				tp.setVisible(true);
				tp.setLocationRelativeTo(null);
				
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
				GD_ThuePhong tp = new GD_ThuePhong();
				tp.setVisible(true);
				tp.setLocationRelativeTo(null);
				tp.btnthemActionPerformed(e);
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
	
	
		public void loadPhieuDatPhongTuDuLieuNhap(String maPhong,String tenKH,String sdt,String cmnd,String diaChi,String songuoi,float giaTien) {
		
                String columnName1 = maPhong;
                String columnName2 = tenKH;
                String columnName3 = sdt;
                String columnName4 = cmnd;
                String columnName5 = diaChi;
                String columnName6 = songuoi;
                float columnName7 = giaTien;
                
                lblSoPhong.setText( "Số phòng: " + columnName1);
                lbl_TenKH.setText( "Số điện thoại: " + columnName2);
                lbl_SDT.setText( "Số điện thoại: " + columnName3);
                lbl_CMND.setText( "Chứng minh nhân dân: " + columnName4);
                lbl_DiaChi.setText( "Địa chỉ: " + columnName5);
                lbl_SoNguoi.setText("Số lượng người: " + columnName6);
                lbl_GiaTien.setText( "Giá tiền: " + columnName7);

	}

}
