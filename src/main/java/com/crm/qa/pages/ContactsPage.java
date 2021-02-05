package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div[text()='Contacts']")
    WebElement contactsLabel;

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



}
