package com.testprojects.facebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class FacebookRatingTest {
    private WebDriver driver;

    @FindBy(css = "")
    WebElement aaa;

    @BeforeTest
    public void setupSelenium(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        System.out.println("New");
    }

    @Test(priority = 1)
    public void facebookRatingCompare(){
        driver.navigate().to("http://www.google.com");

        String searchTerm = "Facebook";
        String expectedResult = "katana";

//        WebElement searchBar = driver.findElement(By.cssSelector("input.gsfi")).clear();
        driver.findElement(By.cssSelector("input.gsfi")).sendKeys(searchTerm);
        driver.findElement(By.cssSelector("input.gsfi")).submit();

        int pageNumber = 1;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ListIterator<WebElement> itr;
        WebElement toClick;

        List<WebElement> searchResults;
        boolean flag = false;
        while (!flag) {
            searchResults = wait.until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(By
                            .xpath("//h3[@class='r']/a")));
            itr = searchResults.listIterator();
            while (itr.hasNext()) {
                toClick = itr.next();
                if (toClick.getAttribute("href").contains(expectedResult)) {
                    toClick.click();
                    flag = true;
                    break;
                }
            }
            if (!flag) {

                do {
                    driver.findElement(By.xpath("//a[@id='pnnext']/span[1]"))
                            .click();
                    pageNumber++;
                    searchResults.clear(); // clean list
                    wait.until(ExpectedConditions.textToBePresentInElementLocated(
                            By.xpath("//td[@class='cur']"), pageNumber + ""));
                } while (driver.findElement(By.cssSelector(".b.navend>a.pn")).isDisplayed());
                break;
            }
        }

        Assert.assertFalse(Integer.parseInt(driver.findElement(By.cssSelector(".rating-bar-container.two span.bar-number"))
                .getText().replaceAll("[\\D.]", "")) <
                Integer.parseInt(driver.findElement(By.cssSelector(".rating-bar-container.one span.bar-number"))
                .getText().replaceAll("[\\D.]", "")),"2 start should be more than 3 start");

        Assert.assertTrue(Integer.parseInt(driver.findElement(By.cssSelector(".rating-bar-container.one span.bar-number"))
                .getText().replaceAll("[\\D.]", "")) <
                Integer.parseInt(driver.findElement(By.cssSelector(".rating-bar-container.five span.bar-number"))
                        .getText().replaceAll("[\\D.]", "")));
    }

    @Test(dependsOnMethods = "facebookRatingCompare")
    public void aaa(){
       System.out.println( driver.getCurrentUrl());
    }
    @AfterTest
    public void closeSelenium(){
        driver.quit();
    }

}
