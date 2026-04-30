package com.mrasmussen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecureAreaPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By heading = By.tagName("h2");
    private final By logoutButton = By.cssSelector("a.button.secondary.radius");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(heading)).getText();
    }

    public boolean isLogoutButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();
    }
}
