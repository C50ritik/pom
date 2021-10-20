package com.crm.qa.pages;

import com.crm.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseClass {
    //Page Factory -Object Repository.
    @FindBy(name = "username")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement logInButton;
    @FindBy(xpath = "//a[@href=\"https://classic.freecrm.com/register/\"]")
    WebElement signUpButton;
    @FindBy(xpath = "//img[@class='img-responsive']")
    WebElement crmLogo;

    //Intializing the page objects.
    public LogInPage(){
        PageFactory.initElements(driver,this);
    }
    public String validateLogInPageTitle(){
        return driver.getTitle();
    }
    public boolean validateCrmImg(){
        return crmLogo.isDisplayed();
    }
    public void login(String un,String pw){
        username.sendKeys(un);
        password.sendKeys(pw);
        logInButton.click();
    }
}
