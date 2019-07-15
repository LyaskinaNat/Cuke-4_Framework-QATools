package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.WebDriverManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;
import testDataTypes.CustomerDataType;


import java.io.IOException;
import java.util.List;

public class CheckoutPageSteps {

    public int customTimeout;
    TestContext testContext;
    CheckoutPage checkoutPage;
    WebDriverManager driverManager;

    public CheckoutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
        driverManager = testContext.getWebDriverManager();
        customTimeout = FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();


    }

    //Customer details from JSON
    @When("enter (.+) personal details on checkout page")
    public void enter_personal_details_on_checkout_page(String customerName) throws InterruptedException {

        Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
        checkoutPage.CustomerPersonalDetailsFromJSON(customer, customTimeout);

    }

    //Customer details from DataTable
    @When("enter customer personal details  as follows on checkout page")
    public void enter_customer_personal_details_as_follows_on_checkout_page(List<CustomerDataType> inputs) throws IOException {

        checkoutPage.CustomerPersonalDetailsFromDataTable(inputs, customTimeout);
    }


    @When("place the order")
    public void place_the_order() throws InterruptedException {

        checkoutPage.check_TermsAndCondition();
        checkoutPage.clickOn_PlaceOrder();


    }

}
