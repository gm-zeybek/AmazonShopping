package com.amazonShopping.steps;

import com.amazonShopping.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.amazonShopping.utilities.Utils.*;


public class AmazonSteps extends HomePage {
    private String bookName;
    
    @Given("Users should be able to select {string} options from drop down")
    public void usersShouldBeAbleToSelectOptionsFromDropDown(String category) {
        
        // selecting dropdown
        verifyThatCategorySelected(selectDropdown, category);
        
    }
    
    @And("Search for the book named {string}")
    public void searchForTheBookNamed(String bookName) {
        
        // makes the local variable global
        this.bookName = bookName;
        
        // enters string and verifyies results are related to sought string
        typeStringAndVerify(bookName, searchBox);
        
    }
    
    
    @Then("Check if Book is a Best Seller or Not")
    public void checkIfBookIsABestSellerOrNot() {
        
        // navigates to the book and wait for page loading
        clickOnAndWaitForPageLoad(clickableBookImageElement,loaderMaskElement2);
        
        // verifies bestseller badge is shown up
        verifyTextDisplayedAsExpected(bestSellerBadge,isDisplayed)
                .withFailMessage("best seller badge is not shown up");
        
    }
    
    
    
    @Then("Check if Book is available in the format of an Kindle Edition?")
    public void checkIfBookIsAvailableInTheFormatOfAn() {
        
        moveToElement(allEditionFormatsLink).click();
        
        verifyTextDisplayedAsExpected((allEditionFormats).get(1),isDisplayed)
                .withFailMessage("Kindle edition is not available");
    
        waitFor().until(ExpectedConditions.elementToBeClickable(hideButton)).click();
        
    }
    
    @And("Verify other author and book related information from the search page")
    public void Verify_other_author_and_book_related_information_from_the_search_page() {
        
        moveToElement(authorNameTag);
        
        verifyTextDisplayedAsExpected(authorNameTag,isDisplayed)
                .withFailMessage("author name is not displayed");
        
        moveToElement(ASINElement);
        
        verifyTextDisplayedAsExpected(bookRelatedItems.get(1),isDisplayed)
                .withFailMessage("ASIN number is not displayed");
        verifyTextDisplayedAsExpected(bookRelatedItems.get(2),isDisplayed)
                .withFailMessage("PublisherInfo is not displayed");
        verifyTextDisplayedAsExpected(bookRelatedItems.get(3),isDisplayed)
                .withFailMessage("Language is not displayed");
        verifyTextDisplayedAsExpected(bookRelatedItems.get(4),isDisplayed)
                .withFailMessage("page number is not displayed");
        verifyTextDisplayedAsExpected(bookRelatedItems.get(5),isDisplayed)
                .withFailMessage("ISBN-10 Info is not displayed");
        verifyTextDisplayedAsExpected(bookRelatedItems.get(6),isDisplayed)
                .withFailMessage("ISBN-13 Info is not displayed");
        verifyTextDisplayedAsExpected(bookRelatedItems.get(7),isDisplayed)
                .withFailMessage("Reading age Info is not displayed");
        verifyTextDisplayedAsExpected(bookRelatedItems.get(8),isDisplayed)
                .withFailMessage("Dimensions Info is not displayed");
        
        

    }
    
    @And("Select the book and proceed towards Check Out")
    public void selectTheBookAnd() {
        
        // navigate to proceed to checkout
        moveToElement(addToCartButton).click();
        moveToElement(proceedToCheckout).click();
        
        
    }
    
    @Then("Select Create Your Amazon Account if user do not have an account")
    public void SelectCreateYourAmazonAccountIfUserDoNotHaveAnAccount() {
        
        // create the account button
        moveToElement(createYourAccount).click();
    }
    
    @And("verify all fields available on Create Your Amazon Account page")
    public void VerifyAllFieldsAvailableOnCreateYourAmazonAccountPage() {
        
        
        
        // verifying input tags on the create account page
        
        verifyTextDisplayedAsExpected(creatAccountLabels.get(0),isDisplayed)
                .withFailMessage( "Your name is not displayed");
        verifyTextDisplayedAsExpected(creatAccountLabels.get(1),isDisplayed)
                .withFailMessage( "Your email is not displayed");
        verifyTextDisplayedAsExpected(creatAccountLabels.get(2),isDisplayed)
                .withFailMessage( "Your Password  is not displayed");
        verifyTextDisplayedAsExpected(creatAccountLabels.get(3),isDisplayed)
                .withFailMessage( "Re-enter password  is not displayed");
    
        
        // verifying checkboxes on the create account page
        typeStringAndVerify("userName", customerNameBox);
        typeStringAndVerify("e___@email.com", emailBox);
        typeStringAndVerify("password1111", passwordBox);
     
        
        verifyTextDisplayedAsExpected(realPersonMessage,isDisplayed)
                .withFailMessage("Any message isn't shown up");
        
    }
}
