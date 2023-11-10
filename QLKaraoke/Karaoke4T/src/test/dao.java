package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.*;

public class dao {
	List<en> danhSachLoaiNV = new ArrayList<>();
    
	String url = "jdbc:sqlserver://localhost:1433;databasename=LNV";
    String user = "sa";
    String password = "123";
    
    public List<en> getAllLoaiNhanVien() {
        
        try{
        	Connection con = DriverManager.getConnection(url, user, password);
        	String sql= "SELECT * FROM LoaiNhanVien";
        	Statement sta = con.createStatement();
        	ResultSet rs = sta.executeQuery(sql);
        	if(con != null) {
        		 while (rs.next()) {
                     String id = rs.getString(1);
                     String tenLoai = rs.getString(2);

                     en loaiNhanVien = new en(id, tenLoai);
                     danhSachLoaiNV.add(loaiNhanVien);
                 }
        	}
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSachLoaiNV;
    }
}
