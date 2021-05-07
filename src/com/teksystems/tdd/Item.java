package com.teksystems.tdd;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Item {
    private final String description;
    private final int quantity;
    private final BigDecimal price;
    private final boolean isImported;
    private final boolean isExempt;

    private Item(String description, int quantity, BigDecimal itemPrice,boolean isExempt,boolean isImported) {
        this.description = description;
        this.quantity = quantity;
        price = itemPrice;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public static Item getInstance(String description, int quantity, BigDecimal itemPrice,boolean isExempt,boolean isImported) {
        return new Item(description, quantity, itemPrice,isExempt,isImported);
    }
    @Override
    public String toString() {
        return String.format("%s\t%d\t%s", description, quantity, NumberFormat.getCurrencyInstance().format(price));
    }

	public BigDecimal getPrice(Item item) {
		return item.price;
	}

	public boolean getIsImported(Item item) {
		
		return isImported;
	}
public boolean getIsExempt(Item item) {
		
		return isExempt;
	}
}
