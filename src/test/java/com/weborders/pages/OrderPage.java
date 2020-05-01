package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage{


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
        Select select = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue(value);
    }


    @FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
    protected WebElement customerName ;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
    protected WebElement street ;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
    protected  WebElement city ;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    protected  WebElement state ;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    protected WebElement zipcode ;


    public void enterAdressInformation(String name, String street, String city, String state, String zip){
    // work on this method to come up with less code.
    }

    public void enterCustomerName(String value){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(customerName)).sendKeys(value);
        BrowserUtilities.wait(2);
    }
    public void enterStreet (String value){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(street)).sendKeys(value);
        BrowserUtilities.wait(2);
    }
    public void enterCity(String value){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(value);
        BrowserUtilities.wait(2);
    }
    public void enterState(String value){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(state)).sendKeys(value);
        BrowserUtilities.wait(2);
    }
    public void enterZip(String value){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(zipcode)).sendKeys(value);
        BrowserUtilities.wait(4);
    }


    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    protected WebElement card ;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    protected WebElement cardNumber ;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    protected WebElement expireDate ;


    public void selectCardType(String value){
        BrowserUtilities.wait(2);
        if(value.equalsIgnoreCase("visa")){
            wait.until(ExpectedConditions.visibilityOf(card)).click();
        }else {
            System.out.println("Invalid data type");
        }
    }
    public void enterCardNumber(String value) {
        BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.visibilityOf(cardNumber)).sendKeys(value);
        BrowserUtilities.wait(2);
    }
    public void enterExpireDate(String value) {

        wait.until(ExpectedConditions.visibilityOf(expireDate)).sendKeys(value);
        BrowserUtilities.wait(2);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    protected WebElement processButton ;

    public void clickProcessButton(){
        BrowserUtilities.wait(1);
        processButton.click();
        BrowserUtilities.wait(2);

    }

    @FindBy (tagName = "strong")
    protected  WebElement displayMessage ;

    public String displayedMessage(){
        BrowserUtilities.wait(2);
        return displayMessage.getText();
    }



}


