/*******************************************************************************
 * AavriStartupRunner.java - pre-data get from Halifax and save it to cache
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) get the data from Halifax through the web services RESTful API;
 *    2) save the data to the cache based on Google's ConcurrentMap
 *    3) this CommandLineRunner program automatically run after Spring boot
 *       Application started.
 ********************************************************************************/

package com.aavri.assess;

import com.aavri.assess.entity.Brancho;
import com.aavri.assess.repository.GetBranchDataFromHalifaxLinkMap;
import com.aavri.assess.repository.GetBranchDataFromHalifaxService;
import com.google.common.collect.Maps;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

@Component
public class AavriStartupRunner implements CommandLineRunner {

    public static ArrayList<Brancho> branch = new ArrayList<Brancho>();

    @Override
    public void run(String... strings) {
        GetBranchDataFromHalifaxService getBranchDataFromHalifaxService = GetBranchDataFromHalifaxService.getInstance();
        branch = getBranchDataFromHalifaxService.GetBranchDataFromHalifaxSite();
        GetBranchDataFromHalifaxLinkMap.getInstance().addLinkMap("branch", branch);
    }

}
