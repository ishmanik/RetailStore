package com.retail.User;

import com.retail.dataobjects.ShoppingCart;

public class UserDO implements User{

	private UserType userType;
	private Long startDate;
	private String name;
	private ShoppingCart cart;
	
	@Override
	public UserType getUserType() {
		return this.userType;
	}
	@Override
	public Long getUserStartDate() {
		return this.startDate;
		
	}
	@Override
	public String getName() {
		return this.name;
		
	}
	@Override
	public ShoppingCart getUserCart() {
		return this.cart;
	}
	
}
