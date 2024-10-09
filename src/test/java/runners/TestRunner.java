package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", // Path to feature files
		glue = "stepdefinitions", // Path to step definitions
		plugin = { "pretty", "html:target/cucumber-reports.html" }, // Reporting options
		publish = false)
public class TestRunner extends AbstractTestNGCucumberTests {
}
