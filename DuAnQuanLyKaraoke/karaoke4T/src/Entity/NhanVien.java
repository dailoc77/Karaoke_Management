package Entity;

import java.sql.Date;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private LoaiNhanVien loaiNhanVien;
	private String chuThich;
	private Date namSinh;
	private Boolean gioiTinh;
	private String trangThaiLamViec;
	private int CMND;
	private int SDT;
	
	public NhanVien(String maNV, String tenNV, LoaiNhanVien loaiNhanVien, String chuThich, Date namSinh, Boolean gioiTinh, String trangThaiLamViec, int CMND, int SDT) {
		setChuThich(chuThich);
		setCMND(CMND);
		setGioiTinh(gioiTinh);
		setLoaiNhanVien(loaiNhanVien);
		setMaNV(maNV);
		setNamSinh(namSinh);
		setSDT(SDT);
		setTenNV(tenNV);
		setTrangThaiLamViec(trangThaiLamViec);
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

	public LoaiNhanVien getLoaiNhanVien() {
		return loaiNhanVien;
	}

	public void setLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getTrangThaiLamViec() {
		return trangThaiLamViec;
	}

	public void setTrangThaiLamViec(String trangThaiLamViec) {
		this.trangThaiLamViec = trangThaiLamViec;
	}

	public int getCMND() {
		return CMND;
	}

	public void setCMND(int cMND) {
		CMND = cMND;
	}

	public int getSDT() {
		return SDT;
	}

	public void setSDT(int sDT) {
		SDT = sDT;
	}
	
	
}
