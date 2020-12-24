package com.amazonShopping.steps;

import com.amazonShopping.pages.HarryPotterPage;
import com.amazonShopping.pages.HomePage;
import com.amazonShopping.utilities.BrowserUtils;
import com.amazonShopping.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AmazonSteps {
    @Given("Users should be able to select {string} options from drop down")
    public void usersShouldBeAbleToSelectOptionsFromDropDown(String category) throws InterruptedException {
        
        HomePage homePage = new HomePage();
        WebElement selectDropdown = homePage.selectDropdown;
        Utils.verifyThatCategorySelected(selectDropdown, category);
        
        
    }
    
    @And("Search for the book named {string}")
    public void searchForTheBookNamed(String bookName) {
        
        HomePage homePage = new HomePage();
        
        homePage.searchBox.sendKeys(bookName, Keys.ENTER);
        
        Utils.waitFor().until(ExpectedConditions.visibilityOf(homePage.loaderMaskElement1));
        
        String searchResult = homePage.searchResult.getText().trim();
        
        Assert.assertTrue(searchResult.contains(" Harry Potter "), "search results are not matched");
        
    }
    
    
    @Then("Check if Book is a {string} or Not")
    public void checkIfBookIsAOrNot(String bestSeller) throws InterruptedException {
        HarryPotterPage hp = new HarryPotterPage();
        // Driver.get().get(hp.selectBoxEndPoint);
        String bookName = "Harry Potter and the Philosopher's Stone";
        Utils.getElementWithFluentWait(hp.loaderMaskElement2);
        
        Thread.sleep(3000);
        Utils.getTextFromListElement(hp.bookLinksElement, bookName).click();
        
        Assert.assertEquals(hp.bestSellerTag.getText(), "#4 this week", "Not best Seller");
        
        
    }
    
    @And("Verify other {string} and {string} related information from the search page")
    public void verifyOtherAndRelatedInformationFromTheSearchPage(String authorName, String bookTitle) {
        
        
        HarryPotterPage hp = new HarryPotterPage();
        // Driver.get().get(hp.selectBoxEndPoint);
        Assert.assertEquals(hp.authorNameTag.getText(), "J.K. Rowling");
        BrowserUtils.hover(hp.bookInfoElementList.get(0));
        
        List<String> infoList = BrowserUtils.getElementsText(hp.bookInfoElementList);
        Assert.assertTrue(infoList.get(0).equals("1408855658"), "ASIN is wrong");
        Assert.assertTrue(infoList.get(1).equals("Bloomsbury Children's Books; 1st edition (1 Sept. 2014)"),
                "Publisher Info wrong");
        Assert.assertTrue(infoList.get(2).equals("English"), "Language is wrong");
        
        
    }
    
    @Then("Check if Book is available in the format of an {string}?")
    public void checkIfBookIsAvailableInTheFormatOfAn(String typeEdition) {
        
        HarryPotterPage hp = new HarryPotterPage();
        // Driver.get().get(hp.selectBoxEndPoint);
        BrowserUtils.hover(hp.allEditionFormatsLink);
        hp.allEditionFormatsLink.click();
        List<String> editionFormats = BrowserUtils.getElementsText(hp.allEditionFormats);
        Assert.assertTrue(editionFormats.get(1).equals("Kindle Edition"), "Kindle Edition is not available");
        
        
    }
    
    @And("Select the book and {string}")
    public void selectTheBookAnd(String arg0) {
        HarryPotterPage hp = new HarryPotterPage();
        // Driver.get().get(hp.selectBoxEndPoint);
        Utils.getElementWithFluentWait(hp.selectTheBook).click();
        Utils.getElementWithFluentWait(hp.addTheBasket).click();
        Utils.moveToElement(hp.proceedToCheckout).click();
        
        
    }
    
    @Then("Select Create Your Amazon Account if user do not have an account")
    public void SelectCreateYourAmazonAccountIfUserDoNotHaveAnAccount() {
        
        HarryPotterPage hp = new HarryPotterPage();
        // Driver.get().get(hp.createAccountEndpoint);
        Utils.getElementWithFluentWait(hp.createYourAccount).click();
    }
    
    @And("verify all fields available on Create Your Amazon Account page")
    public void VerifyAllFieldsAvailableOnCreateYourAmazonAccountPage() {
        
        
        HarryPotterPage hp = new HarryPotterPage();
        // Driver.get().get(hp.createAccountEndpoint);
        Utils.verifyText(hp.creatAccountLabels.get(0), "Your name");
        Utils.verifyText(hp.creatAccountLabels.get(1), "Email");
        Utils.verifyText(hp.creatAccountLabels.get(2), "Password");
        Utils.verifyText(hp.creatAccountLabels.get(3), "Re-enter password");
        
        
    }
}
