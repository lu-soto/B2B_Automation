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
        //quickOrder.searchSKU2();
        quickOrder.addCantidad();
        quickOrder.getAddToCartBtn().click();
        driver.switchTo().activeElement();
        quickOrder.modalVerCarrito();
        //Valida que el usuario es redirigido a la página del carrito
        Assert.assertEquals(driver.getTitle(),"Cart");
        cart.clickComprarCarro();
        summaryPage.clickSiguiente();
        summaryPage.seleccionarTransporte();
        summaryPage.clickCalcularFecha();
        //util.scrollToViewElement(driver, driver.findElement(By.xpath("//button[contains(.,'Siguiente')]")));
        summaryPage.unFocusPoInput();
        summaryPage.clickSiguiente();
        //Valida el mensaje de éxito en la compra
        Assert.assertEquals(compraCompletadaPage.getGraciasMsj().getText(), "¡Gracias por comprar con nosotros!");
        //Assert.assertEquals(compraCompletadaPage.getPedidoCompletoMsj().getText(),"");
        System.out.println("Se concretó la compra rápida");
    }
    @Test (priority=2)
    public void quickOrderSeguirComprando () throws InterruptedException {
        WebDriver driver = getDriver();
        QuickOrderPage quickOrder = new QuickOrderPage(driver);

        quickOrder.searchSKU1();
        quickOrder.getAddToCartBtn().click();
        driver.switchTo().activeElement();
        quickOrder.modalSeguirComprando();
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

        quickOrder.searchSKU1();
        quickOrder.getAddToCartBtn().click();
        driver.switchTo().activeElement();
        quickOrder.modalVerCarrito();
        cart.borrarCarrito();
        driver.switchTo().activeElement();
        cart.modalBorrarCarrito();
        //Validación de que el carro se vació
        Assert.assertEquals(cart.getVacioMsj().getText(),"Tu carro está vacío");
        System.out.println("Se vacio el carro");

    }

}
