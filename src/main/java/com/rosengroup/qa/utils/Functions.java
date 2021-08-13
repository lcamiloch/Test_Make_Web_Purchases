package com.rosengroup.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {

    Actions builder;
    WebDriver driver;
    WebDriverWait wait;
    ReportConfig report;

    public Functions(WebDriver driver, ReportConfig report, WebDriverWait wait){
        this.wait = wait;
        this.driver = driver;
        this.report = report;
        builder = new Actions(driver);
    }

    public void moveToElementAndClick(By locator){
        Action actionMove = builder
                .moveToElement(driver.findElement(locator)).click().build();
        report.screenshot(driver, "Selected item", "info", locator);
        actionMove.perform();
    }

    public void scrollToWebElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView();" + "window.scrollBy(0,-300);",
                driver.findElement(locator));
    }

    public void addItems(By addItem, int iframe, int productNumber){
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addItem)));
        report.screenshot(driver, "Product " + productNumber + " added", "info", addItem);
        driver.findElement(addItem).click();
        driver.switchTo().defaultContent();
    }

    public void clickToContinueShopping(By continueShopping){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueShopping)));
        report.screenshot(driver, "Click on continue shopping", "info", continueShopping);
        driver.findElement(continueShopping).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(continueShopping));
    }

    public void selectDropDownListSize(By sizeLocator, By reportLocator, int iframe, String size){
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(reportLocator)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(reportLocator)));
        report.screenshot(driver, "Select size", "info", reportLocator);
        Select selectList = new Select(driver.findElement(sizeLocator));
        selectList.selectByValue(size);
        driver.switchTo().defaultContent();
    }
}