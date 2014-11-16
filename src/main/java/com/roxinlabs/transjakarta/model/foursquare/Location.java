
package com.roxinlabs.transjakarta.model.foursquare;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location{
   	private String address;
   	private String cc;
   	private String city;
   	private String country;
   	private String crossStreet;
   	private List formattedAddress;
   	private Double lat;
   	private Double lng;
   	private String postalCode;
   	private String state;

   	
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address = address;
	}
 	public String getCc(){
		return this.cc;
	}
	public void setCc(String cc){
		this.cc = cc;
	}
 	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city = city;
	}
 	public String getCountry(){
		return this.country;
	}
	public void setCountry(String country){
		this.country = country;
	}
 	public String getCrossStreet(){
		return this.crossStreet;
	}
	public void setCrossStreet(String crossStreet){
		this.crossStreet = crossStreet;
	}
 	public List getFormattedAddress(){
		return this.formattedAddress;
	}
	public void setFormattedAddress(List formattedAddress){
		this.formattedAddress = formattedAddress;
	}
 	public Double getLat(){
		return this.lat;
	}
	public void setLat(Double lat){
		this.lat = lat;
	}
 	public Double getLng(){
		return this.lng;
	}
	public void setLng(Double lng){
		this.lng = lng;
	}
 	public String getPostalCode(){
		return this.postalCode;
	}
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
 	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
}
