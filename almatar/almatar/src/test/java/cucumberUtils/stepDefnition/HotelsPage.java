package cucumberUtils.stepDefnition;

import basepage.DriverController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lib.SeleniumUserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class HotelsPage extends pages.HotelsPage {
    @And("user click on {string} button on Hotels page")
    public void userClickOnButtonOnHotelsPage(String arg0) {
        try {
           SeleniumUserAction.synchronizationMethods(getAvailableroombutton());
            getAvailableroombutton().click();
        } catch (Exception e) {
            e.printStackTrace();
            SeleniumUserAction.ErrorValidation(false, "not switched child window");
        }
    }


}
