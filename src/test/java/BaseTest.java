import elements.HomePage;
import elements.LoginPage;
import elements.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import util.PropertiesReader;
import util.Util;


public class BaseTest {
    public WebDriver driver;
    PropertiesReader propertyReader = new PropertiesReader();
    Util util = new Util();

    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mlsot\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://b2b-lex-dev1.force.com/CloudSpirits/");
        driver.manage().window().maximize();
        LoginPage login = new LoginPage(driver);
        login.userLogin(driver, propertyReader.getUserName(), propertyReader.getUserPassword());

    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
    public WebDriver getDriver() {
        return driver;
    }

}
