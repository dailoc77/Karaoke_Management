package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectDB.*;
import Entity.*;
public class QLNV_DAO {
	ArrayList<NhanVien> dsnv;
	public QLNV_DAO() {
		dsnv = new ArrayList<NhanVien>();
	}
	public ArrayList<Entity.NhanVien> doctubang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gt = rs.getString(3);
				String ngaySinh = rs.getString(4);
				String cmnd = rs.getString(5);
				String sdt = rs.getString(6);
				String trangThai = rs.getString(7);
				String dc = rs.getString(8);
				String loai = rs.getString(9);
				String maTK = rs.getString(10);
				NhanVien nv = new NhanVien(ma,ten,gt,ngaySinh,cmnd,sdt,trangThai,dc, loai,maTK);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public ArrayList<Entity.NhanVien> laytheomanv(String maNV){
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement stm = null;
		try {
			
			String sql = "Select * from NhanVien";
			stm = con.prepareStatement(sql);
			stm.setString(0, maNV);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gt = rs.getString(3);
				String ngaySinh = rs.getString(4);
				String cmnd = rs.getString(5);
				String sdt = rs.getString(6);
				String trangThai = rs.getString(7);
				String dc = rs.getString(8);
				String loai = rs.getString(9);
				String maTK = rs.getString(10);
				NhanVien nv = new NhanVien(ma,ten,gt,ngaySinh,cmnd,sdt,trangThai,dc, loai,maTK );
				dsnv.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	
}
