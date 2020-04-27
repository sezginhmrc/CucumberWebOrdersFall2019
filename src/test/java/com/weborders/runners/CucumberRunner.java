package com.weborders.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


// this runner class allows us to kick off cucumber test
// by providing paths though cucumber options


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/weborders/step_definitions",
        dryRun = false,
        tags = "@Smoke_Test",
        plugin = {"html:target/default-report",
                "json:target/cucumber1.json"
        }
)
public class CucumberRunner {

}
