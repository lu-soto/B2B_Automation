package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutSummaryPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(.,'Calcular fecha')]")
    public WebElement calcFechaBtn;
    @FindBy(xpath = "//input[@class='slds-input slds-combobox__input']")
    public WebElement selTransporte;
    @FindBy(xpath = "//button[contains(.,'Siguiente')]")
    public WebElement siguienteBtn;
    @FindBy(xpath = "//span[@title='AC. LOGISTICA']")
    public WebElement transporte;
    @FindBy(xpath = "//input[@name='POInput']")
    public WebElement poInput;

    public CheckOutSummaryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public void seleccionarTransporte(){
        selTransporte.click();
        transporte.click();
    }
    public void clickSiguiente(){
        siguienteBtn.click();
    }
    public void clickCalcularFecha(){
        calcFechaBtn.click();
    }
    public void unFocusPoInput() {
        poInput.sendKeys(Keys.TAB);
    }

}
