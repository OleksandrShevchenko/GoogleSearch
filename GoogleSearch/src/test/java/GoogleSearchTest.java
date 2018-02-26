import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.log4j.Logger;
import pac.*;

public class GoogleSearchTest {

    private static final Logger Log = Logger.getLogger("console");

    @BeforeMethod
    public void setUp() {
        GooglePage.invokeHomePage();
    }

    @AfterMethod
    public static void cleanUp() {
        Browser.quit();
    }

    @Test(enabled = true)
    @Parameters("phraseToSearch")
    public void test_Search_First_Title(@Optional("automation") String phraseToSearch) {

        GooglePage.searchResultsInvoke(phraseToSearch);
        GooglePage.navigateToFirstLink();

        String actualTitle = Browser.getTitle();
        Assert.assertTrue(actualTitle.toLowerCase().contains(phraseToSearch.toLowerCase()),
                "Actual Title: " + actualTitle + " Expected Title: " + phraseToSearch);
        Log.info("[INFO] Testcase test_Search_First_Title was successfully completed!");

    }

    @Test(enabled = true)
    @Parameters({"phraseToSearch", "pagesCount", "domainToSearchFor"})
    public void test_Search_For_Domain(@Optional("automation") String searchPattern,
                                       @Optional("5") String pagesCount,
                                       @Optional("testautomationday.com") String domainToSearchFor) {

        GooglePage.searchResultsInvoke(searchPattern);
        Boolean domainFound = GooglePage.checkDomainExistsOnPages(domainToSearchFor, pagesCount);

        Assert.assertTrue(domainFound, "ERROR: " + domainToSearchFor + " was not found on Pages [1-" + pagesCount + "].");
        Log.info("[INFO] Test SearchDomainTest was successfully completed!");

    }

}