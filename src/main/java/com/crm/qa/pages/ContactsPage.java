package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    //pagefactory

    @FindBy(xpath = "//div[text()='Contacts']")
    WebElement contactsLabel;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='middle_name']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;

    @FindBy(xpath = "//div[@name='company']/input[@class='search']")
    WebElement company;

    @FindBy(xpath = "//*[@class='ui linkedin button']")
    WebElement saveBtn;


    //Intialization the page Objects
    public ContactsPage() {
        PageFactory.initElements(driver,this);
    }
    public boolean verifyContactLabel(){
        return contactsLabel.isDisplayed();
    }

    public void selectContactByName(String name){//contact checkbox x-path
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']")).click();
    }
    public void createNewContact(String ftName,String mdName , String ltName ,String comp ){
        firstName.sendKeys(ftName);
        middleName.sendKeys(mdName);
        lastName.sendKeys(ltName);
        company.sendKeys(comp);
        saveBtn.click();

    }






}
