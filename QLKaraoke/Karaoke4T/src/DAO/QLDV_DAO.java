package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.*;
import connectDB.connectDB;

public class QLDV_DAO {
	ArrayList<DichVu> dsdv;
	
	public QLDV_DAO() {
		dsdv = new ArrayList<DichVu>();
	}
	
	public ArrayList<DichVu> docbang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "select * from DichVu";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String maDichVu = rs.getString(1);
				double donGia = rs.getDouble(2);
				int soLuong = rs.getInt(3);
				String tenDichVu = rs.getString(4);
				DichVu dv = new DichVu(maDichVu, donGia, soLuong,tenDichVu);
				dsdv.add(dv);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dsdv;
	}
	
	public boolean themDichVu(DichVu dv) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("insert into DichVu values(?, ?, ?, ?)");
			smt.setString(1, dv.getMaDichVu());
			smt.setDouble(2, dv.getGiaDichVu());
			smt.setInt(3, dv.getSoLuongDichVu());
			smt.setString(4, dv.getTenDichVu());
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public boolean suaDichVu(DichVu dv) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("UPDATE DichVu SET donGia = ? , soLuong = ? , tenDichVu = ? where maDV = ?");
			smt.setDouble(1, dv.getGiaDichVu());
			smt.setInt(2, dv.getSoLuongDichVu());
			smt.setString(3, dv.getTenDichVu());
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public DichVu getDV(int index) {
		return dsdv.get(index);
	}
	
	public boolean xoaDichVu(String madv) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("DELETE from DichVu where maDV = ?");
			smt.setString(1,madv);
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public int getMaxMaDV() {
        int maxMaDV = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectDB.getInstance().getConnection();
            String query = "SELECT MAX(CONVERT(INT, SUBSTRING(maDV, 5, LEN(maDV)))) FROM DichVu";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	maxMaDV = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxMaDV;
    }
	
	public ArrayList<DichVu> getDs(){
		return dsdv;
	}
}
