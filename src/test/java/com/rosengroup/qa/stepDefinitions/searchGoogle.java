package com.rosengroup.qa.stepDefinitions;

import com.rosengroup.qa.steps.CheckTitle;
import com.rosengroup.qa.steps.SearchInGoogle;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.ReportConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class searchGoogle {

    SearchInGoogle searchInGoogle;
    CheckTitle checkTitle;

    @Given("The customer wants to find an element in google")
    public void the_customer_wants_to_find_an_element_in_google() {
        ReportConfig.logReport(DriverConfig.getDriver().getCurrentUrl(), "info");
        searchInGoogle = new SearchInGoogle();
        checkTitle = new CheckTitle();

    }
    @When("^He search the element (.*)$")
    public void he_search_the_element_qa(String element) {
        searchInGoogle.searchElement(element);
    }
    @When("He chose second element")
    public void he_chose_second_element() {
        searchInGoogle.selectLink();
    }
    @Then("He should see the title of the page")
    public void he_should_see_the_title_of_the_page() {
        Assert.assertEquals("https://profile.es/blog/analista-qa/", checkTitle.getUrl());
    }
}