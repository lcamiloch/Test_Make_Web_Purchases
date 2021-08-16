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

    private int productNumber = 0;
    private boolean changeColor = false;
    HomePage homePage;

    public AddToShoppingCart() {
        homePage = new HomePage();
    }

    public void itemOne() {
        scrollToWebElement(homePage.getImg_item_first());
        addItemAndContinueShopping(homePage.getImg_item_first());
    }

    public void itemTwo() {
        addItemAndContinueShopping(homePage.getImg_item_second());
    }

    public void itemThree() {
        addItemAndContinueShopping(homePage.getImg_item_third());
    }

    public void itemFour() {
        addItemAndContinueShopping(homePage.getImg_item_fourth());
    }

    public void itemFive() {
        scrollToWebElement(homePage.getImg_item_fifth());
        addItemAndContinueShopping(homePage.getImg_item_fifth());
    }

    public void itemSix() {
        addItemAndContinueShopping(homePage.getImg_item_sixth());
    }

    public void itemSeven() {
        addItemAndContinueShopping(homePage.getImg_item_seventh());
    }

    public void itemEight() {
        changeColor = true;
        scrollToWebElement(homePage.getImg_item_first());
        addItemAndContinueShopping(homePage.getImg_item_first());
    }

    public void itemNine() {
        changeColor = true;
        addItemAndContinueShopping(homePage.getImg_item_second());
    }

    public void itemTen() {
        changeColor = true;
        addItemAndContinueShopping(homePage.getImg_item_third());
    }

    public void addItemAndContinueShopping(By item){
        productNumber++;
        moveToElementAndClick(item);
        if(changeColor){
            selectDropDownListSize(homePage.getDropdown_List_Size(),
                    homePage.getDropdown_List_report(), 1, "2");
            changeColor = false;
        }
        addItems(homePage.getButton_add_item(),1, productNumber);
        clickToContinueShopping(homePage.getButton_continue_shopping());
    }
}