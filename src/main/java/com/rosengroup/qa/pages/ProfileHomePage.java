package com.rosengroup.qa.pages;

import org.openqa.selenium.By;

public class ProfileHomePage {

    private final By IMG_PRINCIPAL =By.xpath("(//img)[1]");

    public By getIMG_PRINCIPAL(){
        return IMG_PRINCIPAL;
    }
}
