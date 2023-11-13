package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
			String sql = "select maDV, donGia, soLuong, tenDichVu from DichVu";
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
	
	public boolean update(DichVu kh) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("UPDATE DichVu SET donGia = ?, soLuong = ?, tenDichVu = ? where maDv = ?");

			smt.setDouble(1, kh.getGiaDichVu());
			smt.setInt(2, kh.getSoLuongDichVu());
			smt.setString(3, kh.getTenDichVu());
			smt.setString(4, kh.getMaDichVu());

			
			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public DichVu getDV(int index) {
		return dsdv.get(index);
	}
	
	public static void deleteDvbymaDV(String maDV) {
	    try (Connection con = connectDB.getInstance().getConnection()) {
	        String sql = "DELETE from DichVu where maDV = ?";
	        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setString(1, maDV);
	            int n = preparedStatement.executeUpdate();
	            
	            if (n > 0) {
	                JOptionPane.showMessageDialog(null, "Xoa thanh cong");
	            } else {
	                JOptionPane.showMessageDialog(null, "Khong tim thay DichVu co maDV = " + maDV);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public int getMaxMaDV() {
        int maxMaDV = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectDB.getInstance().getConnection();
            String query = "SELECT MAX(CONVERT(INT, SUBSTRING(maDV, 3, LEN(maDV)))) FROM DichVu";
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
	
	 public DichVu layDichVuTheoMa(String maDV) {
	        DichVu dichVu = null;
	        String query = "Select maDV, tenDichVu, donGia from DichVu where maDV = ?";
	        Connection con = connectDB.getInstance().getConnection();
	        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	            preparedStatement.setString(1, maDV);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    String maDichVu = resultSet.getString("maDV");
	                    String tenDichVu = resultSet.getString("tenDichVu");
	                    double donGia = resultSet.getDouble("donGia");

	                    dichVu = new DichVu(maDichVu, tenDichVu, donGia);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return dichVu;
	    }
	public ArrayList<Entity.DichVu> detaiedDichVu(String madv){
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement stm = null;
		try {
			
			String sql = "Select maDV, tenDichVu, donGia from DichVu where maDV = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, madv);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				Double gia = rs.getDouble(3);
				DichVu s = new DichVu(madv, ten, gia);
				dsdv.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsdv;
	}
}
