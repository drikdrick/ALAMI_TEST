package org.example.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver newDriver) {
        this.driver = newDriver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//a[@name='deliveryChangePopup']")
    private WebElement changeDeliveryBtn;

    @FindBy(xpath = "//hgroup/strong[text()='Ubah Kurir']")
    private WebElement deliveryModal;

    @FindBy(xpath = "//select[@id='dlvEtprsCd']")
    private WebElement deliverySelect;

    @FindBy(xpath = "//a[text()='Ubah']")
    private WebElement confirmDeliveryOptBtn;

    @FindBy(xpath = "//p[@class='btnC']//a[@class='btnStyle btnM btnWGray']")
    private WebElement cancelDeliveryOptBtn;

    @FindBy(xpath = "//a[@class='btnStyle btnS btnWGray'][normalize-space()='Hapus']")
    private WebElement deleteProductBtn;

    @FindBy(xpath = "//a[@id='chkDelPopY']")
    private WebElement confirmDeleteProductBtn;

    public void clickChangeDeliveryBtn() {
        changeDeliveryBtn.click();
    }

    public boolean isDeliveryModalDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> deliveryModal.isEnabled());
        return deliveryModal.isEnabled();
    }

    public void cancelDeliveryChange() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:closeLayer();");
    }

    public void deleteProduct() {
        deleteProductBtn.click();
    }

    public void confirmDelete(){
        confirmDeleteProductBtn.click();
    }
}
