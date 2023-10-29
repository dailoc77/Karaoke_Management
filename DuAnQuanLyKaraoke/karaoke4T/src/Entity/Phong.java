package Entity;

public class Phong {
	private String maPhong;
	private String tenPhong;
	private LoaiPhong loaiPhong;
	private double giaPhong;
	private TrangThaiPhong trangThaiPhong;
	private String chuThichPhong;
	
	public Phong(String maPhong, String tenPhong, LoaiPhong loaiPhong, double giaPhong, TrangThaiPhong trangThaiPhong, String chuThichPhong) {
		setChuThichPhong(chuThichPhong);
		setGiaPhong(giaPhong);
		setLoaiPhong(loaiPhong);
		setMaPhong(maPhong);
		setTenPhong(tenPhong);
		setTrangThaiPhong(trangThaiPhong);
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public TrangThaiPhong getTrangThaiPhong() {
		return trangThaiPhong;
	}

	public void setTrangThaiPhong(TrangThaiPhong trangThaiPhong) {
		this.trangThaiPhong = trangThaiPhong;
	}

	public String getChuThichPhong() {
		return chuThichPhong;
	}

	public void setChuThichPhong(String chuThichPhong) {
		this.chuThichPhong = chuThichPhong;
	}
	
	
}
