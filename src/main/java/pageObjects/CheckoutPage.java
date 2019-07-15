package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testDataTypes.Customer;
import org.junit.Assert;
import testDataTypes.CustomerDataType;
import utils.Wait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    WebDriver driver;
    Wait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new Wait();
        PageFactory.initElements(driver, this);


    }

    @FindBy(id = "billing_first_name")
    public WebElement txtbx_FirstName;

    @FindBy(css = "#billing_last_name")
    public WebElement txtbx_LastName;

    @FindBy(css = "#billing_email")
    public WebElement txtbx_Email;

    @FindBy(css = "#billing_phone")
    public WebElement txtbx_Phone;

    @FindBy(id = "billing_country")
    public WebElement select_Country;

    @FindBy(css = "#billing_city")
    public WebElement txtbx_Town;

    @FindBy(css = "#billing_address_1")
    public WebElement txtbx_Address;

    @FindBy(css = "#billing_postcode")
    public WebElement txtbx_PostCode;

    @FindBy(id = "terms")
    public WebElement chkbx_AcceptTermsAndCondition;

    @FindBy(css = "#place_order")
    public WebElement btn_PlaceOrder;


    public void customerDetailsForm(WebElement element, String inputValue, int customTimeout) {
        try {
            if(wait.WaitForElementUsingCustomTimeout(driver,element, customTimeout)) {
                element.sendKeys(inputValue);
            }
        } catch (Exception e) {

            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());
        }

    }

    public void select_Country(String countryName, int customTimeout) {
        if(wait.WaitForElementUsingCustomTimeout(driver,select_Country, customTimeout)) {
            Select country = new Select(select_Country);
            country.selectByVisibleText(countryName);
        }

    }

    public void check_TermsAndCondition() {
        try {
            chkbx_AcceptTermsAndCondition.click();
        } catch (Exception e) {

            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());
        }

    }

    public void clickOn_PlaceOrder() {
        btn_PlaceOrder.submit();
    }

    public void CustomerPersonalDetailsFromJSON(Customer customer, int customTimeout) {

            customerDetailsForm(txtbx_FirstName, customer.firstName, customTimeout);
            customerDetailsForm(txtbx_LastName, customer.lastName, customTimeout);
            customerDetailsForm(txtbx_Phone, customer.phoneNumber.mob, customTimeout);
            customerDetailsForm(txtbx_Email, customer.emailAddress, customTimeout);
            select_Country(customer.address.country, customTimeout);
            customerDetailsForm(txtbx_Town, customer.address.city, customTimeout);
            customerDetailsForm(txtbx_Address, customer.address.streetAddress, customTimeout);
            customerDetailsForm(txtbx_PostCode, customer.address.postCode, customTimeout);

    }


    public void CustomerPersonalDetailsFromDataTable(List<CustomerDataType> inputs, int customTimeout) throws IOException {
        try {

            List<String> firstNameArr = new ArrayList<>();
            List<String> lastNameArr = new ArrayList<>();
            List<String> countryArr = new ArrayList<>();
            List<String> streetAddressArr = new ArrayList<>();
            List<String> townArr = new ArrayList<>();
            List<String> postcodeArr = new ArrayList<>();
            List<String> phoneNumberArr = new ArrayList<>();
            List<String> emailAddressArr = new ArrayList<>();
            Integer size = inputs.size();

            for (CustomerDataType input : inputs) {
                firstNameArr.add(input.getFirstName());
                lastNameArr.add(input.getLastName());
                countryArr.add(input.getCountry());
                streetAddressArr.add(input.getStreetAddress());
                townArr.add(input.getTown());
                postcodeArr.add(input.getPostCode());
                phoneNumberArr.add(input.getPhoneNumber());
                emailAddressArr.add(input.getEmailAddress());
            }
            for (int i = 0; i < size; i++) {
                String firstNameKey = firstNameArr.get(i);
                String lastNameKey = lastNameArr.get(i);
                String countryKey = countryArr.get(i);
                String streetAddressKey = streetAddressArr.get(i);
                String townKey = townArr.get(i);
                String postcodeKey = postcodeArr.get(i);
                String phoneNumberKey = phoneNumberArr.get(i);
                String emailAddressKey = emailAddressArr.get(i);

                customerDetailsForm(txtbx_FirstName, firstNameKey, customTimeout);
                customerDetailsForm(txtbx_LastName, lastNameKey, customTimeout);
                customerDetailsForm(txtbx_Phone, phoneNumberKey, customTimeout);
                customerDetailsForm(txtbx_Email, emailAddressKey, customTimeout);
                select_Country(countryKey, customTimeout);
                customerDetailsForm(txtbx_Town, townKey, customTimeout);
                customerDetailsForm(txtbx_Address, streetAddressKey, customTimeout);
                customerDetailsForm(txtbx_PostCode, postcodeKey, customTimeout);


            }
        } catch (Exception e) {
            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());
        }


    }
}