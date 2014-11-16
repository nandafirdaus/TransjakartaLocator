
package com.roxinlabs.transjakarta.model.foursquare;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response{
   	private List<Venues> venues;

 	public List<Venues> getVenues(){
		return this.venues;
	}
	public void setVenues(List<Venues> venues){
		this.venues = venues;
	}
}
