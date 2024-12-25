package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DeTai;
import models.GiangVien;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import dao.DeTaiDao;
import dao.GiangVienDao;
import daoImpl.DeTaiDaoImpl;
import daoImpl.GiangVienDaoImpl;


public class DeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/QuanLyGiangVienDeTai")
    private DataSource dataSource;
    private DeTaiDao deTaiDAO;
    private GiangVienDao giangVienDAO;
  
    
    public DeTaiController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
		try {
			deTaiDAO = new DeTaiDaoImpl(dataSource);
			giangVienDAO = new GiangVienDaoImpl(dataSource);
			System.out.println("Connection: " + this.dataSource.getConnection());
		} catch (Exception e) {
			throw new ServletException(e);
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";

		switch (action) {
		case "chuyenAddDT":
			request.getRequestDispatcher("/views/DeTai/themDeTai.jsp").forward(request, response);
			break;
		default:
			show(request, response);
			break;
		}
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lấy danh sách giảng viên
		List<GiangVien> dsGiangVien = giangVienDAO.layToanBoGiangVien();
		// lấy danh sách đề tài theo mã giảng viên
		Map<String, List<DeTai>> dsDeTai = new HashMap<String, List<DeTai>>();
		for (GiangVien gv : dsGiangVien) {
			List<DeTai> ds = deTaiDAO.timDeTaiTheoGiangVien(gv.getMaGV());
			dsDeTai.put(gv.getMaGV(), ds);
		}
//    			System.out.println(dsDeTai);
		request.setAttribute("dsGiangVien", dsGiangVien);
		request.setAttribute("dsDeTai", dsDeTai);
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		
		switch (action) {
			case "addDT" :
				themDeTai(request, response);
				break;
			default:
				doGet(request, response);
				break;
		}
	}
	
	private void themDeTai(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//Lay dữ liệu
		String maDeTai = request.getParameter("maDT");
		String tenDeTai = request.getParameter("tenDT");
		int nam = Integer.parseInt(request.getParameter("nam"));
		String moTa = request.getParameter("moTa");
		String maGV = request.getParameter("maGV");
		//Kiem tra trung
		DeTai deTai = deTaiDAO.timDeTaiTheoMaDeTai(maDeTai);
		if(deTai != null) {
            //Trung
            request.setAttribute("message", "Mã đề tài đã tồn tại");
            request.getRequestDispatcher("/views/DeTai/themDeTai.jsp").forward(request, response);
            return;
		} 

		GiangVien giangVien = giangVienDAO.timGiangVienTheoMa(maGV);
		if (giangVien == null) {
            request.setAttribute("message", "Không tìm thấy giáo viên");
            request.getRequestDispatcher("/views/DeTai/themDeTai.jsp").forward(request, response);
            return;
        }
            	
		deTai = new DeTai(maDeTai, tenDeTai, nam, moTa, giangVien);
    	boolean kq = deTaiDAO.themDeTai(deTai);
    	if (kq) {
    		request.setAttribute("message", "Thêm đề tài thành công");
    	} else {
    		request.setAttribute("message", "Thêm đề tài thất bại");
    	}
//    	response.sendRedirect("DeTaiController");
    	request.getRequestDispatcher("/DeTaiController?action=").forward(request, response);
	}
}
