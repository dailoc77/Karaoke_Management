package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
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
				Float donGia = rs.getFloat(2);
				Integer soLuong = rs.getInt(3);
				String tenDichVu = rs.getString(4);
				DichVu dv = new DichVu(maDichVu, tenDichVu, donGia, soLuong);
				dsdv.add(dv);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dsdv;
	}
}
