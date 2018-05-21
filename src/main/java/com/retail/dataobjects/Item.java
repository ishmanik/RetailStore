package com.retail.dataobjects;

public class Item implements ItemImpl {

	private int price;
	private String name;
	private ItemType type;
	@Override
	public int getPrice() {
		return  this.price;
		
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ItemType getItemType() {
		return this.type;
	
}
}
