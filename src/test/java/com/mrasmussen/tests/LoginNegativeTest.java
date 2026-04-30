package com.mrasmussen.tests;

import com.mrasmussen.pages.LoginPage;
import com.mrasmussen.pages.SecureAreaPage;
import com.mrasmussen.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTest extends BaseTest {

    @Test(description = "error for invalid login")
    public void shouldShowErrorForInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        SecureAreaPage secureAreaPage = loginPage.login("wronguser", "wrongPass!12");


        Assert.assertTrue(loginPage.getFlashMessage().contains("Your username is invalid"),"Expect invalid username error message");
        }
}
