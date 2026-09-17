//package testRunners;
//
//import io.cucumber.core.cli.Main;
//
//public class TestRunner {
//
//	public static void main(String[] args) {
//
//		Main.main(new String[]{
//				"--glue", "stepDefinitions",
//				"--glue", "AppHooks",
//				"src/test/resources/com/AppFeatures",
//				"--plugin", "pretty",
//				"--plugin", "rerun:target/rerun.txt"
//		});
//	}
//}

package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		features = "src/test/resources/com/AppFeatures",
		glue = {
				"stepDefinitions",
				"AppHooks"
		},
		plugin = {
				"pretty",
				"rerun:target/rerun.txt",
				"html:target/cucumber-report.html",
//				"io.qameta.allure.testng.AllureTestNg"
		},
		monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}