package com.weborders.step_definitions;

import com.weborders.pages.CreateOrderPage;
import com.weborders.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CreateOrderStepDefinitions {
    // Page Object We implemented our logic in page object
    // in here step_definitions we create instantiate of page object
    // any webelement issues related page object class
    // here we only call getters
    LoginPage loginPage = new LoginPage();
    CreateOrderPage createOrderPage = new CreateOrderPage();



    @When("user enter address information:")
    public void userEnterAddressInformation(List<Map<String,String>> data){
        createOrderPage.enterCustomerName(data.get(0).get("Customer name"));
        createOrderPage.enterStreet(data.get(0).get("Street"));
        createOrderPage.enterCity(data.get(0).get("City"));
        createOrderPage.enterState(data.get(0).get("State"));
        createOrderPage.enterZip(data.get(0).get("Zip"));

    }

    @And("User enter payment information")
    public void userEnterPaymentInformation(List<Map<String,String>> data) {
        createOrderPage.selectCardType(data.get(0).get("Card"));
        createOrderPage.enterCardNumber(data.get(0).get("Card Nr:"));
        createOrderPage.enterExpireDate(data.get(0).get("Expire date (mm/yy)"));

    }

    @And("user click on process button")
    public void userClickOnProcessButton() {
        createOrderPage.clickProcessButton();
    }

    @Then("system should displayed {string}")
    public void systemShouldDisplayed(String arg0) {
        Assert.assertEquals(arg0,createOrderPage.displayedMessage());
    }

   /* @And("user navigates to {string} page")
    public void userNavigatesToPage(String arg0) {
        loginPage.navigateTo(arg0);
    }
*/
    @Then("user verifies that order is displayed")
    public void userVerifiesThatOrderIsDisplayed(List<String >data) {
        Assert.assertEquals(data,loginPage.listOfelements());

    }
}



