package daoImpl;

import java.util.List;

import dao.DienThoaiDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.DienThoai;

@SuppressWarnings(value={"unchecked"})
public class DienThoaiDaoImpl implements DienThoaiDao{
   private EntityManager entityManager; // khai báo biến entityManager dùng để thao tác với database (CRUD)
    
   
	public DienThoaiDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager; // gán giá trị cho biến entityManager
    }

	@Override
	public List<DienThoai> layTatCaDT() {
		try {
			return entityManager.createQuery("from DienThoai").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DienThoai timDienThoaiTheoMa(int maDT) {
	    try {
	    	DienThoai dt = entityManager.find(DienThoai.class, maDT);
		    return dt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DienThoai themDienThoai(DienThoai dienThoai) {
		EntityTransaction transaction =null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(dienThoai);
			transaction.commit();
			return dienThoai;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return null;
		
	}

	
	@Override
	public DienThoai capNhatDienThoai(DienThoai dienThoai) {
		EntityTransaction transaction =null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.merge(dienThoai);
			transaction.commit();
			return dienThoai;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return null;
		
	}

	@Override
	public boolean xoaDienThoai(int maDT) {
		EntityTransaction transaction =null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			DienThoai dt = entityManager.find(DienThoai.class, maDT);
			if (dt != null) {
				if (entityManager.contains(dt)) {
					entityManager.remove(dt);
					entityManager.flush(); 
				} else {
					entityManager.remove(entityManager.merge(dt)); // merge: gộp đối tượng dt vào trong context của entityManager
				}
			}
			transaction.commit(); // dùng để lưu lại các thay đổi vào database
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return false;
	}
}
