package models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dienthoai")
public class DienThoai {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name = "MADT")
	private int maDT;
	@Column(name = "TENDT")
	private String tenDT;
	@Column(name = "NAMSANXUAT")
	private int namSX;
	@Column(name = "CAUHINH")
	private String cauHinh;

	@ManyToOne
    @JoinColumn(name = "MANCC", nullable = false)
	private NhaCungCap nhaCungCap;

	public DienThoai(int maDT, String tenDT, int namSX, String cauHinh, NhaCungCap nhaCungCap) {

		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namSX = namSX;
		this.cauHinh = cauHinh;
		this.nhaCungCap = nhaCungCap;
	}
	
	

	public DienThoai(String tenDT, int namSX, String cauHinh, NhaCungCap nhaCungCap) {
		this.tenDT = tenDT;
		this.namSX = namSX;
		this.cauHinh = cauHinh;
		this.nhaCungCap = nhaCungCap;
	}



	public DienThoai() {

		// TODO Auto-generated constructor stub
	}

	public int getMaDT() {
		return maDT;
	}

	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	@Override
	public String toString() {
		return "DienThoai [maDT=" + maDT + ", tenDT=" + tenDT + ", namSX=" + namSX + ", cauHinh=" + cauHinh
				+ ", nhaCungCap=" + nhaCungCap + "]";
	}

}
