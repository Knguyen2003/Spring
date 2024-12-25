package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showHelloForm")
	public String helloWorld() {
		return "helloForm";
	}

	@RequestMapping("/helloConfirm")
	public String helloWorld_Confirm() {
		return "helloWorld";
	}
}
