package com.roxinlabs.transjakarta;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.roxinlabs.transjakarta.model.Foursquare;
import com.roxinlabs.transjakarta.model.SearchResult;
import com.roxinlabs.transjakarta.model.foursquare.Venues;
import com.roxinlabs.transjakarta.services.LocationService;
import com.roxinlabs.transjakarta.services.LocationServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Home Controller
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value="/getNearest", method = RequestMethod.GET)
	public @ResponseBody String getNearest(double lat, double lng) {
		
		
		
		return "";
	}
	
	@RequestMapping(value = "/getFoursquare", method = RequestMethod.GET)
	public @ResponseBody List<SearchResult> getFoursquare(@RequestParam String term) throws UnsupportedEncodingException {
		
			LocationService locationService = new LocationServiceImpl();
			System.out.println(URLEncoder.encode(term, "UTF-8"));
			Foursquare foursquare = locationService.getLocationList(URLEncoder.encode(term, "UTF-8"));
			List venues = foursquare.getResponse().getVenues();
			
			List<SearchResult> result = new ArrayList<SearchResult>();
			
			for (int i = 0; i < venues.size(); i++) {
				Venues venue = (Venues)venues.get(i);
				result.add(new SearchResult(venue.getName(), 
						venue.getLocation().getLat(),
						venue.getLocation().getLng(),
						venue.getLocation().getAddress() == null ? "" : venue.getLocation().getAddress()));
			}
			
			return result;
	}
}
