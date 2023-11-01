/*******************************************************************************
 * AssessApplication.java - Spring boot start program
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) start the program and wait other requests
 ********************************************************************************/

package com.aavri.assess;

import com.aavri.assess.entity.Brancho;
import com.aavri.assess.repository.GetBranchDataFromHalifaxService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class AssessApplication {
    public static void main(String[] args) {
        SpringApplication.run(AssessApplication.class, args);
    }
}