package com.rosengroup.qa.pages;

import org.openqa.selenium.By;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class HomePage {

    private final By img_item_first = By.xpath("(//a[@class='product_img_link']//img)[1]");
    private final By img_item_second = By.xpath("(//a[@class='product_img_link']//img)[2]");
    private final By img_item_third = By.xpath("(//a[@class='product_img_link']//img)[3]");
    private final By img_item_fourth = By.xpath("(//a[@class='product_img_link']//img)[4]");
    private final By img_item_fifth = By.xpath("(//a[@class='product_img_link']//img)[5]");

    private final By img_item_sixth = By.xpath("(//a[@class='product_img_link']//img)[6]");
    private final By img_item_seventh = By.xpath("(//a[@class='product_img_link']//img)[7]");

    private final By button_add_item = By.name("Submit");
    private final By dropdown_List_Size = By.name("group_1");
    private final By dropdown_List_report = By.xpath("//select[@id='group_1']//..");

    private final By button_continue_shopping = By.xpath("//span[@title='Continue shopping']");

    private final By dropdown_List_Products = By.xpath("//div[@class='shopping_cart']/a");
    private final By label_products_numbers = By.xpath("//b[text()='Cart']//following::span[1]");
    private final By img_title = By.xpath("(//img)[1]");


    public By getImg_item_first() {
        return img_item_first;
    }

    public By getImg_item_second() {
        return img_item_second;
    }

    public By getImg_item_third() {
        return img_item_third;
    }

    public By getImg_item_fourth() {
        return img_item_fourth;
    }

    public By getImg_item_fifth() {
        return img_item_fifth;
    }

    public By getImg_item_sixth() {
        return img_item_sixth;
    }

    public By getImg_item_seventh() {
        return img_item_seventh;
    }

    public By getButton_add_item() {
        return button_add_item;
    }

    public By getDropdown_List_Size() {
        return dropdown_List_Size;
    }

    public By getDropdown_List_report() {
        return dropdown_List_report;
    }

    public By getButton_continue_shopping() {
        return button_continue_shopping;
    }

    public By getDropdown_List_Products() {
        return dropdown_List_Products;
    }

    public By getLabel_products_numbers() {
        return label_products_numbers;
    }

    public By getImg_title() {
        return img_title;
    }
}