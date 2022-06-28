package org.example.Pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@NoArgsConstructor
public class HomePage {
    @FindBy(xpath = "//a[@class='btn-close closeBtnMainPromo']")
    private WebElement closeMainPromoBtn;

    @FindBy(xpath = "//input[@id='AKCKwd']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='header-big']//button[@class='btn-search']")
    private WebElement searchBtn;

    public void closePromoIfExist() {
        if (closeMainPromoBtn.isDisplayed()) {
            closeMainPromoBtn.click();
        }
    }

    public void searchItem(String searchWord) {
        searchInput.sendKeys(searchWord);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }
}
