package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[text()='Parita Patel']")
    WebElement userNameLabel;

    @FindBy(xpath = "//*[@class='users icon']")
    WebElement contactLink;

    @FindBy(xpath = "//button[@class='ui linkedin button']/i[@class='edit icon']")
    WebElement newCOntactLink;


    @FindBy(xpath = "//*[@class='money icon']")
    WebElement dealsLink;

    @FindBy(xpath = "//*[@class='tasks icon']")
    WebElement tasksLink;

    //Intialization the page Objects
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePage(){
        return driver.getTitle();

    }
    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();

    }

    public ContactsPage clickOnContactsLinks(){
        contactLink.click();
        return new ContactsPage();
    }
    public DealsPage clickOnDealsLinks(){
        dealsLink.click();
        return new DealsPage();
    }
    public TaskPage clickOnTasksLinks(){
        tasksLink.click();
        return new TaskPage();
    }
    public void clickOnNewContactLInk(){
        //Here action class need for mouseover movement,
        // without it it was not able to move to the right side of the page

        Actions actions = new Actions(driver);
        actions.moveToElement(contactLink).build().perform();
        newCOntactLink.click();

    }

}
