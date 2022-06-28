package org.example.Pages;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class SearchPage {
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
        productCard.get(index).click();
    }
}
