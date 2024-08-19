package com.example.tests;

import com.example.selenium.BaseTest;
import com.example.selenium.TechDocsPage;
import com.example.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocumentTest extends BaseTest {

    private TechDocsPage techDocsPage;

    @BeforeMethod
    public void setUpTest() {
        driver.get(Constants.TECHDOCS_URL);
        techDocsPage = new TechDocsPage(driver);
        
        // Accept cookies
        techDocsPage.acceptCookies();
    }

    @Test
    public void testDocumentDownload() throws InterruptedException {
        // Select "LUNA EUR" option and verify visibility
        Assert.assertTrue(techDocsPage.selectLunaEURAndVerifyVisibility(), "The LUNA EUR catalog is not visible.");

        // Click "View this document" and verify it opens in a new tab
        Assert.assertTrue(techDocsPage.viewDocumentAndSwitchToNewTab(), "Failed to open document in a new tab with the expected URL.");

        // Close the tab, switch back to the original tab, and download the document
        Assert.assertTrue(techDocsPage.closeTabAndDownloadDocument("D-S006VT_-.pdf"), "File was not downloaded successfully.");
    }
}
