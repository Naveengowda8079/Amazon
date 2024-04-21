package pages;

import basepage.DriverController;
import locators.HomePageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//import static locators.Home.HOMEPAGE_DESTINATION_SEARCHBOX;

public class HomePage extends HomePageLocators {

    @FindBy(xpath= HOMEPAGE_DESTINATION_SEARCHBOX)
    private WebElement destinationsearchbox;

    @FindBy(xpath= HOMEPAGE_DEPARTURE_DATE)
    private WebElement departuredatebutton;

    @FindBy(xpath= HOMEPAGE_ARRIAVAL_DATE)
    private WebElement arrivaldatebutton;

    public WebElement getSearchbutton() {
        return searchbutton;
    }

    public void setSearchbutton(WebElement searchbutton) {
        this.searchbutton = searchbutton;
    }

    @FindBy(id = HOMEPAGE_SEARCH_BUTTON)
    private WebElement searchbutton;


    public WebElement getNightcounttext() {
        return nightcounttext;
    }

    public void setNightcounttext(WebElement nightcounttext) {
        this.nightcounttext = nightcounttext;
    }

    @FindBy(xpath= HOMEPAGE_NIGHT_COUNT_TEXT)
    private WebElement nightcounttext;

    public WebElement getDeparturedatebutton() {
        return departuredatebutton;
    }

    public void setDeparturedatebutton(WebElement departuredatebutton) {
        this.departuredatebutton = departuredatebutton;
    }

    public WebElement getArrivaldatebutton() {
        return arrivaldatebutton;
    }

    public void setArrivaldatebutton(WebElement arrivaldatebutton) {
        this.arrivaldatebutton = arrivaldatebutton;
    }

    public List<WebElement> getDestinationcombobox() {
        return destinationcombobox;
    }

    public void setDestinationcombobox(List<WebElement> destinationcombobox) {
        this.destinationcombobox = destinationcombobox;
    }

    @FindBys({
            @FindBy(xpath = HOMEPAGE_DESTINATION_SEARCHBOX_COMBOBOX)
    })
    private List<WebElement> destinationcombobox;

    public WebElement getDestinationsearchbox() {
        return destinationsearchbox;
    }

    public void setDestinationsearchbox(WebElement destinationsearchbox) {
        this.destinationsearchbox = destinationsearchbox;
    }

    public  HomePage() {
        PageFactory.initElements(DriverController.getDriver(), this);
    }
}