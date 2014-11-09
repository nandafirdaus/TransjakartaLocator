
package com.roxinlabs.transjakarta.model.foursquare;

public class Geometry{
   	private Bounds bounds;
   	private Center center;

 	public Bounds getBounds(){
		return this.bounds;
	}
	public void setBounds(Bounds bounds){
		this.bounds = bounds;
	}
 	public Center getCenter(){
		return this.center;
	}
	public void setCenter(Center center){
		this.center = center;
	}
}
