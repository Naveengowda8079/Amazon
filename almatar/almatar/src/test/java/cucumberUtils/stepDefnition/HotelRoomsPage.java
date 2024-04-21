package cucumberUtils.stepDefnition;

import basepage.DriverController;
import io.cucumber.java.en.And;
import lib.SeleniumUserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class HotelRoomsPage extends pages.HotelRoomsPage {

    @And("user click on {string} button on HotelsRoom page")
    public void userClickOnButtonOnHotelsRoomPage(String arg0) {
try {
    String mainWindowHandle = DriverController.getDriver().getWindowHandle();
    Set<String> allWindowHandles = DriverController.getDriver().getWindowHandles();
    Iterator<String> iterator = allWindowHandles.iterator();
    while(iterator.hasNext()) {
        String ChildWindow = iterator.next();
        if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
            DriverController.getDriver().switchTo().window(ChildWindow);
            WebElement text = DriverController.getDriver().findElement(By.xpath("//*[@id='main-hotel']//h1"));
            System.out.println("Heading of child window is " + text.getText());
        }
    }
    SeleniumUserAction.synchronizationMethods(getRoomsbooknowbutton());
    getRoomsbooknowbutton().click();

}catch (Exception e){
    e.printStackTrace();
    SeleniumUserAction.ErrorValidation(false, "not switched child window");
}

    }


    }

