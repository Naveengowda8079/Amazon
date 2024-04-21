//package basepage;
//
//import org.openqa.selenium.WebDriver;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class BasePage {
//    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    public static Map<String,String> basePageGlobalHashMap = new LinkedHashMap<String,String>();
//
//    public static WebDriver extendDriver()
//    {
//        return driver.get();
//    }
//    public static void closeDriver(){
//        driver.get().quit();
//    }
//}
