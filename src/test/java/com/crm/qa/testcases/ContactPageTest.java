package com.crm.qa.testcases;



import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    String sheetName ="contacts";

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
    public void verifyContactlabel() {
        Assert.assertTrue(contactsPage.verifyContactLabel(), "contactlabel is missing on the page");
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

    /*
    This code is for excel file, Data driven approch (1)
        giving parameter in the method only need when we created dataprovider for the excel sheet,
         otherwise dont provide this fisrtsname.middlename,lastname and company,without it for the dataprovider,gives error

     */
//
//    @DataProvider
//    public Object[][] getCRMTestData() {
//       Object data[][]= TestUtil.getTestData(sheetName);
//       return data;
//    }
//
//    @Test(priority = 2 ,dataProvider = "getCRMTestData")
//    public void validateCreateNewContact(String firstName,String middleName, String lastName, String company){
//        homePage.clickOnNewContactLInk();
//        contactsPage.createNewContact(firstName,middleName,lastName,company);
//    }




//This code is without excl file , for without data driven apporch (2)
    @Test(priority = 2)
    public void validateCreateNewContact() {
        homePage.clickOnNewContactLInk();
        contactsPage.createNewContact("Rosy", "K", "James", "Amazon");

//        number 1 and 2 methods are almost same only diff is one is require with data driven approch ,
//         and one without data driven approch.

    }
    @AfterMethod
    public void tearDown(){
     //  driver.quit();
    }
}

