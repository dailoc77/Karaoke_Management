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
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	private String tam;
	private JLabel lbl_tenphong,lbl_giatien,lbl_soluongnguoi,lbl_loaiphong,lbl_trangthaiphong,lbl_tennhanvien,lbl_tenkhach,lbl_sdtKH,lblGioVao;

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
		setBounds(100, 100, 1021, 658);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl_chitietphong = new JPanel();
		pnl_chitietphong.setBackground(new Color(133, 133, 194));
		pnl_chitietphong.setBounds(0, 0, 1010, 66);
		contentPane.add(pnl_chitietphong);
		pnl_chitietphong.setLayout(null);
		
		JLabel lbl_chiTietPhong = new JLabel("Chi tiết phòng");
		lbl_chiTietPhong.setForeground(new Color(255, 255, 255));
		lbl_chiTietPhong.setBounds(404, 11, 214, 45);
		pnl_chitietphong.add(lbl_chiTietPhong);
		lbl_chiTietPhong.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JPanel pnl_thongtinphong = new JPanel();
		pnl_thongtinphong.setBackground(new Color(230, 230, 230));
		pnl_thongtinphong.setBounds(28, 77, 945, 484);
		contentPane.add(pnl_thongtinphong);
		pnl_thongtinphong.setLayout(null);
		
		JPanel pnl_thongtinphongtxt = new JPanel();
		pnl_thongtinphongtxt.setBounds(201, 11, 526, 39);
		pnl_thongtinphong.add(pnl_thongtinphongtxt);
		
		JLabel lblNewLabel = new JLabel("Thông tin phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnl_thongtinphongtxt.add(lblNewLabel);
		
		JLabel lbl_iconmicro = new JLabel("");
		lbl_iconmicro.setIcon(new ImageIcon(GD_ChiTietPhong.class.getResource("/Imgs/Mic.png")));
		lbl_iconmicro.setBounds(612, 61, 64, 64);
		pnl_thongtinphong.add(lbl_iconmicro);
		
		lbl_tenphong = new JLabel("Phòng ");
		lbl_tenphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_tenphong.setBounds(255, 87, 245, 25);
		pnl_thongtinphong.add(lbl_tenphong);
		
		JPanel pnl_showthongtin = new JPanel();
		pnl_showthongtin.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		pnl_showthongtin.setBackground(new Color(230, 230, 230));
		pnl_showthongtin.setBounds(255, 134, 434, 215);
		pnl_thongtinphong.add(pnl_showthongtin);
		pnl_showthongtin.setLayout(null);
		
		 lbl_trangthaiphong = new JLabel("Trạng thái phòng :");
		lbl_trangthaiphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_trangthaiphong.setBounds(25, 11, 382, 25);
		pnl_showthongtin.add(lbl_trangthaiphong);
		
		 lbl_loaiphong = new JLabel("Loại phòng :");
		lbl_loaiphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_loaiphong.setBounds(25, 57, 382, 25);
		pnl_showthongtin.add(lbl_loaiphong);
		
		 lbl_soluongnguoi = new JLabel("Số lượng người :");
		lbl_soluongnguoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_soluongnguoi.setBounds(25, 112, 382, 25);
		pnl_showthongtin.add(lbl_soluongnguoi);
		
		 lbl_giatien = new JLabel("Giá tiền/h :");
		lbl_giatien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_giatien.setBounds(25, 168, 382, 25);
		pnl_showthongtin.add(lbl_giatien);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(300, 377, 364, 2);
		pnl_thongtinphong.add(separator);
		
		lbl_tenkhach = new JLabel("Tên Khách Hàng:");
		lbl_tenkhach.setBounds(299, 390, 282, 15);
		pnl_thongtinphong.add(lbl_tenkhach);
		lbl_tenkhach.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lbl_sdtKH = new JLabel("SĐT Khách Hàng:");
		lbl_sdtKH.setBounds(300, 416, 282, 15);
		pnl_thongtinphong.add(lbl_sdtKH);
		lbl_sdtKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lbl_tennhanvien = new JLabel("Tên Nhân Viên:");
		lbl_tennhanvien.setBounds(299, 442, 282, 15);
		pnl_thongtinphong.add(lbl_tennhanvien);
		lbl_tennhanvien.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblGioVao = new JLabel("Giờ Vào:");
		lblGioVao.setBounds(300, 468, 341, 15);
		pnl_thongtinphong.add(lblGioVao);
		lblGioVao.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		Buttontest btntstQuayLai = new Buttontest();
		btntstQuayLai.setText("Quay lại");
		btntstQuayLai.setForeground(Color.WHITE);
		btntstQuayLai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btntstQuayLai.setBorder(null);
		btntstQuayLai.setBackground(new Color(19, 142, 234));
		btntstQuayLai.setBounds(28, 572, 111, 39);
		contentPane.add(btntstQuayLai);
		
		btntstQuayLai.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				 GD_ThuePhong thue = new GD_ThuePhong();
				 thue.setVisible(true);
				 thue.setLocationRelativeTo(null);
		            dispose();
			}
		});
		
		
		
		loadChiTietPhong(tam);
	}
	

    public void loadChiTietPhong(String maPhong) {
		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";
        
        tam = maPhong;
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "select tenPhong,tenTrangThaiPhong,tenLoaiPhong,giaTien from Phong p\r\n"
            		+ "inner join TrangThaiPhong ttp\r\n"
            		+ "on p.maTTP = ttp.maTTP\r\n"
            		+ "inner join LoaiPhong lp\r\n"
            		+ "on p.maLP = lp.maLP\r\n"
            		+ "where maPhong = ? ";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,maPhong);
           
            ResultSet resultSet = statement.executeQuery();
            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName1 = resultSet.getString("tenPhong");
                String columnName2 = resultSet.getString("tenTrangThaiPhong");
                String columnName3 = resultSet.getString("tenLoaiPhong");
                String columnName4 = resultSet.getString("giaTien");
                
