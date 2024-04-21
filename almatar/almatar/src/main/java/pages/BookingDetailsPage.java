package pages;

import basepage.DriverController;
import locators.BookingDetailsPagelocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingDetailsPage extends BookingDetailsPagelocators {

    @FindBy(xpath= BOOKINGDETAILS_TITLE_ICON)
    private WebElement titlicon;

    public WebElement getPhonenumbereditbox() {
        return phonenumbereditbox;
    }

    public void setPhonenumbereditbox(WebElement phonenumbereditbox) {
        this.phonenumbereditbox = phonenumbereditbox;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public void setLastname(WebElement lastname) {
        this.lastname = lastname;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public void setFirstname(WebElement firstname) {
        this.firstname = firstname;
    }

    public WebElement getEmailbox() {
        return emailbox;
    }

    public void setEmailbox(WebElement emailbox) {
        this.emailbox = emailbox;
    }

    @FindBy(xpath= BOOKINGDETAILS_PHONENUMBER_EDITBOX)
    private WebElement phonenumbereditbox;

    @FindBy(xpath= BOOKINGDETAILS_LASTNAME_EDITBOX)
    private WebElement lastname;

    @FindBy(xpath= BOOKINGDETAILS_FIRSTNAME_EDITBOX)
    private WebElement firstname;

    @FindBy(xpath= BOOKINGDETAILS_EMIL_EDITBOX)
    private WebElement emailbox;

    @FindBy(xpath= BOOKINGDETAILS_DAY_ICON)
    private WebElement dayicon;

    @FindBy(xpath= BOOKINGDETAILS_MONTH_ICON)
    private WebElement monthicon;

    @FindBy(xpath= BOOKINGDETAILS_NATIONALITY_ICON)
    private WebElement nationalityicon;

    @FindBys({ @FindBy(xpath= BOOKINGDETAILS_PHONECOUNTRYCODE_COBOBOX)})
    private List<WebElement> phonecountrycodecombobox;

    public List<WebElement> getTitlecombobox() {
        return titlecombobox;
    }

    public void setTitlecombobox(List<WebElement> titlecombobox) {
        this.titlecombobox = titlecombobox;
    }

    public List<WebElement> getYearcombobox() {
        return yearcombobox;
    }

    public void setYearcombobox(List<WebElement> yearcombobox) {
        this.yearcombobox = yearcombobox;
    }

    @FindBys({@FindBy(xpath= BOOKINGDETAILS_TITLE_COMBOBOX)})
    private List<WebElement> titlecombobox;

    @FindBys({ @FindBy(xpath= BOOKINGDETAILS_YEAR_COMBOBOX)})
    private List<WebElement> yearcombobox;

    @FindBy(xpath= BOOKINGDETAILS_YEAR_ICON)
    private WebElement yearicon;

    @FindBy(xpath= BOOKINGDETAILS_PHONECOUNTRYCODE_ICON)
    private WebElement phonecountrycodeicon;

    public WebElement getCotinuebutton() {
        return cotinuebutton;
    }

    public void setCotinuebutton(WebElement cotinuebutton) {
        this.cotinuebutton = cotinuebutton;
    }

    @FindBy(xpath= BOOKINGDETAILS_CONTINUE_BUTTON)
    private WebElement cotinuebutton;

    public WebElement getTitlicon() {
        return titlicon;
    }

    public void setTitlicon(WebElement titlicon) {
        this.titlicon = titlicon;
    }

    public WebElement getDayicon() {
        return dayicon;
    }

    public void setDayicon(WebElement dayicon) {
        this.dayicon = dayicon;
    }

    public WebElement getMonthicon() {
        return monthicon;
    }

    public void setMonthicon(WebElement monthicon) {
        this.monthicon = monthicon;
    }

    public WebElement getNationalityicon() {
        return nationalityicon;
    }

    public void setNationalityicon(WebElement nationalityicon) {
        this.nationalityicon = nationalityicon;
    }

    public List<WebElement> getPhonecountrycodecombobox() {
        return phonecountrycodecombobox;
    }

    public void setPhonecountrycodecombobox(List<WebElement> phonecountrycodecombobox) {
        this.phonecountrycodecombobox = phonecountrycodecombobox;
    }


    public WebElement getYearicon() {
        return yearicon;
    }

    public void setYearicon(WebElement yearicon) {
        this.yearicon = yearicon;
    }

    public WebElement getPhonecountrycodeicon() {
        return phonecountrycodeicon;
    }

    public void setPhonecountrycodeicon(WebElement phonecountrycodeicon) {
        this.phonecountrycodeicon = phonecountrycodeicon;
    }

    public BookingDetailsPage(){
        PageFactory.initElements(DriverController.getDriver(), this);
    }
}
