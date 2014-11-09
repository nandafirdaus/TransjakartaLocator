
package com.roxinlabs.transjakarta.model.foursquare;

import java.util.List;

public class Response{
   	private Geocode geocode;
   	private List venues;

 	public Geocode getGeocode(){
		return this.geocode;
	}
	public void setGeocode(Geocode geocode){
		this.geocode = geocode;
	}
 	public List getVenues(){
		return this.venues;
	}
	public void setVenues(List venues){
		this.venues = venues;
	}
}
