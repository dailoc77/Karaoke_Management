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
	public List<LoaiNhanVien> doctubang(){
		List<LoaiNhanVien> ds = new ArrayList<LoaiNhanVien>();
		Connection con = connectDB.getConnection();
		connectDB.getInstance();
		try {
			String sql = "select * from LoaiNhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ds.add(new LoaiNhanVien(
						rs.getString("maLNV"),
						rs.getString("tenLNV")
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
}

