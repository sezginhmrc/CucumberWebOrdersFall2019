package com.weborders.step_definitions;

import com.weborders.pages.OrderPage;
import com.weborders.pages.LoginPage;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    OrderPage orderPage = new OrderPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on Login Page ");
        Driver.getDriver("chromeheadless").get(ConfigurationReader.getProperty("url"));
        System.out.println("Open :: "+ConfigurationReader.getProperty("url"));
    }


    @Given("user logs in")
    public void user_logs_in() {
        System.out.println("User Login as a Tester");
        loginPage.login();
        System.out.println("User logs in as :: " +ConfigurationReader.getProperty("username"));
    }


    @Given("navigates to {string} page")
    public void navigates_to_page(String string) {
        System.out.println("User navigates to :: " +string+ " page");
        loginPage.navigateTo(string);
        // double qurotes defines variable in test steps as a string we get it here it comes from there
    }

    @When("user enter product information:")
    public void userEnterProductInformation(List<Map<String, String>> dataTable) {
        System.out.println("User Enter Product information");
            orderPage.selectProduct(dataTable.get(0).get("Product"));
            orderPage.enterQuantity(dataTable.get(0).get("Quantity"));
            orderPage.enterPricePerUnit(dataTable.get(0).get("Price per unit"));
            orderPage.enterDiscount(dataTable.get(0).get("Discount"));

    }

    @And("user clicks on Calculate Button")
    public void userClicksOnCalculateButton() {
        System.out.println("User click on calculate button");
        orderPage.clickCalculate();
    }

    @Then("user should verify that total {string} is displayed")
    public void userShouldVerifyThatTotalIsDisplayed(String value) {
        Assert.assertEquals(value, orderPage.getTotalValue());

    }
    //@Given("user navigates to {string} page")
    //public void user_navigates_to_page(String string) {
    //    System.out.println("User clicks on the tab and navigates to, "+ string);
    //    loginPage.navigatesTo(string);
    //}
}
