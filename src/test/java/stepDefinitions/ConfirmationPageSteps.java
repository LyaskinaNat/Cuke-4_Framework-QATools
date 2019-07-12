package stepDefinitions;

import org.junit.Assert;
import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import pageObjects.ConfirmationPage;
import utils.Wait;

public class ConfirmationPageSteps {
    TestContext testContext;
    ConfirmationPage confirmationPage;
    Wait wait;

    public ConfirmationPageSteps(TestContext context) {
        testContext = context;
        confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
        wait = new Wait(context);
    }

    @Then("verify the order details")
    public void verify_the_order_details() throws InterruptedException {

        String productName = ((String) testContext.scenarioContext.getContext(Context.PRODUCT_NAME)).toLowerCase();
        if (wait.WaitForElementUsingCustomTimeout(confirmationPage.prd_List.get(0))) {
            Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.contains(productName)).findFirst().get().length() > 0);

        }

    }
}
