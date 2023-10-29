package Entity;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String diaChi;
	private int SDT;
	private int CMND;
	private boolean gioiTinh;
	
	public KhachHang(String maKH, String tenKH, String diaChi, int SDT, int CMND, boolean gioiTinh) {
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

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	
}
