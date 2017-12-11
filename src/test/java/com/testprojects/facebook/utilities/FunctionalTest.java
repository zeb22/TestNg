package com.testprojects.facebook.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
