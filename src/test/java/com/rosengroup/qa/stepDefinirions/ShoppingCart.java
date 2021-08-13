package com.rosengroup.qa.stepDefinirions;

import com.rosengroup.qa.steps.AddToShoppingCart;
import com.rosengroup.qa.steps.DeleteFromShoppingCart;
import com.rosengroup.qa.steps.ValidateShoppingCart;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.PropertiesConfig;
import com.rosengroup.qa.utils.ReportConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Integer.parseInt;

public class ShoppingCart {

    String products;
    WebDriver driver;
    WebDriverWait wait;
    ReportConfig report;
    DriverConfig configDriver;
    AddToShoppingCart addToShoppingCart;
    ValidateShoppingCart validateShoppingCart;
    DeleteFromShoppingCart deleteFromShoppingCart;

    @Before
    public void initialConfig(){
        report = new ReportConfig();
        configDriver = new DriverConfig();
        driver = configDriver.selectNavigator();
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(Long.parseLong(
                        PropertiesConfig.getParameter("WaitDurationExpected"))));
        driver.navigate().to(PropertiesConfig.getParameter("web"));
    }

    @Given("The customer wants to test the functionality of the shopping cart")
    public void initialStep() {
        addToShoppingCart = new AddToShoppingCart(driver, report, wait);
        validateShoppingCart = new ValidateShoppingCart(driver, report, wait);
        deleteFromShoppingCart = new DeleteFromShoppingCart(driver, report, wait);
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
                validateShoppingCart.validatePurchasedProducts());
    }

    @And("He then deletes them")
    public void removeItems(){
        deleteFromShoppingCart.clickOnShoppingCart();
        deleteFromShoppingCart.deleteItems(parseInt(products));
    }

    @Then("^He should see the shopping cart (.*)$")
    public void VerifyEmptyShoppingCart(String key) {
        Assert.assertTrue(validateShoppingCart
                .validateRemovedProducts().contains(key));
    }

    @After
    public void cleanUp(){
        driver.close();
        driver.quit();
        report.createReport();
    }
}
