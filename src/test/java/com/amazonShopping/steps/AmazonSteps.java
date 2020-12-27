package com.amazonShopping.steps;

import com.amazonShopping.pages.HarryPotterPage;
import com.amazonShopping.pages.HomePage;
import com.amazonShopping.utilities.BrowserUtils;
import com.amazonShopping.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class AmazonSteps {
    @Given("Users should be able to select {string} options from drop down")
    public void usersShouldBeAbleToSelectOptionsFromDropDown(String category) throws InterruptedException {
        
        HomePage homePage = new HomePage();
        // selecting dropdown
        WebElement selectDropdown = homePage.selectDropdown;
        Utils.verifyThatCategorySelected(selectDropdown, category);
        
        
    }
    
    @And("Search for the book named {string}")
    public void searchForTheBookNamed(String bookName) {
        
        HomePage homePage = new HomePage();
        
        // filtering
        homePage.searchBox.sendKeys(Keys.CLEAR, bookName, Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // waiting for page loading
        Utils.waitFor().until(ExpectedConditions.visibilityOf(homePage.loaderMaskElement1));
        
        // entering keyword
        String acualString = homePage.searchResult.getText();
        
        // verifying entered is seen on the searchbox
        Assert.assertEquals("search results are not matched", bookName, acualString.substring(1,
                acualString.length() - 1));
        
    }
    
    
    @Then("Check if Book is a {string} or Not")
    public void checkIfBookIsAOrNot(String bestSeller) throws InterruptedException {
        HarryPotterPage hp = new HarryPotterPage();
//         Driver.get().get(hp.selectBoxEndPoint);
        String bookName = "Harry Potter and the Philosopher's Stone";
        Utils.getElementWithFluentWait(hp.loaderMaskElement2);
        
        Thread.sleep(3000);
        Utils.getTextFromListElement(hp.bookLinksElement, bookName).click();
        
        Assert.assertEquals("Not best Seller", "#4 this week", hp.bestSellerTag.getText());
        
        
    }
    
    @And("Verify other author and book related information from the search page")
    public void Verify_other_author_and_book_related_information_from_the_search_page() throws InterruptedException {
        
        
        HarryPotterPage hp = new HarryPotterPage();
        //   Driver.get().get(hp.selectBoxEndPoint);
        
        // validating the author
        Assert.assertEquals("author name is not correct","J.K. Rowling", hp.authorNameTag.getText());
        
        Thread.sleep(5000);
        // validating the book
    
        Assert.assertEquals("age group not matched","9 - 11 years", hp.readingAge.getText());
        Assert.assertEquals("book page is not correct","352 pages", hp.printLength.getText());
        
    }
    
    @Then("Check if Book is available in the format of an {string}?")
    public void checkIfBookIsAvailableInTheFormatOfAn(String typeEdition) {
        
        HarryPotterPage hp = new HarryPotterPage();
//        Driver.get().get(hp.selectBoxEndPoint);
        // all available formats
        BrowserUtils.hover(hp.allEditionFormatsLink);
        hp.allEditionFormatsLink.click();
        List<String> editionFormats = BrowserUtils.getElementsText(hp.allEditionFormats);
        Assert.assertEquals("Kindle Edition is not available", "Kindle Edition", editionFormats.get(1));
        
        
    }
    
    @And("Select the book and {string}")
    public void selectTheBookAnd(String arg0) {
        HarryPotterPage hp = new HarryPotterPage();
//        Driver.get().get(hp.selectBoxEndPoint);
        
        // navigate to proceed to checkout
        Utils.moveToElement(hp.selectTheBook).click();
        Utils.moveToElement(hp.addTheBasket).click();
        Utils.moveToElement(hp.proceedToCheckout).click();
        
        
    }
    
    @Then("Select Create Your Amazon Account if user do not have an account")
    public void SelectCreateYourAmazonAccountIfUserDoNotHaveAnAccount() {
        
        HarryPotterPage hp = new HarryPotterPage();
//        Driver.get().get(hp.createAccountEndpoint);
        
        // create the account button
        Utils.moveToElement(hp.createYourAccount).click();
    }
    
    @And("verify all fields available on Create Your Amazon Account page")
    public void VerifyAllFieldsAvailableOnCreateYourAmazonAccountPage() throws InterruptedException {
        
        
        HarryPotterPage hp = new HarryPotterPage();
//        Driver.get().get(hp.createAccountEndpoint);
        
        // verifying input tags on the create account page
        
        Utils.verifyText(hp.creatAccountLabels.get(0), "Your name");
        Utils.verifyText(hp.creatAccountLabels.get(1), "Email");
        Utils.verifyText(hp.creatAccountLabels.get(2), "Password");
        Utils.verifyText(hp.creatAccountLabels.get(3), "Re-enter password");
        
        
    }
}
