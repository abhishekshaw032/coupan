package com.cg.onlinepizza.pizza.app.service;

import java.util.List;

import com.cg.onlinepizza.pizza.app.Exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.pizza.app.Exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.pizza.app.dto.Coupan;

public interface ICoupanRepository {
	Coupan addCoupans(Coupan coupan);

	Coupan editCoupans(Coupan coupan) throws InvalidCoupanOperationException;

	String deleteCoupans(int coupanId) throws  CoupanIdNotFoundException;

	List<Coupan> viewCoupans();

}
