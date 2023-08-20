package com.rosengroup.qa.steps;

import com.rosengroup.qa.pages.ProfileHomePage;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.ReportConfig;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckTitle extends Functions {

    ProfileHomePage profileHomePage;

    public CheckTitle(){
        profileHomePage = new ProfileHomePage();
    }

    public String getUrl(){
        DriverConfig.getWait().until(ExpectedConditions.visibilityOf(DriverConfig.getDriver().findElement(profileHomePage.getIMG_PRINCIPAL())));
        ReportConfig.screenshot(DriverConfig.getDriver(), "Select link QA", "pass", profileHomePage.getIMG_PRINCIPAL());
        return DriverConfig.getDriver().getCurrentUrl();
    }
}
