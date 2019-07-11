package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testDataTypes.Customer;
import selenium.Wait;
import org.junit.Assert;
import testDataTypes.CustomerDataType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Wait wait = new Wait();

    @FindBy(id = "billing_first_name")
    private WebElement txtbx_FirstName;

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
        try {
            element.sendKeys(inputValue);
        } catch (Exception e) {

            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());
        }

    }

    public void select_Country(String countryName) {
        Select country = new Select(select_Country);
        country.selectByVisibleText(countryName);

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

    public void CustomerPersonalDetailsFromJSON(Customer customer) {

        customerDetailsForm(txtbx_FirstName, customer.firstName);
        customerDetailsForm(txtbx_LastName, customer.lastName);
        customerDetailsForm(txtbx_Phone, customer.phoneNumber.mob);
        customerDetailsForm(txtbx_Email, customer.emailAddress);
        select_Country(customer.address.country);
        customerDetailsForm(txtbx_City, customer.address.city);
        customerDetailsForm(txtbx_Address, customer.address.streetAddress);
        customerDetailsForm(txtbx_PostCode, customer.address.postCode);

    }


    public void CustomerPersonalDetailsFromDataTable(List<CustomerDataType> inputs) throws IOException {
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

                customerDetailsForm(txtbx_FirstName, firstNameKey);
                customerDetailsForm(txtbx_LastName, lastNameKey);
                customerDetailsForm(txtbx_Phone, phoneNumberKey);
                customerDetailsForm(txtbx_Email, emailAddressKey);
                select_Country(countryKey);
                customerDetailsForm(txtbx_City, townKey);
                customerDetailsForm(txtbx_Address, streetAddressKey);
                customerDetailsForm(txtbx_PostCode, postcodeKey);


            }
        } catch (Exception e) {
            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());
        }


    }
}