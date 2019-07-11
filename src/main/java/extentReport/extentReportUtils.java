//NOT IN USE

package extentReport;

import cucumber.api.Scenario;
import managers.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.*;
import java.util.Date;

public class extentReportUtils extends WebDriverManager {

    private  String screenshotName;

    public String returnDateStamp(String fileExtension) {
        Date d = new Date();
        String date = d.toString().replace(":", "_").replace(" ", "_").replace("BST", "") + fileExtension;
        return date;
    }

    public String returnScreenshotName() {
        return (System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName);
    }

    // This method is not is use
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

    public void captureScreenshot(Scenario scenario) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshotName = returnDateStamp(".png");
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName));
        scenario.write("Taking a screenshot for a failing step");
        scenario.write("<br>");
        scenario.write("<a target=\"_blank\", href=" + returnScreenshotName() + "><img src=" + returnScreenshotName() + " height=200 width=300></img></a>");
    }

    public void additionalReportInfo(Scenario scenario) throws IOException {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toUpperCase();
        String browserVersion = cap.getVersion();

        scenario.write("Executed by: " + System.getProperty("user.name"));
        scenario.write("Platform: " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") v." + System.getProperty("os.version"));
        scenario.write("Browser: " + browserName + " v. " + browserVersion);


    }
}
