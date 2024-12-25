package shopping.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shopping.dao.ProductDao;
import shopping.daoImpl.ProductDaoImpl;
import shopping.entities.ItemCart;


public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/shooping")
	private DataSource dataSource;
	private ProductDao productDAO;
       
    
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
		try {
			System.out.println("Init ProductController");
			System.out.println("DataSource: " + this.dataSource.getConnection()); // .getConnection dùng để kiểm tra kết
																					// nối đến database
		} catch (Exception e) {
			e.printStackTrace();
		}
    	productDAO = new ProductDaoImpl(this.dataSource);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "buy":
			buyProduct(request, response);
			//mua
			break;
		case "remove":
			removeProduct(request, response);
			//xoa
			break;
		default:
			//quay ve trang chu
			returnShopping(request, response);
			break;
		}
	}
	/**
	 * Điều hướng quay về trang chủ để mua hàng
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void returnShopping(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         request.getRequestDispatcher("views/product/index.jsp").forward(request, response);
		response.sendRedirect("ProductController");
	}
	
	private void removeProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
		int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
//		response.sendRedirect("CartController"); //chuyển hướng về trang giỏ hàng
		request.getRequestDispatcher("views/cart/cart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	private void buyProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		List<ItemCart> cart = null;
		if (session.getAttribute("cart") == null) {
			cart = new ArrayList<ItemCart>();
        } else {
            cart = (List<ItemCart>) session.getAttribute("cart");
		}
		int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
		if (index == -1) {
			cart.add(new ItemCart(productDAO.getProductByID(Integer.parseInt(request.getParameter("id"))), 1));
		} else {
			int quantity = cart.get(index).getQuanlity() + 1;
			cart.get(index).setQuanlity(quantity);
		}
		session.setAttribute("cart", cart);
//		response.sendRedirect("CartController");
		request.getRequestDispatcher("views/cart/cart.jsp").forward(request, response);
		
	}
	
	private int isExisting(int id, List<ItemCart> cart) {
		for (int i = 0; i < cart.size(); i++) {   //cart.size() trả về số lượng phần tử trong danh sách
			if (cart.get(i).getProduct().getId() == id) {  //get(i) trả về phần tử tại vị trí thứ i trong danh sách
				return i;
			}
		}
		return -1;
	}
	
	

}
