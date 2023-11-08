package Entity;

import java.util.Objects;

public class KhachHang {

	private String maKH;
	private String gioiTinh;
	private String tenKH;
	private String SDT;
	private String CMND;
	private String diaChi;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH, String gioiTinh, String tenKH, String sDT, String cMND, String diaChi) {
		super();
		this.maKH = maKH;
		this.gioiTinh = gioiTinh;
		this.tenKH = tenKH;
		SDT = sDT;
		CMND = cMND;
		this.diaChi = diaChi;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CMND, SDT, diaChi, gioiTinh, maKH, tenKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(CMND, other.CMND) && Objects.equals(SDT, other.SDT)
				&& Objects.equals(diaChi, other.diaChi) && Objects.equals(gioiTinh, other.gioiTinh)
				&& Objects.equals(maKH, other.maKH) && Objects.equals(tenKH, other.tenKH);
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
}