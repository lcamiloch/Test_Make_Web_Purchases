package com.rosengroup.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartSummary {

    WebDriver driver;

    public ShoppingCartSummary(WebDriver driver){
        this.driver = driver;
    }

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