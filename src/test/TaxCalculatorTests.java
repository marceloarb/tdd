package test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teksystems.tdd.TaxCalculator;

@Test
public class TaxCalculatorTests {
    public void testCalculateTax_sales() {
        double taxRate = 0.1;
        BigDecimal price = BigDecimal.valueOf(14.99);
        BigDecimal expected = BigDecimal.valueOf(16.49);
        BigDecimal actual = TaxCalculator.getInstace().calculateTax(price, taxRate);
        Assert.assertEquals(actual, expected);
    }

    public void testCalculateTax_import() {
        double taxRate = 0.05;
        BigDecimal price = BigDecimal.valueOf(10.00);
        String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(10.50));
        String actual = NumberFormat.getCurrencyInstance().format(TaxCalculator.getInstace().calculateTax(price, taxRate));
        Assert.assertEquals(actual, expected);
    }
    
    public void testCalculateTax_sales_import() {
        double taxRate = 0.15;
        BigDecimal price = BigDecimal.valueOf(47.50);
        String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(54.65));
        String actual = NumberFormat.getCurrencyInstance().format(TaxCalculator.getInstace().calculateTax(price, taxRate));
        Assert.assertEquals(actual, expected);
    }
    
}
