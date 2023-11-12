package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.HoaDon;
import Entity.KhachHang;
import Entity.LoaiNhanVien;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.ThongKeHoaDon;
import Entity.ThongKeKhachHang;
import connectDB.connectDB;

public class ThongKeKhachHang_DAO {
	ArrayList<ThongKeKhachHang> dskh;
	public ThongKeKhachHang_DAO () {
		dskh = new ArrayList<ThongKeKhachHang>();
	}
	public ArrayList<Entity.ThongKeKhachHang> doctubang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "select kh.maKH,tenKH,SDT,CMND,diaChi,thoiGianNhanPhong from PhieuDatPhong p\r\n"
					+ "inner join KhachHang kh\r\n"
					+ "on p.maKH = kh.maKH";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				KhachHang maKH = new KhachHang(rs.getString(1),null,null,null,null,null);
				KhachHang tenKH = new KhachHang(null,null,rs.getString(2),null,null,null);
				KhachHang SDT = new KhachHang(null,null,null,rs.getString(3),null,null);
				KhachHang CMND = new KhachHang(null,null,null,null,rs.getString(4),null);
				KhachHang diaChi = new KhachHang(null,null,null,null,null,rs.getString(5));
				PhieuDatPhong thoigianNhan = new PhieuDatPhong(null,null,rs.getString(6),null,null,null,null);
				ThongKeKhachHang tkkh = new ThongKeKhachHang(maKH,tenKH,SDT,CMND,diaChi,thoigianNhan);
				dskh.add(tkkh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dskh;
	}
	
	public ArrayList<Entity.ThongKeKhachHang> doctubangTheoThang(int ngay,String thang,int nam) {
	    try {
	        Connection con = connectDB.getInstance().getConnection();
	        String sql = "select kh.maKH,tenKH,SDT,CMND,diaChi,thoiGianNhanPhong\r\n"
	        		+ "from PhieuDatPhong p\r\n"
	        		+ "inner join KhachHang kh\r\n"
	        		+ "on p.maKH = kh.maKH\r\n"
	        		+ "where Day(thoiGianNhanPhong) = ? and month(thoiGianNhanPhong) = ? and YEAR(thoiGianNhanPhong) = ?";
	        
	        // Sử dụng PreparedStatement để có thể truyền tham số
	        try (PreparedStatement sta = con.prepareStatement(sql)) {
	            // Truyền giá trị của biến thang vào tham số ?
	            sta.setInt(1, ngay);
	            sta.setString(2, thang);
	            sta.setInt(3, nam);

	            ResultSet rs = sta.executeQuery();
	            while (rs.next()) {
	            	KhachHang maKH = new KhachHang(rs.getString(1),null,null,null,null,null);
					KhachHang tenKH = new KhachHang(null,null,rs.getString(2),null,null,null);
					KhachHang SDT = new KhachHang(null,null,null,rs.getString(3),null,null);
					KhachHang CMND = new KhachHang(null,null,null,null,rs.getString(4),null);
					KhachHang diaChi = new KhachHang(null,null,null,null,null,rs.getString(5));
					PhieuDatPhong thoigianNhan = new PhieuDatPhong(null,null,rs.getString(6),null,null,null,null);
					ThongKeKhachHang tkkh = new ThongKeKhachHang(maKH,tenKH,SDT,CMND,diaChi,thoigianNhan);
					dskh.add(tkkh);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dskh;
	}

}
