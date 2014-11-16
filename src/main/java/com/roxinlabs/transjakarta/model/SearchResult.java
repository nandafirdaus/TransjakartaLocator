package com.roxinlabs.transjakarta.model;


public class SearchResult {
	private String Name;
	private Double Latitude;
	private Double Longitude;
	private String Address;
	
	
	public SearchResult() {
		
	}
	
	public SearchResult(String name, Double latitude, Double longitude, String address) {
		super();
		Name = name;
		Latitude = latitude;
		Longitude = longitude;
		Address = address;
	}

	
	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}
	
	
}
