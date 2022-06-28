package org.example.Pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NoArgsConstructor
public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver newDriver) {
        this.driver = newDriver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//h1[@class='notranslate']")
    private WebElement productName;

    @FindBy(xpath = "//span[@class='price notranslate']")
    private WebElement productPrice;

    @FindBy(xpath = "//span[@class='normPrice notranslate']")
    private WebElement productNormalPrice;

    @FindBy(xpath = "//div[@class='optionSelect']//button[@class='ico_btnType incre'][normalize-space()='Increase']")
    private WebElement incrementBtn;

    @FindBy(xpath = "//div[@class='optionSelect']//button[@class='ico_btnType decre'][normalize-space()='Decrease']")
    private WebElement decrementBtn;

    @FindBy(xpath = "//a[@class='btnStyle btnFlat btnL btnOrangeW']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@id='mo_lay144']//div[@class='popCon']")
    private WebElement popUpModal;

    @FindBy(xpath = "//ul[@class='prdList prdListH']")
    private WebElement otherProductList;

    @FindBy(xpath = "//a[@href='http://www.elevenia.co.id/cart/CartAction/getCartList.do']")
    private WebElement yesCartBtn;

    @FindBy(xpath = "//div[@id='mo_lay144']//a[@class='btnStyle btnS btnWGray btnClose'][normalize-space()='Tidak']")
    private WebElement noCartBtn;

    public void addProductQty(int index) {
        for (int i = 0; i < index; i++) {
            incrementBtn.click();
        }
    }

    public void substractProductQty(int index) {
        for (int i = 0; i < index; i++) {
            decrementBtn.click();
        }
    }

    public boolean isModalPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> popUpModal.isDisplayed());
        return this.popUpModal.isDisplayed();
    }

    public void clickYesCartBtn() {
        this.yesCartBtn.click();
    }

    public boolean isOtherProductExist() {
        return this.otherProductList.isEnabled();
    }

    public void clickAddToCart() {
        this.addToCartBtn.click();
    }

    public void clickNoCartBtn() {
        this.noCartBtn.click();
    }
}
