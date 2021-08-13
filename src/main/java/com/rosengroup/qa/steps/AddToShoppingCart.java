package com.rosengroup.qa.steps;

import com.rosengroup.qa.pages.HomePage;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.ReportConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToShoppingCart extends Functions {

    int productNumber = 0;
    boolean changeColor = false;
    WebDriver driver;
    HomePage homePage;
    WebDriverWait wait;
    ReportConfig report;

    public AddToShoppingCart(WebDriver driver, ReportConfig report, WebDriverWait wait) {
        super(driver, report, wait);
        this.wait = wait;
        this.driver = driver;
        this.report = report;
        report.flowName("RTRC_test");
        report.logReport(driver.getCurrentUrl(), "info");
        homePage = new HomePage(driver);
    }

    public void itemOne() {
        productNumber++;
        scrollToWebElement(homePage.img_item_first);
        addItemAndContinueShopping(homePage.img_item_first);
    }

    public void itemTwo() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_second);
    }

    public void itemThree() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_third);
    }

    public void itemFour() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_fourth);
    }

    public void itemFive() {
        productNumber++;
        scrollToWebElement(homePage.img_item_fifth);
        addItemAndContinueShopping(homePage.img_item_fifth);
    }

    public void itemSix() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_sixth);
    }

    public void itemSeven() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_seventh);
    }

    public void itemEight() {
        productNumber++;
        changeColor = true;
        scrollToWebElement(homePage.img_item_first);
        addItemAndContinueShopping(homePage.img_item_first);
    }

    public void itemNine() {
        productNumber++;
        changeColor = true;
        addItemAndContinueShopping(homePage.img_item_second);
    }

    public void itemTen() {
        productNumber++;
        changeColor = true;
        addItemAndContinueShopping(homePage.img_item_third);
    }

    public void addItemAndContinueShopping(By item){
        moveToElementAndClick(item);
        if(changeColor){
            selectDropDownListSize(homePage.dropdown_List_Size,
                    homePage.dropdown_List_report, 1, "2");
            changeColor = false;
        }
        addItems(homePage.button_add_item,1, productNumber);
        clickToContinueShopping(homePage.button_continue_shopping);
    }
}