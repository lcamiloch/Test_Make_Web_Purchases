package com.rosengroup.qa.hooks;

import com.rosengroup.qa.utils.ReportConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.rosengroup.qa.utils.DriverConfig.*;
import static com.rosengroup.qa.utils.ReportConfig.initializeReport;

public class Hooks {

    @Before
    public void initialConfig(){
        initializeDriver();
        waitDriver();
        initializeReport();
    }

    @After
    public void Disconnection(){
        ReportConfig.generateReport();
        disconnectDriver();
    }
}
