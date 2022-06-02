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

    public WebElement getAddCartBtn() {
        return addCartBtn;
    }

    public WebElement getModal() {
        return modal;
    }

    public WebElement getViewCartBtn() {
        return viewCartBtn;
    }

    public WebElement getProceedBtn() {
        return proceedBtn;
    }

    public WebElement getFilter() {
        return filter;
    }

    @FindBy(xpath = "//button[contains(.,'ADD TO CART')]")
    private WebElement addCartBtn;
    //@FindBy(xpath = "//h2[contains(@class,'slds-text-heading_medium slds-hyphenate')]")
    @FindBy(xpath = "//h2[contains(.,'Item was added to cart')]")
    private WebElement modal;
    @FindBy(xpath = "//a[contains(text(),'View Cart')]")
    private WebElement viewCartBtn;
    @FindBy(xpath = "//button[contains(@title,'Proceed To Checkout')]")
    private WebElement proceedBtn;
    @FindBy(xpath = "//ul[contains(@role,'listbox')]")
    private List<WebElement> searchResults;
    @FindBy(xpath = "(//span[@class='slds-checkbox_faux'])[1]")
    private WebElement filter;



    //search results page methods


    public void clickViewCart() throws InterruptedException {
        // WebElement modal = driver.findElement(By.xpath("//a[contains(text(),'View Cart')]"));
        // TODO : Investigate if switch should be here or not
        //wait(5000);
        modal.getText();
        System.out.println(modal.getText());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", viewCartBtn);
        // viewCartBtn.click();
    }

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public void addToCart() /*throws InterruptedException*/ {
        //wait(5000);
        addCartBtn.click();
    }
   /* public void openProduct(){
        verProductoBtn.click();
    }*/

   /* public void irAlCarrito() throws InterruptedException {
        carritoBtn.click();
    } */
   /* public void verProducto(){
        verProductoBtn.click();
    }
    public void verAplicaciones(){
        aplicacionesLink.click();
    }*/

    public List<WebElement> getSearchResults() {
        return searchResults;
    }
   public void agregarFiltro(){
        getFilter().click();
    }
    public void liquidacionIsDisplayed(){
        // load search results
        List<WebElement> filteredResults = driver.findElements(By.xpath("//ul[contains(@role,'listbox')]"));
        filteredResults.forEach(result -> {
            assert result.findElement(By.xpath("(//p[@class='pill__label'][contains(.,'Liquidación')])")).isDisplayed();
        });
    }



}
