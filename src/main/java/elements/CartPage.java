package elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(@title,'Proceed To Checkout')]")
    public WebElement chkOutBtn;
    @FindBy(xpath = "//button[contains(@title,'COMPRAR TODO EL CARRO')]")
    public WebElement comprarCarroBtn;
    @FindBy(xpath = "//button[contains(@title,'COMPRAR CARRO PARCIAL')]")
    public WebElement compraParcialBtn;
    @FindBy(xpath = "//h3[contains(.,'Tu carro está vacío')]")
    public WebElement vacioMsj;
    @FindBy(xpath = "//button[@type='button'][contains(.,'Borrar carrito')]")
    public WebElement borrarBtn;
    @FindBy(xpath = "//button[@type='button'][contains(.,'Agregar todo a la lista')]")
    public WebElement agregarListaBtn;
    @FindBy(xpath = "//div[contains(@class,'slds-modal__container')]")
    public WebElement modalBorrar;
    @FindBy(xpath = "(//button[contains(@class,'brand')])[2]")
    public WebElement borrarCarritoBtn;
    @FindBy(xpath = "//input[@type='number']")
    public WebElement cantidad;
    @FindBy(xpath = "(//div[@class='cart-summary__item cart-summary__prices'])[2]")
    public WebElement totalCarro;
    @FindBy(xpath = "(//div[contains(@class,'cart-summary__item cart-summary__prices')])[1]")
    public WebElement totalNeto;
    @FindBy(xpath = "(//lightning-formatted-number)[2]")
    public WebElement ivaValue;


    public WebElement getTotalNeto() {
        return totalNeto;
    }
    public WebElement getTotalCarro() {
        return totalCarro;
    }
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public void clickComprarCarro(){comprarCarroBtn.click();}
    public void borrarCarrito(){
        borrarBtn.click();
    }
    public WebElement getVacioMsj() {
        return vacioMsj;
    }
    public WebElement getIvaValue() {
        return ivaValue;
    }
    public void modalBorrarCarrito() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", borrarCarritoBtn);
    }
    public void agregarCantidad() {
        cantidad.click();
        cantidad.clear();
        cantidad.sendKeys("2");
    }
    public float calculoIva(){
        float calculoIva;
        String totalNetoText = totalNeto.getText();
        String totalNetoValue = totalNetoText.split("\\$")[1].replace(".", "");
        float neto = Long.parseLong(totalNetoValue);
        calculoIva = (neto*19)/100;
        return calculoIva;
    }
    public float totalNeto(){
        String totalNetoText = totalNeto.getText();
        String totalNetoValue = totalNetoText.split("$")[1].replace(".", "");
        return Float.parseFloat(totalNetoValue);
    }

    public float calculoTotalCarro(float neto, float iva){
        float totalCarro;
        String totalNetoText = totalNeto.getText();
        String totalNetoValue = totalNetoText.split("$")[1];
        float netoValue = Float.parseFloat(totalNetoValue);
        totalCarro = netoValue + iva;
        return totalCarro;
    }

}
