package Test;

import POM.HomePage;
import POM.NotFoundPage;
import POM.SearchedPage;
import Utills.BaseClass;
import Utills.DataDriven;
import Utills.Propertiesdriven;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BaseTest {

    protected WebDriver driver;
    private static String browser = Propertiesdriven.getProperty("browser");
    protected ArrayList<String> dataSet;
    protected HomePage homePage;
    protected SearchedPage searchPage;
    protected NotFoundPage notFoundPage;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        try{
            WebDriver driver = BaseClass.generateDriver(browser);
            BaseClass.setMaximWindow(driver);
            BaseClass.setWait(driver);
            this.driver = driver;
            this.homePage = new HomePage(driver);
            this.searchPage = new SearchedPage(driver);
            this.notFoundPage = new NotFoundPage(driver);
            this.dataSet = DataDriven.getTestData(testInfo.getDisplayName());
        }catch (Exception e){
            Assertions.fail("Can not create driver session");
        }
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }
}
