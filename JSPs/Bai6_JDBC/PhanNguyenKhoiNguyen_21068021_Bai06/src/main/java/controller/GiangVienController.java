package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.GiangVien;

import java.io.IOException;

import javax.sql.DataSource;

import dao.GiangVienDao;
import daoImpl.GiangVienDaoImpl;


public class GiangVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/QuanLyGiangVienDeTai")
	private DataSource dataSource;
	private GiangVienDao giangVienDao;
 
    public GiangVienController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
			giangVienDao = new GiangVienDaoImpl(dataSource);
		    System.out.println("DataSource: " + this.dataSource.getConnection());
		} catch (Exception e) {
			throw new ServletException();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		   case "chuyenAddGV":
			   request.getRequestDispatcher("views/GiangVien/themGiangVien.jsp").forward(request, response);
			   break;
			case "addGV":
				themGiangVien(request, response);
				break;
			case "chuyenHome":
				response.sendRedirect("DeTaiController");
				break;
			default:
			   break;
		}
	}
	
	private void themGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maGV = request.getParameter("maGV");
		String tenGV = request.getParameter("tenGV");
		String linhVuc = request.getParameter("linhVuc");
		String sdt = request.getParameter("soDT");
		GiangVien giangVien = new GiangVien(maGV, tenGV, linhVuc, sdt);
		
		//Kiem tra ma trung
		GiangVien gv = giangVienDao.timGiangVienTheoMa(maGV);

		if (gv != null || maGV.isEmpty()) {
			request.setAttribute("message", "Mã giảng viên đã tồn tại");
			request.getRequestDispatcher("/views/GiangVien/themGiangVien.jsp").forward(request, response);
			return;
		}else {
			boolean kq =  giangVienDao.themGiangVien(giangVien);
			if(kq) {
	            request.setAttribute("message", "Thêm giảng viên thành công");
	        }else {
	        	request.setAttribute("message", "Thêm giảng viên thất bại");
	        }
			request.getRequestDispatcher("/DeTaiController?action=").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
