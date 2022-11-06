package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSteps {
    private WebDriver driver;
    private CommonPage commonPage;
    private RegisterPage registerPage;
    @Given("I launch chrome broswer")
    public void iLaunchChromeBroswer() {
        //change the driver path to your own driver path
        String driverPath = "C:\\Users\\fedrick.siagian\\DevLand\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
        this.commonPage = new CommonPage(this.driver);
        this.registerPage = new RegisterPage(this.driver);
    }
    @Given("I open Cermati registration page")
    public void iOpenCermatiRegistrationPage() {
        commonPage.goToUrl("https://www.cermati.com/app/gabung");
    }

    @When("I fill in {string} with {string}")
    public void iFillInWith(String field, String value) throws InterruptedException {
        this.registerPage.setFieldWithValue(field, value);
    }

    @And("I press register button")
    public void iPressRegisterButton() {
        this.registerPage.clickRegisterBtn();
    }

    @Then("I should be on the {string} page")
    public void iShouldBeOnThePage(String arg0) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(
                this.commonPage.getDriver().getCurrentUrl().equalsIgnoreCase("https://www.cermati.com/app/verification-methods"));
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        this.commonPage.closeDriver();
    }
}
