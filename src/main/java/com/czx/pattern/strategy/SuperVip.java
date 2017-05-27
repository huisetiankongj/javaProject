package com.czx.pattern.strategy;

@PriceRegion(min=3000)
public class SuperVip implements CalPrice {

	public Double calPrice(Double orgnicPrice) {
		// TODO Auto-generated method stub
		return orgnicPrice * 0.8;
	}

}
