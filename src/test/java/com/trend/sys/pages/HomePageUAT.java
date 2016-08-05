package com.trend.sys.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by kabburi on 8/5/2016.
 */
public class HomePageUAT {

    private WebDriver webDriver;

    public HomePageUAT(WebDriver driver) {
        this.webDriver = driver;
    }

    public boolean checkIfThePageIsHomePage() {
        return webDriver.getTitle().equals("Home Page");
    }

    public boolean checkIfHomePageTextAvailable() {

        return webDriver.getPageSource().contains("This is Home Page");
    }
}
