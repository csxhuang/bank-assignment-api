/*******************************************************************************
 * Data.java - entity class that is created based on Halifax data structure
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

public class Data {

	private Brand[] Brand;

	public Brand[] getBrand() {
		return Brand;
	}

	public void setBrand(Brand[] brand) {
		this.Brand = brand;
	}
	
	
}
