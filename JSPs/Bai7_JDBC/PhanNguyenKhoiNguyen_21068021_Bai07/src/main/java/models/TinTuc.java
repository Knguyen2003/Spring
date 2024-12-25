package models;

public class TinTuc {
	private String maTinTuc;
	private String tieuDe;
	private String noiDungTT;
	private String lienKet;
	private String maDM;

	public String getMaTinTuc() {
		return maTinTuc;
	}

	public void setMaTinTuc(String maTinTuc) {
		this.maTinTuc = maTinTuc;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDungTT() {
		return noiDungTT;
	}

	public void setNoiDungTT(String noiDungTT) {
		this.noiDungTT = noiDungTT;
	}

	public String getLienKet() {
		return lienKet;
	}

	public void setLienKet(String lienKet) {
		this.lienKet = lienKet;
	}

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

	public TinTuc(String maTinTuc, String tieuDe, String noiDungTT, String lienKet, String maDM) {
		this.maTinTuc = maTinTuc;
		this.tieuDe = tieuDe;
		this.noiDungTT = noiDungTT;
		this.lienKet = lienKet;
		this.maDM = maDM;
	}

	public TinTuc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TinTuc [maTinTuc=" + maTinTuc + ", tieuDe=" + tieuDe + ", noiDungTT=" + noiDungTT + ", lienKet="
				+ lienKet + ", maDM=" + maDM + "]";
	}

}
