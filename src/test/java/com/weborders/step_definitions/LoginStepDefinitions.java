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

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on Login Page ");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
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


}
