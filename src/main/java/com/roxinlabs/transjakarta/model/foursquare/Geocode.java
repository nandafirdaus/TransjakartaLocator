
package com.roxinlabs.transjakarta.model.foursquare;

import java.util.List;

public class Geocode{
   	private Feature feature;
   	private List parents;
   	private String what;
   	private String where;

 	public Feature getFeature(){
		return this.feature;
	}
	public void setFeature(Feature feature){
		this.feature = feature;
	}
 	public List getParents(){
		return this.parents;
	}
	public void setParents(List parents){
		this.parents = parents;
	}
 	public String getWhat(){
		return this.what;
	}
	public void setWhat(String what){
		this.what = what;
	}
 	public String getWhere(){
		return this.where;
	}
	public void setWhere(String where){
		this.where = where;
	}
}
