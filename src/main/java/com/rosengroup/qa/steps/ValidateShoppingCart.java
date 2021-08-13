package com.rosengroup.qa.steps;

import com.rosengroup.qa.pages.HomePage;
import com.rosengroup.qa.pages.ShoppingCartSummary;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.ReportConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateShoppingCart extends Functions {

    String products;
    WebDriver driver;
    HomePage homePage;
    WebDriverWait wait;
    ReportConfig report;
    ShoppingCartSummary shoppingCartSummary;

    public ValidateShoppingCart(WebDriver driver, ReportConfig report, WebDriverWait wait){
        super(driver, report, wait);
        this.wait = wait;
        this.driver = driver;
        this.report = report;
        homePage = new HomePage(driver);
        shoppingCartSummary = new ShoppingCartSummary(driver);
    }

    public String validatePurchasedProducts(){
        scrollToWebElement(homePage.img_title);
        products = driver.findElement(homePage.label_products_numbers).getText();
        report.screenshot(driver, "Validate products", "pass", homePage.label_products_numbers);
        return products;
    }

    public String validateRemovedProducts(){
        products = driver.findElement(shoppingCartSummary.label_shopping_cart_empty).getText();
        report.screenshot(driver, "Validate shopping cart empty", "pass", shoppingCartSummary.label_shopping_cart_empty);
        return products;
    }
}
