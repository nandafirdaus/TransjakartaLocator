package com.roxinlabs.transjakarta.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.roxinlabs.transjakarta.dao.ShelterDAO;
import com.roxinlabs.transjakarta.model.Foursquare;
import com.roxinlabs.transjakarta.model.Shelter;
import com.roxinlabs.transjakarta.util.HttpRequestHelper;

public class LocationServiceImpl implements LocationService {

	private final String API_KEY = "PTB02MM204OC1ZTIND0K4YY5UIQWBV43JRTLEU5JXSCRSVI5";
    private final String API_KEY_SECRET = "GECYMGKQ0FNU45AVWOHGVBVUHAZCLTI2DSETJ00XZZ1GPDDG";
    private final String API_ROOT = "http://api.foursquare.com/v2/venues/search?near=jakarta&query=";
    private final String API_KEY_IDENTIFIER = "client_id=";
    private final String API_KEY_SECRET_IDENTIFIER = "client_secret=";
    private final String DATE_TIME_IDENTIFIER = "v=";
    private final String PARAMETER_SEPARATOR = "&";
    
    @Autowired
    private ShelterDAO shelterDAO;
	
	@Override
	public Foursquare getLocationList(String query) {
		
		String url = API_ROOT +
                query +
                PARAMETER_SEPARATOR +
                API_KEY_IDENTIFIER +
                API_KEY +
                PARAMETER_SEPARATOR +
                API_KEY_SECRET_IDENTIFIER +
                API_KEY_SECRET +
                PARAMETER_SEPARATOR +
                DATE_TIME_IDENTIFIER +
                new SimpleDateFormat("yyyymmdd").format(new Date());
		
		try {
			String response = HttpRequestHelper.sendGet(url);
			
			ObjectMapper mapper = new ObjectMapper();
			Foursquare foursquare = mapper.readValue(response, Foursquare.class);
			
			return foursquare;
		} catch (Exception e) {
			Logger log = Logger.getLogger(LocationServiceImpl.class.getName());
			
			log.error(e.toString());
		}
		
		return null;
	}

	@Override
	public List<Shelter> getNearest(Double lat, Double lng) {
		List<Shelter> listShelter = shelterDAO.list();
		
		// Temp variable to save 2 nearest shelter
		Shelter shelter1 = new Shelter();
		Shelter shelter2 = new Shelter();
		
		// Save 2 nearest distance
		Double distance1 = Double.MAX_VALUE;
		Double distance2 = Double.MAX_VALUE;
		
		for (Shelter shelter : listShelter) {
			double tempDistance = Math.sqrt(Math.pow(shelter.getLatitude() - lat, 2) 
					+ Math.pow(shelter.getLongitude() - lng, 2));
			
			if (distance1 < distance2) {
				
				if (distance2 > tempDistance) {
					distance2 = tempDistance;
					shelter2 = shelter;
				}
			} else {
				
				if (distance1 > tempDistance) {
					distance1 = tempDistance;
					shelter1 = shelter;
				}
			}
		}
		
		List<Shelter> nearest = new ArrayList<Shelter>();
		nearest.add(shelter1);
		nearest.add(shelter2);
		
		return nearest;
	}

}
