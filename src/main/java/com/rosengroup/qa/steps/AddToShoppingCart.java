package com.rosengroup.qa.steps;

import com.rosengroup.qa.pages.HomePage;
import com.rosengroup.qa.utils.Functions;
import org.openqa.selenium.By;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class AddToShoppingCart extends Functions {

    int productNumber = 0;
    boolean changeColor = false;
    HomePage homePage;

    public AddToShoppingCart() {
        homePage = new HomePage();
    }

    public void itemOne() {
        productNumber++;
        scrollToWebElement(homePage.img_item_first);
        addItemAndContinueShopping(homePage.img_item_first);
    }

    public void itemTwo() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_second);
    }

    public void itemThree() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_third);
    }

    public void itemFour() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_fourth);
    }

    public void itemFive() {
        productNumber++;
        scrollToWebElement(homePage.img_item_fifth);
        addItemAndContinueShopping(homePage.img_item_fifth);
    }

    public void itemSix() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_sixth);
    }

    public void itemSeven() {
        productNumber++;
        addItemAndContinueShopping(homePage.img_item_seventh);
    }

    public void itemEight() {
        productNumber++;
        changeColor = true;
        scrollToWebElement(homePage.img_item_first);
        addItemAndContinueShopping(homePage.img_item_first);
    }

    public void itemNine() {
        productNumber++;
        changeColor = true;
        addItemAndContinueShopping(homePage.img_item_second);
    }

    public void itemTen() {
        productNumber++;
        changeColor = true;
        addItemAndContinueShopping(homePage.img_item_third);
    }

    public void addItemAndContinueShopping(By item){
        moveToElementAndClick(item);
        if(changeColor){
            selectDropDownListSize(homePage.dropdown_List_Size,
                    homePage.dropdown_List_report, 1, "2");
            changeColor = false;
        }
        addItems(homePage.button_add_item,1, productNumber);
        clickToContinueShopping(homePage.button_continue_shopping);
    }
}