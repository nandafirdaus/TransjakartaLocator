package com.roxinlabs.transjakarta.model;

public class Shelter {
	
	private String Name;
	private int Latitude;
	private int Longitude;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getLatitude() {
		return (double)Latitude / 1E6;
	}
	public void setLatitude(int latitude) {
		Latitude = latitude;
	}
	public double getLongitude() {
		return (double)Longitude / 1E6;
	}
	public void setLongitude(int longitude) {
		Longitude = longitude;
	}
	
	
}
