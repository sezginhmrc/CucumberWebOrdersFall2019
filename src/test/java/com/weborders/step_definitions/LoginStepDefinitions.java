package com.weborders.step_definitions;

import com.weborders.pages.CreateOrderPage;
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
    CreateOrderPage createOrderPage = new CreateOrderPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on Login Page ");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @Given("user logs in")
    public void user_logs_in() {
        System.out.println("User Login as a Tester");
        loginPage.login();
    }

    @Given("navigates to {string} page")
    public void navigates_to_page(String string) {
        System.out.println("User navigates to :: " +string);
        loginPage.navigateTo(string);
    }

    @When("user enter product information:")
    public void userEnterProductInformation(List<Map<String, String>> dataTable) {
        System.out.println("User Enter Product information");
            createOrderPage.selectProduct(dataTable.get(0).get("Product"));
            createOrderPage.enterQuantity(dataTable.get(0).get("Quantity"));
            createOrderPage.enterPricePerUnit(dataTable.get(0).get("Price per unit"));
            createOrderPage.enterDiscount(dataTable.get(0).get("Discount"));

    }

    @And("user clicks on Calculate Button")
    public void userClicksOnCalculateButton() {
        System.out.println("User click on calculate button");
        createOrderPage.clickCalculate();
    }

    @Then("user should verify that total {string} is displayed")
    public void userShouldVerifyThatTotalIsDisplayed(String value) {
        Assert.assertEquals(value,createOrderPage.getTotalValue());

    }
    //@Given("user navigates to {string} page")
    //public void user_navigates_to_page(String string) {
    //    System.out.println("User clicks on the tab and navigates to, "+ string);
    //    loginPage.navigatesTo(string);
    //}
}
