package org.example.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class CommonPage {
    private WebDriver driver;

    public CommonPage() {
        //change the driver path to your own driver path
        String driverPath = "C:\\Users\\fedrick.siagian\\DevLand\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
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
