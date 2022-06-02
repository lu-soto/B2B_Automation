package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    //home page elements
    @FindBy(xpath = "//input[@placeholder='Enter keyword or SKU number']")
    private WebElement searchBox;
    @FindBy(xpath = "//button[contains(.,'Search')]")
    private WebElement searchBtn;

    //getters
    public WebDriver getDriver() {
        return driver;
    }

    //home page methods
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public void searchItem(){
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        searchBox.click();
        searchBox.sendKeys("J&B Urban Honey Scotch Whisky 70cl");
        searchBtn.click();
    }



}
