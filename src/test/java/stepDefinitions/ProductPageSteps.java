package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ProductListingPage;
import utils.Wait;

public class ProductPageSteps {

    TestContext testContext;
    ProductListingPage productListingPage;
    Wait wait;

    // Constructor for the ProductPageSteps step class
    public ProductPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
        wait = new Wait(context);
    }

    @When("choose to buy the first item")
    public void choose_to_buy_the_first_item() {
        if (wait.WaitForElementUsingCustomTimeout(productListingPage.prd_List.get(0))) {
            String productName = productListingPage.getProductName(0);
            testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);
            productListingPage.select_Product(0);
        }

        if (wait.WaitForElementUsingCustomTimeout(productListingPage.selectColour)) {
            productListingPage.makeSelection(1);
            productListingPage.clickOn_AddToCart();
        }

    }
}


