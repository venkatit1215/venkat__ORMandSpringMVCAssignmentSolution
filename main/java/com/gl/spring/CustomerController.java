package com.gl.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gl.spring.model.Customer;
import com.gl.spring.service.CustomerService;

@Controller
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService cs){
		this.customerService = cs;
	}
	
	@RequestMapping(value = "/customeres", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("Customer", new Customer());
		model.addAttribute("listCustomeres", this.customerService.listCustomeres());
		return "customer";
	}
	
	//For add and update Customer both
	@RequestMapping(value= "/customer/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("Customer") Customer customer){
		
		if(customer.getId() == 0){
			//new Customer, add it
			this.customerService.addCustomer(customer);
		}else{
			//existing Customer, call update
			this.customerService.updateCustomer(customer);
		}
		
		return "redirect:/customeres";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id){
		
        this.customerService.removeCustomer(id);
        return "redirect:/customeres";
    }
 
    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("Customer", this.customerService.getCustomerById(id));
        model.addAttribute("listCustomers", this.customerService.listCustomeres());
        return "customer";
    }
	
}