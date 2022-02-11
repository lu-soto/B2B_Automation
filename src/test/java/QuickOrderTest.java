import elements.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class QuickOrderTest extends BaseTest {

    @Test (priority=1)
    public void quickOrderVerCarrito () throws Exception {
        WebDriver driver = getDriver();
        QuickOrderPage quickOrder = new QuickOrderPage(driver);
        CartPage cart = new CartPage(driver);
        CheckOutSummaryPage summaryPage = new CheckOutSummaryPage(driver);
        CompraCompletadaPage compraCompletadaPage = new CompraCompletadaPage(driver);


        util.waitForPageToLoad(3000);
        quickOrder.searchSKU1();
        util.waitForPageToLoad(5000);
        //quickOrder.searchSKU2();
        quickOrder.addCantidad();
        quickOrder.getAddToCartBtn().click();
        util.waitForPageToLoad(5000);
        driver.switchTo().activeElement();
        util.waitForPageToLoad(5000);
        quickOrder.modalVerCarrito();
        util.waitForPageToLoad(3000);
        //Valida que el usuario es redirigido a la página del carrito
        Assert.assertEquals(driver.getTitle(),"Cart");
        cart.clickComprarCarro();
        util.waitForPageToLoad(5000);
        summaryPage.clickSiguiente();
        util.waitForPageToLoad(5000);
        summaryPage.seleccionarTransporte();
        util.waitForPageToLoad(5000);
        summaryPage.clickCalcularFecha();
        util.waitForPageToLoad(15000);
        //util.scrollToViewElement(driver, driver.findElement(By.xpath("//button[contains(.,'Siguiente')]")));
        summaryPage.unFocusPoInput();
        summaryPage.clickSiguiente();
        util.waitForPageToLoad(5000);
        //Valida el mensaje de éxito en la compra
        Assert.assertEquals(compraCompletadaPage.getGraciasMsj().getText(), "¡Gracias por comprar con nosotros!");
        //Assert.assertEquals(compraCompletadaPage.getPedidoCompletoMsj().getText(),"");
        System.out.println("Se concretó la compra rápida");
    }
    @Test (priority=2)
    public void quickOrderSeguirComprando () throws InterruptedException {
        WebDriver driver = getDriver();
        QuickOrderPage quickOrder = new QuickOrderPage(driver);

        util.waitForPageToLoad(3000);
        quickOrder.searchSKU1();
        util.waitForPageToLoad(3000);
        quickOrder.getAddToCartBtn().click();
        driver.switchTo().activeElement();
        util.waitForPageToLoad(3000);
        quickOrder.modalSeguirComprando();
        util.waitForPageToLoad(3000);
        //Valida que el usuario es redirigido a la página de home para seguir comprando
        Assert.assertEquals(driver.getTitle(),"Home");
    }
    @Test (priority=3)
    public void quickOrderAgregarLinea () throws InterruptedException {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        QuickOrderPage quickOrder = new QuickOrderPage(driver);

        util.waitForPageToLoad(3000);
        quickOrder.getAgregarLineaBtn().click();
        System.out.println("Se agregó una línea");
    }
    @Test(priority=4)
    public void borrarCarrito () throws InterruptedException {
        WebDriver driver = getDriver();
        QuickOrderPage quickOrder = new QuickOrderPage(driver);
        CartPage cart = new CartPage(driver);

        util.waitForPageToLoad(3000);
        quickOrder.searchSKU1();
        util.waitForPageToLoad(5000);
        quickOrder.getAddToCartBtn().click();
        util.waitForPageToLoad(5000);
        driver.switchTo().activeElement();
        util.waitForPageToLoad(5000);
        quickOrder.modalVerCarrito();
        util.waitForPageToLoad(3000);
        cart.borrarCarrito();
        util.waitForPageToLoad(5000);
        driver.switchTo().activeElement();
        util.waitForPageToLoad(5000);
        cart.modalBorrarCarrito();
        //Validación de que el carro se vació
        Assert.assertEquals(cart.getVacioMsj().getText(),"Tu carro está vacío");
        System.out.println("Se vacio el carro");

    }

}
