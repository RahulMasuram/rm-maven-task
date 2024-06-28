import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderTest extends BaseTest{

    @DataProvider(name = "testData")
    public static Object[][] provideData() throws IOException {
       // return readExcelData("src/test/resources/data.csv"); // Replace with your data file path
        return new Object[][]{{"Rahul","password"}};
    }

    @Test(dataProvider = "testData")
    public void testWithDataProvider(String username, String password) {
        // Use username and password from data provider
        // Perform test actions
        System.out.println(username+" "+password);
    }
}
