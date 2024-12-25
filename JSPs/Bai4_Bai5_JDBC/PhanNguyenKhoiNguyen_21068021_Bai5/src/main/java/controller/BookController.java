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
import java.util.List;

import javax.sql.DataSource;

import dao.BookDao;
import daoImpl.BookImpl;
import entity.Book;
import entity.CartItem;


public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	@Resource(name="jdbc/book")
	private DataSource dataSource;
       
    
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }
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
    }
    
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	    // Lấy thông báo từ session
	    String message = (String) session.getAttribute("message");
	    if (message != null) {
	        request.setAttribute("message", message);
	        session.removeAttribute("message"); // Xóa thông báo sau khi đã hiển thị
	    }
		List<Book> books = bookDao.getAllBooks();
		
		List<CartItem> dsCart = null;
		dsCart = (List<CartItem>) session.getAttribute("cart");
		if (dsCart != null) {
			request.setAttribute("sLuong", dsCart.size());
		}
		request.setAttribute("books", books);
		request.getRequestDispatcher("views/home.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
