package com.fit.dao;

import com.fit.entities.GIANGVIEN;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GiangVienDaoImpl implements GiangVienDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addGiangVien(GIANGVIEN giangVien) {
        entityManager.merge(giangVien);
    }

    @Override
    public List<GIANGVIEN> getAllGiangVien() {
        return entityManager.createQuery("from GIANGVIEN", GIANGVIEN.class)
                .getResultList();
    }

    @Override
    public GIANGVIEN getGiangVienById(int maGV) {
        return entityManager.find(GIANGVIEN.class, maGV);
    }

}
