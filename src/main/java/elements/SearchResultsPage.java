package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    //search results page elements

    @FindBy(xpath = "(//button[contains(.,'AGREGAR AL CARRO')])[1]")
    private WebElement addCartBtn;
    @FindBy(xpath = "(//a[contains(.,'Ver AplicacionesVer Aplicaciones')])[1]")
    private WebElement aplicacionesLink;
    @FindBy(xpath = "(//a[contains(.,'Ver Cross ReferenceVer Cross Reference')])[1]")
    private WebElement crossLink;
    @FindBy(xpath = "(//p[contains(.,'Stock Disponible:')])[1]")
    private WebElement stockLabel;
    @FindBy(xpath = "(//p[contains(@class,'stock-available__units')])[1]")
    private WebElement stockUnits;
    @FindBy(xpath = "//ul[contains(@role,'listbox')]")
    private List<WebElement> searchResults;
    @FindBy(xpath = "//img[contains(@xpath,'1')]")
    private WebElement productImage;
    @FindBy(xpath = "(//p[contains(@class,'card__product-sku')])")
    private WebElement skuLabel;
    @FindBy(xpath = "(//img[contains(@class,'card__product-brand-image')])")
    private WebElement manufacturerImg;
    @FindBy(xpath = "(//p[contains(@class,'card__product-brand')])")
    private WebElement marcaProducto;
    @FindBy(xpath = "(//p[contains(@class,'card__product-specs')])")
    private WebElement añoProducto;
    @FindBy(xpath = "(//button[contains(.,'Ver Producto')])")
    private WebElement verProductoBtn;
    @FindBy(xpath = "(//header/div[1]/div[3]/div[3]/div[1]/div[1]/b2b_buyer_cart-badge[1]/span[1]/a[1]/span[1]/*[1])")
    private WebElement carritoBtn;
    @FindBy(xpath = "(//span[@class='slds-checkbox_faux'])[1]")
    private WebElement filter;
    @FindBy(xpath = "(//p[@class='pill__label'][contains(.,'Liquidación')])[1]")
    private WebElement labelLiquidacion;

    //Filtros

    // fin filtros

    // modal de aplicaciones vehiculares
    @FindBy(xpath = "(//div[contains(@class,'slds-modal')])")
    private WebElement modalApp;
    @FindBy(xpath = "//h2[@class='modal__title'][contains(.,'Aplicaciones de este repuesto')]")
    private WebElement apModalTitle;
    // fin de modal de aplicaciones vehiculares

    // modal de  cross reference
    @FindBy(xpath = "(//div[contains(@class,'slds-modal')])")
    private WebElement crossRef;
    @FindBy(xpath = "//h2[@class='modal__title'][contains(.,'Cross Reference')]")
    private WebElement crossModalTitle;

    // fin de modal de cross reference

    //search results page methods
    public WebElement getApModalTitle() {
        return apModalTitle;
    }
    public WebElement getCrossModalTitle() {
        return crossModalTitle;
    }
    public WebElement getFilter() {
        return filter;
    }
    public WebElement getLabelLiquidacion() {
        return labelLiquidacion;
    }
    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public void addToCart() /*throws InterruptedException*/ {
        //wait(5000);
        addCartBtn.click();
    }
    public void openProduct(){
        verProductoBtn.click();
    }
    public void openAplicacionesVehiculares(){
        aplicacionesLink.click();
    }
    public void openCrossReference(){
        crossLink.click();
    }
    public void irAlCarrito() /*throws InterruptedException*/ {
        carritoBtn.click();
    }
    public void verProducto(){
        verProductoBtn.click();
    }
    public void verAplicaciones(){
        aplicacionesLink.click();
    }
    public void verCrossReference(){
        crossLink.click();
    }
    public List<WebElement> getSearchResults() {
        return searchResults;
    }
    public void agregarFiltro(){
        filter.click();
        System.out.println(filter.isSelected());
    }
    public void liquidacionIsDisplayed(){
        // load search results
        List<WebElement> filteredResults = driver.findElements(By.xpath("//ul[contains(@role,'listbox')]"));
        filteredResults.forEach(result -> {
            assert result.findElement(By.xpath("(//p[@class='pill__label'][contains(.,'Liquidación')])")).isDisplayed();
        });
    }


}
