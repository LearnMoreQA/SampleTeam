package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com.featurefile"},
        glue = {"com.stepdefinition"},
        tags = "@login"
)
public class Runner {

}
