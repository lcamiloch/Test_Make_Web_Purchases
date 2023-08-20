package com.rosengroup.qa.steps;

import com.rosengroup.qa.pages.GoogleHomePage;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.ReportConfig;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchInGoogle extends Functions {

    GoogleHomePage googleHomePage;

    public SearchInGoogle(){
        googleHomePage = new GoogleHomePage();
    }

     public void searchElement(String element){
         DriverConfig.getWait().until(ExpectedConditions.visibilityOf(DriverConfig.getDriver().findElement(googleHomePage.getINPUT_GOOGLE())));
         DriverConfig.getDriver().findElement(googleHomePage.getINPUT_GOOGLE()).sendKeys(element);
         ReportConfig.screenshot(DriverConfig.getDriver(), "Search QA", "info", googleHomePage.getINPUT_GOOGLE());
         DriverConfig.getDriver().findElement(googleHomePage.getINPUT_GOOGLE()).submit();
     }

     public void selectLink(){
         DriverConfig.getWait().until(ExpectedConditions.visibilityOf(DriverConfig.getDriver().findElement(googleHomePage.getLINK_PROFILE())));
         scrollToWebElement(googleHomePage.getLINK_PROFILE());
         ReportConfig.screenshot(DriverConfig.getDriver(), "Select link QA", "info", googleHomePage.getLINK_PROFILE());
         DriverConfig.getDriver().findElement(googleHomePage.getLINK_PROFILE()).click();
         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

}
