package com.weborders.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/weborders/step_definitions",
        dryRun = false,

        tags = "@Create_Order",

        plugin = {"html:target/default-report",
                "json:target/cucumber1.json"
        }
)
public class CucumberRunner {

}
