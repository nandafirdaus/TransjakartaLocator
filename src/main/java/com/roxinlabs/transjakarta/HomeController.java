package com.roxinlabs.transjakarta;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.roxinlabs.transjakarta.model.Foursquare;
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
	public @ResponseBody String getFoursquare(String query) {
		
		try {
			LocationService locationService = new LocationServiceImpl();
			Foursquare foursquare = locationService.getLocationList(query);
			
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(foursquare);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}
