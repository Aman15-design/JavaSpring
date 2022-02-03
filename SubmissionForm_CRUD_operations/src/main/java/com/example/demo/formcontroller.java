package com.example.demo;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.glassfish.jersey.internal.inject.Custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	// initially we want to find all the customers present in the database
//	@RequestMapping("/customers")
//	@ResponseBody
//	public String getCustomers()
//	{
//		// gets all the customers from h2 database and than we have to convert it to String as it returns the values in form iterable format
//		return repo.findAll().toString();
//	}

	//if we want to retrieve data of specific customers
	//@RequestMapping("/customers/{cid}")
	//@ResponseBody
	//public String getCustomers2(@PathVariable("cid") int cid)
	//{
	//	//here we will get the customer whose ID is specified in cid which is passed by uder
	//	return repo.findById(cid).toString();
	//}
	// Pathvariable annotation tells the spring to take the value of CID from URL

	//if we want a list to be returned


	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers()
	{
		return repo.findAll(); //here we will get the output in the form of JSON format
	}

	//if we want to get the optional details
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomersopt(@PathVariable("cid") int cid)
	{
		//here we will get the customer whose ID is specified in cid which is passed by uder
		return repo.findById(cid); //here also the output would be in form of JSON
	}


	// 1.Post
	@PostMapping("/customers") //it is basically used to create a new customer
	public Customers getCustomers3(@RequestBody Customers customers)
	{
		//we have used @RequestBody in the above as I am requesting from the body itself
		
		repo.save(customers);
		return customers;
	}

	//2.Delete
	@DeleteMapping("/customers/{cid}") 
	public Customers getCustomers4(@PathVariable("cid") int cid)
	{
		//we have used @RequestBody in the above as I am requesting from the body itself
		
		Customers cust=repo.getById(cid);
		repo.delete(cust);
		return cust;
	}

	//3.PUT: it is used to update the record
	@PutMapping(path="/customers", consumes = {"application/json"}) 
	public Customers getCustomers5(@RequestBody Customers customers)
	{
		//we have used @RequestBody in the above as I am requesting from the body itself
		repo.delete(customers);
		return customers;
	}
    

	
}
