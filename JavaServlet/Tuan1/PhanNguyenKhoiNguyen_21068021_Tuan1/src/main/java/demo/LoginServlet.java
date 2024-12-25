package demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Lây thông tin context-param
		String username = getServletContext().getInitParameter("username");
		String password = getServletContext().getInitParameter("password");
		// Lấy thông tin từ người dùng
		String user = request.getParameter("usn");
		String pass = request.getParameter("pw");
		// Kiểm tra thông tin
		PrintWriter out = response.getWriter();
		if(username.equals(user) && password.equals(pass)) {
           out.println("LOGIN SUCCESSFUL");
        } else {
			out.println("LOGIN FAILED");
		}
        out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = getServletContext().getInitParameter("username");
		String password = getServletContext().getInitParameter("password");
		// Lấy thông tin từ người dùng
		String user = request.getParameter("usn");
		String pass = request.getParameter("pw");
		// Kiểm tra thông tin
		PrintWriter out = response.getWriter();
		if(username.equals(user) && password.equals(pass)) {
           out.println("LOGIN SUCCESSFUL");
        } else {
			out.println("LOGIN FAILED");
		}
        out.close();
	}

}
