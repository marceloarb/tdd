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

	public BigDecimal calculateTax(double price, double taxRate) {
		MathContext mc = new MathContext(2);
		double tax = price*taxRate;
		tax = Math.round(tax*20.0)/20.0;
		return BigDecimal.valueOf(tax);
	}

	public double calculateTaxRate(boolean isSales, boolean isImported) {
		double taxRate = 0;
		if(isSales) taxRate = 10;
		if(isImported) taxRate += 5;
		return taxRate/100;
		
	}
	public BigDecimal calculateTotal(BigDecimal price, double taxRate) {
		MathContext mc = new MathContext(4);
		
		return price.add(price.multiply(BigDecimal.valueOf(taxRate))).round(mc);
	}
}
