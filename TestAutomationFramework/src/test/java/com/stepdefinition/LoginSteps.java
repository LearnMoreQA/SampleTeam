package com.stepdefinition;

import helper.ActionsHelper;
import helper.TextBoxHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resuseable.BrowerInvoke;

import java.io.IOException;

public class LoginSteps extends BrowerInvoke {

    private WebDriver driver;
    private String actualText;

    @Given("User Navigates to Required Url")
    public void navigatesToUrl() throws IOException {
       driver = BrowerInvoke.openBrowser();  // Acutal Property
    }

    @When("User Enters valid Username and Password")
    public void userEntersValidCredantials() {
        TextBoxHelper textBoxHelper = TextBoxHelper.getInstance(driver);
        textBoxHelper.enterText(By.name("username"),"Admin");
        textBoxHelper.enterText(By.name("password"),"admin123");
    }

    @And("User Clicks the Login Button")
    public void userClicksLoginBtn() {
       ActionsHelper actionsHelper = ActionsHelper.getInstance(driver);
       actionsHelper.clickElement(By.xpath("//button[text()=' Login ']"));
       actualText = actionsHelper.getTextValue(By.xpath("//span[contains(@class,'header-breadcrumb')]/child::h6"));
    }

    @Then("Validate System navigates to Home Page")
    public void navigatesToHomePage() {
        Assert.assertEquals("Dashboard",actualText);
    }




}
