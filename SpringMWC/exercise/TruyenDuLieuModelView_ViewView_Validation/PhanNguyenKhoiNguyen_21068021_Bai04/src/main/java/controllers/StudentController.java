package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import models.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showStudentForm")
	public String StudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "StudentForm";

	}

	@RequestMapping("/processStudent")
	public String processStudentForm(@ModelAttribute("student") Student student) {
		return "StudentConfirm";
	}

}
