/*******************************************************************************
 * GetBranchDataFromHalifaxService.java - get the data form Halifax through web
 *          services RESTful method GET and parse the data to ArrayList
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) set up the Singleton environment;
 *    2) get the data from Halifax websit through RESTful method GET API
 *    3) parse the get data to a array list
 ********************************************************************************/

package com.aavri.assess.repository;

import com.aavri.assess.entity.*;
import com.alibaba.fastjson.JSON;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

@Repository
public class GetBranchDataFromHalifaxService {

    private static GetBranchDataFromHalifaxService instance = null;

    private GetBranchDataFromHalifaxService() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new GetBranchDataFromHalifaxService();
        }
    }

    public static GetBranchDataFromHalifaxService getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public static ArrayList<Brancho> GetBranchDataFromHalifaxSite() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//        headers.set("APIKey", "5567GGH67225HYVGG");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceURL = "https://api.halifax.co.uk/open-banking/v2.2/branches";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            String body = response.getBody();
            Halifax halifax = JSON.parseObject(body, Halifax.class);
            ArrayList<Brancho> branchos = new ArrayList<Brancho>();
            for (Data da : halifax.getData()) {
                for (Brand bd : da.getBrand()) {
                    for (Branch bh : bd.getBranch()) {
                        Brancho brancho = new Brancho();
                        brancho.setBranchName(bh.getName());
                        brancho.setLatitude(Float.parseFloat(bh.getPostalAddress().getGeoLocation().getGeographicCoordinates().getLatitude()));
                        brancho.setLongitude(Float.parseFloat(bh.getPostalAddress().getGeoLocation().getGeographicCoordinates().getLongitude()));
                        if (bh.getPostalAddress().getAddressLine() != null)
                            brancho.setStreetAddress(bh.getPostalAddress().getAddressLine()[0]);
                        brancho.setCity(bh.getPostalAddress().getTownName());
                        if (bh.getPostalAddress().getCountrySubDivision() != null)
                            brancho.setCountrySubDivision(bh.getPostalAddress().getCountrySubDivision()[0]);
                        brancho.setCountry(bh.getPostalAddress().getCountry());
                        brancho.setPostCode(bh.getPostalAddress().getPostCode());
                        branchos.add(brancho);
                    }
                }
            }
            return branchos;
        } else {
            return null;
        }
    }
}
