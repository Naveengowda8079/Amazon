package basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DriverController {
    private static DriverController extendeddriver;

    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    private DriverController() {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--test-type");
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
//        options.addArguments("--disable-geolocation");
//        options.addArguments("--enable-strict-powerful-feature-restrictions");
        options.addArguments("--safebrowsing-disable-extension-blacklist");
//        options.addArguments("--safebrowsing-disable-download-protection");
        chromePrefs.put("profile.default_content_setting_values.geolocation", 2);
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {

        if (extendeddriver==null) {
            extendeddriver = new DriverController();
        }
    }

    public static void tearDown() {

        if(driver!=null) {
            driver.close();
            driver.quit();
        }

        extendeddriver = null;
    }

}

