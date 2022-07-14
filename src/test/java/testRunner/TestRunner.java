package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = "classpath:features",
        glue = "stepDef",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = ""
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
