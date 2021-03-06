package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Wait;

public class ProductListingPage {
    WebDriver driver;
    Wait wait;

    public ProductListingPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new Wait();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.single_add_to_cart_button")
    public WebElement btn_AddToCart;

    @FindAll(@FindBy(css = ".noo-product-inner"))
    public List<WebElement> prd_List;

    @FindBy(css= ".entry-summary")
    public WebElement selectedProduct;
    @FindBy(id="pa_color")
    public WebElement selectColour;

    @FindBy(id="pa_size")
    public WebElement selectSize;

    public void makeSelection(int index) {
        Select colour = new Select(selectColour);
        colour.selectByIndex(index);
        Select size  = new Select(selectSize);
        size.selectByIndex(index);
    }

    public void clickOn_AddToCart(int customTimeout) {
        if (wait.WaitForElementUsingCustomTimeout(driver,btn_AddToCart, customTimeout)) {
            btn_AddToCart.click();
        }
    }

    public void select_Product(int productNumber, int customTimeout) {

        if (wait.WaitForElementUsingCustomTimeout(driver,prd_List.get(productNumber), customTimeout)) {
            prd_List.get(productNumber).click();
        }


    }

    public String getProductName(int customTimeout) {
        String productName;
        if (wait.ElementVisibleUsingCustomTimeout(driver,selectedProduct, customTimeout)) {
            productName = selectedProduct.findElement(By.cssSelector("h1")).getText();
        } else {
            productName = "Unable to get Product Name";
        }
         return productName;
    }

}
