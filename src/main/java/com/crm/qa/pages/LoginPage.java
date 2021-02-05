package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //pagefactory - OR(object repo)

    @FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
    WebElement loginMenu;

    @FindBy(name ="email")
    WebElement userEmail;

    @FindBy(name ="password")
    WebElement userPass;

    @FindBy(xpath = "//div[text()='Login']")
    WebElement loginBtn;


    @FindBy(xpath = "//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
    WebElement signUpBtn;

    @FindBy(xpath = "//div[@class='rd-navbar-panel']")
    WebElement crmLOgo;

    //Intializing the page Objects:
    public LoginPage() {
        PageFactory.initElements(driver,this);//this means current class
    }

    //Actions/Methods
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
       return crmLOgo.isDisplayed();
    }

    public HomePage login(String ue,String pwd){
        loginMenu.click();
        userEmail.sendKeys(ue);
        userPass.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();//after login page goes to Homepage ,so we use Homepage class here
    }




}
