package Entity;

public class LoaiPhong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private double giaTien;
	
	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, double giaTien) {
		setMaLoaiPhong(maLoaiPhong);
		setTenLoaiPhong(tenLoaiPhong);
		setGiaTien(giaTien);
	}

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	
	
}
