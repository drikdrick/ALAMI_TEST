package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSteps {
    private WebDriver driver;
    private CommonPage commonPage;
    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Given("I am on the elevania home page")
    public void iAmOnTheElevaniaHomePage() {
        commonPage.goToUrl("https://www.elevenia.co.id/");
    }

    @When("I search {string}")
    public void iSearch(String searchWord) {
        homePage.searchItem(searchWord);
    }

    @And("I click search button")
    public void iClickSearchButton() {
        homePage.clickSearchBtn();
    }

    @Then("I should see {string} search result")
    public void iShouldSeeSearchResult(String searchWord) {
        Assert.assertTrue(searchPage.getSearchResult().contains(searchWord));
    }

    @When("I click {string}")
    public void iClick(String menu) {
        if (menu.equals("Produk terlaris")) {
            searchPage.clickProdukTerlarisLink();
        }
    }

    @Then("Product list sorted by {string}")
    public void productListSortedBy(String sortBy) {
    }

    @When("I click product number {int}")
    public void iClickProductNumber(int index) {
        searchPage.clickProductCard(index - 1);
    }

    @Then("I redirected to the right product detail page")
    public void iRedirectedToTheRightProductDetailPage() {
    }

    @And("I can see other products from the seller")
    public void iCanSeeOtherProductsFromTheSeller() {
        Assert.assertTrue(productPage.isOtherProductExist());
    }

    @When("I add the quantity of the product {int} time(s)")
    public void iAddTheQuantityOfTheProductTimes(int total) {
        productPage.addProductQty(total);
    }

    @And("I can see the quantity changed to {int}")
    public void iCanSeeTheQuantityChangedTo(int total) {
    }

    @And("I click add to cart button")
    public void iClickAddToCartButton() {
        productPage.clickAddToCart();
    }

    @And("I can see pop up modals")
    public void iCanSeePopUpModals() {
        Assert.assertTrue(productPage.isModalPopUp());
    }

    @Then("I redirected to the cart page")
    public void iRedirectedToTheCartPage() {
        Assert.assertTrue(
                driver.getCurrentUrl().contains("https://www.elevenia.co.id/cart/CartAction/getCartList.do"));
    }

    @And("I can see the correct product added to the cart")
    public void iCanSeeTheCorrectProductAddedToTheCart() {
    }

    @And("I click {string} on pop up modals")
    public void iClickOnPopUpModals(String choose) {
        if (choose.equals("Yes")) {
            productPage.clickYesCartBtn();
        } else {
            productPage.clickNoCartBtn();
        }
    }

    @And("I close onboarding modal if exists")
    public void iCloseOnboardingModalIfExists() {
        homePage.closePromoIfExist();
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commonPage.closeDriver();
    }

    @Given("I launch chrome broswer")
    public void iLaunchChromeBroswer() {
        //change the driver path to your own driver path
        String driverPath = "C:\\Users\\fedrick.siagian\\DevLand\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
        this.commonPage = new CommonPage(this.driver);
        this.homePage = new HomePage(this.driver);
        this.searchPage = new SearchPage(this.driver);
        this.productPage = new ProductPage(this.driver);
        this.cartPage = new CartPage(this.driver);
    }

    @When("I click change delievery option")
    public void iClickChangeDelieveryOption() {
        cartPage.clickChangeDeliveryBtn();
    }

    @Then("I can see delivery modal pops up")
    public void iCanSeeDeliveryModalPopsUp() {
        Assert.assertTrue(cartPage.isDeliveryModalDisplayed());
    }

    @When("I cancel to change delivery option")
    public void iCancelToChangeDeliveryOption() {
        cartPage.cancelDeliveryChange();
    }

    @And("I delete product")
    public void iClickDeleteProduct() {
        cartPage.deleteProduct();
        cartPage.confirmDelete();
    }

    @Then("Selected product is deleted from the cart")
    public void selectedProductIsDeletedFromTheCart() {
    }
}
