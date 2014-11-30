package com.roxinlabs.transjakarta.services;

import java.util.List;

import com.roxinlabs.transjakarta.model.Foursquare;
import com.roxinlabs.transjakarta.model.Shelter;

public interface LocationService {
	
	public Foursquare getLocationList(String query);
	
	public List<Shelter> getNearest(Double lat, Double lng);
}
