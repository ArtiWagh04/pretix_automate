package testRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	
	    features = "src/test/resources/com/AppFeatures",
	    glue = {"stepDefinitions", "AppHooks"},
	    plugin = {"pretty"}
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}

