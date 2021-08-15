package com.rosengroup.qa.pages;

import org.openqa.selenium.By;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class ShoppingCartSummary {

    private By img_item_delete;
    private By row_product_deleted;
    private final By label_shopping_cart_empty = By.xpath("//ul[@id='order_step']//following::p");

    public By getImg_item_delete() {
        return img_item_delete;
    }

    public void setImg_item_delete(int productNumber) {
        img_item_delete = By.xpath(
                "(//i[@class='icon-trash'])[" + productNumber + "]");
    }

    public By getRow_product_deleted() {
        return row_product_deleted;
    }

    public void setRow_product_deleted(int rowProductDeleted) {
        row_product_deleted = By.xpath(
                "//tr[starts-with(@id,'product')][" + rowProductDeleted + "]");
    }

    public By getLabel_shopping_cart_empty() {
        return label_shopping_cart_empty;
    }
}