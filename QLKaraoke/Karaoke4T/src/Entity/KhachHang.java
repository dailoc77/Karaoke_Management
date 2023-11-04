package Entity;

import java.util.Objects;

public class KhachHang {
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
		return CMND == other.CMND && SDT == other.SDT && Objects.equals(diaChi, other.diaChi)
				&& gioiTinh == other.gioiTinh && Objects.equals(maKH, other.maKH) && Objects.equals(tenKH, other.tenKH);
	}

	private String maKH;
	private String tenKH;
	private String diaChi;
	private int SDT;
	private int CMND;
	private String gioiTinh;
	
	public KhachHang(String maKH, String gioiTinh, String tenKH, int SDT, int CMND, String diaChi) {
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

	public int getSDT() {
		return SDT;
	}

	public void setSDT(int sDT) {
		SDT = sDT;
	}

	public int getCMND() {
		return CMND;
	}

	public void setCMND(int cMND) {
		CMND = cMND;
	}

	public String isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	
}
