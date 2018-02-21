import org.testng.Assert;
import org.testng.annotations.*;
import pac.*;

public class GoogleSearchTest {

    @BeforeMethod
    public void setUp() {

        GooglePage.invokeHomePage();
    }

    @AfterClass
    public static void cleanUp() {
        Browser.quit();
    }

    @Test(enabled = true)
    @Parameters("phraseToSearch")
	public void test_Search_First_Title (@Optional("automation") String phraseToSearch) {

        GooglePage.searchResultsInvoke(phraseToSearch);
        GooglePage.navigateToFirstLink();

        String actualTitle = Browser.getTitle();
        Assert.assertTrue(actualTitle.toLowerCase().contains(phraseToSearch.toLowerCase()),
                "Actual Title: " + actualTitle + " Expected Title: " + phraseToSearch);
        Log.info("Testcase test_Search_First_Title was successfully completed!");

    }

    @Test(enabled = true)
    @Parameters({"phraseToSearch", "pagesCount", "domainToSearchFor"})
    public void test2_Search_For_Domain(@Optional("automation") String searchPattern,
                                        @Optional("5") String pagesCount,
                                        @Optional("bbsautomation.com") String domainToSearchFor) {
//                                                 testautomationday

        GooglePage.searchResultsInvoke(searchPattern);
        Boolean domainFound = GooglePage.checkDomainExistsOnPages(domainToSearchFor, pagesCount);

        Assert.assertTrue(domainFound, "ERROR: " + domainToSearchFor + " was not found on Pages [1-" + pagesCount + "].");
        Log.info("[INFO] Test SearchDomainTest was successfully completed!");

    }

}