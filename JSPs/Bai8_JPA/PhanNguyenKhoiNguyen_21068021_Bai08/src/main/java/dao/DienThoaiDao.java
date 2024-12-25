package dao;

import java.util.List;

import models.DienThoai;

public interface DienThoaiDao {
    public List<DienThoai> layTatCaDT();
    public DienThoai timDienThoaiTheoMa(int maDT);
    public DienThoai themDienThoai(DienThoai dienThoai);
    public DienThoai capNhatDienThoai(DienThoai dienThoai);
    public boolean xoaDienThoai(int maDT);
}
