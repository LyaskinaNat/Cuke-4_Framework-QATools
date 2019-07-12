package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import utils.Wait;

public class CartPageSteps {

    TestContext testContext;
    CartPage cartPage;
    Wait wait;



    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
        wait = new Wait(context);

    }




    @When("moves to checkout from mini cart")
    public void moves_to_checkout_from_mini_cart() {
        if (wait.WaitForElementUsingCustomTimeout(cartPage.btn_Cart)) {
            cartPage.clickOn_Cart();
        }

        if (wait.WaitForElementUsingCustomTimeout(cartPage.btn_ContinueToCheckout)) {
            cartPage.clickOn_ContinueToCheckout();
        }

    }
}
