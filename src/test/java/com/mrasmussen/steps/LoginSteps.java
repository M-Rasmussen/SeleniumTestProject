package com.mrasmussen.steps;

import com.mrasmussen.pages.LoginPage;
import com.mrasmussen.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = DriverFactory.createDriver("chrome", false);
        loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.open();
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see the secure area")
    public void iShouldSeeTheSecureArea() {
        Assert.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area"));
    }

    @Then("I should see an invalid username error")
    public void iShouldSeeInvalidUsernameError() {
        Assert.assertTrue(loginPage.getFlashMessage().contains("Your username is invalid"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}