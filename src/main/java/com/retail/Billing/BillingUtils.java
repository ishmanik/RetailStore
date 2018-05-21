package com.retail.Billing;

import java.util.Iterator;
import java.util.Map;

import com.retail.User.User;
import com.retail.User.UserType;
import com.retail.dataobjects.Item;
import com.retail.dataobjects.ItemType;

public class BillingUtils {

	public static void generateBill(User user)
	{
		try{	
			Map<Item,Long> items=user.getUserCart().getAllItems();
			if(!items.isEmpty()){
				Iterator<Item> it=items.keySet().iterator();
				Long costOfGrocieries=(long) 0;
				Long costOfOther=(long) 0;
				while(it.hasNext())
				{
					Item item=it.next();
					Long quantity=items.get(item);
					if(item.getItemType().equals(ItemType.GROCERY))
					{
						costOfGrocieries=costOfGrocieries+(item.getPrice()*quantity);
					}else{
						costOfOther=costOfOther+(item.getPrice()*quantity);
					}

				}
				if (costOfOther>0)
				{
					costOfOther=getAfterDiscountCost(costOfOther, user);
				}	
				Long total=costOfGrocieries+costOfOther;
				if(total>0)
				{
					Long discount=total/100;
					total=(discount>0)?total-(5*discount):total;
				}	
			System.out.println("*****Total Amount Payable is***"+total);	
				
			}else{

				System.out.println("Cart is Empty");
			}
		}
		catch(Exception e){
			System.out.println("Error Processing Bill");
		}
	}
	private static Long getAfterDiscountCost(Long costOfOther,User user)
	{
		Integer discountPercentage=0;
		discountPercentage=getUserBasedDiscount(user);
		boolean discountApplied=false;
		if(discountPercentage>0)
		{ 
			discountApplied=true;
			costOfOther=costOfOther-(costOfOther*(discountPercentage/100));
		}
		if(!discountApplied)
		{
			discountPercentage=getUserTypeBasedDiscount(user.getUserType());
			if(discountPercentage>0)
			{
				discountApplied=true;
				costOfOther=costOfOther-(costOfOther*(discountPercentage/100));
			}

		}
		return costOfOther;
	}

	private static  Integer  getUserTypeBasedDiscount(UserType userType)
	{
		Integer discount_percent=0;
		switch(userType){
		case Employee:
			discount_percent=30;
			break;
		case Affiliated:
			discount_percent=10;
			break;
		case General:
			discount_percent=0;
			break;
		default:
			discount_percent=0;
			break;
		}

		return discount_percent;
	}
	private static Integer getUserBasedDiscount(User user)
	{
		long currentTime=System.currentTimeMillis();
		long userStartDate=user.getUserStartDate();
		long diff =currentTime- - userStartDate;
		int diffInDays = (int) diff / (1000 * 60 * 60 * 24);
		Integer discount_percentage=0;		
		if (diffInDays >  730 )
		{
			discount_percentage=5;
		}
		return discount_percentage;

	}

}
