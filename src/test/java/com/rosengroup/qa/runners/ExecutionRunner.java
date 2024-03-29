package com.rosengroup.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.rosengroup.qa.hooks",
                "com.rosengroup.qa.stepDefinitions"})
public class ExecutionRunner {
}