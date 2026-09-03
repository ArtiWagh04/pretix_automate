package testRunners;

import io.cucumber.core.cli.Main;

public class TestRunner {

	public static void main(String[] args) {

		Main.main(new String[]{
				"--glue", "stepDefinitions",
				"--glue", "AppHooks",
				"src/test/resources/com/AppFeatures",
				"--plugin", "pretty",
				"--plugin", "rerun:target/rerun.txt"
		});
	}
}