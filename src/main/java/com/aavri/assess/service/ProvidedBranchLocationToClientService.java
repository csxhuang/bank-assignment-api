/*******************************************************************************
 * ProvidedBranchLocationToClientService.java - provided the services to the
 *          client use
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) getAllBranchInfoService, provided all informaton that is included fields
 *       as branchName, latitude, longitude, streetAddress, city, countrySubDivision
 *       country, postCode;
 *    2) getAllBranchLocationService, provided all locations for client;
 *    3) getBranchNameByCityName, provided the locations filtered by city name.
 ********************************************************************************/

package com.aavri.assess.service;

import com.aavri.assess.entity.Brancho;
import com.aavri.assess.repository.GetBranchDataFromHalifaxLinkMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvidedBranchLocationToClientService {

    public ArrayList<Brancho> getAllBranchInfoService() {
        ArrayList<Brancho> bra = GetBranchDataFromHalifaxLinkMap.getInstance().getToLinkMap("branch");
        return bra;
    }

    public List<String> getAllBranchLocationService() {
        ArrayList<Brancho> bra = GetBranchDataFromHalifaxLinkMap.getInstance().getToLinkMap("branch");
        List<String> branchList = new ArrayList<String>();
        List<String> result = null;
        for (Brancho a : bra) {
            String pt = a.getBranchName();
            boolean isUnique = true;
            for (String pl : branchList) {
                if (pt.equals(pl)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                branchList.add(pt);
            }
            System.out.println(pt + ", ");
        }
        return branchList;
    }

//    public ArrayList<Brancho> getBranchInfoByCityName(String city) {
//        ArrayList<Brancho> bra = GetBranchDataFromHalifaxLinkMap.getInstance().getToLinkMap("branch");
//
////        ArrayList<String > searchCity = new ArrayList<String >();
////        searchCity.add(city);
////        List<String> result = null;
////        result = bra.stream()
////                .filter((Brancho b)->searchCity.contains(b.getCity()))
////                .collect(Collectors.toList());
//
//        List<String> cityList = new ArrayList<String>();
//        List<String> result = null;
//        for (Brancho a : bra) {
//            String pt = a.getCity();
//            if (!(pt.equals(city)))
//                continue;
//            boolean isUnique = true;
//            for(String pl:cityList) {
//                if (pt .equals(pl) ) {
//                    isUnique = false;
//                    break;
//                }
//            }
//            if (isUnique) {
//                cityList.add(pt);
//            }
//            System.out.println(pt+", ");
//        }
//        return bra;
//    }

    public List<String> getBranchNameByCityName(String city) {
        ArrayList<Brancho> bra = GetBranchDataFromHalifaxLinkMap.getInstance().getToLinkMap("branch");

//        ArrayList<String > searchCity = new ArrayList<String >();
//        searchCity.add(city);
//        List<String> result = null;
//        result = bra.stream()
//                .filter((Brancho b)->searchCity.contains(b.getCity()))
//                .collect(Collectors.toList());

        List<String> branchList = new ArrayList<String>();
        List<String> result = null;
        for (Brancho a : bra) {
            String pt = a.getBranchName();
            if (a.getCity()==null) continue;   // skip the dirty data
            if ((a.getCity().trim().toUpperCase().equals(city.trim().toUpperCase())) == false)
                continue;
            boolean isUnique = true;
            for (String pl : branchList) {
                if (pt.equals(pl)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                branchList.add(pt);
            }
            System.out.println(pt + ", ");
        }
        return branchList;
    }
}
