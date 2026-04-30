package com.mrasmussen.tests;

import com.mrasmussen.pages.LoginPage;
import com.mrasmussen.pages.SecureAreaPage;
import com.mrasmussen.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Valid user can log in successfully")
    public void validLoginDisplaysSecureArea() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(secureAreaPage.getHeadingText(), "Secure Area");
        Assert.assertTrue(secureAreaPage.isLogoutButtonVisible(), "Logout button should be visible after login.");
    }
}
