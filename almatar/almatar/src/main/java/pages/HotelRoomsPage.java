package pages;

import basepage.DriverController;
import locators.HotelRoomsPageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomsPage extends HotelRoomsPageLocators {
    public WebElement getRoomsbooknowbutton() {
        return roomsbooknowbutton;
    }

    public void setRoomsbooknowbutton(WebElement roomsbooknowbutton) {
        this.roomsbooknowbutton = roomsbooknowbutton;
    }

    @FindBy(xpath= HOTELROOMSPAGE_BOOKNOW_BUTTON)
    private WebElement roomsbooknowbutton;



    public HotelRoomsPage(){
         PageFactory.initElements(DriverController.getDriver(),this);
     }
}
