package com.testprojects.facebook.tests;

import com.testprojects.facebook.pages.GmailGooglePlayPage;
import com.testprojects.facebook.pages.GoogleResultsPage;
import com.testprojects.facebook.pages.GoogleSearchPage;
import com.testprojects.facebook.utilities.FunctionalTest;
import org.testng.annotations.Test;

public class GmailRatingTest extends FunctionalTest{
    /**
     * search Google
     */
    @Test()
    public void searchOnGoogle(){
        String searchTerm = "Gmail App";
        GoogleSearchPage searchPage = new GoogleSearchPage(getDriver());
        searchPage.searchFor(searchTerm);
    }

    /**
     * accesare rezultat
     */
    @Test(dependsOnMethods = "searchOnGoogle")
    public void clickOnSearchResult(){
        String expectedResult = "Google Play";
        GoogleResultsPage resultsPage = new GoogleResultsPage(getDriver());
        resultsPage.clickOnResult(expectedResult);
    }

    /**
     * 5 star reviews are the most
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test1() {
        GmailGooglePlayPage gmail = new GmailGooglePlayPage(getDriver());
        gmail.fiveStarReviewsAreTheMost();
        gmail.sumOf2And3StarsIsLessThan4Stars();
    }

    /**
     * 4 > 3, 3 > 2, 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test2(){
        GmailGooglePlayPage gmail = new GmailGooglePlayPage(getDriver());
        gmail.fourStarsAreMoreThan3AreMoreThan2StarsAreMoreThan1Star();
    }

    /**
     * 3 > 2, 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test3(){
        GmailGooglePlayPage gmail = new GmailGooglePlayPage(getDriver());
        gmail.threeStarsAreMoreThan2StarsAreMoreThan1Star();
    }

    /**
     * 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test4(){
        GmailGooglePlayPage gmail = new GmailGooglePlayPage(getDriver());
        gmail.twoStarsAreMoreThanOneStar();
    }

    /**
     * 2 + 3 < 4
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test5(){
        GmailGooglePlayPage gmail = new GmailGooglePlayPage(getDriver());
        gmail.sumOf2And3StarsIsLessThan4Stars();
    }
}
