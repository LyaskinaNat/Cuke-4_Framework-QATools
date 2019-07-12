package pageObjects;

import cucumber.TestContext;
import cucumber.api.Scenario;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;

public class CartPage  {




    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".cart-button")
    public WebElement btn_Cart;

    @FindBy(css = ".checkout-button.alt")
    public WebElement btn_ContinueToCheckout;


    public void clickOn_Cart() {

        btn_Cart.click();

    }

    public void clickOn_ContinueToCheckout() {

        btn_ContinueToCheckout.click();


    }
}
