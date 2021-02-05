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


public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public ContactPageTest() {
        super();//calling testbase class
    }

    @BeforeMethod
    public void setUp() {
        intialization();

        contactsPage = new ContactsPage();

        testUtil = new TestUtil();//use when testutil method switchtoframe required.

        loginPage = new LoginPage();//create loginpage object to access loginpage method ,to login into application
        //to reach homePage we have to login first

        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        //testUtil.switchToFrame();//if there is frame available , no need to write frame in the Testcases

        contactsPage = homePage.clickOnContactsLinks();//contactlinkpage method is available in the homepage

    }
    @Test(priority = 1)
    public void verifyContactlabel(){
        Assert.assertTrue(contactsPage.verifyContactLabel(),"contactlabel is missing on the page");
    }
//    @Test(priority = 2)
//    public void selectSingleContactList(){
//        contactsPage.selectContactByName("Parita Chirag Patel");
//    }
//    @Test(priority = 3)
//    public void selectMultiplyContactList(){
//        contactsPage.selectContactByName("Parita Chirag Patel");
//        contactsPage.selectContactByName("Chirag I Patel");
//        contactsPage.selectContactByName("Saumyaa Chirag Patel");
  //  }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