//                String columnName5 = resultSet.getString("SDT");
//                String columnName6 = resultSet.getString("tenKH");
//                String columnName7 = resultSet.getString("tenNV");
//                String columnName8 = resultSet.getString("soLuongDichVu");
//                String columnName9 = resultSet.getString("gioNhanPhong");
//                String columnName10 = resultSet.getString("thoiLuong");
//                String columnName11 = resultSet.getString("soNguoi");
//                String columnName12 = resultSet.getString("donGia");
//                String columnName13 = resultSet.getString("tongTien");
                
                
                lbl_tenphong.setText("Tên phòng hát: " + columnName1);
                lbl_trangthaiphong.setText("Trạng thái phòng hát: " + columnName2);
                lbl_loaiphong.setText("Loại phòng hát: " + columnName3);
                lbl_giatien.setText("Giá phòng hát: " + columnName4 + " VND");
//                lbl_tienphong.setText("Tiền phòng: " + columnName4 + " VND");
//                lbl_sdtKH.setText("Số điện thoại khách hàng: " + columnName5);
//                lbl_tenkhach.setText("Tên khách hàng: " + columnName6);
//                lbl_tennhanvien.setText("Tên nhân viên: " + columnName7);
//                lblTongDichVu.setText("Tổng số lượng dịch vụ: " + columnName8);
//                lblGioVao.setText("Giờ nhận phòng: " + columnName9);
//                lblThoiLuong.setText("Thời lượng hát: " + columnName10);
//                lbl_soluongnguoi.setText("Sức chứa: " + columnName11);
//                lbl_tiendichvu.setText("Tiền dịch vụ " + columnName12 + " VND");
//                lbl_tongcong.setText("Tổng cộng: " + columnName13 + " VND");
               
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    
    
    public void loadChiTietKhachHangDaDatPhong(String maPhong) {
		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";
        
        tam = maPhong;
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "select  tenKH,kh.SDT,tenNV,thoiGianNhanPhong \r\n"
            		+ "from PhieuDatPhong pdp\r\n"
            		+ "inner join KhachHang kh\r\n"
            		+ "on pdp.maKH = kh.maKH\r\n"
            		+ "inner join NhanVien nv\r\n"
            		+ "on pdp.maNV = nv.maNV\r\n"
            		+ "where maPhong = ? ";
            
            PreparedStatement statement = connection.prepareStatement(sql);
           
            statement.setString(1,maPhong);
           
            ResultSet resultSet = statement.executeQuery();
            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
               
                String columnName5 = resultSet.getString("SDT");
                String columnName6 = resultSet.getString("tenKH");
                String columnName7 = resultSet.getString("tenNV");
                String columnName9 = resultSet.getString("thoiGianNhanPhong");

                
                lbl_sdtKH.setText("Số điện thoại khách hàng: " + columnName5);
                lbl_tenkhach.setText("Tên khách hàng: " + columnName6);
                lbl_tennhanvien.setText("Tên nhân viên: " + columnName7);
                lblGioVao.setText("Giờ nhận phòng: " + columnName9);
                
               

               
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
