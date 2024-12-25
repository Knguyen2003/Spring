package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.BookDao;
import dao.CartDao;
import daoImpl.BookImpl;
import daoImpl.CartDaoImpl;
import entity.Book;
import entity.CartItem;
import entity.Order;


public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/book")
	private DataSource dataSource;
	private BookDao bookDao;
    private CartDao cartDao;
    private double tongTien = 0;
    private int orderID = 0;
	
	@Override
    public void init(ServletConfig config) throws ServletException {
    	
    	super.init(config);
    	try {
    		System.out.println("init");
    		System.out.println(this.dataSource.getConnection());
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	bookDao = new BookImpl(dataSource);
    	cartDao = new CartDaoImpl(dataSource);
    }
	
       
   
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch(action) {
            case "addCart":
            	addCart(request, response);
                break;
			case "remove":
				remove(request, response);
				break;
			case "save":
				showTrangXuLyThanhToan(request, response);
				break;
			case "continue":
				tongTien = 0;
				response.sendRedirect("BookController");
				break;
			case "luu":
				save(request, response);
				break;
            default:
                break;
        }
	}
	
	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("ma"));
		List<CartItem> dsCart = (List<CartItem>) session.getAttribute("cart");
		int index = isExisting(id, dsCart);
		int soLuongMoi = dsCart.get(index).getQuantity() - 1;
		dsCart.remove(index);
		

		if (dsCart != null) {
			request.setAttribute("sLuong", dsCart.size());
		}
		session.setAttribute("cart", dsCart);
		request.getRequestDispatcher("views/XuLyMuaHang.jsp").forward(request, response);
		
	}
	private void showTrangXuLyThanhToan(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		List<CartItem> dsCart = (List<CartItem>) session.getAttribute("cart");
		
		if (dsCart != null) {
			request.setAttribute("sLuong", dsCart.size());
		}
		
		
		for (CartItem cart : dsCart) {
			tongTien += cart.getBook().getPrice() * cart.getQuantity();
		}
		session.setAttribute("tongTien", tongTien);
		request.getRequestDispatcher("views/TrangXuLyThanhToan.jsp").forward(request, response);
	}
	
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		List<CartItem> dsCart = (List<CartItem>) session.getAttribute("cart");

		
		String tenKH = request.getParameter("fullname");
		String diaChi = request.getParameter("address");
		String phuongThuc = request.getParameter("paymentMethod");
		int payment = 0;
		if(phuongThuc.equals("Paypal")) {
            payment = 1;
         }else if(phuongThuc.equals("ATM Debit")) {
        	payment = 2;
         }else {
        	 payment = 3;
         }
		
		Order o  =   new Order(tenKH, diaChi, tongTien, payment);
        cartDao.saveOrder(o);
        System.out.println("Luu order thanh cong");
     
		
		orderID = cartDao.getOrderId();
		List<CartItem> dsCartMoi = new ArrayList<CartItem>();
		for (CartItem cart : dsCart) {
			CartItem cartItem = new CartItem(cart.getBook(), cart.getQuantity(), orderID);
			dsCartMoi.add(cartItem);
		}
		//Luu vao CSDL
		for (CartItem cart : dsCartMoi) {
			cartDao.saveCart(cart);
		}
		
		session.removeAttribute("cart");
		
		session.setAttribute("message", "Thêm đơn hàng thành công!");
		
		response.sendRedirect("BookController");
	}

	
	private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.getBookById(id);
		List<CartItem> dsCart = null;
		if (session.getAttribute("cart") == null) {
			dsCart = new ArrayList<CartItem>();
		}else {
			dsCart = (List<CartItem>) session.getAttribute("cart");
		}
		int index = isExisting(id, dsCart);
		if (index == -1) {  //khong trung 
			dsCart.add(new CartItem(book, 1));
		}else {
			int soLuongMoi = dsCart.get(index).getQuantity() +1 ;
			dsCart.get(index).setQuantity(soLuongMoi);
		}
		if (dsCart != null) {
			request.setAttribute("sLuong", dsCart.size());
		}
		if (dsCart != null) {
			request.setAttribute("sLuong", dsCart.size());
		}
		session.setAttribute("cart", dsCart);
		request.getRequestDispatcher("views/XuLyMuaHang.jsp").forward(request, response);

	}
	
	private int isExisting(int id, List<CartItem> cart) {
		for (int i = 0; i < cart.size(); i++) {   //cart.size() trả về số lượng phần tử trong danh sách
			if (cart.get(i).getBook().getId() == id) {  //get(i) trả về phần tử tại vị trí thứ i trong danh sách
				return i;
			}
		}
		return -1;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
