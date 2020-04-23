package com.weborders.pages;

import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

    @FindBy(id = "ctl00_MainContent_username")
    protected WebElement username ;

    @FindBy(id = "ctl00_MainContent_password")
    protected  WebElement password ;

    public void login(){
       String userNameData =  ConfigurationReader.getProperty("username");
       String passwordData = ConfigurationReader.getProperty("password");

       username.sendKeys(userNameData);
       password.sendKeys(passwordData, Keys.ENTER);

    }

}
