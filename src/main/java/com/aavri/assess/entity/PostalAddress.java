/*******************************************************************************
 * PostalAddress.java - entity class that is created based on Halifax data
 *          structure
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

public class PostalAddress {

	private String[] AddressLine;
	private String TownName;
	private String[] CountrySubDivision;
	private String Country;
	private String PostCode;
	private GeoLocation geoLocation;

	public String[] getAddressLine() {
		return AddressLine;
	}

	public void setAddressLine(String[] addressLine) {
		AddressLine = addressLine;
	}

	public String getTownName() {
		return TownName;
	}

	public void setTownName(String townName) {
		TownName = townName;
	}

	public String[] getCountrySubDivision() {
		return CountrySubDivision;
	}

	public void setCountrySubDivision(String[] countrySubDivision) {
		CountrySubDivision = countrySubDivision;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPostCode() {
		return PostCode;
	}

	public void setPostCode(String postCode) {
		PostCode = postCode;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
}
