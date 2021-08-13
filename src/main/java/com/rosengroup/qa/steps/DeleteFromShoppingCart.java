package com.rosengroup.qa.steps;

import com.rosengroup.qa.pages.HomePage;
import com.rosengroup.qa.pages.ShoppingCartSummary;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.ReportConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeleteFromShoppingCart extends Functions {

    WebDriver driver;
    HomePage homePage;
    WebDriverWait wait;
    ReportConfig report;
    ShoppingCartSummary shoppingCartSummary;


    public DeleteFromShoppingCart(WebDriver driver, ReportConfig report, WebDriverWait wait) {
        super(driver, report, wait);
        this.wait = wait;
        this.driver = driver;
        this.report = report;
        homePage = new HomePage(driver);
        shoppingCartSummary = new ShoppingCartSummary(driver);
    }

    public void clickOnShoppingCart(){
        report.screenshot(driver, "Click on shopping cart", "info", homePage.dropdown_List_Products);
        driver.findElement(homePage.label_products_numbers).click();
    }

    public void deleteItems(int products){
        for(int i=products; i > 0; i-- ){
            shoppingCartSummary.setImgItemDelete(i);
            shoppingCartSummary.setRowProductDeleted(i);
            scrollToWebElement(shoppingCartSummary.row_product_deleted);
            report.screenshot(driver, "Product " + i + " removed", "info", shoppingCartSummary.row_product_deleted);
            driver.findElement(shoppingCartSummary.img_item_delete).click();
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(shoppingCartSummary.img_item_delete)));
        }
    }
}