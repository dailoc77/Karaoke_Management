package Entity;

import java.sql.Date;

public class HoaDon {
	private String maHoaDon;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Date ngayLap;
	private String trangThai;
	private Date gioNhanPhong;
	private Date gioKetThuc;
	
	public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, Date ngayLap, String trangThai, Date gioNhanPhong, Date gioKetThuc) {
		setGioKetThuc(gioKetThuc);
		setGioNhanPhong(gioNhanPhong);
		setKhachHang(khachHang);
		setMaHoaDon(maHoaDon);
		setNgayLap(ngayLap);
		setNhanVien(nhanVien);
		setTrangThai(trangThai);
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getGioNhanPhong() {
		return gioNhanPhong;
	}

	public void setGioNhanPhong(Date gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}

	public Date getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}
	
	
}
