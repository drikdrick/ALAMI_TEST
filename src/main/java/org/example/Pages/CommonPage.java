package org.example.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class CommonPage {
    private WebDriver driver;

    public CommonPage(WebDriver newDriver) {
        this.driver = newDriver;
        PageFactory.initElements(this.driver, this);

    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void goToUrl(String url) {
        this.getDriver().get(url);
        this.getDriver().manage().window().maximize();
        this.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeDriver() {
        this.getDriver().close();
        this.getDriver().quit();
    }
}
