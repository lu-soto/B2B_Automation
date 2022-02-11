import elements.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

   /* @Test
    public void testLogin() throws Exception {
        try {
            LoginPage login = new LoginPage(driver);
            login.userLogin(driver, propertyReader.getUserName(), propertyReader.getUserPassword());
            System.out.println("Login test completed successfully");
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }*/
    @Test
    public void testLoginPageTitle() throws Exception {
        try {
            LoginPage login = new LoginPage(driver);
            String title = driver.getTitle();
            System.out.println(title);
            //assertEquals(title, "Home");
            System.out.println("El titulo de la página está correcto");
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    @Test
    public void testLogoIsPresent() throws Exception {
        try {
            LoginPage login = new LoginPage(driver);
           // WebElement log = login.getLoginBtn();
            //log.click();
            login.userLogin(driver,propertyReader.getUserName(), propertyReader.getUserPassword());
            Thread.sleep(5000);
            WebElement logo = login.getLogo();
            assertTrue(logo.isDisplayed());
            System.out.println("El logo de Mannheim está visible");
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    /*@Test
    public void testForgotPassLink() throws Exception {
        try {
            LoginPage login = new LoginPage(driver);
            login.getLoginBtn().click();
            Thread.sleep(5000);
            login.getForgotPassBtn().click();
            System.out.println("Forgot password link is clickable");
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }*/
}
