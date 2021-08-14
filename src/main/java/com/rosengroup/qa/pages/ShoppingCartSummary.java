package com.rosengroup.qa.pages;

import org.openqa.selenium.By;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class ShoppingCartSummary {

    public By img_item_delete;
    public By row_product_deleted;
    public By label_shopping_cart_empty = By.xpath("//ul[@id='order_step']//following::p");

    public void setImgItemDelete(int productNumber){
        img_item_delete = By.xpath(
                "(//i[@class='icon-trash'])[" + productNumber + "]");
    }

    public void setRowProductDeleted(int rowProductDeleted){
        row_product_deleted = By.xpath(
                "//tr[starts-with(@id,'product')][" + rowProductDeleted + "]");
    }
}