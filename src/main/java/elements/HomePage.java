package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    //home page elements
    @FindBy(xpath = "//input[contains(@placeholder,'Buscar productos, marcas y más...')]")
    private WebElement searchBox;
    @FindBy(xpath = "//header/div[1]/div[2]/div[1]/div[1]/div[1]/b2b_search_suggestions-combobox[1]/div[1]/b2b_search_suggestions-input[1]/div[1]/div[2]/button[1]/*[1]")
    private WebElement searchBtn;
    @FindBy(xpath = "(//span[contains(.,'Motor')])[1]")
    private WebElement menuMotor;
    @FindBy(xpath = "//span[contains(.,'Transmision')]")
    private WebElement menuTransmision;
    @FindBy(xpath = "//span[contains(.,'Direccion/Suspension')]")
    private WebElement menuDireccion;
    @FindBy(xpath = "//span[contains(.,'Frenos')]")
    private WebElement menuFrenos;
    @FindBy(xpath = "//span[contains(.,'Impacto')]")
    private WebElement menuImpacto;
    @FindBy(xpath = "//span[contains(.,'Electricos')]")
    private WebElement menuElectricos;
    @FindBy(xpath = "//span[contains(.,'Más')]")
    private WebElement menuMas;

    //getters
    public WebDriver getDriver() {
        return driver;
    }
    public WebElement getMenuMotor() {
        return menuMotor;
    }
    public WebElement getMenuTransmision() {
        return menuTransmision;
    }
    public WebElement getMenuDireccion() {return menuDireccion;}
    public WebElement getMenuElectricos() {
        return menuElectricos;
    }
    public WebElement getMenuMas() {
        return menuMas;
    }
    public WebElement getMenuFrenos() {return menuFrenos;}
    public WebElement getMenuImpacto() {return menuImpacto;}

    //home page methods
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public void searchItem(){
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        searchBox.click();
        searchBox.sendKeys("002913536-3");
        searchBtn.click();
    }
    public boolean menuMotorIsDisplayed(){
        getMenuMotor().isDisplayed();
        return menuMotorIsDisplayed();
    }
    public boolean menuTransmisionIsDisplayed(){
        getMenuTransmision().isDisplayed();
        return menuTransmisionIsDisplayed();
    }
    public boolean menuDireccionIsDisplayed(){
        getMenuDireccion().isDisplayed();
        return menuDireccionIsDisplayed();
    }
    public boolean menuFrenosIsDisplayed(){
        getMenuFrenos().isDisplayed();
        return menuFrenosIsDisplayed();
    }
    public boolean menuElectricosIsDisplayed(){
        getMenuElectricos().isDisplayed();
        return menuElectricosIsDisplayed();
    }
    public boolean menuImpactoIsDisplayed(){
        getMenuImpacto().isDisplayed();
        return menuImpactoIsDisplayed();
    }
    public boolean menuMasIsDisplayed(){
        getMenuMas().isDisplayed();
        return menuMasIsDisplayed();
    }

}
