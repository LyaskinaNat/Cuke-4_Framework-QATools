package utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesingWait {


    public boolean WaitForElementUsingCustomTimeoutTestTest(WebDriver driver, WebElement element, int customTimeout) {


        try {

            final WebDriverWait customWait;
            customWait= new WebDriverWait(driver, customTimeout);
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
