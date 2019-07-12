package utils;


import cucumber.TestContext;
import managers.FileReaderManager;
import managers.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    TestContext testContext;
    WebDriverManager driverManager;
    private static int customTimeout;


    public Wait(TestContext context) {
        testContext = context;
        driverManager = testContext.getWebDriverManager();
        customTimeout = FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();

    }

    public boolean WaitForElementUsingCustomTimeout(WebElement element) {


        try {

            final WebDriverWait customWait;
            customWait= new WebDriverWait(driverManager.getDriver(), customTimeout);
            customWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
            System.out.println("Successfully found the WebElement, using locator: " + "<" + element + ">" + ", using a custom Timeout of: " + customTimeout);
            return true;

        } catch (Exception e) {
            System.out.println("Unable to find the WebElement, using locator: " + "<" + element + ">" + ", using a custom Timeout of: " + customTimeout);
            Assert.fail("Unable to find the WebElement, Exception: " + e.getMessage());
            return false;

        }
    }

}
