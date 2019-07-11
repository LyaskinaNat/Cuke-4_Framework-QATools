package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;
import org.junit.AfterClass;
import org.testng.annotations.AfterTest;


public class Hooks extends WebDriverManager {


    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {


  //      testContext.getWebDriverManager().getDriver();


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
    public void tearDownAndScreenShotOnFailure(Scenario scenario) {
        try {

                testContext.getWebDriverManager().captureScreenshot(scenario);
                testContext.getWebDriverManager().additionalReportInfo(scenario);
                testContext.getWebDriverManager().closeDriver();
                testContext.getWebDriverManager().copyLatestExtentReport();


        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenShotOnFailure, Exception:" + e.getMessage());
        }
    }
}














