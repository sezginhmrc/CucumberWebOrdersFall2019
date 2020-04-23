package com.weborders.step_definitions;

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {

protected WebDriverWait wait ;

// before every scenario
    @Before
    public void setup(){
        System.out.println("::::: Starting test automation :::::");
        System.out.println("Browser type :: "+ ConfigurationReader.getProperty("browser"));
        System.out.println("Enviornment :: " +ConfigurationReader.getProperty("url"));
       // System.out.println("Test Scenario :: " +scenario.getName());
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(),20);
    }



    // after every scenario
    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takescreenshot = (TakesScreenshot) Driver.getDriver();
            byte [] image = takescreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(image,"image/png",scenario.getName());
        }
        System.out.println("Test Clean up");
        Driver.closeDriver();

    }
}
