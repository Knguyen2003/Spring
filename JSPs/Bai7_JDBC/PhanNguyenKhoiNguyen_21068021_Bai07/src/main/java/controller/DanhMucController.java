package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import dao.DanhMucDao;
import daoImpl.DanhMucDaoImpl;
import daoImpl.TinTucDaoImpl;

/**
 * Servlet implementation class DanhMucController
 */
public class DanhMucController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/QUANLYDANHMUC")
	private DataSource dataSource;
	private DanhMucDao danhMucDao;

	public DanhMucController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
    		danhMucDao = new DanhMucDaoImpl(dataSource);
			System.out.println("Connection to database..." + this.dataSource.getConnection());
		} catch (Exception e) {
			throw new ServletException(e);
		}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
