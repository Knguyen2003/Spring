
package com.fit.dao;


import com.fit.entities.DETAI;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DeTaiDaoImpl implements DeTaiDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDeTai(DETAI deTai) {
        entityManager.merge(deTai);
    }

    @Override
    public void deleteDeTai(int theId) {
        DETAI deTai = entityManager.find(DETAI.class, theId);
        if (deTai != null) {
            entityManager.remove(deTai);
        }
    }

    @Override
    public List<DETAI> getDeTaiByGiangVien(int maGV) {
        return entityManager.createQuery("from DETAI where giangvien.MAGV = :maGV", DETAI.class)
                .setParameter("maGV", maGV)
                .getResultList();
    }

    @Override
    public DETAI getDeTai(int theId) {
        return entityManager.find(DETAI.class, theId);
    }
}
