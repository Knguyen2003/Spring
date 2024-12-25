package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import models.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showCustomerForm")
	public String CustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "CustomerForm";
	}

	@RequestMapping("/processCustomer")
	public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { // Nêu có lỗi thì trả về trang CustomerForm
			return "CustomerForm";
		} else {
			return "CustomerConfirm";
		}
	}

	// @Valid dùng để kiểm tra dữ liệu nhập vào từ form
	// BindingResult dùng để kiểm tra lỗi
	// @ModelAttribute("customer") Customer customer: Lấy dữ liệu từ form và gán vào
	// đối tượng customer

}
