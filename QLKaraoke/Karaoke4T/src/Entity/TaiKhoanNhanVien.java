package Entity;

public class TaiKhoanNhanVien {
	private String maTaiKhoan;
	private String tenTaiKhoan;
	private String matKhau;	
	private String tenNV;
	
	public TaiKhoanNhanVien(String maTaiKhoan, String tenTaiKhoan, String matKhau, String tenNV) {
		setMaTaiKhoan(maTaiKhoan);
		setTenTaiKhoan(tenTaiKhoan);
		setMatKhau(matKhau);
		setTenNV(tenNV);
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	
	
}
