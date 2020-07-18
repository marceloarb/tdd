package test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teksystems.tdd.Item;
import com.teksystems.tdd.Order;
import com.teksystems.tdd.Receipt;
import com.teksystems.tdd.ReceiptView;

@Test
public class ReceiptViewTests {

    @Test
    public void testPrePrint_singleItem() {
        BigDecimal price = BigDecimal.valueOf(12.49);
        Order order = Order.getInstance();
        Item book = Item.getInstance("book", 1, BigDecimal.valueOf(12.49));
        order.addItem(book);
        Receipt receipt = Receipt.getInstance(order);
        String expected = getItemFormat(price, "book", 1);
        String actual = ReceiptView.getInstance().prePrint(receipt);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testPrePrint_multipleItems() {
        String expectedBook = getItemFormat(BigDecimal.valueOf(12.49), "book", 1);
        String expectedChocolate = getItemFormat(BigDecimal.valueOf(0.85), "chocolate bar", 1);
        Order order = Order.getInstance();
        Item book = Item.getInstance("book", 1, BigDecimal.valueOf(12.49));
        Item chocolate = Item.getInstance("chocolate bar", 1, BigDecimal.valueOf(0.85));
        order.addItem(book);
        order.addItem(chocolate);
        Receipt receipt = Receipt.getInstance(order);
        String expected = String.format("%s%s", expectedBook, expectedChocolate);
        String actual = ReceiptView.getInstance().prePrint(receipt);
        Assert.assertEquals(actual, expected);
    }
    private String getItemFormat(BigDecimal price, String description, int quantity) {
        return String.format("\n\t%s\t%d\t%s", description, quantity, NumberFormat.getCurrencyInstance().format(price));
    }
}
