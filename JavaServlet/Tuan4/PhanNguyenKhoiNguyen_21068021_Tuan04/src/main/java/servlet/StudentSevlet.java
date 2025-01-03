package servlet;

import java.io.IOException;

import entity.Qualification;
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
		String hobbies_other = request.getParameter("other");
		for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Others")) {
                hobbies[i] = hobbies_other;
            }
        }
		String course = request.getParameter("course");
		
		
		String board1 = request.getParameter("board1");
		String percentage1 = request.getParameter("percentage1");
		String year1 = request.getParameter("year1");
		
		Qualification q1 = new Qualification(board1, percentage1, year1);
		
		String board2 = request.getParameter("board2");
		String percentage2 = request.getParameter("percentage2");
		String year2 = request.getParameter("year2");
		
		Qualification q2 = new Qualification(board2, percentage2, year2);
		
		String board3 = request.getParameter("board3");
		String percentage3 = request.getParameter("percentage3");
		String year3 = request.getParameter("year3");
		
		Qualification q3 = new Qualification(board3, percentage3, year3);
		
		String board4 = request.getParameter("board4");
		String percentage4 = request.getParameter("percentage4");
		String year4 = request.getParameter("year4");
		
		Qualification q4 = new Qualification(board4, percentage4, year4);
		

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
		sv.setClassX(q1);
		sv.setClassXII(q2);
		sv.setGraduation(q3);
		sv.setMasters(q4);
		

		request.setAttribute("student", sv);

		RequestDispatcher rd = request.getRequestDispatcher("ResultForm.jsp");
		rd.forward(request, response);

	}

}
