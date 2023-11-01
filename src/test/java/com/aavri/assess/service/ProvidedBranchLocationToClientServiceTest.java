package com.aavri.assess.service;

import com.aavri.assess.entity.Brancho;
import com.aavri.assess.repository.GetBranchDataFromHalifaxLinkMap;
import com.aavri.assess.repository.GetBranchDataFromHalifaxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import com.aavri.assess.AavriStartupRunner;

@RunWith(SpringRunner.class)
public class ProvidedBranchLocationToClientServiceTest {

    @Test
    public void getAllBranchInfoService() {
        runnnn();
        ArrayList<Brancho> bra = GetBranchDataFromHalifaxLinkMap.getInstance().getToLinkMap("branch");
        System.out.println("Check the result: "+bra);
    }

    @Test
    public void getAllBranchNameService() {
        runnnn();
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
        System.out.println("Check the result: "+branchList);
    }

    @Test
    public void getBranchNameByCityName() {
        runnnn();
        ArrayList<Brancho> bra = GetBranchDataFromHalifaxLinkMap.getInstance().getToLinkMap("branch");
        String city = "tadcaster";    // liverpool
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
        System.out.println("Check the result: "+branchList);
    }

    public void runnnn() {
        ArrayList<Brancho> branch = new ArrayList<Brancho>();
        GetBranchDataFromHalifaxService getBranchDataFromHalifaxService = GetBranchDataFromHalifaxService.getInstance();
        branch = getBranchDataFromHalifaxService.GetBranchDataFromHalifaxSite();
        GetBranchDataFromHalifaxLinkMap.getInstance().addLinkMap("branch", branch);
    }

}
