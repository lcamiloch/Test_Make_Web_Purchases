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
        ReportConfig.screenshot(DriverConfig.driver, "Click on shopping cart", "info", homePage.dropdown_List_Products);
        DriverConfig.driver.findElement(homePage.label_products_numbers).click();
    }

    public void deleteItems(int products){
        for(int i=products; i > 0; i-- ){
            shoppingCartSummary.setImgItemDelete(i);
            shoppingCartSummary.setRowProductDeleted(i);
            scrollToWebElement(shoppingCartSummary.row_product_deleted);
            ReportConfig.screenshot(DriverConfig.driver, "Product " + i + " removed", "info", shoppingCartSummary.row_product_deleted);
            DriverConfig.driver.findElement(shoppingCartSummary.img_item_delete).click();
            DriverConfig.wait.until(ExpectedConditions.invisibilityOf(DriverConfig.driver.findElement(shoppingCartSummary.img_item_delete)));
        }
    }
}