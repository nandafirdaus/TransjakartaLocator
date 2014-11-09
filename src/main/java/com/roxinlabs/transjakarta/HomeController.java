package com.roxinlabs.transjakarta;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.roxinlabs.transjakarta.model.Foursquare;

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
		
		ObjectMapper mapper = new ObjectMapper();
		
		return "";
	}
	
}
