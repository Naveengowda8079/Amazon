package lib;

import basepage.DriverController;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;
import java.util.Locale;

//------------------------------
//   Author : Shridhara k d
//-----------------------------
public class SeleniumUserAction {
    public static String result_Date = "";
//static WebDriverWait wait = new WebDriverWait(DriverController.getDriver(), Duration.ofSeconds(10));

    public static boolean selcetvaluefromdropdown(WebElement element, String value) {
        boolean isselect = false;
        String val;
        try {
            Select select = new Select(element);
            List<WebElement> list = select.getAllSelectedOptions();
            for (WebElement alloption : list) {
                if (alloption.getText().equalsIgnoreCase(value)) {
                    alloption.click();
                    isselect = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isselect;
    }

    public static void ErrorValidation(boolean s, String result) {
        Assert.assertTrue(s, result);
    }

    public static boolean click(WebElement webElement) {
        boolean isClicked = false;
        try {
            ((JavascriptExecutor) DriverController.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
            webElement.click();
            isClicked = true;
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            isClicked = false;
        }
        return isClicked;
    }

    public static void clearText(WebElement webElement) {
        webElement.clear();
    }

    public static boolean setElementText(WebElement webElement, String text) {
        boolean isSetText = false;
        try {
            synchronizationMethods(webElement);
            clearText(webElement);
            webElement.sendKeys(text);
            isSetText = true;
        } catch (Exception e) {
            e.printStackTrace();
            isSetText = false;
        }
        return isSetText;
    }

    public static void synchronizationMethods(WebElement webElement) {
//        WebDriverWait wait = new WebDriverWait(DriverController.getDriver(), Duration.ofSeconds(60));
//        wait.until(ExpectedConditions.visibilityOf(webElement));
//        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void entertheelemtvalue(WebElement webElement, String ObjToSetText) {
        SeleniumUserAction.synchronizationMethods(webElement);
        SeleniumUserAction.setElementText(webElement, ObjToSetText);
    }

    public static boolean selcetvaluefromcombobox(List<WebElement> element, String value) {
        String alloption = "";
        boolean flag = false;
        Actions action = new Actions(DriverController.getDriver());
        for (WebElement option : element) {
            alloption = option.getText();
            System.out.println(alloption);
            if (option.getText().contains(value)) {
                action.moveToElement(option).click(option).build().perform();
                System.out.println("Trying to select: " + value);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            {
                SeleniumUserAction.ErrorValidation(false, value + " is not seleted from the combobox");
            }
        }
        return flag;
    }

    public static void userEnterTheRandomToField(WebElement element, String datatype, String strValueToSet) {
        Faker faker = new Faker(new Locale("en-US"));
        switch (datatype.toUpperCase()){
            case "FIRSTNAME":
                strValueToSet=faker.name().firstName();
                SeleniumUserAction.entertheelemtvalue(element, strValueToSet);
                break;
            case "LASTNAME":
                strValueToSet=faker.name().lastName();
                SeleniumUserAction.entertheelemtvalue(element, strValueToSet);
                break;
            case "PHONENUMBER":
                strValueToSet = RandomStringUtils.randomNumeric(10);
                SeleniumUserAction.entertheelemtvalue(element, strValueToSet);
                break;
            case "EMAIL":
                strValueToSet=faker.name().firstName();
                SeleniumUserAction.entertheelemtvalue(element, strValueToSet +"@yopmail.com");
                break;
            default:
                System.out.println("Step - Set Random data to field - Please use proper data selection");
        }
    }
}

