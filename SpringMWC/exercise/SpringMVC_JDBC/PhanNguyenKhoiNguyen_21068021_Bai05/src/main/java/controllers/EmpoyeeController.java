package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDao;
import entities.Employee;

@Controller
public class EmpoyeeController {
	@Autowired   // Injecting EmployeeDao bean
    private EmployeeDao employeeDao;
	
//	@RequestMapping("/")
//	public String show(Model model) {
//		List<Employee> list = employeeDao.getEmployees();
//		System.out.println(list);
//		model.addAttribute("employeeList", list);
//		return "employeeList";
//	}
	//R
	@RequestMapping("/")
	public ModelAndView viewEmployee() {
		List<Employee> list = employeeDao.getEmployees();
		return new ModelAndView("employeeList", "employeeList", list);
	}
	//C
	@RequestMapping("/showFormAdd")
	public ModelAndView addEmployee() {
		return new ModelAndView("AddForm", "employee", new Employee());
	}
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeDao.saveEmployee(employee);
		return "redirect:/";  // Redirect to home page
	}
	
	//D
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("id") int id) {
        employeeDao.deleteEmployee(id);
        return new ModelAndView("redirect:/");
	}
	
	//U
	@RequestMapping(value = "/showFormEdit/{id}")
	public ModelAndView showEditEmployee(@PathVariable("id") int id) {
		Employee employee = employeeDao.getEmployeeById(id);
		return new ModelAndView("EditForm", "edit", employee);
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute("edit") Employee employee) {
		System.out.println("Edit Employee : ");
		System.out.println(employee);
		employeeDao.updateEmployee(employee);
		return "redirect:/" ;
	}
	
	
	
}
