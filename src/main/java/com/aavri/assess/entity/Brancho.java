/*******************************************************************************
 * Brancho.java - it is used to save the result of parse
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) it is defined accordong to BE Technical Assessment
 *    2) save the result of parse
 *    3) used by Google's cocurrentMap to cache the data
 ********************************************************************************/

package com.aavri.assess.entity;

public class Brancho {
    private String branchName;
    private float latitude;
    private float longitude;
    private String streetAddress;
    private String city;
    private String countrySubDivision;
    private String country;
    private String postCode;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountrySubDivision() {
        return countrySubDivision;
    }

    public void setCountrySubDivision(String countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

}
