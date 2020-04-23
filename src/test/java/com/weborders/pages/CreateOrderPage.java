package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrderPage extends BasePage{


    @FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
    protected  WebElement quantity ;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    protected WebElement pricePerUnit ;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    protected  WebElement discount ;


    @FindBy(xpath = "//input[@type='submit']")
    protected WebElement calculate;


    @FindBy (xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtTotal']")
    protected WebElement totalValue ;


    public String getTotalValue(){
        BrowserUtilities.wait(3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtTotal']")));
        return totalValue.getAttribute("value");
    }
    public void clickCalculate(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
        wait.until(ExpectedConditions.visibilityOf(calculate)).click();
    }

    public void enterDiscount(String value){
        BrowserUtilities.wait(3);
        wait.until(ExpectedConditions.visibilityOf(discount)).clear();
        BrowserUtilities.wait(3);
        discount.sendKeys(value);
        BrowserUtilities.wait(3);
    }
    public void enterPricePerUnit(String value){
        BrowserUtilities.wait(3);
        wait.until(ExpectedConditions.visibilityOf(pricePerUnit)).clear();
        BrowserUtilities.wait(3);
        pricePerUnit.sendKeys(value);
    }
    public void enterQuantity (String value){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(quantity)).clear();
        BrowserUtilities.wait(3);
        quantity.sendKeys(value);
    }
    public  void selectProduct(String value){
        BrowserUtilities.waitForPageToLoad(3);
        System.out.println("Product type :: " +value);
        Select select = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue(value);
    }


}


