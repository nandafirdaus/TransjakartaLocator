
package com.roxinlabs.transjakarta.model.foursquare;

public class Stats{
   	private Number checkinsCount;
   	private Number tipCount;
   	private Number usersCount;

 	public Number getCheckinsCount(){
		return this.checkinsCount;
	}
	public void setCheckinsCount(Number checkinsCount){
		this.checkinsCount = checkinsCount;
	}
 	public Number getTipCount(){
		return this.tipCount;
	}
	public void setTipCount(Number tipCount){
		this.tipCount = tipCount;
	}
 	public Number getUsersCount(){
		return this.usersCount;
	}
	public void setUsersCount(Number usersCount){
		this.usersCount = usersCount;
	}
}
