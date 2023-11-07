package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectDB.*;
import Entity.*;
public class QLTK_DAO {
	ArrayList<TaiKhoanNhanVien> dstk;
	public QLTK_DAO() {
		dstk = new ArrayList<TaiKhoanNhanVien>();
	}
	public ArrayList<Entity.TaiKhoanNhanVien> doctubang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "Select * from TaiKhoan";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String mk = rs.getString(3);
				TaiKhoanNhanVien tk = new TaiKhoanNhanVien(ma,ten,mk,null);
				dstk.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dstk;
	}
	public ArrayList<Entity.TaiKhoanNhanVien> laytheomatk(String matk){
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement stm = null;
		try {
			
			String sql = "Select * from TaiKhoan";
			stm = con.prepareStatement(sql);
			stm.setString(0, matk);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				System.out.println(matk);
				String ten = rs.getString(2);
				String mk = rs.getString(3);
				TaiKhoanNhanVien tk = new TaiKhoanNhanVien(ma,ten,mk,null);
				dstk.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dstk;
	}
	
}
