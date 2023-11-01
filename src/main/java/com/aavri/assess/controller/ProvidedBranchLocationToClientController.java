/*******************************************************************************
 * ProvidedBranchLocationToClientController.java - provided the controller to
 *          the client use
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) getAllBranchInfo, provided all information that is included fields
 *       as branchName, latitude, longitude, streetAddress, city, countrySubDivision
 *       country, postCode;
 *    2) getAllBranchLocation, provided all locations for client;
 *    3) getBranchByCity, provided the locations filtered by city name.
 ********************************************************************************/

package com.aavri.assess.controller;

import com.aavri.assess.Common.ObjectAndJsonConvertter;
import com.aavri.assess.service.ProvidedBranchLocationToClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/branchs")
public class ProvidedBranchLocationToClientController {

    @Autowired
    private ProvidedBranchLocationToClientService bs;

    @RequestMapping(value = "/allinfo", method = RequestMethod.GET)
    public String getAllBranchInfo() {
        return ObjectAndJsonConvertter.object_2_json(bs.getAllBranchInfoService());
    }

    @RequestMapping(value = "/allloc", method = RequestMethod.GET)
    public String getAllBranchLocation() {
        return ObjectAndJsonConvertter.object_2_json(bs.getAllBranchLocationService());
    }

    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
    public String getBranchByCity(@PathVariable("city") String city) {
        List<String> rtnstr = new ArrayList<String>();
        rtnstr = bs.getBranchNameByCityName(city);
        return ObjectAndJsonConvertter.object_2_json(rtnstr);
    }

}
