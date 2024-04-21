package cucumberUtils;
import basepage.DriverController;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;


import java.io.IOException;
import java.util.Set;

public class Hooks {
    static WebDriver driver;

    @Before()
    public void beforeHooks(Scenario scenario) throws IOException {
        System.out.println("Before Hooks Started...");
        if (System.getProperty("EnvironmentConfigFile") == null) {
            System.setProperty("EnvironmentConfigFile", "Project");
        }
        if (!System.getProperty("EnvironmentConfigFile").contains("config.properties")) {
            System.setProperty("EnvironmentConfigFile", "src/main/resources/properties/" + System.getProperty("EnvironmentConfigFile") + "_config.properties");
        }
        DriverController.setUpDriver();
    }


    @After
    public void afterHooks(Scenario scenario) {
        System.out.println("After Hooks Started... ");
        String alltags = scenario.getSourceTagNames().toString();
        String[] tags = alltags.split(",");
        String testCasename = scenario.getName().replaceAll(" ", "_");
        for (int i = 0; i < tags.length; i++) {
            if (tags[i].contains("@tc")) {
                testCasename = tags[i];
                break;
            }
        }

        if (DriverController.getDriver() != null)
            try {
                Set<String> windowhandle = DriverController.getDriver().getWindowHandles();
                for (String windows : windowhandle) {
                    DriverController.getDriver().switchTo().window(windows);
                    DriverController.getDriver().close();
                }
                DriverController.getDriver().quit();
            } catch (Exception e) {
                e.printStackTrace();

            }
    }

}