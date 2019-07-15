package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;
import managers.WebDriverManager;
import utils.ExtentReportBuilder;


public class Hooks extends WebDriverManager {


    TestContext testContext;
    ExtentReportBuilder reportBuilder;

    public Hooks(TestContext context) {

        testContext = context;
        reportBuilder = new ExtentReportBuilder(context);
    }

    @Before
    public void BeforeSteps() {

        testContext.getWebDriverManager().getDriver();

 /*
 Can performed here (everything what is required before actual test starts):
 - Starting a webdriver
 - Setting up DB connections
 - Setting up test data
 - Setting up browser cookies
 - Navigating to certain page
  */
    }

    // Even in case of test fail, after hook will execute
    @After
    public void tearDownAndScreenShotOnFailure(Scenario scenario) {
        try {

                reportBuilder.captureScreenshot(scenario);
                reportBuilder.additionalReportInfo(scenario);
                reportBuilder.copyLatestExtentReport();
                testContext.getWebDriverManager().closeDriver();


        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenShotOnFailure, Exception:" + e.getMessage());
        }
    }
}














