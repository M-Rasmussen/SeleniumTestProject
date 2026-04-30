package com.mrasmussen.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
 if (!result.isSuccess()) {
        takeScreenshot(result.getName());
    }

    if (driver != null) {
        driver.quit();
    }
}

private void takeScreenshot(String testName) {
    try {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destination = Path.of("screenshots", testName + ".png");
        Files.createDirectories(destination.getParent());
        Files.copy(screenshot.toPath(), destination);
    } catch (IOException e) {
        System.out.println("Failed to capture screenshot: " + e.getMessage());
    }
    }
}
