package com.rosengroup.qa.stepDefinitions;

import com.rosengroup.qa.steps.AddToShoppingCart;
import com.rosengroup.qa.steps.DeleteFromShoppingCart;
import com.rosengroup.qa.steps.checkShoppingCart;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.ReportConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static java.lang.Integer.parseInt;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class ShoppingCart {

    String products;
    AddToShoppingCart addToShoppingCart;
    checkShoppingCart checkShoppingCart;
    DeleteFromShoppingCart deleteFromShoppingCart;

    @Given("The customer wants to test the functionality of the shopping cart")
    public void initialStep() {
        ReportConfig.logReport(DriverConfig.getDriver().getCurrentUrl(), "info");
        addToShoppingCart = new AddToShoppingCart();
        checkShoppingCart = new checkShoppingCart();
        deleteFromShoppingCart = new DeleteFromShoppingCart();
    }

    @When("^He adds (.*) products to the shopping cart$")
    public void selectAndAddItems(String products) {
        this.products = products;
        addToShoppingCart.itemOne();
        addToShoppingCart.itemTwo();
        addToShoppingCart.itemThree();
        addToShoppingCart.itemFour();
        addToShoppingCart.itemFive();
        addToShoppingCart.itemSix();
        addToShoppingCart.itemSeven();
        addToShoppingCart.itemEight();
        addToShoppingCart.itemNine();
        addToShoppingCart.itemTen();
        Assert.assertEquals(products,
                checkShoppingCart.checkPurchasedProducts());
    }

    @And("He then deletes them")
    public void removeItems(){
        deleteFromShoppingCart.clickOnShoppingCart();
        deleteFromShoppingCart.deleteItems(parseInt(products));
    }

    @Then("^He should see the shopping cart (.*)$")
    public void VerifyEmptyShoppingCart(String key) {
        Assert.assertTrue(checkShoppingCart
                .checkRemovedProducts().contains(key));
    }
}