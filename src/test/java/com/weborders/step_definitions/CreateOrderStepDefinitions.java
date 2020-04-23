package com.weborders.step_definitions;

import com.weborders.pages.CreateOrderPage;
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

    CreateOrderPage createOrderPage = new CreateOrderPage();

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

}



