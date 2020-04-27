package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,30);


    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public void navigateTo(String module){
        BrowserUtilities.wait(4);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+module+"']"))).click();
       BrowserUtilities.wait(3);
       BrowserUtilities.waitForPageToLoad(15);

    }

    @FindBy(xpath = "//table[1]//tbody//tr[2]//td/following-sibling::td")
    protected List<WebElement> newOrder ;

    public List<String> listOfelements(){
        BrowserUtilities.wait(3);
        BrowserUtilities.waitForPageToLoad(14);
        return BrowserUtilities.getTextFromWebElements(newOrder);

    }

}
