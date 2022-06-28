package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.CommonPage;
import org.example.Pages.HomePage;
import org.example.Pages.SearchPage;
import org.junit.Assert;

public class ProductSteps {
    private final CommonPage commonPage = new CommonPage();
    private final HomePage homePage = new HomePage();
    private final SearchPage searchPage = new SearchPage();

    @Given("I am on the elevania home page")
    public void iAmOnTheElevaniaHomePage() {
        this.commonPage.goToUrl("https://www.elevenia.co.id/");
    }

    @When("I search {string}")
    public void iSearch(String searchWord) {
        this.homePage.searchItem(searchWord);
    }

    @And("I click search button")
    public void iClickSearchButton() {
        this.homePage.clickSearchBtn();
    }

    @Then("I should see {string} search result")
    public void iShouldSeeSearchResult(String searchWord) {
        Assert.assertTrue(this.searchPage.getSearchResult().contains(searchWord));
    }

    @When("I click {string}")
    public void iClick(String menu) {
        if (menu.equals("Produk terlaris")) {
            this.searchPage.clickProdukTerlarisLink();
        }
    }

    @Then("Product list sorted by {string}")
    public void productListSortedBy(String sortBy) {
    }

    @When("I click product number {int}")
    public void iClickProductNumber(int index) {
        this.searchPage.clickProductCard(index - 1);
    }

    @Then("I redirected to the right product detail page")
    public void iRedirectedToTheRightProductDetailPage() {
    }

    @And("I can see other products from the seller")
    public void iCanSeeOtherProductsFromTheSeller() {
    }

    @When("I add the quantity of the product {int} time(s)")
    public void iAddTheQuantityOfTheProductTimes(int total) {
    }

    @And("I can see the quantity changed to {int}")
    public void iCanSeeTheQuantityChangedTo(int total) {
    }

    @And("I click add to cart button")
    public void iClickAddToCartButton() {
    }

    @And("I can see pop up modals")
    public void iCanSeePopUpModals() {
    }

    @Then("I redirected to the cart page")
    public void iRedirectedToTheCartPage() {
    }

    @And("I can see the correct product added to the cart")
    public void iCanSeeTheCorrectProductAddedToTheCart() {
    }

    @And("I click {string} on pop up modals")
    public void iClickOnPopUpModals(String choose) {
    }

    @And("I close onboarding modal if exists")
    public void iCloseOnboardingModalIfExists() {
        this.homePage.closePromoIfExist();
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        this.commonPage.closeDriver();
    }
}
