package Entity;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String gioiTinh;
	private String ngaySinh;
	private String CMND;
	private String SDT;
	private String trangThaiLamViec;
	private String maDC;
	private LoaiNhanVien tenLNV;
	private TaiKhoanNhanVien maTK;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV, String tenNV, String gioiTinh, String ngaySinh, String cMND, String sDT,
			String trangThaiLamViec, String maDC, LoaiNhanVien tenLNV, TaiKhoanNhanVien maTK) {
		setMaNV(maNV);
		setTenNV(tenNV);
		setGioiTinh(gioiTinh);
		setNgaySinh(ngaySinh);
		setCMND(cMND);
		setSDT(sDT);
		setTrangThaiLamViec(trangThaiLamViec);
		setMaDC(maDC);
		setTenLNV(tenLNV);
		setMaTK(maTK);
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getTrangThaiLamViec() {
		return trangThaiLamViec;
	}
	public void setTrangThaiLamViec(String trangThaiLamViec) {
		this.trangThaiLamViec = trangThaiLamViec;
	}
	public String getMaDC() {
		return maDC;
	}
	public void setMaDC(String maDC) {
		this.maDC = maDC;
	}
	public LoaiNhanVien getTenLNV() {
		return tenLNV;
	}
	public void setTenLNV(LoaiNhanVien tenLNV) {
		this.tenLNV = tenLNV;
	}
	public TaiKhoanNhanVien getMaTK() {
		return maTK;
	}
	public void setMaTK(TaiKhoanNhanVien maTK) {
		this.maTK = maTK;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CMND, SDT, gioiTinh, maDC, tenLNV, maNV, maTK, ngaySinh, tenNV, trangThaiLamViec);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(CMND, other.CMND) && Objects.equals(SDT, other.SDT)
				&& Objects.equals(gioiTinh, other.gioiTinh) && Objects.equals(maDC, other.maDC)
				&& Objects.equals(tenLNV, other.tenLNV) && Objects.equals(maNV, other.maNV)
				&& Objects.equals(maTK, other.maTK) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(tenNV, other.tenNV) && Objects.equals(trangThaiLamViec, other.trangThaiLamViec);
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", CMND=" + CMND + ", SDT=" + SDT + ", trangThaiLamViec=" + trangThaiLamViec + ", maDC=" + maDC
				+ ", maLNV=" + tenLNV + ", maTK=" + maTK + "]";
	}
	
	
}
