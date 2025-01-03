package servlet;

import java.io.IOException;

import entity.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentSevlet")
public class StudentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentSevlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lay du lieu
		String fname = request.getParameter("txtFirstName");
		String lname = request.getParameter("txtLastName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String email = request.getParameter("txtEmail");
		String mobileNum = request.getParameter("txtPhone");
		String gender = request.getParameter("gioitinh");
		String address = request.getParameter("txtAddress");
		String city = request.getParameter("txtCity");
		String pinCode = request.getParameter("txtPincode");
		String state = request.getParameter("txtState");
		String country = request.getParameter("txtCountry");
		String[] hobbies = request.getParameterValues("hobbies");
		String course = request.getParameter("course");

		Student sv = new Student();
		sv.setAddress(address);
		sv.setFirstName(fname);
		sv.setLastName(lname);
		sv.setNumberPhone(mobileNum);
		sv.setCity(city);
		sv.setDay(Integer.parseInt(day));
		sv.setMonth(Integer.parseInt(month));
		sv.setYear(Integer.parseInt(year));
		sv.setEmail(email);
		sv.setGender(gender);
		sv.setPinCode(pinCode);
		sv.setState(state);
		sv.setCountry(country);
		sv.setHoobies(hobbies);
		sv.setCourse(course);

		request.setAttribute("student", sv);

		RequestDispatcher rd = request.getRequestDispatcher("ResultForm.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("txtFirstName");
		String lname = request.getParameter("txtLastName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String email = request.getParameter("txtEmail");
		String mobileNum = request.getParameter("txtPhone");
		String gender = request.getParameter("gioitinh");
		String address = request.getParameter("txtAddress");
		String city = request.getParameter("txtCity");
		String pinCode = request.getParameter("txtPincode");
		String state = request.getParameter("txtState");
		String country = request.getParameter("txtCountry");
		String[] hobbies = request.getParameterValues("hobbies");
		String course = request.getParameter("course");

		Student sv = new Student();
		sv.setAddress(address);
		sv.setFirstName(fname);
		sv.setLastName(lname);
		sv.setNumberPhone(mobileNum);
		sv.setCity(city);
		sv.setDay(Integer.parseInt(day));
		sv.setMonth(Integer.parseInt(month));
		sv.setYear(Integer.parseInt(year));
		sv.setEmail(email);
		sv.setGender(gender);
		sv.setPinCode(pinCode);
		sv.setState(state);
		sv.setCountry(country);
		sv.setHoobies(hobbies);
		sv.setCourse(course);

		request.setAttribute("student", sv);

		RequestDispatcher rd = request.getRequestDispatcher("ResultForm.jsp");
		rd.forward(request, response);

	}

}
