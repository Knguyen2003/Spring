package models;

public class DeTai {
     private String maDeTai;
     private String tenDeTai;
     private int namDangky;
     private String moTa;
     private GiangVien maGiangVien;
	public String getMaDeTai() {
		return maDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public int getNamDangky() {
		return namDangky;
	}
	public void setMaDangky(int maDangky) {
		this.namDangky = maDangky;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public GiangVien getMaGiangVien() {
		return maGiangVien;
	}
	public void setMaGiangVien(GiangVien maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	public DeTai(String maDeTai, String tenDeTai, int maDangky, String moTa, GiangVien maGiangVien) {
		super();
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.namDangky = maDangky;
		this.moTa = moTa;
		this.maGiangVien = maGiangVien;
	}

	public DeTai(String maDeTai, String tenDeTai, int maDangky, String moTa) {
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.namDangky = maDangky;
		this.moTa = moTa;
	}
	public DeTai() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DeTai [maDeTai=" + maDeTai + ", tenDeTai=" + tenDeTai + ", maDangky=" + namDangky + ", moTa=" + moTa
				+ ", maGiangVien=" + maGiangVien + "]";
	}
  
}
