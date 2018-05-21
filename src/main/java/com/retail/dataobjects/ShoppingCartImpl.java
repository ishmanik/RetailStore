package com.retail.dataobjects;

import java.util.Map;

public class ShoppingCartImpl implements ShoppingCart {

	private Map<Item,Long> shoppingCart;
	
	/**
	 * @return the shoppingCart
	 */
	public Map<Item, Long> getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * @param shoppingCart the shoppingCart to set
	 */
	public void setShoppingCart(Map<Item, Long> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public void addToCart(Item item) {
		if(shoppingCart.get(item)==null)
		{
			shoppingCart.put(item, Long.valueOf("1"));
			
		}	
		else
		{
			Long quantity =shoppingCart.get(item);
			quantity=quantity+1;
			shoppingCart.put(item,quantity);
		}	
		
	}

	@Override
	public void removeFromCart(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Item,Long> getAllItems() {
		return this.shoppingCart;
		
	}
	
	
}
