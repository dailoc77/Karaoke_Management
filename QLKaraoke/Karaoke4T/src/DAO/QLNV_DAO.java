package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectDB.*;
import Entity.*;
public class QLNV_DAO {
	ArrayList<NhanVien> dsnv;
	public QLNV_DAO() {
		dsnv = new ArrayList<NhanVien>();
	}
	public ArrayList<Entity.NhanVien> doctubang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "Select maNV,tenNV,gioiTinh,ngaySinh,CMND,SDT,trangThaiLamViec,diaChi,nv.maLNV , maTK from NhanVien nv inner join LoaiNhanVien lnv on nv.maLNV = lnv.maLNV";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gt = rs.getString(3);
				String ngaySinh = rs.getString(4);
				String cmnd = rs.getString(5);
				String sdt = rs.getString(6);
				String trangThaiLamViec = rs.getString(7);
				String dc = rs.getString(8);
				LoaiNhanVien loainv = new LoaiNhanVien(rs.getString(9), "");
				TaiKhoanNhanVien maTK = new TaiKhoanNhanVien(rs.getString(10), null, null, null, null);
				NhanVien nv = new NhanVien(ma,ten,gt,ngaySinh,cmnd,sdt,trangThaiLamViec,dc, loainv,maTK);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public boolean create(NhanVien nv) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("INSERT INTO [dbo].[NhanVien] ([maNV], [tenNV],[gioiTinh], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [diaChi],[maLNV] ,[maTK]) VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?)");
			smt.setString(1, nv.getMaNV());
			smt.setString(2, nv.getTenNV());
			smt.setString(3, nv.getGioiTinh());
			smt.setString(4, nv.getNgaySinh());
			smt.setString(5, nv.getCMND());
			smt.setString(6, nv.getSDT());
			smt.setString(7, nv.getTrangThaiLamViec());
			smt.setString(8, nv.getMaDC());
			smt.setString(9, nv.getLNV().getMaLNV());
			smt.setString(10, nv.getMaTK().getMaTaiKhoan());
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean update(NhanVien nv) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("UPDATE NhanVien SET tenNV = ?, gioiTinh = ?, ngaySinh = ?, CMND = ?, SDT = ?, trangThaiLamViec = ? , diaChi = ?, maLNV = ?, maTK = ? where maNV = ?");


			smt.setString(1, nv.getTenNV());
			smt.setString(2, nv.getGioiTinh());
			smt.setString(3, nv.getNgaySinh());
			smt.setString(4, nv.getCMND());
			smt.setString(5, nv.getSDT());
			smt.setString(6, nv.getTrangThaiLamViec());
			smt.setString(7, nv.getMaDC());
			smt.setString(8, nv.getLNV().getMaLNV());
			smt.setString(9, nv.getMaTK().getMaTaiKhoan());
			smt.setString(10, nv.getMaNV());

			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public NhanVien getNV(int index) {
		return dsnv.get(index);
	}
	public boolean delete(String maNV) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		
		int n = 0;
		try {
			smt = con.prepareStatement("delete from NhanVien where maNV = ?");
			smt.setString(1, maNV);
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public int getMaxMaNV() {
        int maxMaNV = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectDB.getInstance().getConnection();
            String query = "SELECT MAX(CONVERT(INT, SUBSTRING(maNV, 5, LEN(maNV)))) FROM NhanVien";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	maxMaNV = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxMaNV;
    }
	
	public int getMaxMaTK() {
        int maxMaTK = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectDB.getInstance().getConnection();
            String query = "SELECT MAX(CONVERT(INT, SUBSTRING(maTK, 3, LEN(maTK)))) FROM NhanVien";
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
	
	public ArrayList<NhanVien> getnv(){
		return dsnv;
	}
	
}
