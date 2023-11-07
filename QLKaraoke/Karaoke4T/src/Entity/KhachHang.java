package Entity;

import java.util.Objects;

public class KhachHang {

	private String maKH;
	private String tenKH;
	private String diaChi;
	private String SDT;
	private String CMND;
	private Boolean gioiTinh;
	
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
		return CMND == other.CMND && SDT == other.SDT && Objects.equals(diaChi, other.diaChi)
				&& gioiTinh == other.gioiTinh && Objects.equals(maKH, other.maKH) && Objects.equals(tenKH, other.tenKH);
	}


	public KhachHang(String maKH, Boolean gioiTinh, String tenKH, String SDT, String CMND, String diaChi) {
		super();
		setCMND(CMND);
		setDiaChi(diaChi);
		setGioiTinh(gioiTinh);
		setMaKH(maKH);
		setSDT(SDT);
		setTenKH(tenKH);
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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

	public Boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", SDT=" + SDT + ", CMND=" + CMND
				+ ", gioiTinh=" + gioiTinh + "]";
	}
}