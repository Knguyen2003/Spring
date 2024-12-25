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

import dao.BookDao;
import daoImpl.BookImpl;
import entity.Book;


public class BookDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/book")
	private DataSource dataSource;
	private BookDao bookDao;
	
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
   
    public BookDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		System.out.println(action);
		switch(action) {
            case "details":
                showBookDetail(request, response);
                break;
			case "quayLai":
				backTo(request, response);
				break;
            default:
                break;
        }
	}
	
	private void backTo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("BookController");	
	}

	private void showBookDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Book b = bookDao.getBookById(id);
		request.setAttribute("bookDetail", b);
		request.getRequestDispatcher("views/ChiTietSP.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
