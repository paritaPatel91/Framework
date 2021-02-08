package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*parita patel*/


public class HomePageTest extends TestBase {//using extends to inheritant Testbase class properties

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();//calling testbase class
    }

    @BeforeMethod
    public void setUp() {
        intialization();
        contactsPage = new ContactsPage();
        testUtil = new TestUtil();//use when testutil method switchtoframe required.
        loginPage = new LoginPage();//create loginpage object to access loginpage method ,to login into application
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        //to reach homePage we have to login first

    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() throws InterruptedException {
        String homePageTitle = homePage.verifyHomePage();
        Assert.assertEquals(homePageTitle, "Cogmento CRM", "Title is not matched");

    }

    @Test(priority = 2)
    public void veryUserNameTest(){
        Assert.assertTrue(homePage.verifyCorrectUserName());
        //testUtil.switchToFrame();//for the frames when required


}

     @Test(priority = 3)
     public void verifyContacrLink(){
          contactsPage = homePage.clickOnContactsLinks();

     }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

}
