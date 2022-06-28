package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver newDriver) {
        this.driver = newDriver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//a[@name='deliveryChangePopup']")
    private WebElement changeDeliveryBtn;

    @FindBy(xpath = "//section[@class='openPopup smallPop kurirPop']")
    private WebElement deliveryModal;

    @FindBy(xpath = "//select[@id='dlvEtprsCd']")
    private WebElement deliverySelect;

    @FindBy(xpath = "//a[text()='Ubah']")
    private WebElement confirmDeliveryOptBtn;

    @FindBy(xpath = "//a[text()='Batal']")
    private WebElement cancelDeliveryOptBtn;

    @FindBy(xpath = "//a[@class='btnStyle btnS btnWGray'][normalize-space()='Hapus']")
    private WebElement deleteProductBtn;

    public void clickChangeDeliveryBtn() {
        changeDeliveryBtn.click();
    }

    public boolean isDeliveryModalDisplayed() {
        return deliveryModal.isDisplayed();
    }

    public void cancelDeliveryChange() {
        cancelDeliveryOptBtn.click();
    }

    public void deleteProduct() {
        deleteProductBtn.click();
    }
}
