package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;
import managers.FileReaderManager;
import org.openqa.selenium.Keys;

public class HomePage {
    WebDriver driver;
    Wait wait;


    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new Wait();
        PageFactory.initElements(driver, this);
    }


    @FindBy(css=".noo-search")
    public WebElement btn_Search;

    @FindBy(css=".form-control")
    public WebElement input_Search;


    public void perform_Search(String search, int customTimeout) {
        if(wait.WaitForElementUsingCustomTimeout(driver,btn_Search, customTimeout)) {
            btn_Search.click();
            input_Search.sendKeys(search);
            input_Search.sendKeys(Keys.RETURN);
        }

    }

    public void navigateTo_HomePage() {

        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

    }

}