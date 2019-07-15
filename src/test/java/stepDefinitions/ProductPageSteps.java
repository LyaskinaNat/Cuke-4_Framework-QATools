package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import managers.FileReaderManager;
import pageObjects.ProductListingPage;
import utils.Wait;

public class ProductPageSteps {

    TestContext testContext;
    ProductListingPage productListingPage;
    public int customTimeout;


    // Constructor for the ProductPageSteps step class
    public ProductPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
        customTimeout = FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
    }


    @When("choose to buy the first item")
    public void choose_to_buy_the_first_item() throws InterruptedException {
            productListingPage.select_Product(0, customTimeout);
            String productName = productListingPage.getProductName(customTimeout);
            testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);
            productListingPage.makeSelection(1);
            productListingPage.clickOn_AddToCart(customTimeout);


    }
}


