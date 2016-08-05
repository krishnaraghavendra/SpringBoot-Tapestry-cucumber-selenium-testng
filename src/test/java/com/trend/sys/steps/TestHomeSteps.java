package com.trend.sys.steps;

import com.trend.sys.UATBase;
import com.trend.sys.pages.HomePageUAT;
import com.trend.sys.pages.IndexPageUAT;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kabburi on 8/5/2016.
 */
public class TestHomeSteps extends UATBase {

    IndexPageUAT indexPageUAT;

    HomePageUAT homePageUAT;

    @Before
    public void setupForTest() {
        driver = new FirefoxDriver();
    }

    @After
    public void shutDown(Scenario scenario) {

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");

        driver.quit();
    }

    @Given("the user enters Index page")
    public void setup() {
        indexPageUAT = new IndexPageUAT(driver);
        assertThat(indexPageUAT.checkIfThePageIsIndexPage()).isTrue();
    }

    @When("user navigates to home page")
    public void userNavigatesToHome() {
        homePageUAT = indexPageUAT.clickOnHomeButton();
        assertThat(homePageUAT.checkIfThePageIsHomePage()).isTrue();
    }

    @Then("user should be able to see home page")
    public void checkForAllHeaders() {
        assertThat(homePageUAT.checkIfHomePageTextAvailable()).isTrue();
    }
}
