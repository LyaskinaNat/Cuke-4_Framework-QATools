package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;

public class Hooks {


    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {
        testContext.getWebDriverManager().getDriver();


 /*What all you can perform here
 Starting a webdriver
 Setting up DB connections
 Setting up test data
 Setting up browser cookies
 Navigating to certain page
 or anything before the test
 */
    }

    // Even in case of test fail, after hook will execute
    @After
    public void AfterSteps() {

        testContext.getWebDriverManager().closeDriver();
    }

}
