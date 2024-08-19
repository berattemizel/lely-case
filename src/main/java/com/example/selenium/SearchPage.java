package com.example.selenium;

import com.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private By searchButton = By.cssSelector(Constants.SEARCH_BUTTON_CSS);
    private By searchBox = By.cssSelector(Constants.SEARCH_BOX_CSS);
    private By searchResults = By.cssSelector(Constants.SEARCH_RESULTS_CSS);


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSearchButton() {
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
    }


    public void enterSearchKeyword(String keyword) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(keyword);
        searchInput.submit();
    }


    public void searchFor(String keyword) {
        clickSearchButton();
        enterSearchKeyword(keyword);
    }


    public boolean verifyResultsContainKeyword(String keyword) {
        List<WebElement> results = driver.findElements(searchResults);

        for (WebElement result : results) {
            String resultText = result.getText().toLowerCase();
            System.out.println("Result text: " + resultText);
            if (!resultText.contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

}
