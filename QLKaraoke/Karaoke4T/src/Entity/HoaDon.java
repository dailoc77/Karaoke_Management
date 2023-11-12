package Entity;

import java.sql.Date;
import java.util.Objects;

public class HoaDon {
	private String maHD;
	private Date gioKetThuc;
	private Date gioNhanPhong;
	private Date ngayLap;
	private float tienKhachTra;
	private float tongTien;
	private String maKH;
	private String maNV;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHD, Date gioKetThuc, Date gioNhanPhong, Date ngayLap, float tienKhachTra, float tongTien,
			String maKH, String maNV) {
			
		setMaHD(maHD);
		setGioKetThuc(gioKetThuc);
		setGioNhanPhong(gioNhanPhong);
		setNgayLap(ngayLap);
		setTienKhachTra(tienKhachTra);
		setTongTien(tongTien);
		setMaKH(maKH);
		setMaNV(maNV);
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getGioKetThuc() {
		return gioKetThuc;
	}
	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}
	public Date getGioNhanPhong() {
		return gioNhanPhong;
	}
	public void setGioNhanPhong(Date gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public float getTienKhachTra() {
		return tienKhachTra;
	}
	public void setTienKhachTra(float tienKhachTra) {
		this.tienKhachTra = tienKhachTra;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(gioKetThuc, gioNhanPhong, maHD, maKH, maNV, ngayLap, tienKhachTra, tongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(gioKetThuc, other.gioKetThuc) && Objects.equals(gioNhanPhong, other.gioNhanPhong)
				&& Objects.equals(maHD, other.maHD) && Objects.equals(maKH, other.maKH)
				&& Objects.equals(maNV, other.maNV) && Objects.equals(ngayLap, other.ngayLap)
				&& Float.floatToIntBits(tienKhachTra) == Float.floatToIntBits(other.tienKhachTra)
				&& Float.floatToIntBits(tongTien) == Float.floatToIntBits(other.tongTien);
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", gioKetThuc=" + gioKetThuc + ", gioNhanPhong=" + gioNhanPhong + ", ngayLap="
				+ ngayLap + ", tienKhachTra=" + tienKhachTra + ", tongTien=" + tongTien + ", maKH=" + maKH + ", maNV="
				+ maNV + "]";
	}
	
	
}
