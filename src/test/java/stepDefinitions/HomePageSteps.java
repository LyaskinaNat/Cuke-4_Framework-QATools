package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import cucumber.TestContext;

public class HomePageSteps {

    HomePage homePage;
    TestContext testContext;

    // Constructor for the HomePageSteps step class
    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }


    @Given("user is on Home Page")
    public void user_is_on_Home_Page(){
        homePage.navigateTo_HomePage();
    }

    @When("he search for {string}")
    public void he_search_for(String product)  {
        homePage.perform_Search(product);
    }

}
