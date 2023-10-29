package Entity;

public class TrangThaiPhong {
	private String maTrangThai;
	private String tenTrangThai;
	
	public TrangThaiPhong(String maTrangThai, String tenTrangThai) {
		setMaTrangThai(maTrangThai);
		setTenTrangThai(tenTrangThai);
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	
	
}
