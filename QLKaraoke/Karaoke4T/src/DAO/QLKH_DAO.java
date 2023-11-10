package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectDB.*;
import Entity.*;

public class QLKH_DAO {
	ArrayList<KhachHang> dskh;
	public QLKH_DAO() {
		dskh = new ArrayList<KhachHang>();
	}
	public ArrayList<Entity.KhachHang> doctubang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "Select * from KhachHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String gt = rs.getString(2);
				String ten = rs.getString(3);
				String sdt = rs.getString(4);
				String cccd = rs.getString(5);
				String dc = rs.getString(6);		
				KhachHang kh = new KhachHang(ma, gt, ten, sdt, cccd, dc);
				dskh.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dskh;
	}
	public ArrayList<Entity.KhachHang> laytheomakh(String makh){
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement stm = null;
		try {
			
			String sql = "Select * from KhachHang";
			stm = con.prepareStatement(sql);
			stm.setString(0, makh);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				System.out.println(makh);
				String gt = rs.getString(2);
				String ten = rs.getString(3);
				String sdt = rs.getString(4);
				String cccd = rs.getString(5);
				String dc = rs.getString(6);
				KhachHang kh = new KhachHang(makh, gt, ten, sdt, cccd, dc);
				dskh.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dskh;
	}
	public boolean create(KhachHang kh) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("insert into KhachHang values(?, ?, ?, ?, ?, ?)");
			smt.setString(1, kh.getMaKH());
			smt.setString(2, kh.getGioiTinh());
			smt.setString(3, kh.getTenKH());
			smt.setString(4, kh.getSDT());
			smt.setString(5, kh.getCMND());
			smt.setString(6, kh.getDiaChi());
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean update(KhachHang kh) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("UPDATE KhachHang SET gioiTinh = ?, tenKH = ?, SDT = ?, CMND = ? , diaChi = ? where maKH = ?");

			smt.setString(1, kh.getGioiTinh());
			smt.setString(2, kh.getTenKH());
			smt.setString(3, kh.getSDT());
			smt.setString(4, kh.getCMND());
			smt.setString(5, kh.getDiaChi());
			smt.setString(6, kh.getMaKH());
			
			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public KhachHang getKH(int index) {
		return dskh.get(index);
	}
	public boolean delete(String makh) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		
		int n = 0;
		try {
			smt = con.prepareStatement("delete from KhachHang where maKH = ?");
			smt.setString(1, makh);
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public ArrayList<KhachHang> getDs(){
		return dskh;
	}
	
	public int getMaxMaKH() {
        int maxMaKH = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectDB.getInstance().getConnection();
            String query = "SELECT MAX(CONVERT(INT, SUBSTRING(maKH, 5, LEN(maKH)))) FROM KhachHang";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	maxMaKH = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxMaKH;
    }
}
