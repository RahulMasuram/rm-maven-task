import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

//@Listeners(ScreenshotListener.class)
public class SampleTest {

    WebDriver driver;
    @Test(enabled = true)
    public void runTest() throws IOException, InterruptedException {
        BaseTest test = new BaseTest();
        driver = test.initializeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("javatpoint");
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//h3[text()=\"Javatpoint: Tutorials List\"]")).getText();
       // Assert.assertTrue(false);
    }
}
