
package com.fit.service;

import com.fit.dao.DeTaiDao;
import com.fit.entities.DETAI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeTaiServiceImpl implements DeTaiService {

    @Autowired
    private DeTaiDao deTaiDao;

    @Override
    @Transactional
    public void addDeTai(DETAI deTai) {
        deTaiDao.addDeTai(deTai);
    }

    @Override
    @Transactional
    public void deleteDeTai(int theId) {
        deTaiDao.deleteDeTai(theId);
    }

    @Override
    @Transactional
    public List<DETAI> getDeTaiByGiangVien(int maGV) {
        return deTaiDao.getDeTaiByGiangVien(maGV);
    }

    @Override
    @Transactional
    public DETAI getDeTai(int theId) {
        return deTaiDao.getDeTai(theId);
    }
}
