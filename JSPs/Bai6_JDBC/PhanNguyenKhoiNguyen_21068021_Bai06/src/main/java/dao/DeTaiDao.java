package dao;

import java.util.List;

import models.DeTai;

public interface DeTaiDao {
	public boolean themDeTai(DeTai deTai);
	public List<DeTai> timDeTaiTheoGiangVien(String maGiangVien);
	public DeTai timDeTaiTheoMaDeTai(String maDeTai);
}
