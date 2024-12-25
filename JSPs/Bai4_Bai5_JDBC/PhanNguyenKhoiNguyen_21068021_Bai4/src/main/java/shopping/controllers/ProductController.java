package shopping.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shopping.dao.ProductDao;
import shopping.daoImpl.ProductDaoImpl;
import shopping.entities.Product;

//@WebServlet(urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/shooping")
	private DataSource dataSource;
	private ProductDao productDAO;

	public ProductController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			System.out.println("Init ProductController");
			System.out.println("DataSource: " + this.dataSource.getConnection()); // .getConnection dùng để kiểm tra kết
																					// nối đến database
		} catch (SQLException e) {
			e.printStackTrace();
		}
		productDAO = new ProductDaoImpl(this.dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Them san pham vao database
		/*
		Product p1 = new Product("Iphone 12", 1000, "1.jpg");
		Product p2 = new Product("Iphone 11", 900, "2.jpg");
		Product p3 = new Product("Iphone 10", 800, "3.jpg");
		Product p4 = new Product("Iphone 9", 700, "4.jpg");
		Product p5 = new Product("Iphone 8", 600, "5.jpg");
		Product p6 = new Product("Iphone 7", 500, "6.jpg");
		Product p7 = new Product("Iphone 6", 400, "7.jpg");
	    Product p8 = new Product("Iphone 5", 300, "8.jpg");
	    Product p9 = new Product("Iphone 4", 200, "9.jpg");
	    Product p10 = new Product("Iphone 3", 100, "10.jpg");
	    productDAO.addProduct(p10);
	    productDAO.addProduct(p9);
	    productDAO.addProduct(p8);
	    productDAO.addProduct(p7);
	    productDAO.addProduct(p6);
	    productDAO.addProduct(p5);
	    productDAO.addProduct(p4);
	    productDAO.addProduct(p3);
	    productDAO.addProduct(p2);
	    productDAO.addProduct(p1);
	    */
	    
	    //Lay danh sach san pham
	    List<Product> list = productDAO.findAll();
	    //Truyen danh sach san pham từ servlet toi trang jsp de hien thi khi gọi getAttribute
	    request.setAttribute("products", list); //setAttribute Lưu trữ dữ liệu để có thể sử dụng trong JSP.
	    //Chuyen toi trang product.jsp
	    request.getRequestDispatcher("views/product/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
