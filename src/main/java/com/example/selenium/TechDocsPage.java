package com.example.selenium;

import com.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class TechDocsPage {

    private WebDriver driver;

    // Selectors
    private By dropdown = By.id(Constants.DROPDOWN_ID);
    private By lunaOption = By.cssSelector(Constants.LUNA_OPTION_CSS);
    private By catalogHeader = By.cssSelector(Constants.CATALOG_HEADER_CSS);
    private By viewDocumentLink = By.cssSelector(Constants.VIEW_DOCUMENT_LINK_CSS);
    private By downloadButton = By.cssSelector(Constants.DOWNLOAD_BUTTON_CSS);
    private By cookieAcceptButton = By.id(Constants.COOKIE_ACCEPT_BUTTON_ID);
    private By dropdownInput = By.cssSelector(Constants.DROPDOWN_INPUT_CSS);

    public TechDocsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Accept cookies
    public void acceptCookies() {
        if (driver.findElements(cookieAcceptButton).size() > 0) {
            WebElement cookieAccept = driver.findElement(cookieAcceptButton);
            cookieAccept.click();
        }
    }

    // Select "LUNA EUR" option from dropdown and verify catalog visibility
    public boolean selectLunaEURAndVerifyVisibility() {
        selectLunaEUR();
        return isCatalogVisible();
    }

    // "LUNA EUR" option selection logic
    private void selectLunaEUR() {
        WebElement dropdownElement = driver.findElement(dropdown);
        dropdownElement.click();

        WebElement dropdownInputElement = driver.findElement(dropdownInput);
        dropdownInputElement.sendKeys("LUNA EUR");

        WebElement lunaOptionElement = driver.findElement(lunaOption);
        lunaOptionElement.click();
    }

    // Verify that LUNA EUR catalog is visible
    private boolean isCatalogVisible() {
        WebElement catalog = driver.findElement(catalogHeader);
        return catalog.isDisplayed();
    }

    // View document and switch to new tab
    public boolean viewDocumentAndSwitchToNewTab() {
        viewDocument();
        return switchToNewTab() && waitForUrl(Constants.EXPECTED_URL_FRAGMENT);
    }

    // "View this document" link click logic
    private void viewDocument() {
        WebElement viewDocumentElement = driver.findElement(viewDocumentLink);
        viewDocumentElement.click();
    }

    // Switch to new tab logic
    private boolean switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                return true;
            }
        }
        return false;
    }

    // Wait for specific URL fragment in the new tab
    private boolean waitForUrl(String urlFragment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(driver -> driver.getCurrentUrl().contains(urlFragment));
    }

    // Close current tab, switch back to original tab, and download document
    public boolean closeTabAndDownloadDocument(String fileName) throws InterruptedException {
        closeCurrentTabAndSwitchBack();
        Thread.sleep(5000); // Wait for download button to be ready
        downloadDocument();
        Thread.sleep(5000); // Wait for download to complete
        return isFileDownloaded(fileName);
    }

    // Close current tab and switch back to original tab
    private void closeCurrentTabAndSwitchBack() {
        try {
            String originalWindow = driver.getWindowHandle();
            driver.close();

            Set<String> windows = driver.getWindowHandles();
            if (!windows.isEmpty()) {
                for (String window : windows) {
                    if (!window.equals(originalWindow)) {
                        driver.switchTo().window(window);
                        break;
                    }
                }
            } else {
                System.out.println("No remaining windows to switch back to.");
            }
        } catch (Exception e) {
            System.out.println("No window to close or switch back to: " + e.getMessage());
        }
    }

    // "Download" button click logic
    private void downloadDocument() {
        WebElement downloadBtn = driver.findElement(downloadButton);
        downloadBtn.click();
    }

    // Verify if the file has been downloaded
    private boolean isFileDownloaded(String fileName) {
        File downloadDir = new File(Constants.DOWNLOAD_DIR);
        File[] files = downloadDir.listFiles((dir, name) -> name.equals(fileName));
        return files != null && files.length > 0;
    }
}
