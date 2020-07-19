package com.teksystems.tdd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;

public class TaxCalculator {
	private TaxCalculator() {
	}
	
	public static TaxCalculator getInstace() {
		
		return new TaxCalculator();
	}

	public BigDecimal calculateTax(BigDecimal price, double taxRate) {
		MathContext mc = new MathContext(4);
		return price.add(price.multiply(BigDecimal.valueOf(taxRate))).round(mc);
	}

	public double calculateTaxRate(boolean isSales, boolean isImported) {
		double taxRate = 0;
		if(isSales) taxRate = 0.1;
		else if(isImported) taxRate = 0.05;
		return taxRate;
		
	}
}
