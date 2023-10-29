package Entity;

public class LoaiNhanVien {
	private String maLoaiNhanVien;
	private String tenLoaiNhanVien;
	
	public LoaiNhanVien(String maLoaiNhanVien, String tenLoaiNhanVien) {
		setMaLoaiNhanVien(maLoaiNhanVien);
		setTenLoaiNhanVien(tenLoaiNhanVien);
	}

	public String getMaLoaiNhanVien() {
		return maLoaiNhanVien;
	}

	public void setMaLoaiNhanVien(String maLoaiNhanVien) {
		this.maLoaiNhanVien = maLoaiNhanVien;
	}

	public String getTenLoaiNhanVien() {
		return tenLoaiNhanVien;
	}

	public void setTenLoaiNhanVien(String tenLoaiNhanVien) {
		this.tenLoaiNhanVien = tenLoaiNhanVien;
	}
	
	
}
