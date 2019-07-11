package managers;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;

public class WebDriverManager {
    public  WebDriver driver;
 //   protected WebDriverWait wait;
    private  String screenshotName;
    private  String archivedReportName;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX : driver = new FirefoxDriver();
                break;
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

    public String returnDateStamp(String fileExtension) {
        Date d = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(d);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dates = calendar.get(Calendar.DATE);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int shortFormat = calendar.get(Calendar.SHORT_FORMAT);
        String date = (String.valueOf(dates)
                + "_" + String.valueOf(month)
                + "_" + String.valueOf(year)
                + "_" + String.valueOf(hours)
                + "_" + String.valueOf(min) + fileExtension);
        return date;
    }

    public String returnScreenshotName() {
        return (System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName);
    }

    public void captureScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            screenshotName = returnDateStamp(".png");
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName));
            scenario.write("Taking a screenshot for a failing step");
            scenario.write("<br>");
            scenario.write("<a target=\"_blank\", href=" + returnScreenshotName() + "><img src=" + returnScreenshotName() + " height=200 width=300></img></a>");
        }

    }

       public void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }catch (Exception e) {
            System.out.println("Unable to copy the report" + e.getMessage());

        } finally {
            is.close();
            os.close();
        }
    }


    public void additionalReportInfo(Scenario scenario) throws IOException {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toUpperCase();
        String browserVersion = cap.getVersion();

        scenario.write("Executed by: " + System.getProperty("user.name"));
        scenario.write("Platform: " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") v." + System.getProperty("os.version"));
        scenario.write("Browser: " + browserName + " v. " + browserVersion);


    }

    public void copyLatestExtentReport() throws IOException {
    //    Date d = new Date();
    //    String date = d.toString().replace(":", "_").replace(" ", "_");
        archivedReportName = "ArchivedOn_" + returnDateStamp(".html");
        File source = new File(System.getProperty("user.dir") + "/test-output/HtmlReport/ExtentHtml.html");
        File dest = new File(System.getProperty("user.dir") + "/test-output/ArchivedReports/" + archivedReportName);
        copyFileUsingStream(source, dest);

    }


    public boolean WaitForElementUsingCustomTimeout(WebElement element, int timeout) {
        try {
            final WebDriverWait customWait;
            customWait= new WebDriverWait(driver, timeout);
            customWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
            System.out.println("Successfully clicked on the WebElement, using locator: " + "<" + element + ">" + ", using a custom Timeout of: " + timeout);
            return true;

        } catch (Exception e) {
            System.out.println("Unable to click on the WebElement, using locator: " + "<" + element + ">" + ", using a custom Timeout of: " + timeout);
       //     Assert.fail("Unable to click on the WebElement, Exception: " + e.getMessage());
            return false;
        }
    }


}
