/*******************************************************************************
 * GeographicCoordinates.java - entity class that is created based on Halifax
 *          data structure
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) get the Halifax data from website;
 *    2) analysis the data structure reference to JSON parse
 *    3) the useless filed to be ignored
 ********************************************************************************/

package com.aavri.assess.entity;

public class GeographicCoordinates {
	
	private String Latitude;
	private String Longitude;
	
	public GeographicCoordinates() {
	}
	
	public GeographicCoordinates(String latitude, String longitude) {
		Latitude = latitude;
		Longitude = longitude;
	}
	
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

}
