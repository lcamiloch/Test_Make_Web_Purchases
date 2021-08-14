package com.rosengroup.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class Functions {

    Actions builder;

    public Functions(){
        builder = new Actions(DriverConfig.driver);
    }

    public void moveToElementAndClick(By locator){
        Action actionMove = builder
                .moveToElement(DriverConfig.driver.findElement(locator)).click().build();
        ReportConfig.screenshot(DriverConfig.driver, "Selected item", "info", locator);
        actionMove.perform();
    }

    public void scrollToWebElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) DriverConfig.driver;
        js.executeScript(
                PropertiesConfig.getParameter("FirstArgumentScroll") + PropertiesConfig.getParameter("SecondArgumentScroll"),
                DriverConfig.driver.findElement(locator));
    }

    public void addItems(By addItem, int iframe, int productNumber){
        DriverConfig.driver.switchTo().frame(iframe);
        DriverConfig.wait.until(ExpectedConditions.visibilityOf(DriverConfig.driver.findElement(addItem)));
        ReportConfig.screenshot(DriverConfig.driver, "Product " + productNumber + " added", "info", addItem);
        DriverConfig.driver.findElement(addItem).click();
        DriverConfig.driver.switchTo().defaultContent();
    }

    public void clickToContinueShopping(By continueShopping){
        DriverConfig.wait.until(ExpectedConditions.visibilityOf(DriverConfig.driver.findElement(continueShopping)));
        ReportConfig.screenshot(DriverConfig.driver, "Click on continue shopping", "info", continueShopping);
        DriverConfig.driver.findElement(continueShopping).click();
        DriverConfig.wait.until(ExpectedConditions.invisibilityOfElementLocated(continueShopping));
    }

    public void selectDropDownListSize(By sizeLocator, By reportLocator, int iframe, String size){
        DriverConfig.driver.switchTo().frame(iframe);
        DriverConfig.wait.until(ExpectedConditions.visibilityOf(DriverConfig.driver.findElement(reportLocator)));
        Select selectList = new Select(DriverConfig.driver.findElement(sizeLocator));
        selectList.selectByValue(size);
        ReportConfig.screenshot(DriverConfig.driver, "Select size", "info", reportLocator);
        DriverConfig.driver.switchTo().defaultContent();
    }
}