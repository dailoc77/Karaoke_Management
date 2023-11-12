package Entity;

import java.util.Objects;

public class PhieuDatPhong {
	private String maPDP;
	private String thoiGianDangKyPhong;
	private String thoiGianNhanPhong;
	private TrangThaiPhong trangThaiPhong; 
	private KhachHang maKH;
	private NhanVien maNV;
	private Phong maPhong;
	public PhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuDatPhong(String maPDP, String thoiGianDangKyPhong, String thoiGianNhanPhong,
			TrangThaiPhong trangThaiPhong, KhachHang maKH, NhanVien maNV, Phong maPhong) {
		setMaKH(maKH);
		setThoiGianDangKyPhong(thoiGianDangKyPhong);
		setThoiGianNhanPhong(thoiGianNhanPhong);
		setTrangThaiPhong(trangThaiPhong);
		setMaKH(maKH);
		setMaNV(maNV);
		setMaPhong(maPhong);
	}
	public String getMaPDP() {
		return maPDP;
	}
	public void setMaPDP(String maPDP) {
		this.maPDP = maPDP;
	}
	public String getThoiGianDangKyPhong() {
		return thoiGianDangKyPhong;
	}
	public void setThoiGianDangKyPhong(String thoiGianDangKyPhong) {
		this.thoiGianDangKyPhong = thoiGianDangKyPhong;
	}
	public String getThoiGianNhanPhong() {
		return thoiGianNhanPhong;
	}
	public void setThoiGianNhanPhong(String thoiGianNhanPhong) {
		this.thoiGianNhanPhong = thoiGianNhanPhong;
	}
	public TrangThaiPhong getTrangThaiPhong() {
		return trangThaiPhong;
	}
	public void setTrangThaiPhong(TrangThaiPhong trangThaiPhong) {
		this.trangThaiPhong = trangThaiPhong;
	}
	public KhachHang getMaKH() {
		return maKH;
	}
	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	public Phong getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(Phong maPhong) {
		this.maPhong = maPhong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKH, maNV, maPDP, maPhong, thoiGianDangKyPhong, thoiGianNhanPhong, trangThaiPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatPhong other = (PhieuDatPhong) obj;
		return Objects.equals(maKH, other.maKH) && Objects.equals(maNV, other.maNV)
				&& Objects.equals(maPDP, other.maPDP) && Objects.equals(maPhong, other.maPhong)
				&& Objects.equals(thoiGianDangKyPhong, other.thoiGianDangKyPhong)
				&& Objects.equals(thoiGianNhanPhong, other.thoiGianNhanPhong)
				&& Objects.equals(trangThaiPhong, other.trangThaiPhong);
	}
	@Override
	public String toString() {
		return "PhieuDatPhong [maPDP=" + maPDP + ", thoiGianDangKyPhong=" + thoiGianDangKyPhong + ", thoiGianNhanPhong="
				+ thoiGianNhanPhong + ", trangThaiPhong=" + trangThaiPhong + ", maKH=" + maKH + ", maNV=" + maNV
				+ ", maPhong=" + maPhong + "]";
	}
	
	
}
