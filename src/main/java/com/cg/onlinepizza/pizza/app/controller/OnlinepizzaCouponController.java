package com.cg.onlinepizza.pizza.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.pizza.app.Exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.pizza.app.Exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.pizza.app.Exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.pizza.app.dto.Coupan;

import com.cg.onlinepizza.pizza.app.service.ICoupanRepositoryImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * Author : ABHISHEK SHAW
 * Version : 1.0
 * Date : 18-05-2021
 * Description : This is Coupan Controller
*/


@RestController
@RequestMapping("/coupan")
public class OnlinepizzaCouponController {
	
	static final Logger LOGGER= LoggerFactory.getLogger(OnlinepizzaCouponController.class);
	
	
	@Autowired
	 ICoupanRepositoryImpl serviceobj;
	
	
	@PostMapping("/add")
	public ResponseEntity<Coupan> addCoupan(@RequestBody Coupan coupan){
		Coupan c=serviceobj.addCoupans(coupan);
		if(c==null){
		return new ResponseEntity("Coupan Not Found!!",HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Coupan Added");
		return new ResponseEntity <Coupan>(c ,HttpStatus.OK);
	}
	
	
	@PutMapping("/editCoupan")
	public String editCoupan(@RequestBody Coupan coupan) throws InvalidCoupanOperationException  {
		Coupan c=serviceobj.editCoupans(coupan);
		if(c==null)
			return "not edited";
		else
			LOGGER.info("Coupan Edited");
			return "edited";
		}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteCoupan(@PathVariable("id") int id) throws CoupanIdNotFoundException {
		LOGGER.info("Coupan Deleted");
		return serviceobj.deleteCoupans(id);
	}
	
	
	@GetMapping("/viewAllCoupan")
	public List<Coupan> viewAllCoupan() {
		return serviceobj.viewCoupans(); 
	}
}
