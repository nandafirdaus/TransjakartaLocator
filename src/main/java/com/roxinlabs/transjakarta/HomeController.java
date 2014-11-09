package com.roxinlabs.transjakarta;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
}
