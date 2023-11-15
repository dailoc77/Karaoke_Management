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
import Entity.*;
public class QLTK_DAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
	ArrayList<TaiKhoanNhanVien> dstk;
	public QLTK_DAO() {
		dstk = new ArrayList<TaiKhoanNhanVien>();
	}
	
	 // Kiểm tra tài khoản và mật khẩu từ cơ sở dữ liệu
    public static boolean checkLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM TaiKhoan WHERE maTK = ? AND MK = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();
                return resultSet.next(); // Trả về true nếu có kết quả, ngược lại là false
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public ArrayList<Entity.TaiKhoanNhanVien> doctubang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "Select * from TaiKhoan";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String mk = rs.getString(3);
				String tennv = rs.getString(4);
				String email = rs.getString(5);
				TaiKhoanNhanVien tk = new TaiKhoanNhanVien(ma,ten,mk,tennv,email);
				dstk.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dstk;
	}
	public ArrayList<Entity.TaiKhoanNhanVien> laytheomatk(String matk){
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement stm = null;
		try {
			
			String sql = "Select * from TaiKhoan";
			stm = con.prepareStatement(sql);
			stm.setString(0, matk);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				System.out.println(matk);
				String ten = rs.getString(2);
				String mk = rs.getString(3);
				String tennv = rs.getString(4);
				String email = rs.getString(5);
				TaiKhoanNhanVien tk = new TaiKhoanNhanVien(ma,ten,mk,tennv,email);
				dstk.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dstk;
	}
	
    public boolean create(TaiKhoanNhanVien tk) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("insert into TaiKhoan values(?, ?, ?, ?, ?)");
			smt.setString(1, tk.getMaTaiKhoan());
			smt.setString(2, tk.getTenTaiKhoan());
			smt.setString(3, tk.getMatKhau());
			smt.setString(4, tk.getTenNV());
			smt.setString(5, tk.getEmail());
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
    
    public boolean update(TaiKhoanNhanVien tk) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("UPDATE TaiKhoan SET tenTK = ?, MK = ? , tenNV = ?, email = ? where maTK = ?");
			smt.setString(1, tk.getTenTaiKhoan());
			smt.setString(2, tk.getMatKhau());
			smt.setString(3, tk.getTenNV());
			smt.setString(4, tk.getEmail());
			smt.setString(5, tk.getMaTaiKhoan());
			
			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
    public TaiKhoanNhanVien getTaiKhoanNhanVien(int index) {
		return dstk.get(index);
	}
    
    public boolean delete(String matk) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		
		int n = 0;
		try {
			smt = con.prepareStatement("delete from TaiKhoan where maTK = ?");
			smt.setString(1, matk);
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
    
    public ArrayList<TaiKhoanNhanVien> getDs(){
		return dstk;
	}
    
    public int getMaxMaTaiKhoan() {
        int maxMaTK = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectDB.getInstance().getConnection();
            String query = "SELECT MAX(CONVERT(INT, SUBSTRING(maTK, 3, LEN(maTK)))) FROM TaiKhoan";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxMaTK = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxMaTK;
    }
}
