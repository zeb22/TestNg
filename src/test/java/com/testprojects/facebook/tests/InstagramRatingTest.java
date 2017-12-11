package com.testprojects.facebook.tests;

import com.testprojects.facebook.pages.GoogleResultsPage;
import com.testprojects.facebook.pages.GoogleSearchPage;
import com.testprojects.facebook.pages.InstagramGooglePage;
import com.testprojects.facebook.utilities.FunctionalTest;
import org.testng.annotations.Test;

public class InstagramRatingTest extends FunctionalTest{
    /**
     * search Google
     */
    @Test()
    public void searchOnGoogle(){
        String searchTerm = "Instagram App";
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
        InstagramGooglePage instagram = new InstagramGooglePage(getDriver());
        instagram.fiveStarReviewsAreTheMost();
        instagram.sumOf2And3StarsIsLessThan4Stars();
    }

    /**
     * 4 > 3, 3 > 2, 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test2(){
        InstagramGooglePage instagram = new InstagramGooglePage(getDriver());
        instagram.fourStarsAreMoreThan3AreMoreThan2StarsAreMoreThan1Star();
    }

    /**
     * 3 > 2, 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test3(){
        InstagramGooglePage instagram = new InstagramGooglePage(getDriver());
        instagram.threeStarsAreMoreThan2StarsAreMoreThan1Star();
    }

    /**
     * 2 > 1
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test4(){
        InstagramGooglePage instagram = new InstagramGooglePage(getDriver());
        instagram.twoStarsAreMoreThanOneStar();
    }

    /**
     * 2 + 3 < 4
     */
    @Test(dependsOnMethods = "clickOnSearchResult")
    public void test5(){
        InstagramGooglePage instagram = new InstagramGooglePage(getDriver());
        instagram.sumOf2And3StarsIsLessThan4Stars();
    }
}
