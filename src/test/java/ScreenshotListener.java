import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");

        System.out.println("onTestFailure method from Listener class is executed...........");
//        if (driver != null) {
//            System.out.println("Before captureScreenshot method got executed......");
//            captureScreenshot(driver, result.getName());
//            System.out.println("After captureScreenshot method got executed......");
//        }
        captureScreenshot(driver, result.getName());
    }

}
