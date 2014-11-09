package com.roxinlabs.transjakarta.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.roxinlabs.transjakarta.model.Foursquare;
import com.roxinlabs.transjakarta.model.Shelter;

public class LocationServiceImpl implements LocationService {

	private final String API_KEY = "PTB02MM204OC1ZTIND0K4YY5UIQWBV43JRTLEU5JXSCRSVI5";
    private final String API_KEY_SECRET = "GECYMGKQ0FNU45AVWOHGVBVUHAZCLTI2DSETJ00XZZ1GPDDG";
    private final String API_ROOT = "http://api.foursquare.com/v2/venues/search?near=jakarta&query=";
    private final String API_KEY_IDENTIFIER = "client_id=";
    private final String API_KEY_SECRET_IDENTIFIER = "client_secret=";
    private final String DATE_TIME_IDENTIFIER = "v=";
    private final String PARAMETER_SEPARATOR = "&";
	
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
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public List<Shelter> getNearest(int lat, int lng) {
		// TODO Auto-generated method stub
		return null;
	}

}
