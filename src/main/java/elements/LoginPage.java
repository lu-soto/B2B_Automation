package elements;

import constants.PageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = PageConstants.USERNAME)
    private WebElement userName;
    @FindBy(xpath = PageConstants.PASSWORD)
    public WebElement passWord;
    @FindBy(xpath = PageConstants.LOGIN_BTN)
    private WebElement logBtn;
    @FindBy(xpath = PageConstants.LOGO)
    public WebElement logo;

    //LoginPage methods
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public WebElement getLogBtn() {
        return logBtn;
    }

    public WebElement getLoginUsername() {
        return userName;
    }
    public WebElement getLoginPassword() {
        return passWord;
    }
   // public WebElement getForgotPassBtn(){return forgotPassBtn;}
    public WebElement getLogo(){
        return logo;
    }
    public void userLogin(WebDriver driver, String username, String password) throws InterruptedException {
       // loginBtn.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        getLoginUsername().sendKeys(username);
        getLoginPassword().sendKeys(password);
        logBtn.click();
    }
}
