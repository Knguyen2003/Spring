package dao;

import java.util.List;

import models.GiangVien;

public interface GiangVienDao {
    public boolean themGiangVien(GiangVien giangVien);
    public GiangVien timGiangVienTheoMa(String maGiangVien);
    public List<GiangVien> layToanBoGiangVien();
}
