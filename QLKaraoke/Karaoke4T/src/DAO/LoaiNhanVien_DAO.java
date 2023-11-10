package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectDB.*;
import test.en;
import Entity.*;


public class LoaiNhanVien_DAO {
	List<LoaiNhanVien> danhSachLoaiNV;
	public  LoaiNhanVien_DAO() {
		danhSachLoaiNV = new ArrayList<>();
	}
		public List<LoaiNhanVien> getAllLoaiNhanVien() {
	        
	        try{
	        	Connection con = connectDB.getInstance().getConnection();
	        	String sql= "SELECT * FROM LoaiNhanVien";
	        	Statement sta = con.createStatement();
	        	ResultSet rs = sta.executeQuery(sql);
	        	if(con != null) {
	        		 while (rs.next()) {
	                     String id = rs.getString(1);
	                     String tenLoai = rs.getString(2);

	                     LoaiNhanVien loaiNhanVien = new LoaiNhanVien(id, tenLoai);
	                     danhSachLoaiNV.add(loaiNhanVien);
	                 }
	        	}
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return danhSachLoaiNV;
	    }
}

