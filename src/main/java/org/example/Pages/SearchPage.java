package org.example.Pages;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver newDriver) {
        this.driver = newDriver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//p[@class='searchTxt']//strong")
    private WebElement searchResult;

    @FindBy(xpath = "//a[normalize-space()='Produk terlaris']")
    private WebElement bestProductLink;

    @FindBy(xpath = "//li[@class='itemList']/div[@class='group']/a")
    private List<WebElement> productCard;

    public String getSearchResult() {
        return searchResult.getText();
    }

    public void clickProdukTerlarisLink() {
        bestProductLink.click();
    }

    public void clickProductCard(int index) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productCard.get(index).click();
    }
}
