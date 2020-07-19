package test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teksystems.tdd.Item;
import com.teksystems.tdd.Order;
import com.teksystems.tdd.TaxCalculator;

@Test
public class TaxCalculatorTests {
	
	public void testCalculateTaxRate_Sales() {
		BigDecimal expected = BigDecimal.valueOf(0.1);
		BigDecimal	actual = BigDecimal.valueOf(TaxCalculator.getInstace().calculateTaxRate(true,false));
		Assert.assertEquals(actual, expected);
	}
	public void testCalculateTaxRate_SalesAndImported() {
		BigDecimal expected = BigDecimal.valueOf(0.15);
		BigDecimal	actual = BigDecimal.valueOf(TaxCalculator.getInstace().calculateTaxRate(true,true));
		Assert.assertEquals(actual, expected);
	}
	public void testCalculateTaxRate_Imported() {
		BigDecimal expected = BigDecimal.valueOf(0.05);
		BigDecimal	actual = BigDecimal.valueOf(TaxCalculator.getInstace().calculateTaxRate(false,true));
		Assert.assertEquals(actual, expected);
	}
	public void testCalculateTaxRate_NotSalesAndNotImported() {
		BigDecimal expected = BigDecimal.valueOf(0.0);
		BigDecimal	actual = BigDecimal.valueOf(TaxCalculator.getInstace().calculateTaxRate(false,false));
		Assert.assertEquals(actual, expected);
	}
	
    public void testCalculateTax_NotSalesAndNotImported() {
    	TaxCalculator taxCalculator = TaxCalculator.getInstace();
    	String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(0.00));
    	String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateTax(12.49, taxCalculator.calculateTaxRate(false, false)));
		Assert.assertEquals(actual, expected);
    	
    }
    public void testCalculateTax_sales() {
    	TaxCalculator taxCalculator = TaxCalculator.getInstace();
    	String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(1.50));
    	String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateTax(14.99, taxCalculator.calculateTaxRate(true, false)));
		Assert.assertEquals(actual, expected);
    	
    }
    public void testCalculateTax_import() {
    	TaxCalculator taxCalculator = TaxCalculator.getInstace();
    	String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(0.50));
    	String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateTax(10.00, taxCalculator.calculateTaxRate(false, true)));
		Assert.assertEquals(actual, expected);
    }
    public void testCalculateTax_salesAndImport() {
    	TaxCalculator taxCalculator = TaxCalculator.getInstace();
    	String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(7.15));
    	String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateTax(47.50, taxCalculator.calculateTaxRate(true, true)));
		Assert.assertEquals(actual, expected);
    }
    public void testCalculateTotal_salesAndImport() {
    	TaxCalculator taxCalculator = TaxCalculator.getInstace();
    	String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(54.65));
    	String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateTotal(BigDecimal.valueOf(47.50), taxCalculator.calculateTax(47.50, taxCalculator.calculateTaxRate(true, true))));
		Assert.assertEquals(actual, expected);
    }
    public void testCalculateTotal_Import() {
    	TaxCalculator taxCalculator = TaxCalculator.getInstace();
    	String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(10.50));
    	String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateTotal(BigDecimal.valueOf(10.00), taxCalculator.calculateTax(10.00, taxCalculator.calculateTaxRate(false, true))));
		Assert.assertEquals(actual, expected);
    }   
    public void testCalculateTotal_Sales() {
    	TaxCalculator taxCalculator = TaxCalculator.getInstace();
    	String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(16.49));
    	String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateTotal(BigDecimal.valueOf(14.99), taxCalculator.calculateTax(14.99, taxCalculator.calculateTaxRate(true, false))));
		Assert.assertEquals(actual, expected);
    }
    
}
