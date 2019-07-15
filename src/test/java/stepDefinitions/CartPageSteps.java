package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.CartPage;
import utils.Wait;

public class CartPageSteps {

    TestContext testContext;
    CartPage cartPage;
    public int customTimeout;



    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
        customTimeout = FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();

    }




    @When("moves to checkout from mini cart")
    public void moves_to_checkout_from_mini_cart() {
            cartPage.clickOn_Cart(customTimeout);
            cartPage.clickOn_ContinueToCheckout(customTimeout);

    }
}
