package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class QuickOrderPage {
    WebDriver driver;

    @FindBy(xpath = "(//input[@placeholder='SKU'])[1]")
    WebElement skuNumber;
    @FindBy(xpath = "(//input[@placeholder='SKU'])[2]")
    WebElement skuNumber2;
    @FindBy(xpath = "(//input[@type='number'])[1]")
    WebElement cantidadSKU;
    @FindBy(xpath = "//button[contains(.,'+ Agregar Línea')]")
    WebElement agregarLineaBtn;
    @FindBy(xpath = "//button[contains(.,'AGREGAR AL CARRITO')]")
    WebElement addToCartBtn;


    //Modal quickorder page
    //@FindBy(xpath = "//div[contains(@class,'slds-modal__container')]")
    @FindBy(xpath = "//div[contains(@id,'modal-content-8098')]")
    WebElement modal;

    public WebElement getVerCarritoBtn() {
        return verCarritoBtn;
    }

    @FindBy(xpath = "//a[contains(.,'Ver carrito')]")
    WebElement verCarritoBtn;
    @FindBy(xpath = "//button[contains(.,'Seguir comprando')]")
    WebElement seguirComprandoBtn;

    //fin modal quickorderpage

    public QuickOrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }


    public WebDriver getDriver() {
        return driver;
    }
    public WebElement getSkuNumber() {
        return skuNumber;
    }
    public WebElement getCantidadSKU() {
        return cantidadSKU;
    }
    public WebElement getAgregarLineaBtn() {
        return agregarLineaBtn;
    }
    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }
    public WebElement getSkuNumber2() {
        return skuNumber2;
    }

    public WebElement getModal() {
        return modal;
    }

    public WebElement getSeguirComprandoBtn() {
        return seguirComprandoBtn;
    }


    public void searchSKU1(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        skuNumber.click();
        skuNumber.sendKeys("002913536-3");
        skuNumber.sendKeys(Keys.RETURN);
    }
    public void searchSKU2(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        skuNumber2.click();
        skuNumber2.sendKeys("001201006-0");
        skuNumber2.sendKeys(Keys.RETURN);
    }

    public void modalVerCarrito() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", verCarritoBtn);
    }
    public void modalSeguirComprando() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", seguirComprandoBtn);
    }
    public void addCantidad(){
        cantidadSKU.clear();
        cantidadSKU.sendKeys("3");
    }


}

