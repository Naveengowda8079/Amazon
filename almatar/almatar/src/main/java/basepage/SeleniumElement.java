package basepage;
import exception.InvalidLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Jsonutils;

import java.io.IOException;

public class SeleniumElement {
    static WebDriver driver;
    public static SeleniumLocator locatorType;
    public static String locatorString;

    public SeleniumElement(WebDriver driver, String pageClassName, String elementName) {
        SeleniumElement.driver = driver;

        String elementVal;

        String className = pageClassName.concat("Locators");

        Jsonutils jsonUtils = new Jsonutils();
        elementVal = jsonUtils.getLocatorAndValuefromJson(className, elementName);
        String[] arrayOfElementVal = elementVal.split("##");
        SeleniumElement.locatorType = SeleniumLocator.valueOf(arrayOfElementVal[0]);
        SeleniumElement.locatorString = arrayOfElementVal[1];
    }
    public static By getObject(SeleniumLocator locatorType, String locatorString) {
        By locator = null;

        if (locatorType == SeleniumLocator.XPath)
            locator = By.xpath(locatorString);
        else if (locatorType == SeleniumLocator.CssSelctor)
            locator = By.cssSelector(locatorString);
        else if (locatorType == SeleniumLocator.ID)
            locator = By.id(locatorString);
        else if (locatorType == SeleniumLocator.Name)
            locator = By.name(locatorString);
        else if (locatorType == SeleniumLocator.ClassName)
            locator = By.className(locatorString);
        else if (locatorType == SeleniumLocator.LinkText)
            locator = By.linkText(locatorString);
        else if (locatorType == SeleniumLocator.TagName)
            locator = By.tagName(locatorString);
        else if (locatorType == SeleniumLocator.PartialLinkText)
            locator = By.partialLinkText(locatorString);


        if (locator == null) {
            try {
                throw new InvalidLocator(locatorType,  locatorString);
            } catch (InvalidLocator e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return locator;
    }
    }



