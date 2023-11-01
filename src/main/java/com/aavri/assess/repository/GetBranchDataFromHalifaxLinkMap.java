/*******************************************************************************
 * GetBranchDataFromHalifaxLinkMap.java - save data to Google's ConcurrentMap
 *          after it is retrieved from Halifax website.
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) set up the Singleton environment;
 *    2) save the data in Google's ConcurrentMay with key "branch"
 ********************************************************************************/

package com.aavri.assess.repository;

import com.aavri.assess.entity.*;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

@Repository
public class GetBranchDataFromHalifaxLinkMap {

    private static GetBranchDataFromHalifaxLinkMap instance = null;

    private GetBranchDataFromHalifaxLinkMap() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new GetBranchDataFromHalifaxLinkMap();
        }
    }

    public static GetBranchDataFromHalifaxLinkMap getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    private volatile ConcurrentMap<String , ArrayList<Brancho>> linkMap= Maps.newConcurrentMap();


    public  ArrayList<Brancho> getToLinkMap(String key) {
            return linkMap.get(key);
    }

    public void addLinkMap(String key,ArrayList<Brancho> br) {
        linkMap.put(key,br);
    }

}
