
package com.roxinlabs.transjakarta.model.foursquare;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Venues{
   	private String id;
   	private Location location;
   	private String name;
   	private boolean verified;

 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public Location getLocation(){
		return this.location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public boolean getVerified(){
		return this.verified;
	}
	public void setVerified(boolean verified){
		this.verified = verified;
	}
}
