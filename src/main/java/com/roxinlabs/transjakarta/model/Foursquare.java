
package com.roxinlabs.transjakarta.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.roxinlabs.transjakarta.model.foursquare.Response;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Foursquare{
	
   	private Response response;

 	public Response getResponse(){
		return this.response;
	}
	public void setResponse(Response response){
		this.response = response;
	}
}
