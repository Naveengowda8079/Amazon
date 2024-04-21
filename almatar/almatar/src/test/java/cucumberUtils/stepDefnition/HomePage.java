package cucumberUtils.stepDefnition;

import basepage.DriverController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import lib.SeleniumUserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.ReadPropartyFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class HomePage extends pages.HomePage {

    @Given("user login to {string} web admin portal")
    public void userLoginToWebAdminPortal(String url) throws IOException {
        DriverController.openPage(ReadPropartyFile.readProperty("URL"));
    }
    @And("user switch to add cart window")
    public void userSwitchtoWindow(String button) throws InterruptedException {
    	String parentWindow = DriverController.getDriver().getWindowHandle();

    	Set<String> handles =  DriverController.getDriver().getWindowHandles();
    	   for(String windowHandle  : handles)
    	       {
    	       if(!windowHandle.equals(parentWindow))
    	          {
    	    	   DriverController.getDriver().switchTo().window(windowHandle);
//    	         driver.close(); //closing child window
//    	    	   DriverController.getDriver().switchTo().window(parentWindow); //cntrl to parent window
    	          }
    	       }

    }

    
	@Then("user select {int} item in the result list")
    public void userEnterSelectValueFromresult(int num) {
        boolean flag = false;
        List<WebElement> optionsToSelect = getDestinationcombobox();
        Actions action = new Actions(DriverController.getDriver());
        for(int i=0; i <optionsToSelect.size(); i++) {
        	if(optionsToSelect.get(i).equals(num)) {
        	action.moveToElement(optionsToSelect.get(i)).click(optionsToSelect.get(i)).build().perform();
        	  flag = true;
              break;
        }
        }
        if (flag == false) {
            {
                SeleniumUserAction.ErrorValidation(false, num+ " item is not seleted from the result list");
            }
        }
    }
    @Then("user enter cityname {string} to desination textbox and select value from combobox")
    public void userEnterCitynameToDesinationTextboxAndSelectValueFromCombobox(String cityname) {
        getDestinationsearchbox().sendKeys(cityname);
        String alloption = "";
        boolean flag = false;
        List<WebElement> optionsToSelect = getDestinationcombobox();
        Actions action = new Actions(DriverController.getDriver());
        for (WebElement option : optionsToSelect) {
            alloption = option.getText();
            System.out.println(alloption);
            if (option.getText().contains(cityname)) {
                action.moveToElement(option).click(option).build().perform();
                System.out.println("Trying to select: " + cityname);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            {
                SeleniumUserAction.ErrorValidation(false, cityname + " is not seleted from the combobox");
            }
        }
    }
    @And("user verify the {string} text is displayed")
    public void userVerifyTheIsDisplayed(String text) {
        boolean flag = false;
        if (getNightcounttext().getText().equals(text)) {
            System.out.println("Actual text is " + getNightcounttext().getText() + " Expected text is " + text);
            System.out.println("Text is displayed");
            flag = true;
        }

        if (flag == false) {

            System.out.println("Text is not displayed web admin portal");
        }
    }

    @And("user click on {string} button on home page")
    public void userClickOnButton(String button) throws InterruptedException {
        SeleniumUserAction.synchronizationMethods(getSearchbutton());
        getSearchbutton().submit();
    }

    @And("user select {string} date from the departure calender and {string} date from the arrival calender")
    public void userSelectDateFromTheDepartureCalenderAndDateFromTheArrivalCalender(String departure, String arrival) {
        try {
            getDeparturedatebutton().click();
            SimpleDateFormat sdf = new SimpleDateFormat("d");
            // Creating a calendar
            Calendar cal = Calendar.getInstance();
            Calendar call = Calendar.getInstance();
           cal.roll(Calendar.DATE, 1);
            call.roll(Calendar.DATE, 4);
            departure = sdf.format(cal.getTime());
            arrival = sdf.format(call.getTime());
//            DriverController.getDriver().findElement(By.xpath("//table[@class='month1']//div[@class='day toMonth valid tmp hovering' and text()='" + departure + "']
//                    DriverController.getDriver().findElement(By.xpath("//table[@class='month1']//div[@class='day toMonth valid tmp hovering' and text()='" + arrival + "']

            DriverController.getDriver().findElement(By.xpath("//table[@class='month1']//div[contains(text(),'" + departure + "')]")).click();
            DriverController.getDriver().findElement(By.xpath("//table[@class='month1']//div[contains(text(),'" + arrival + "')]")).click();

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            SeleniumUserAction.ErrorValidation(false, departure + "and " + arrival + "is not seleted not selected");
        }
    }
    @And("user fetch the product price into {price} varibale")
    public void userVerifyIsDisplayed(String text) {
        boolean flag = false;
        if (getNightcounttext().getText().equals(text)) {
            System.out.println("Actual text is " + getNightcounttext().getText() + " Expected text is " + text);
            System.out.println("Text is displayed");
            flag = true;
        }

        if (flag == false) {

            System.out.println("Text is not displayed web admin portal");
        }
    }
    @And("user verify the price is identical to the product page price {price}")
    public void userVerifyDisplayed(String text) {
        boolean flag = false;
        if (getNightcounttext().getText().equals(text)) {
            System.out.println("Actual text is " + getNightcounttext().getText() + " Expected text is " + text);
            System.out.println("Text is displayed");
            flag = true;
        }

        if (flag == false) {

            System.out.println("Text is not displayed web admin portal");
        }
    }
    
    @And("user verify sub total price is identical to the product page {price}")
    public void userVerifyCompare(String text) {
        boolean flag = false;
        if (getNightcounttext().getText().equals(text)) {
            System.out.println("Actual text is " + getNightcounttext().getText() + " Expected text is " + text);
            System.out.println("Text is displayed");
            flag = true;
        }

        if (flag == false) {

            System.out.println("Text is not displayed web admin portal");
        }
    }
}