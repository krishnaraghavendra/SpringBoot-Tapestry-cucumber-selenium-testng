package com.trend.sys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

/**
 * Created by kabburi on 8/5/2016.
 */
@ContextConfiguration
@SpringBootTest(classes = MainApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberOptions(features = "src/test/java/com/trend/sys/features",
        format = {"pretty", "html:target/cucumber"})
public class UATBase {

    protected WebDriver driver;

    @Test
    public void runAllTests() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
}
