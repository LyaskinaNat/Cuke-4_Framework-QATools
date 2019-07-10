package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testDataTypes.Customer;
import selenium.Wait;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Wait wait = new Wait();

    @FindBy(id = "billing_first_name")
    public WebElement txtbx_FirstName;

    @FindBy(css = "#billing_last_name")
    private WebElement txtbx_LastName;

    @FindBy(css = "#billing_email")
    private WebElement txtbx_Email;

    @FindBy(css = "#billing_phone")
    private WebElement txtbx_Phone;

    @FindBy(id = "billing_country")
    private WebElement select_Country;

    @FindBy(css = "#billing_city")
    private WebElement txtbx_City;

    @FindBy(css = "#billing_address_1")
    private WebElement txtbx_Address;

    @FindBy(css = "#billing_postcode")
    private WebElement txtbx_PostCode;

    @FindBy(id = "terms")
    private WebElement chkbx_AcceptTermsAndCondition;

    @FindBy(css = "#place_order")
    private WebElement btn_PlaceOrder;



    public void customerDetailsForm(WebElement element, String inputValue) {
        element.sendKeys(inputValue);
    }

    public void select_Country(String countryName) {
        Select country = new Select(select_Country);
        country.selectByVisibleText(countryName);

    }

    public void check_TermsAndCondition() {
        chkbx_AcceptTermsAndCondition.click();
    }

    public void clickOn_PlaceOrder() {
        btn_PlaceOrder.submit();
    }

    public void fill_PersonalDetails(Customer customer) {

            customerDetailsForm(txtbx_FirstName, customer.firstName);
            customerDetailsForm(txtbx_LastName, customer.lastName);
            customerDetailsForm(txtbx_Phone, customer.phoneNumber.mob);
            customerDetailsForm(txtbx_Email, customer.emailAddress);
            select_Country(customer.address.country);
            customerDetailsForm(txtbx_City, customer.address.city);
            customerDetailsForm(txtbx_Address, customer.address.streetAddress);
            customerDetailsForm(txtbx_PostCode, customer.address.postCode);


    }

}