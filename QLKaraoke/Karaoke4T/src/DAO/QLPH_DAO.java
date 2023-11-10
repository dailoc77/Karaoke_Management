package DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.*;
import connectDB.connectDB;

public class QLPH_DAO {
	ArrayList<Phong> dsph;
	
	public QLPH_DAO() {
		dsph = new ArrayList<Phong>();
	}
	
	public ArrayList<Phong> docbang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "select maPhong , soNguoi , tenPhong , tenTrangThaiPhong,tenLoaiPhong from Phong p inner join LoaiPhong lp on p.maLP = lp.maLP inner join TrangThaiPhong ttp on p.maTTP = ttp.maTTP";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String maPhong = rs.getString(1);
				String soNguoi = rs.getString(2);
				String tenPhong = rs.getString(3);
				TrangThaiPhong tenTrangThaiPhong = new TrangThaiPhong(null, rs.getString(4));
				LoaiPhong tenLoaiPhong = new LoaiPhong(null, rs.getString(5), 0);
				Phong ph = new Phong(maPhong, soNguoi, tenPhong, tenTrangThaiPhong, tenLoaiPhong);
				dsph.add(ph);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dsph;
	}
}
