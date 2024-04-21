package cucumberUtils.stepDefnition;

import basepage.DriverController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lib.SeleniumUserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BookingDetailsPage extends pages.BookingDetailsPage {

    @Then("user select value {string} from title combobox")
    public void userSelectValueFromTitleCombobox(String value) {
        getTitlicon().click();
        SeleniumUserAction.selcetvaluefromcombobox(getTitlecombobox(), value);
    }


    @Then("user select value {string} from Phone code combobox")
    public void userSelectValueFromPhoneCodeCombobox(String value) {
        getPhonecountrycodeicon().click();
        SeleniumUserAction.selcetvaluefromcombobox(getPhonecountrycodecombobox(), value);
    }

    @Then("user select value {string} from nationality combobox")
    public void userSelectValueFromNationalityCombobox(String value) {
        getNationalityicon().click();
        SeleniumUserAction.selcetvaluefromcombobox(getPhonecountrycodecombobox(), value);
    }

    @Then("user check {string} check box")
    public void userCheckCheckBox(String checkbox) {
        DriverController.getDriver().findElement(By.xpath("//span[normalize-space()='"+checkbox+"']")).click();
    }

    @Then("user select value {string} from year DOB combobox")
    public void userSelectValueFromYearDOBCombobox(String value) {
        getYearicon().click();
        SeleniumUserAction.selcetvaluefromcombobox(getYearcombobox(), value);
    }

    @Then("user select value {string} from month DOB combobox")
    public void userSelectValueFromMonthDOBCombobox(String value) {
        getMonthicon().click();
        SeleniumUserAction.selcetvaluefromcombobox(getPhonecountrycodecombobox(), value);
    }

    @Then("user select value {string} from day DOB combobox")
    public void userSelectValueFromDayDOBCombobox(String value) {
        getDayicon().click();
        SeleniumUserAction.selcetvaluefromcombobox(getPhonecountrycodecombobox(), value);
    }

    @And("user click on {string} button on Booking details page")
    public void userClickOnButtonOnBookingDetailsPage(String arg0) {
        getCotinuebutton().click();
    }

    @And("user enter the {string} to {string} field")
    public void userEnterTheToField(String value, String fieldname) {
       boolean flag =false;
        if(value.equalsIgnoreCase("FIRSTNAME")) {
            SeleniumUserAction.userEnterTheRandomToField(getFirstname(), value, fieldname);
            flag=true;
        }
       else if(value.equalsIgnoreCase("LASTNAME")) {
            SeleniumUserAction.userEnterTheRandomToField(getLastname(), value, fieldname);
            flag=true;
       }
        else if(value.equalsIgnoreCase("EMAIL")) {
            SeleniumUserAction.userEnterTheRandomToField(getEmailbox(), value, fieldname);
            flag=true;
        }
        else if(value.equalsIgnoreCase("PHONENUMBER")) {
            SeleniumUserAction.userEnterTheRandomToField(getPhonenumbereditbox(), value, fieldname);
            flag=true;
        }
        else if(flag==false){
            System.out.println("Step - Set Random data to field - Please use proper data selection");
        }
    }
}
