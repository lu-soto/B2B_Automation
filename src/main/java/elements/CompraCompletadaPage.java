package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraCompletadaPage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(.,'Seguir comprando')]")
    public WebElement seguirComprandoBtn;
    @FindBy(xpath = "//h1[contains(.,'¡Gracias por comprar con nosotros!')]")
    public WebElement graciasMsj;
    @FindBy(xpath = "//button[@title='Ver mi pedido'][contains(.,'Ver mi pedido')]")
    public WebElement verPedidoBtn;
    @FindBy(xpath = "//p[@title='Su pedido se ha completado y está en proceso de validación interna de Mannheim. Si desea más detalles, haga click en “Ver mi pedido”.'][contains(.,'Su pedido se ha completado y está en proceso de validación interna de Mannheim. Si desea más detalles, haga click en “Ver mi pedido”.')]")
    public WebElement pedidoCompletoMsj;
    public WebElement getGraciasMsj() {
        return graciasMsj;
    }
    public WebElement getPedidoCompletoMsj() {
        return pedidoCompletoMsj;
    }

    public CompraCompletadaPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public void verMiPedido(){
        verPedidoBtn.click();
    }


}
