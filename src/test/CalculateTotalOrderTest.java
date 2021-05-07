package test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teksystems.tdd.Item;
import com.teksystems.tdd.Order;
import com.teksystems.tdd.TaxCalculator;

@Test
public class CalculateTotalOrderTest {
	@Test
	public void testCalculateMultipleItemsTaxTotal() {
		TaxCalculator taxCalculator = TaxCalculator.getInstace();
		String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(1.50));
		Order order = Order.getInstance();
        Item book = Item.getInstance("book", 1, BigDecimal.valueOf(12.49),false,false);
        Item chocolate = Item.getInstance("chocolate bar", 1, BigDecimal.valueOf(0.85),false,false);
        Item cd = Item.getInstance("Music CD", 1, BigDecimal.valueOf(14.99),true,false);
        order.addItem(cd);
        order.addItem(book);
        order.addItem(chocolate);
		String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateMultipleTaxTotal(order.getItems()));
		Assert.assertEquals(actual, expected);
	}@Test
	public void testCalculateMultipleItemsTotalPrice() {
		TaxCalculator taxCalculator = TaxCalculator.getInstace();
		String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(29.83));
		Order order = Order.getInstance();
        Item book = Item.getInstance("book", 1, BigDecimal.valueOf(12.49),false,false);
        Item chocolate = Item.getInstance("chocolate bar", 1, BigDecimal.valueOf(0.85),false,false);
        Item cd = Item.getInstance("Music CD", 1, BigDecimal.valueOf(14.99),true,false);
        order.addItem(cd);
        order.addItem(book);
        order.addItem(chocolate);
		String actual = NumberFormat.getCurrencyInstance().format(taxCalculator.calculateMultipleItemsTotalPrice(order.getItems()));
		Assert.assertEquals(actual, expected);
	}
}
