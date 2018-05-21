package com.retail.dataobjects;

import java.util.Map;

public interface ShoppingCart {
	
	public void addToCart(Item item);
	public void removeFromCart(Item item);
	public Map<Item,Long> getAllItems();
	

}
