package dao;

import models.TinTuc;

public interface TinTucDao {
   public TinTuc getTinTucByIDDM(String maDM);
   public boolean addTinTuc(TinTuc tt);
   public boolean deleteTinTuc(String maTinTuc);
}
