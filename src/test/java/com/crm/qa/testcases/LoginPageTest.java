package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        super();//calling testbase class
    }

    @BeforeMethod
    public void setUp(){
        intialization();
        loginPage = new LoginPage();
        //here we have created Object so we can access all the functionality of loginpage class

    }
    @Test(priority = 1)
    public void loginPageTitleTest(){
      String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud");//for validattion
    }
    @Test(priority = 2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest(){

        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @AfterMethod
    public void teatDown(){

        driver.quit();
    }

}
