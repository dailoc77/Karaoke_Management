package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;
import connectDB.connectDB;

public class TinhTien_DAO {
	ArrayList<PhieuDatPhong> dsPDP;
	
	public TinhTien_DAO() {
		dsPDP = new ArrayList<PhieuDatPhong>();
	}
	
	public ArrayList<PhieuDatPhong> docbang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "Select kh.SDT , tenKH , tenNV,thoiGianNhanPhong,tenPhong from PhieuDatPhong pdp inner join KhachHang kh on pdp.maKH = kh.maKH inner join NhanVien nv on pdp.maNV = nv.maNV inner join Phong p on pdp.maPhong = p.maPhong";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				KhachHang sdtKH = new KhachHang(null, null, null, rs.getString(1), null, null);
				KhachHang tenKH = new KhachHang(null, null, rs.getString(2), null, null, null);
				NhanVien tenNV = new NhanVien(null, rs.getString(3), null, null, null, null, null, null, null, null);
				String thoiGianNhanPhong = rs.getString(4);
				Phong tenPhong = new Phong(rs.getString(5), null, null, null, null, null);
				PhieuDatPhong pdp = new PhieuDatPhong(sdtKH, tenKH, tenNV,thoiGianNhanPhong, tenPhong);
				dsPDP.add(pdp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dsPDP;
	}
}
