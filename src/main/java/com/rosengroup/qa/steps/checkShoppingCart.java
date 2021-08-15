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
public class checkShoppingCart extends Functions {

    String products;
    HomePage homePage;
    ShoppingCartSummary shoppingCartSummary;

    public checkShoppingCart(){
        homePage = new HomePage();
        shoppingCartSummary = new ShoppingCartSummary();
    }

    public String checkPurchasedProducts(){
        scrollToWebElement(homePage.getImg_title());
        products = DriverConfig.getDriver()
                .findElement(homePage.getLabel_products_numbers()).getText();
        ReportConfig.screenshot(DriverConfig.getDriver(),
                "Check products", "pass", homePage.getLabel_products_numbers());
        return products;
    }

    public String checkRemovedProducts(){
        products = DriverConfig.getDriver()
                .findElement(shoppingCartSummary.getLabel_shopping_cart_empty()).getText();
        ReportConfig.screenshot(DriverConfig.getDriver(),
                "Check shopping cart empty", "pass", shoppingCartSummary.getLabel_shopping_cart_empty());
        return products;
    }
}
