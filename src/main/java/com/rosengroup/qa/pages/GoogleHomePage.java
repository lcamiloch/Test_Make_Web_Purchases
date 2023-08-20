package com.rosengroup.qa.pages;

import org.openqa.selenium.By;

public class GoogleHomePage {

    private final By INPUT_GOOGLE = By.xpath("//textarea[@name='q']");
    private final By LINK_PROFILE = By.xpath("(//h3[starts-with(@class,'LC20lb MBeuO')])[6]");

    public By getINPUT_GOOGLE() {
        return INPUT_GOOGLE;
    }

    public By getLINK_PROFILE() {
        return LINK_PROFILE;
    }
}
