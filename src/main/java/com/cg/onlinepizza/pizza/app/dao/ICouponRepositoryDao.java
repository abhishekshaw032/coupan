package com.cg.onlinepizza.pizza.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.pizza.app.dto.Coupan;

@Repository
public interface ICouponRepositoryDao extends JpaRepository<Coupan, Integer> {
   public String deleteById(int coupanId);

//public Coupan editCoupans(Coupan coupan);
}
