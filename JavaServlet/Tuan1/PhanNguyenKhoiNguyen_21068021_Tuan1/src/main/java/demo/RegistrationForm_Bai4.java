package demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationForm
 */
//@WebServlet("/RegistrationForm")
public class RegistrationForm_Bai4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public RegistrationForm_Bai4() {
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response là phản hồi từ server trả về cho client
//		request là yêu cầu từ client gửi lên server
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html"); //Dùng để thiết lập kiểu dữ liệu trả về là text/html để hiển thị trên trình duyệt
		PrintWriter out=response.getWriter();
		String first =request.getParameter("frist");
		String last=request.getParameter("last");
		String email=request.getParameter("email");
		String facebook=request.getParameter("face");
		String shortbio=request.getParameter("short");
		String html="<br>" + "<html>"
		+ "<head>" + "<title>Result Page</title>"
		+ "</head>" + "<body>"
		+ "First Name: "+ first +last +"<br>"
		+ "Email: "+ email +"<br> Facebook URL: "+ facebook +"<br>"
		+ "Short Bio: "+ shortbio +"<br>"
		+ "</body>" + "</html>";

		out.println(html);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter();
		String first =request.getParameter("first");
		String last=request.getParameter("last");
		String email=request.getParameter("email");
		String facebook=request.getParameter("face");
		String shortbio=request.getParameter("short");
		String html="<br>" + "<html>"
		+ "<head>" + "<title>Result Page</title>"
		+ "</head>" + "<body>"
		+ "First Name: "+ first +last +"<br>"
		+ "Email: "+ email +"<br> Facebook URL: "+ facebook +"<br>"
		+ "Short Bio: "+ shortbio +"<br>"
		+ "</body>" + "</html>";

		out.println(html);
		out.close();
		
	}
	
	// So sánh sự khác nhau hàm doGet và hàm doPost
	/*
	 * Hàm doGet:
	 * - Được gọi khi người dùng gửi yêu cầu HTTP GET đến servlet từ trình duyệt
	 * - Dữ liệu được gửi thông qua URL
	 * - Dữ liệu được gửi có thể nhìn thấy trên URL
	 * - Hạn chế về kích thước dữ liệu gửi đi
	 * - Không an toàn vì dữ liệu được gửi thông qua URL
	 * - Dùng để lấy dữ liệu từ máy chủ
	 * Hàm doPost:
	 * - Được gọi khi người dùng gửi yêu cầu HTTP POST đến servlet từ trình duyệt
	 * - Dữ liệu được gửi không thể nhìn thấy trên URL
	 * - Dữ liệu được gửi không giới hạn về kích thước
	 * - An toàn hơn vì dữ liệu không được gửi thông qua URL
	 * - Dùng để gửi dữ liệu lên máy chủ
	 */

}
