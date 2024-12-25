package com.fit.controller;

import com.fit.entities.Customer;
import com.fit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomer(Model theModel){
        List<Customer> theCustomers = customerService.getAllCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "list_customers";
    }

    //C
    @GetMapping("/showForm")
    public ModelAndView showFormForAdd(){
        return new ModelAndView("customer_form", "customer", new Customer());
    }

    @PostMapping("/saveCustomer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer);
        return new ModelAndView("redirect:/customer/list");
    }

    //D
    @GetMapping("/delete")
    public ModelAndView deleteCustomer(@RequestParam("customerId") int customerId){
        customerService.deleteCustomer(customerId);
        return new ModelAndView("redirect:/customer/list");
    }







}
