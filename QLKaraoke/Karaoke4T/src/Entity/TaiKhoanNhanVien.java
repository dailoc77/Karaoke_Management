package Entity;

import java.util.Objects;

public class TaiKhoanNhanVien {
	private String maTaiKhoan;
	private String tenTaiKhoan;
	private String matKhau;	
	private String tenNV;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoanNhanVien other = (TaiKhoanNhanVien) obj;
		return Objects.equals(maTaiKhoan, other.maTaiKhoan);
	}

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
	@Override
	public int hashCode() {
		return Objects.hash(maTaiKhoan);
	}
	
}
