package com.cg.onlinepizza.pizza.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.pizza.app.Exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.pizza.app.Exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.pizza.app.Exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.pizza.app.dao.ICouponRepositoryDao;
import com.cg.onlinepizza.pizza.app.dto.Coupan;
@Service
@Transactional
public class ICoupanRepositoryImpl implements ICoupanRepository{
	 @Autowired
     ICouponRepositoryDao dao;
	@Override
	public Coupan addCoupans(Coupan coupan) {
		Coupan c = dao.saveAndFlush(coupan);;
		return c;
	}

	
	@Override
	public Coupan editCoupans(Coupan coupan) throws InvalidCoupanOperationException {
		boolean b=dao.existsById(coupan.getCoupanId());
		if(!b) {
			throw new InvalidCoupanOperationException("Invalid Coupan Operation");
		}
		else {
			 
			 return dao.save(coupan);
		}
	}
	

	@Override
	public String deleteCoupans(int coupanId) throws CoupanIdNotFoundException  {
		if(!dao.existsById(coupanId)) {
			
			throw new CoupanIdNotFoundException("No Coupon found for the coupan id");
			
		}
		else
		{
			dao.deleteById(coupanId);
			
		return "Deleted Coupon";
		}
	}

	
	@Override
	public List<Coupan> viewCoupans() {
		return dao.findAll();
	}

	
}

