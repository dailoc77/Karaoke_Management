package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public static Connection con = null;
	private static Database instance = new Database();
	public static Database getInstance() {
		return instance;
	}
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;;databasename=Karaoke4T";
		String user = "sa";
		String password = "lockuteqn2003";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
