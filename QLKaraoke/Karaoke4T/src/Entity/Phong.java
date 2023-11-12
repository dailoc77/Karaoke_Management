package Entity;

public class Phong {
	private String maPhong;
	private String soNguoi;
	private String tenPhong;
	private LoaiPhong loaiPhong;
	private double giaPhong;
	private TrangThaiPhong trangThaiPhong;
	private String chuThichPhong;
	
	public Phong(String maPhong,String soNguoi, String tenPhong, LoaiPhong loaiPhong, double giaPhong, TrangThaiPhong trangThaiPhong, String chuThichPhong) {
		setMaPhong(maPhong);
		setSoNguoi(soNguoi);
		setTenPhong(tenPhong);
		setGiaPhong(giaPhong);
		setLoaiPhong(loaiPhong);
		setTrangThaiPhong(trangThaiPhong);
		setChuThichPhong(chuThichPhong);
	}
	
	

	public Phong(String maPhong, String soNguoi, String tenPhong,TrangThaiPhong trangThaiPhong, LoaiPhong loaiPhong) {
		setMaPhong(maPhong);
		setSoNguoi(soNguoi);
		setTenPhong(tenPhong);
		setTrangThaiPhong(trangThaiPhong);
		setLoaiPhong(loaiPhong);
	}



	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	
	public String getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(String soNguoi) {
		this.soNguoi = soNguoi;
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
