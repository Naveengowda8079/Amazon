package cucumberUtils;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@ExtendedCucumberOptions(jsonReport = "target/cucumber-reports/cucumber.json"
// @r
//
//
//)

@CucumberOptions(features = {"src/features"},

        glue = {"cucumberUtils"},
        plugin = {
                "junit:target/cucumber-report/cucumber.xml",
                "pretty:target/cucumber-report/cucumber-pretty.txt",
                "usage:target/cucumber-report/cucumber.json",
                "rerun:target/rerun.txt"},

       tags = "@Hotelbooking",

        monochrome = true
)
public class Runner {


    @BeforeClass
    public static void testApi() throws Throwable {
        if (System.getProperty("EnvironmentConfigFile") == null) {
            System.setProperty("EnvironmentConfigFile", "Project");
        }
        if (!System.getProperty("EnvironmentConfigFile").contains("config.properties")) {
            System.setProperty("EnvironmentConfigFile", "src/main/resources/properties/" + System.getProperty("EnvironmentConfigFile") + "_config.properties");
        }


    }
}
