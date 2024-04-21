package pages;


import basepage.DriverController;
import locators.HotelsPageLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage extends HotelsPageLocator {
    @FindBy(xpath= HOTELSPAGE_AVAILABLE_ROOMS)
    private WebElement availableroombutton;

    public WebElement getAvailableroombutton() {
        return availableroombutton;
    }

    public void setAvailableroombutton(WebElement availableroombutton) {
        this.availableroombutton = availableroombutton;
    }

public HotelsPage(){
    PageFactory.initElements(DriverController.getDriver(),this);
}

}
