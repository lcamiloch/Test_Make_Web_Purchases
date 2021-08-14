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
        scrollToWebElement(homePage.getImg_title());
        products = DriverConfig.getDriver()
                .findElement(homePage.getLabel_products_numbers()).getText();
        ReportConfig.screenshot(DriverConfig.getDriver(),
                "Validate products", "pass", homePage.getLabel_products_numbers());
        return products;
    }

    public String validateRemovedProducts(){
        products = DriverConfig.getDriver()
                .findElement(shoppingCartSummary.getLabel_shopping_cart_empty()).getText();
        ReportConfig.screenshot(DriverConfig.getDriver(),
                "Validate shopping cart empty", "pass", shoppingCartSummary.getLabel_shopping_cart_empty());
        return products;
    }
}
