package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


//JPA repository extends the pagesorting repository and also the CRUDrepository itself
public interface CustomersRepo extends JpaRepository<Customers, Integer>{

}
