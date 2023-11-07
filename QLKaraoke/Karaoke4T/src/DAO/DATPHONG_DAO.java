package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.*;
import Entity.*;

public class DATPHONG_DAO {
	ArrayList<Phong> dsPhong;

	public DATPHONG_DAO() {
		dsPhong = new ArrayList<Phong>();
	}
	
	public ArrayList<Phong> docBang(){
		try {
		Connection con = Database.getInstance().getConnection();
		String sql = "Select * from Phong";
		Statement sta = con.createStatement();
		ResultSet rs = sta.executeQuery(sql);
		}catch(Exception e){
		  e.printStackTrace();
		}
		return dsPhong;
		}
}
