package com.testprojects.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultsPage {
    private WebDriver driver;

    public GoogleResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h3.r > a")
    private List<WebElement> searchResults;
    public boolean isOnGoogleSearchResults(String expectedResult){
        boolean isThere = false;
        for (WebElement element : searchResults){
            if (element.getText().contains(expectedResult)){
                isThere = true;
            }
        }
        return isThere;
    }

    @FindBy(partialLinkText = "Google Play")
    private WebElement facebookAppLink;
    public void clickOnResult(String expectedResult){
        if (isOnGoogleSearchResults(expectedResult))
            facebookAppLink.click();
        else System.out.println("Searched entry not found");
    }
}
