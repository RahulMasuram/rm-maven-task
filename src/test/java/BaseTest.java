import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTest {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        return driver;
    }
    public void captureScreenshot(WebDriver driver, String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Define destination path and filename format
            File file = new File(System.getProperty("user.dir") + "//reports//" + testName + ".png");
            FileUtils.copyFile(screenshot, file);
            System.out.println("Screenshot file has been copied to reports folder");
        } catch (IOException e) {
            // Handle screenshot capture exceptions
            e.printStackTrace();
        }
    }

    public static List<Map<String, String>> readExcelData(String filePath) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        //Workbook workbook = WorkbookFactory.create(inputStream);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data on the first sheet

        int rowCount = sheet.getLastRowNum() + 1; // +1 to include header row
        Row headerRow = sheet.getRow(0);

        for (int i = 1; i < rowCount; i++) { // Skip header row
            Row row = sheet.getRow(i);
            Map<String, String> dataRow = new HashMap<>();
            for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                dataRow.put(headerRow.getCell(j).getStringCellValue().trim(),
                        cell != null ? cell.getStringCellValue().trim() : ""); // Handle empty cells
            }
            data.add(dataRow);
        }
        workbook.close();
        inputStream.close();
        return data;
    }
}
