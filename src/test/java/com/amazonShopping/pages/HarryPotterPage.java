package com.amazonShopping.pages;

import com.amazonShopping.utilities.Driver;
import com.amazonShopping.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class HarryPotterPage {
    
    
    
    @FindBy(id = "a-page")
    public WebElement loaderMaskElement2;
    
    @FindBy(xpath = "//span[@class='cat-name']")
    public WebElement bestSellerTag;
    
    @FindBy(xpath = "//div[2]//h2[1]//span[1]")
    public List<WebElement> bookLinksElement;
    
    @FindBy(xpath = "//*[@id=\"authorFollow_feature_div\"]/div[1]/div[2]/a")
    public WebElement authorNameTag;
    
    @FindBy(xpath = "//*[.='9 - 11 years']/../../div[3]/span")
    public WebElement readingAge;
    
    @FindBy(xpath = "//*[.='352 pages']/../../div[3]/span")
    public WebElement printLength;
    
    @FindBy(xpath = "//*[@id=\"showMoreFormatsPrompt\"]")
    public WebElement allEditionFormatsLink;
    
    @FindBy(xpath = "//*[@id='twister']//table//tr/td[1]")
    public List<WebElement> allEditionFormats;
    
    @FindBy(xpath = "//div[@id='leftCol']//style/../div/img")
    public WebElement selectTheBook;
    
    @FindBy(xpath = "//*[@id=\"sitbReaderCart-form\"]/span/span/input")
    public WebElement addTheBasket;
    
    @FindBy(xpath = "//*[@id=\"hlb-ptc-btn-native\"]")
    public WebElement proceedToCheckout;
    
    @FindBy(xpath = "//*[@id=\"createAccountSubmit\"]")
    public WebElement createYourAccount;
    
    @FindBy(xpath = "//*[@id=\"ap_register_form\"]/div//label")
    public List<WebElement> creatAccountLabels;
    
    
    
    public static WebElement getBookFeature(Feature feature) {
    
        WebElement element = null;
        try {
        
        
               element = Utils.waitFor().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.='" + FeatureMathcher(feature) +
                "']/../." +
                "./div[3]/span")));
        }catch (NoSuchElementException e){
    
            e.printStackTrace();
        }
       return element;
    }
    
    public static String FeatureMathcher(Feature feature) {
        
        switch (feature) {
            case AGE:
                return "Reading age";
            case LENGTH:
                return "Print length";
            case LANGUAGE:
                return "Language:";
            case DIMENSIONS:
                return "Dimensions";
            case PUBLISHER:
                return "Publisher";
            case DATE:
                return "Publication date";
            case ISBN10:
                return "ISBN-10";
            case ISBN13:
                return "ISBN-13";
        }
        return null;
    }
    public enum Feature {
        AGE,
        LENGTH,
        LANGUAGE,
        DIMENSIONS,
        PUBLISHER,
        DATE,
        ISBN10,
        ISBN13,
    }
    
    
    public String selectBoxEndPoint ="https://www.amazon.co.uk/Harry-Potter-Philosophers-Stone/dp/1408855658/ref" +
        "=sr_1_1?dchild=1&keywords" +
            "=Harry" +
            "+Potter" +
            "+and+the+Philosopher%27s+Stone&qid=1608777771&s=books&sr=1-1";
    
    public String createAccountEndpoint = "https://www.amazon.co.uk/ap/register?showRememberMe=true&showRmrMe=0" +
            "&openid.pape" +
            ".max_auth_age=0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2" +
            ".0%2Fidentifier_select&siteState=isRegularCheckout.1%7CIMBMsgs.%7CisRedirect" +
            ".0&pageId=amazon_checkout_gb&openid.return_to=https%3A%2F%2Fwww.amazon.co" +
            ".uk%2Fgp%2Fbuy%2Fsignin%2Fhandlers%2Fcontinue" +
            ".html%3Fie%3DUTF8%26brandId%3D%26cartItemIds%3D%26eGCApp%3D%26hasWorkingJavascript%3D0%26isEGCOrder%3D0" +
            "%26isFresh%3D0%26oldCustomerId%3D%26oldPurchaseId%3D%26preInitiateCustomerId%3D%26purchaseInProgress%3D" +
            "%26ref_%3Dcart_signin_submit%26siteDesign%3D&prevRID=CRYCDNRDDJ2NWQXJA5JX&openid" +
            ".assoc_handle=amazon_checkout_gb&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid" +
            ".net%2Fextensions%2Fpape%2F1.0&prepopulatedLoginId=&failedSignInCount=0&openid" +
            ".claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs" +
            ".openid.net%2Fauth%2F2.0";
    
    public HarryPotterPage() {
        PageFactory.initElements(Driver.get(), this);
        
    }
}
