
package com.roxinlabs.transjakarta.model.foursquare;

import java.util.List;

public class HereNow{
   	private Number count;
   	private List groups;
   	private String summary;

 	public Number getCount(){
		return this.count;
	}
	public void setCount(Number count){
		this.count = count;
	}
 	public List getGroups(){
		return this.groups;
	}
	public void setGroups(List groups){
		this.groups = groups;
	}
 	public String getSummary(){
		return this.summary;
	}
	public void setSummary(String summary){
		this.summary = summary;
	}
}
