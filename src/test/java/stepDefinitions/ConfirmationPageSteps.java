package stepDefinitions;

import managers.FileReaderManager;
import org.junit.Assert;
import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import pageObjects.ConfirmationPage;
import utils.Wait;

public class ConfirmationPageSteps {
    TestContext testContext;
    ConfirmationPage confirmationPage;
    public int customTimeout;

    public ConfirmationPageSteps(TestContext context) {
        testContext = context;
        confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
        customTimeout = FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();

    }

    @Then("verify the order details")
    public void verify_the_order_details() throws InterruptedException {

        String productName = ((String) testContext.scenarioContext.getContext(Context.PRODUCT_NAME)).toLowerCase();
            Assert.assertTrue(confirmationPage.getProductNames(customTimeout).stream().filter(x -> x.contains(productName)).findFirst().get().length() > 0);

    }
}
