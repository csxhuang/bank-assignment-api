/*******************************************************************************
 * Halifax.java - entity class that is created based on Halifax data structure
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

public class Halifax {

	private String meta;
	
	private Data[] data;

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public Data[] getData() {
		return data;
	}

	public void setData(Data[] data) {
		this.data = data;
	}
	
}
