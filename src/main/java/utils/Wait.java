package utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public boolean WaitForElementUsingCustomTimeout(WebDriver driver, WebElement element, int customTimeout) {

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
    public boolean ElementVisibleUsingCustomTimeout(WebDriver driver, WebElement element, int customTimeout) {

        try {


            final WebDriverWait customWait;
            customWait= new WebDriverWait(driver, customTimeout);
            customWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
            System.out.println("Successfully found the WebElement, using locator: " + "<" + element + ">" + ", using a custom Timeout of: " + customTimeout);
            return true;

        } catch (Exception e) {
            System.out.println("Unable to find the WebElement, using locator: " + "<" + element + ">" + ", using a custom Timeout of: " + customTimeout);
            Assert.fail("Unable to find the WebElement, Exception: " + e.getMessage());
            return false;

        }
    }

 /*   public void waitAndClickElement(WebElement element)  {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    } */

}
