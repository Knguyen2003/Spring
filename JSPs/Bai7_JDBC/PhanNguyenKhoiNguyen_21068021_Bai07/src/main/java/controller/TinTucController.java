package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DanhMuc;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import dao.DanhMucDao;
import dao.TinTucDao;
import daoImpl.DanhMucDaoImpl;
import daoImpl.TinTucDaoImpl;


public class TinTucController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/QUANLYDANHMUC")
    private DataSource dataSource;
    private TinTucDao tinTucDao;
    private DanhMucDao danhMucDao;
    
    public TinTucController() {
        super();
       
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
    		tinTucDao = new TinTucDaoImpl(dataSource);
    		danhMucDao = new DanhMucDaoImpl(dataSource);
			System.out.println("Connection to database..." + this.dataSource.getConnection());
		} catch (Exception e) {
			throw new ServletException(e);
		}
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		showTinTuc(request, response);
	}
	
	
   private void showTinTuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   List<DanhMuc> danhMucList = danhMucDao.getAllDanhMuc();
	   System.out.println("Danh muc list: " + danhMucList.size());
       request.setAttribute("dsDM", danhMucList);
       request.getRequestDispatcher("/views/home.jsp").forward(request, response);
   }
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
