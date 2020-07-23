package com.family.domain;

import java.io.Serializable;

public class CountBill implements Serializable{
	private double total;
	private double total2;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getTotal2() {
		return total2;
	}
	public void setTotal2(double total2) {
		this.total2 = total2;
	}
}
