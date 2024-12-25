
package com.fit.service;




import com.fit.entities.DETAI;

import java.util.List;

public interface DeTaiService {
    public void addDeTai(DETAI deTai);

    public void deleteDeTai(int theId);

    public List<DETAI> getDeTaiByGiangVien(int maGV);

    public DETAI getDeTai(int theId);
}
