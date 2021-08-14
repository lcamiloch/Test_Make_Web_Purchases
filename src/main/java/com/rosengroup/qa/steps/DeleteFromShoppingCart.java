package com.rosengroup.qa.steps;

import com.rosengroup.qa.pages.HomePage;
import com.rosengroup.qa.pages.ShoppingCartSummary;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.ReportConfig;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class DeleteFromShoppingCart extends Functions {

    HomePage homePage;
    ShoppingCartSummary shoppingCartSummary;

    public DeleteFromShoppingCart() {
        homePage = new HomePage();
        shoppingCartSummary = new ShoppingCartSummary();
    }

    public void clickOnShoppingCart(){
        ReportConfig.screenshot(DriverConfig.getDriver(), "Click on shopping cart", "info", homePage.getDropdown_List_Products());
        DriverConfig.getDriver().findElement(homePage.getLabel_products_numbers()).click();
    }

    public void deleteItems(int products){
        for(int i=products; i > 0; i-- ){
            shoppingCartSummary.setImg_item_delete(i);
            shoppingCartSummary.setRow_product_deleted(i);
            scrollToWebElement(shoppingCartSummary.getRow_product_deleted());
            ReportConfig.screenshot(DriverConfig.getDriver(), "Product " + i + " removed", "info", shoppingCartSummary.getRow_product_deleted());
            DriverConfig.getDriver().findElement(shoppingCartSummary.getImg_item_delete()).click();
            DriverConfig.getWait().until(ExpectedConditions.invisibilityOf(DriverConfig.getDriver().findElement(shoppingCartSummary.getImg_item_delete())));
        }
    }
}