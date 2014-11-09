
package com.roxinlabs.transjakarta.model;

import com.roxinlabs.transjakarta.model.foursquare.Meta;
import com.roxinlabs.transjakarta.model.foursquare.Response;

public class Foursquare{
   	private Meta meta;
   	private Response response;

 	public Meta getMeta(){
		return this.meta;
	}
	public void setMeta(Meta meta){
		this.meta = meta;
	}
 	public Response getResponse(){
		return this.response;
	}
	public void setResponse(Response response){
		this.response = response;
	}
}
