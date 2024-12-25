
package com.fit.service;



import com.fit.entities.GIANGVIEN;

import java.util.List;

public interface GiangVienService {
    public void addGiangVien(GIANGVIEN giangVien);

    public List<GIANGVIEN> getAllGiangVien();

    public GIANGVIEN getGiangVienById(int maGV);
}
