package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class formcontroller {
	@Autowired
	CustomersRepo repo;
	@RequestMapping("/") // when we request mapping i.e when we type local host 8084, edureka.jsp file should be returned
	public String details()
	{
		return "edureka";
	}
	@RequestMapping("/details")// if we say localhost 8084/details, edureka.jsp should again be retreived and data must be stored in h2 data
	public String details(Customers customers)
	{
		repo.save(customers);
		return "edureka";
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
		return "ViewCustomers";
	}

	@PostMapping("/getdetails")// data must be retrieved from h2 database
	public ModelAndView getdetails(@RequestParam int cid)
	{
		ModelAndView mv=new ModelAndView("retrieve");
		Customers customers=repo.findById(cid).orElse(null);
		mv.addObject(customers);
		return mv;
	}
	// now we want the details to be stored in our customer database
	
}
