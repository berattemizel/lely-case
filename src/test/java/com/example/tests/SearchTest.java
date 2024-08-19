package com.example.tests;

import com.example.selenium.BaseTest;
import com.example.selenium.SearchPage;
import com.example.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeMethod
    public void setUpTest() {
        driver.get(Constants.LELY_BASE_URL);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchFunctionality() {
        // Enter the keyword "happy" into the search box and initiate the search
        searchPage.searchFor(Constants.SEARCH_KEYWORD);
        // Verify that all search results contain the keyword "happy"
        Assert.assertTrue(searchPage.verifyResultsContainKeyword(Constants.SEARCH_KEYWORD),
                "Not all search results contain the keyword 'happy'");
    }

}
