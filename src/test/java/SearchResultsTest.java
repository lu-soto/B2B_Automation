import elements.HomePage;
import elements.LoginPage;
import org.openqa.selenium.WebDriver;
import elements.*;

import org.testng.annotations.Test;

public class SearchResultsTest extends BaseTest{

    @Test
    public void testFilters() throws InterruptedException {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        util.waitForPageToLoad(5000);
        homePage.searchItem();
        util.waitForPageToLoad(15000);
        searchResultsPage.agregarFiltro();
        util.waitForPageToLoad(5000);
        searchResultsPage.liquidacionIsDisplayed();

    }
}
