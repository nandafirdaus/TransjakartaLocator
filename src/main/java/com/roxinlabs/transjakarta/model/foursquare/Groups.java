
package com.roxinlabs.transjakarta.model.foursquare;

import java.util.List;

public class Groups{
   	private Number count;
   	private List items;
   	private String name;
   	private String type;

 	public Number getCount(){
		return this.count;
	}
	public void setCount(Number count){
		this.count = count;
	}
 	public List getItems(){
		return this.items;
	}
	public void setItems(List items){
		this.items = items;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
}
