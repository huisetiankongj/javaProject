package com.czx.pattern.strategy;

@PriceRegion(max = 10000)
public class Orgnic implements CalPrice {

	public Double calPrice(Double orgnicPrice) {
		return orgnicPrice;
	}

}
