Feature:  Amazon Searching a product, Basket, And Checkout functionalities

  @wip
  Scenario: Searching a product from menu, verify the features and the check out
    Given Users should be able to select "Books" options from drop down
    And Search for the book named "Harry Potter and the Philosopher's Stone"
    Then Check if Book is a "Best Seller" or Not
    And Verify other "author" and "book" related information from the search page
    Then Check if Book is available in the format of an "Kindle Edition"?
    And Select the book and "proceed towards Check Out"
    Then Select Create Your Amazon Account if user do not have an account
    And verify all fields available on Create Your Amazon Account page