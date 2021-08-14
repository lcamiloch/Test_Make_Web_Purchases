package com.rosengroup.qa.pages;

import org.openqa.selenium.By;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class HomePage {

    public By img_item_first = By.xpath("(//a[@class='product_img_link']//img)[1]");
    public By img_item_second = By.xpath("(//a[@class='product_img_link']//img)[2]");
    public By img_item_third = By.xpath("(//a[@class='product_img_link']//img)[3]");
    public By img_item_fourth = By.xpath("(//a[@class='product_img_link']//img)[4]");
    public By img_item_fifth = By.xpath("(//a[@class='product_img_link']//img)[5]");
    public By img_item_sixth = By.xpath("(//a[@class='product_img_link']//img)[6]");
    public By img_item_seventh = By.xpath("(//a[@class='product_img_link']//img)[7]");

    public By button_add_item = By.name("Submit");
    public By dropdown_List_Size = By.name("group_1");
    public By dropdown_List_report = By.xpath("//select[@id='group_1']//..");

    public By button_continue_shopping = By.xpath("//span[@title='Continue shopping']");

    public By dropdown_List_Products = By.xpath("//div[@class='shopping_cart']/a");
    public By label_products_numbers = By.xpath("//b[text()='Cart']//following::span[1]");
    public By img_title = By.xpath("(//img)[1]");
}