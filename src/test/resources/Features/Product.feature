@Products @UI
Feature: Product Behaviour

  Scenario: Verify checkout product
    Given I launch chrome broswer
    And   I am on the elevania home page
    And   I close onboarding modal if exists
    When  I search "komputer"
    And   I click search button
    Then  I should see "komputer" search result
    When  I click "Produk terlaris"
    Then  Product list sorted by "Produk terlaris"
    When  I click product number 1
    Then  I redirected to the right product detail page
    And   I can see other products from the seller
    When  I add the quantity of the product 2 times
    And   I can see the quantity changed to 3
    And   I click add to cart button
    And   I can see pop up modals
    And   I click "Yes" on pop up modals
    Then  I redirected to the cart page
    And   I can see the correct product added to the cart
    When  I click change delievery option
    When  I cancel to change delivery option
    And   I delete product
    Then  Selected product is deleted from the cart
    And   I close the browser
