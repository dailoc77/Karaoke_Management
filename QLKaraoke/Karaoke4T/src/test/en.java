package test;

import java.util.Objects;

public class en {
	private String maLNV;
	private String tenLNV;
	public en() {
		super();
		// TODO Auto-generated constructor stub
	}
	public en(String maLNV, String tenLNV) {
		super();
		this.maLNV = maLNV;
		this.tenLNV = tenLNV;
	}
	public String getMaLNV() {
		return maLNV;
	}
	public void setMaLNV(String maLNV) {
		this.maLNV = maLNV;
	}
	public String getTenLNV() {
		return tenLNV;
	}
	public void setTenLNV(String tenLNV) {
		this.tenLNV = tenLNV;
	}
	@Override
	public String toString() {
		return tenLNV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLNV, tenLNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		en other = (en) obj;
		return Objects.equals(maLNV, other.maLNV) && Objects.equals(tenLNV, other.tenLNV);
	}
	
}

