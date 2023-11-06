package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.*;
import connectDB.Database;
public class THUEPHONG_DAO {
	ArrayList<Phong> dsPhong;
	public THUEPHONG_DAO() {
		dsPhong = new ArrayList<Phong>();
	}
	
	public ArrayList<Phong> docBang(){
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "Select * from Phong";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dsPhong;
	}
}
