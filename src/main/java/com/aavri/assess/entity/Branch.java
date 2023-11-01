/*******************************************************************************
 * Branch.java - entity class that is created based on Halifax data structure
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

public class Branch {
	
	private String identification;
	private String sequenceNumber;
	private String name;
	private String type;
	private String customerSegment;
	private String otherServiceAndFacility;
	private String availability;
	private String contactInfo;
	private PostalAddress postalAddress;

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCustomerSegment() {
		return customerSegment;
	}

	public void setCustomerSegment(String customerSegment) {
		this.customerSegment = customerSegment;
	}

	public String getOtherServiceAndFacility() {
		return otherServiceAndFacility;
	}

	public void setOtherServiceAndFacility(String otherServiceAndFacility) {
		this.otherServiceAndFacility = otherServiceAndFacility;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public PostalAddress getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}
	
	
}
