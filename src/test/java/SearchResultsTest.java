import elements.HomePage;
import elements.LoginPage;
import org.openqa.selenium.WebDriver;
import elements.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTest extends BaseTest{

    @Test
    public void verifyProductSearch() throws InterruptedException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        util.waitForPageToLoad(5000);
        homePage.searchItem();
    }
    @Test
    public void verifyAddFilter() throws InterruptedException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        util.waitForPageToLoad(3000);
        homePage.searchItem();
        util.waitForPageToLoad(3000);
        searchResultsPage.agregarFiltro();
        util.waitForPageToLoad(3000);
        Assert.assertTrue(searchResultsPage.getFilter().isEnabled());
    }

}
