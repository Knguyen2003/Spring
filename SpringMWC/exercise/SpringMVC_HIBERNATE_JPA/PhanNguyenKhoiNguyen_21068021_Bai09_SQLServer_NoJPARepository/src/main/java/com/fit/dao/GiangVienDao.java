
package com.fit.dao;



import com.fit.entities.GIANGVIEN;

import java.util.List;

public interface GiangVienDao {
    public void addGiangVien(GIANGVIEN giangVien);

    public List<GIANGVIEN> getAllGiangVien();

    public GIANGVIEN getGiangVienById(int maGV);
}
