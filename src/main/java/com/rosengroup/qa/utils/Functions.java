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

    public void moveToElementAndClick(By locator){
        Actions builder = new Actions(DriverConfig.getDriver());
        Action actionMove = builder
                .moveToElement(DriverConfig.getDriver().findElement(locator)).click().build();
        ReportConfig.screenshot(DriverConfig.getDriver(), "Selected item", "info", locator);
        actionMove.perform();
    }

    public void scrollToWebElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) DriverConfig.getDriver();
        js.executeScript(
                PropertiesConfig.getParameter("FirstArgumentScroll") + PropertiesConfig.getParameter("SecondArgumentScroll"),
                DriverConfig.getDriver().findElement(locator));
    }

    public void addItems(By addItem, int iframe, int productNumber){
        DriverConfig.getDriver().switchTo().frame(iframe);
        DriverConfig.getWait().until(ExpectedConditions.visibilityOf(DriverConfig.getDriver().findElement(addItem)));
        ReportConfig.screenshot(DriverConfig.getDriver(), "Product " + productNumber + " added", "info", addItem);
        DriverConfig.getDriver().findElement(addItem).click();
        DriverConfig.getDriver().switchTo().defaultContent();
    }

    public void clickToContinueShopping(By continueShopping){
        DriverConfig.getWait().until(ExpectedConditions.visibilityOf(DriverConfig.getDriver().findElement(continueShopping)));
        ReportConfig.screenshot(DriverConfig.getDriver(), "Click on continue shopping", "info", continueShopping);
        DriverConfig.getDriver().findElement(continueShopping).click();
        DriverConfig.getWait().until(ExpectedConditions.invisibilityOfElementLocated(continueShopping));
    }

    public void selectDropDownListSize(By sizeLocator, By reportLocator, int iframe, String size){
        DriverConfig.getDriver().switchTo().frame(iframe);
        DriverConfig.getWait().until(ExpectedConditions.visibilityOf(DriverConfig.getDriver().findElement(reportLocator)));
        Select selectList = new Select(DriverConfig.getDriver().findElement(sizeLocator));
        selectList.selectByValue(size);
        ReportConfig.screenshot(DriverConfig.getDriver(), "Select size", "info", reportLocator);
        DriverConfig.getDriver().switchTo().defaultContent();
    }
}