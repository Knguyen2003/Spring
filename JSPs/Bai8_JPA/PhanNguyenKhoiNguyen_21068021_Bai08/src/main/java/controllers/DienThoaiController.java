package controllers;

import java.io.IOException;
import java.util.List;

import Util.EntityManagerFactoryUtil;
import dao.DienThoaiDao;
import daoImpl.DienThoaiDaoImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DienThoai;
import models.NhaCungCap;

public class DienThoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
	private DienThoaiDao dienThoaiDao;

	public DienThoaiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			this.entityManagerFactoryUtil = new EntityManagerFactoryUtil();
			this.dienThoaiDao = new DienThoaiDaoImpl(this.entityManagerFactoryUtil.getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Failed to initialize DienThoaiDao", e);
		}

	}

	public void destroy() {
		this.entityManagerFactoryUtil.close();
		super.destroy();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "add": {
			break;
		}
		case "showSP": {
			showDanhSachSanPham(request, response);
			break;
		}
		case "moveAddSP": {
			request.getRequestDispatcher("/views/dienThoai/themSanPham.jsp").forward(request, response);
			break;
		}
		case "quanLi": {
			List<DienThoai> listDienThoai = dienThoaiDao.layTatCaDT();
			request.setAttribute("DSDT", listDienThoai);
			request.getRequestDispatcher("/views/dienThoai/quanLySanPham.jsp").forward(request, response);
			break;
		}
		case "remove": {
			removeSanPham(request, response);
			break;
		}
		case "update": {
			int id = Integer.parseInt(request.getParameter("id"));
			DienThoai dienThoai = dienThoaiDao.timDienThoaiTheoMa(id);
			request.setAttribute("dienThoai", dienThoai);
			request.getRequestDispatcher("/views/dienThoai/suaSanPham.jsp").forward(request, response);
			break;
		}
		default: {
			showDanhSachSanPham(request, response);
			break;
		}
		}
	}

	private void addSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDT = request.getParameter("tenDienThoai");
		int namSX = Integer.parseInt(request.getParameter("namSanXuat"));
		String cauHinh = request.getParameter("cauHinh");
		int maNCC = Integer.parseInt(request.getParameter("maNhaCungCap"));

		DienThoai dienThoai = new DienThoai(tenDT, namSX, cauHinh, new NhaCungCap(maNCC));
		DienThoai dt = dienThoaiDao.themDienThoai(dienThoai);
		if (dt != null) {
			request.setAttribute("message", "Thêm sản phẩm thành công");
		} else {
			request.setAttribute("message", "Thêm sản phẩm thất bại");
		}
		request.getRequestDispatcher("/views/dienThoai/themSanPham.jsp").forward(request, response);
	}

	private void removeSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean kq = dienThoaiDao.xoaDienThoai(id);
		if (kq) {
			request.setAttribute("message", "Xóa sản phẩm thành công");
		} else {
			request.setAttribute("message", "Xóa sản phẩm thất bại");
		}
		request.getRequestDispatcher("DienThoaiController?action=quanLi").forward(request, response);

	}

	private void updateSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("maDienThoai"));
		String tenDT = request.getParameter("tenDienThoai");
		int namSX = Integer.parseInt(request.getParameter("namSanXuat"));
		String cauHinh = request.getParameter("cauHinh");
		int maNCC = Integer.parseInt(request.getParameter("maNhaCungCap"));

		DienThoai dienThoai = new DienThoai(tenDT, namSX, cauHinh, new NhaCungCap(maNCC));
		DienThoai dt = dienThoaiDao.capNhatDienThoai(dienThoai);
		if (dt != null) {
			request.setAttribute("message", "Cập nhất sản phẩm thành công");
		} else {
			request.setAttribute("message", "Cập nhật sản phẩm thất bại");
		}
		request.getRequestDispatcher("DienThoaiController?action=quanLi").forward(request, response);
	}

	private void showDanhSachSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DienThoai> listDienThoai = dienThoaiDao.layTatCaDT();
		request.setAttribute("DSDT", listDienThoai);
		request.getRequestDispatcher("/views/dienThoai/danhSachSanPham.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "addSP": {
			addSP(request, response);
			break;
		}
		case "sua": {
			updateSanPham(request, response);
			break;
		}
		default: {
			doGet(request, response);
			break;
		}

		}
	}

}
