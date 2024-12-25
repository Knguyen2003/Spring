package daoImpl;

import javax.sql.DataSource;

import dao.TinTucDao;
import models.TinTuc;

public class TinTucDaoImpl implements TinTucDao{
	
	private DataSource dataSource;

	public TinTucDaoImpl(DataSource dataSource) {
       super();
		this.dataSource = dataSource;
	}


	@Override
	public TinTuc getTinTucByIDDM(String maDM) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean addTinTuc(TinTuc tt) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean deleteTinTuc(String maTinTuc) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
