
package com.roxinlabs.transjakarta.model.foursquare;

public class Feature{
   	private String cc;
   	private String displayName;
   	private Geometry geometry;
   	private String highlightedName;
   	private String id;
   	private String longId;
   	private String matchedName;
   	private String name;
   	private String slug;
   	private Number woeType;

 	public String getCc(){
		return this.cc;
	}
	public void setCc(String cc){
		this.cc = cc;
	}
 	public String getDisplayName(){
		return this.displayName;
	}
	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}
 	public Geometry getGeometry(){
		return this.geometry;
	}
	public void setGeometry(Geometry geometry){
		this.geometry = geometry;
	}
 	public String getHighlightedName(){
		return this.highlightedName;
	}
	public void setHighlightedName(String highlightedName){
		this.highlightedName = highlightedName;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public String getLongId(){
		return this.longId;
	}
	public void setLongId(String longId){
		this.longId = longId;
	}
 	public String getMatchedName(){
		return this.matchedName;
	}
	public void setMatchedName(String matchedName){
		this.matchedName = matchedName;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getSlug(){
		return this.slug;
	}
	public void setSlug(String slug){
		this.slug = slug;
	}
 	public Number getWoeType(){
		return this.woeType;
	}
	public void setWoeType(Number woeType){
		this.woeType = woeType;
	}
}
