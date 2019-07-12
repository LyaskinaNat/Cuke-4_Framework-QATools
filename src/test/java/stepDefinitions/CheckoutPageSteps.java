package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.WebDriverManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;
import testDataTypes.CustomerDataType;
import utils.Wait;


import java.io.IOException;
import java.util.List;

public class CheckoutPageSteps {

    TestContext testContext;
    CheckoutPage checkoutPage;
    WebDriverManager driverManager;
    Wait wait;

    public CheckoutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
        driverManager = testContext.getWebDriverManager();
        wait = new Wait(context);


    }
   //Customer details from JSON
    @When("enter (.+) personal details on checkout page")
    public void enter_personal_details_on_checkout_page(String customerName) throws InterruptedException {

        if (wait.WaitForElementUsingCustomTimeout(checkoutPage.txtbx_FirstName)) {
            Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
            checkoutPage.CustomerPersonalDetailsFromJSON(customer);
        }
    }
    //Customer details from DataTable
    @When("enter customer personal details  as follows on checkout page")
    public void enter_customer_personal_details_as_follows_on_checkout_page(List<CustomerDataType> inputs) throws IOException {

        if (wait.WaitForElementUsingCustomTimeout(checkoutPage.txtbx_FirstName)) {
            checkoutPage.CustomerPersonalDetailsFromDataTable(inputs);
        }
    }


    @When("place the order")
    public void place_the_order() {
        checkoutPage.check_TermsAndCondition();
        if (wait.WaitForElementUsingCustomTimeout(checkoutPage.btn_PlaceOrder)) {
            checkoutPage.clickOn_PlaceOrder();

        }
     }

}
