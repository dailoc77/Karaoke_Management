package Entity;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private double giaDichVu;
	private int soLuongDichVu;
	
	public DichVu(String maDichVu,double giaDichVu , int soLuongDichVu , String tenDichVu) {
		setMaDichVu(maDichVu);
		setGiaDichVu(giaDichVu);
		setSoLuongDichVu(soLuongDichVu);
		setTenDichVu(tenDichVu);
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public double getGiaDichVu() {
		return giaDichVu;
	}

	public void setGiaDichVu(double giaDichVu) {
		this.giaDichVu = giaDichVu;
	}

	public int getSoLuongDichVu() {
		return soLuongDichVu;
	}

	public void setSoLuongDichVu(int soLuongDichVu) {
		this.soLuongDichVu = soLuongDichVu;
	}
	
}
