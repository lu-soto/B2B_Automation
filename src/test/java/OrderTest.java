import elements.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {

    @Test (priority=1)
    public void verifyE2E() throws InterruptedException {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        DeliveryPage deliveryPage = new DeliveryPage(driver);
        CheckOutSummaryPage checkOutSummaryPage = new CheckOutSummaryPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        homePage.searchItem();
        util.waitForPageToLoad(5000);
        searchResultsPage.addToCart();
        util.waitForPageToLoad(10000);
        searchResultsPage.clickViewCart();
        driver.switchTo().activeElement();
        util.waitForPageToLoad(3000);
        shoppingCartPage.clickCheckOut();
        util.waitForPageToLoad(3000);
        deliveryPage.clickNext();
        util.waitForPageToLoad(3000);
        checkOutSummaryPage.clickNext();
        util.waitForPageToLoad(5000);
        paymentPage.enterPO();
        util.waitForPageToLoad(3000);
        Assert.assertEquals(paymentPage.message.getText(), "Thanks for shopping with us!");
        System.out.println("Se concretó la compra");
}

    @Test (priority=2)
    public void verProducto () throws InterruptedException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        util.waitForPageToLoad(3000);
        homePage.searchItem();
        util.waitForPageToLoad(5000);
        //searchResultsPage.verProducto();
        //Validación que es rediriido a la página de detalle del producto
        Assert.assertEquals(driver.getTitle(), "Product Detail");
    }
    @Test(priority=3)
    public void verAplicacionesVehiculares () throws InterruptedException {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        util.waitForPageToLoad(3000);
        homePage.searchItem();
        util.waitForPageToLoad(5000);
        //searchResultsPage.verAplicaciones();
        driver.switchTo().activeElement();
        //Validacion que muestra que se están mostrando las aplicaciones vehiculares
        //Assert.assertEquals(searchResultsPage.getApModalTitle().getText(), "Aplicaciones de este repuesto");
    }

    @Test(priority=4)
    public void verCrossReference () throws InterruptedException {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        util.waitForPageToLoad(3000);
        homePage.searchItem();
        util.waitForPageToLoad(5000);
       // searchResultsPage.verCrossReference();
        driver.switchTo().activeElement();
        //Validacion que muestra que se está las referencias cruzadas
       //Assert.assertEquals(searchResultsPage.getCrossModalTitle().getText(), "Cross Reference");
    }
    @Test (priority=5)
    public void validarIva () throws Exception {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        CheckOutSummaryPage summaryPage = new CheckOutSummaryPage(driver);
        CompraCompletadaPage compraCompletadaPage = new CompraCompletadaPage(driver);

        util.waitForPageToLoad(3000);
        homePage.searchItem();
        util.waitForPageToLoad(5000);
        searchResults.addToCart();
       // searchResults.irAlCarrito();
        cart.calculoIva();
        //Valida que el el iva mostrado es correcto
        String iva = "$" + cart.calculoIva();
        Assert.assertEquals(cart.getIvaValue().getText(), String.format("$%(,.0f", cart.calculoIva()).replace(",", "."));
        Assert.assertEquals(cart.getTotalCarro().getText(),
                String.format("$%(,.0f", cart.calculoTotalCarro(cart.totalNeto(), cart.calculoIva())));
    }

}
