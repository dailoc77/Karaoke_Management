package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.*;
import connectDB.connectDB;
public class LoaiPhong_DAO {
	ArrayList<LoaiPhong> list  = new ArrayList<LoaiPhong>();
	
	public LoaiPhong_DAO() {
		// TODO Auto-generated constructor stub
		napDuLieu();
	}
	public int size() {
		return list.size();
	}
	private void napDuLieu() {
		// TODO Auto-generated method stub
		String sql = "select * from Phong";
		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma= rs.getString(1);
				String songuoi = rs.getString(2);
				String ten = rs.getString(3);
				LoaiPhong lp =new LoaiPhong(null, rs.getString(5), 0);
				double gia = rs.getDouble(5);
				String ttp = rs.getString(6);
				
				TrangThaiPhong tt = new TrangThaiPhong(rs.getString(6),  null);
				String ct =  rs.getString(7);
				Phong p = new Phong(ma, songuoi, ten, lp, gia, tt, ct);
				list.add(lp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public LoaiPhong getPhong(int index) {
		return list.get(index);
	}
}
