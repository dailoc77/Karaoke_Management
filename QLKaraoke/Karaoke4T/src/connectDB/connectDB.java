package connectDB;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	public static Connection con = null;
	private static connectDB instance = new connectDB();
	public static connectDB getInstance() {
		return instance;
	}
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
		String user = "sa";
<<<<<<< HEAD:QLKaraoke/Karaoke4T/src/connectDB/connectDB.java
		String password = "13112003";
=======
		String password = "lockuteqn2003";
>>>>>>> f058d8e9c72f1a67cca62bf881acb53a1f13d1e8:QLKaraoke/Karaoke4T/src/connectDB/Database.java
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
