package com.trend.sys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by kabburi on 8/5/2016.
 */
public class IndexPageUAT {

    private WebDriver webDriver;

    public IndexPageUAT(WebDriver driver) {
        this.webDriver = driver;
        webDriver.get("http://localhost:9090/Index");
        webDriver.manage().window().maximize();
    }

    public boolean checkIfThePageIsIndexPage() {
        System.out.println(webDriver.getTitle());
        return webDriver.getTitle().equals("Index Page");
    }

    public HomePageUAT clickOnHomeButton() {
        webDriver.findElement(By.linkText("Home Page")).click();
        return new HomePageUAT(webDriver);
    }
}
