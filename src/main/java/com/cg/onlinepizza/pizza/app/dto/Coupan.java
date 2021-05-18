package com.cg.onlinepizza.pizza.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coupan")
public class Coupan {
	    @Id
		private int coupanId;
	    private String coupanCode;
		private String coupanDescription;
		private float coupanDiscount;
		public Coupan(int i, String string, String string2, double d) {
			}
		public Coupan() {
		}
		public int getCoupanId() {
			return coupanId;
		}
		public void setCoupanId(int coupanId) {
			this.coupanId = coupanId;
		}
		public String getCoupanCode() {
			return coupanCode;
		}
		public void setCoupanCode(String coupanCode) {
			this.coupanCode = coupanCode;
		}
		public String getCoupanDescription() {
			return coupanDescription;
		}
		public void setCoupanDescription(String coupanDescription) {
			this.coupanDescription = coupanDescription;
		}
		public float getCoupanDiscount() {
			return coupanDiscount;
		}
		public void setCoupanDiscount(float coupanDiscount) {
			this.coupanDiscount = coupanDiscount;
		}
		

		
	}
