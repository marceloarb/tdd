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
	public BigDecimal calculateTotal(BigDecimal price, BigDecimal taxRate) {
		MathContext mc = new MathContext(4);
		
		return price.add(taxRate).round(mc);
	}

	public BigDecimal calculateMultipleTaxTotal(Iterable<? extends Item> items) {
		double totalTax = 0.0;
		for(Item item : items) {
			totalTax += calculateTax(item.getPrice(item).doubleValue(),calculateTaxRate(item.getIsExempt(item),item.getIsImported(item))).doubleValue();
		}
		return BigDecimal.valueOf(totalTax);
		
	}
	public BigDecimal calculateMultipleItemsTotalPrice(Iterable<? extends Item> items) {
		double totalPrice = 0.0;
		BigDecimal tax = calculateMultipleTaxTotal(items);
		for(Item item : items) {
			totalPrice += item.getPrice(item).doubleValue();
		}
		BigDecimal totalOrder = calculateTotal(BigDecimal.valueOf(totalPrice),tax);
		return totalOrder;
		
	}
	
}
