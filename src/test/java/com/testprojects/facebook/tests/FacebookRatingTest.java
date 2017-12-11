package com.testprojects.facebook.tests;

import com.testprojects.facebook.pages.FacebookGooglePlayPage;
import com.testprojects.facebook.pages.GoogleResultsPage;
import com.testprojects.facebook.pages.GoogleSearchPage;
import com.testprojects.facebook.utilities.FunctionalTest;
import org.testng.annotations.Test;

public class FacebookRatingTest extends FunctionalTest{

    /**
     * search Google
     */
    @Test()
    public void searchOnGoogle(){
        String searchTerm = "Facebook App";
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
        FacebookGooglePlayPage facebook = new FacebookGooglePlayPage(getDriver());
        facebook.fiveStarReviewsAreTheMost();
        facebook.sumOf2And3StarsIsLessThan4Stars();
    }

    /**
     * 4 > 3, 3 > 2, 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test2(){
        FacebookGooglePlayPage facebook = new FacebookGooglePlayPage(getDriver());
        facebook.fourStarsAreMoreThan3AreMoreThan2StarsAreMoreThan1Star();
    }

    /**
     * 3 > 2, 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test3(){
        FacebookGooglePlayPage facebook = new FacebookGooglePlayPage(getDriver());
        facebook.threeStarsAreMoreThan2StarsAreMoreThan1Star();
    }

    /**
     * 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test4(){
        FacebookGooglePlayPage facebook = new FacebookGooglePlayPage(getDriver());
        facebook.twoStarsAreMoreThanOneStar();
    }

    /**
     * 2 + 3 < 4
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test5(){
        FacebookGooglePlayPage facebook = new FacebookGooglePlayPage(getDriver());
        facebook.sumOf2And3StarsIsLessThan4Stars();
    }
}
