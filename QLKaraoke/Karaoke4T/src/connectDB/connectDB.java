package connectDB;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class connectDB {
	public static Connection con = null;
	private static connectDB instance = new connectDB();
	public static connectDB getInstance() {
	return instance;
	}
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
		String user = "sa";
		String password = "123";


		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void print(String string) {
		// TODO Auto-generated method stub
		
	}
	private void Console(String string) {
		// TODO Auto-generated method stub
		
	}
	public static Connection getConnection() {
		return con;
	}
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
