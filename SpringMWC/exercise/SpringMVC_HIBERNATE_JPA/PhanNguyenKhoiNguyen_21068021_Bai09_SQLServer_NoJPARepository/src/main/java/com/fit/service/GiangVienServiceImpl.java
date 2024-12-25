
package com.fit.service;


import com.fit.dao.GiangVienDao;
import com.fit.entities.GIANGVIEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GiangVienServiceImpl implements GiangVienService {
    @Autowired
    private GiangVienDao giangVienDao;

    @Override
    @Transactional
    public void addGiangVien(GIANGVIEN giangVien) {
        giangVienDao.addGiangVien(giangVien);
    }

    @Override
    @Transactional
    public List<GIANGVIEN> getAllGiangVien() {
        return giangVienDao.getAllGiangVien();
    }

    @Override
    @Transactional
    public GIANGVIEN getGiangVienById(int maGV) {
        return giangVienDao.getGiangVienById(maGV);
    }
}
