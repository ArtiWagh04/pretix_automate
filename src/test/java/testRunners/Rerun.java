package testRunners;

import io.cucumber.core.cli.Main;

public class Rerun {

        public static void main(String[] args) {

                Main.main(new String[]{
                        "@target/rerun.txt",
                        "--glue", "stepDefinitions",
                        "--plugin", "pretty",
                        "--plugin", "html:target/rerun-report.html",
                        "--plugin", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                });
        }
}