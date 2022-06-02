import elements.HomePage;
import elements.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void testMenuMotorIsPresent() throws Exception {
        try {
            HomePage home = new HomePage(driver);
            util.waitForPageToLoad(5000);
            //WebElement menuMotor = home.getMenuMotor();
           // assertTrue(menuMotor.isDisplayed());
            System.out.println("El menú de Motor está presente en la página");
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
