package com.retail.User;

import com.retail.dataobjects.ShoppingCart;

public interface User {
	public UserType getUserType();
	public Long getUserStartDate();
	public String getName();
	public ShoppingCart getUserCart(); 
	

}
