package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String sql = "select maNV,tenNV,gioiTinh,ngaySinh,CMND,SDT,trangThaiLamViec,diaChi,tenLNV,maTK from NhanVien n\r\n"
					+ "inner join LoaiNhanVien ln\r\n"
					+ "on n.maLNV = ln.maLNV";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gt = rs.getString(3);
				String ngaySinh = rs.getString(4);
				String cmnd = rs.getString(5);
				String sdt = rs.getString(6);
				String trangThai = rs.getString(7);
				String dc = rs.getString(8);
				LoaiNhanVien loai = new LoaiNhanVien(null, rs.getString(9));
				TaiKhoanNhanVien maTK = new TaiKhoanNhanVien(rs.getString(10), null, null, null);
				NhanVien nv = new NhanVien(ma,ten,gt,ngaySinh,cmnd,sdt,trangThai,dc, loai,maTK);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public boolean create(NhanVien kh) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("insert into NhanVien values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			smt.setString(1, kh.getMaNV());
			smt.setString(2, kh.getTenNV());
			smt.setString(3, kh.getGioiTinh());
			smt.setString(4, kh.getNgaySinh());
			smt.setString(5, kh.getCMND());
			smt.setString(6, kh.getSDT());
			smt.setString(7, kh.getTrangThaiLamViec());
			smt.setString(8, kh.getMaDC());
			smt.setString(9, kh.getTenLNV().getTenLNV());
			smt.setString(10, kh.getMaTK().getMaTaiKhoan());
			
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean update(NhanVien kh) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("UPDATE NhanVien SET tenNV = ?, gioiTinh = ?, ngaySinh = ?, CMND = ?, SDT = ?, trangThaiLamViec = ? , maDC = ?, maLNV = ?, maTK = ? where maNV = ?");

			smt.setString(1, kh.getMaNV());
			smt.setString(2, kh.getTenNV());
			smt.setString(3, kh.getGioiTinh());
			smt.setString(4, kh.getNgaySinh());
			smt.setString(5, kh.getCMND());
			smt.setString(6, kh.getSDT());
			smt.setString(7, kh.getTrangThaiLamViec());
			smt.setString(8, kh.getMaDC());
			smt.setString(9, kh.getTenLNV().getTenLNV());
			smt.setString(10, kh.getMaTK().getMaTaiKhoan());

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
	
	public ArrayList<NhanVien> getnv(){
		return dsnv;
	}
	
}
