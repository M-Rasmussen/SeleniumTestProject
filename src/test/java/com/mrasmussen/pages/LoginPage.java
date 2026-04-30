package com.mrasmussen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    // Example of a dynamic XPath selector for ATS alignment and maintainable UI targeting.
    private final By flashMessageByText = By.xpath("//div[@id='flash' and contains(., 'You logged into a secure area!')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void enterUsername(String username) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        input.clear();
        input.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        input.clear();
        input.sendKeys(password);
    }

    public SecureAreaPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new SecureAreaPage(driver);
    }

    public SecureAreaPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLogin();
    }

    public boolean isSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessageByText)).isDisplayed();
    }
    
    public String getFlashMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage)).getText();
    }
}
