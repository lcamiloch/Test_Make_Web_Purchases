package com.rosengroup.qa.steps;

import com.rosengroup.qa.pages.HomePage;
import com.rosengroup.qa.pages.ShoppingCartSummary;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.ReportConfig;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class ValidateShoppingCart extends Functions {

    String products;
    HomePage homePage;
    ShoppingCartSummary shoppingCartSummary;

    public ValidateShoppingCart(){
        homePage = new HomePage();
        shoppingCartSummary = new ShoppingCartSummary();
    }

    public String validatePurchasedProducts(){
        scrollToWebElement(homePage.img_title);
        products = DriverConfig.driver.findElement(homePage.label_products_numbers).getText();
        ReportConfig.screenshot(DriverConfig.driver, "Validate products", "pass", homePage.label_products_numbers);
        return products;
    }

    public String validateRemovedProducts(){
        products = DriverConfig.driver.findElement(shoppingCartSummary.label_shopping_cart_empty).getText();
        ReportConfig.screenshot(DriverConfig.driver, "Validate shopping cart empty", "pass", shoppingCartSummary.label_shopping_cart_empty);
        return products;
    }
}
