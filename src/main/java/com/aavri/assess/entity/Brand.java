/*******************************************************************************
 * Brand.java - entity class that is created based on Halifax data structure
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

public class Brand {

    private String BrandName;
    private Branch[] Branch;

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public Branch[] getBranch() {
        return Branch;
    }

    public void setBranch(Branch[] branch) {
        Branch = branch;
    }
}
