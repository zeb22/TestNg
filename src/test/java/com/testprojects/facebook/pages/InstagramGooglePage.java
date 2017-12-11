package com.testprojects.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InstagramGooglePage {
    private WebDriver driver;

    public InstagramGooglePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".rating-bar-container.one span.bar-number")
    private WebElement oneStarReviews;
    @FindBy(css = ".rating-bar-container.two span.bar-number")
    private WebElement twoStarReviews;
    @FindBy(css = ".rating-bar-container.three span.bar-number")
    private WebElement threeStarsReviews;
    @FindBy(css = ".rating-bar-container.four span.bar-number")
    private WebElement fourStarReviews;
    @FindBy(css = ".rating-bar-container.five span.bar-number")
    private WebElement fiveStarReviews;

    private Integer oneStar;
    private Integer twoStars;
    private Integer threeStars;
    private Integer fourStars;
    private Integer fiveStars;

    public void fiveStarReviewsAreTheMost(){
        oneStar = Integer.parseInt(oneStarReviews.getText().replaceAll("[\\D.]", ""));
        twoStars = Integer.parseInt(twoStarReviews.getText().replaceAll("[\\D.]", ""));
        threeStars = Integer.parseInt(threeStarsReviews.getText().replaceAll("[\\D.]", ""));
        fourStars = Integer.parseInt(fourStarReviews.getText().replaceAll("[\\D.]", ""));
        fiveStars = Integer.parseInt(fiveStarReviews.getText().replaceAll("[\\D]", ""));

        Assert.assertTrue(fiveStars > fourStars
                && fiveStars > threeStars
                && fiveStars > twoStars
                && fiveStars > oneStar);
    }

    public void fourStarsAreMoreThan3AreMoreThan2StarsAreMoreThan1Star(){
        oneStar = Integer.parseInt(oneStarReviews.getText().replaceAll("[\\D.]", ""));
        twoStars = Integer.parseInt(twoStarReviews.getText().replaceAll("[\\D.]", ""));
        threeStars = Integer.parseInt(threeStarsReviews.getText().replaceAll("[\\D.]", ""));
        fourStars = Integer.parseInt(fourStarReviews.getText().replaceAll("[\\D.]", ""));

        Assert.assertTrue(fourStars > threeStars &&
                threeStars > twoStars &&
                twoStars > oneStar,"4 > 3, 3 > 2 , 2 > 1");
    }

    public void threeStarsAreMoreThan2StarsAreMoreThan1Star(){
        oneStar = Integer.parseInt(oneStarReviews.getText().replaceAll("[\\D.]", ""));
        twoStars = Integer.parseInt(twoStarReviews.getText().replaceAll("[\\D.]", ""));
        threeStars = Integer.parseInt(threeStarsReviews.getText().replaceAll("[\\D.]", ""));

        Assert.assertTrue(threeStars > twoStars && twoStars > oneStar, "3 > 2, 2 > 1");
    }

    public void twoStarsAreMoreThanOneStar(){
        oneStar = Integer.parseInt(oneStarReviews.getText().replaceAll("[\\D.]", ""));
        twoStars = Integer.parseInt(twoStarReviews.getText().replaceAll("[\\D.]", ""));

        Assert.assertTrue(twoStars > oneStar,"2 stars should be more than 1 star");
    }

    public void sumOf2And3StarsIsLessThan4Stars(){
        twoStars = Integer.parseInt(twoStarReviews.getText().replaceAll("[\\D.]", ""));
        threeStars = Integer.parseInt(threeStarsReviews.getText().replaceAll("[\\D.]", ""));
        fourStars = Integer.parseInt(fourStarReviews.getText().replaceAll("[\\D.]", ""));
        Integer sum2And3 = twoStars + threeStars;

        Assert.assertTrue(fourStars > sum2And3, "4 stars reviews are more than sum of 2 and 3");
    }
}
