package com.amazonShopping.pages;

import com.amazonShopping.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HarryPotterPage {
    
    
    
    
    @FindBy(className = "a-ember")
    public WebElement loaderMaskElement2;
    
    @FindBy(xpath = "//span/span[contains(.,'ASIN')]")
    public WebElement ASINElement;
    
    @FindBy(xpath = "//*[@id=\"detailBullets_feature_div\"]//li//span[2]")
    public List<WebElement> bookRelatedItems;
    
    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    public WebElement addToCartButton;
    
    @FindBy(xpath = "//i[@class=\"a-icon a-icon-arrow rotate\"]/../span[2]")
    public WebElement hideButton;
    
    @FindBy(css = "[id=\"search\"] div[data-index=\"0\"] img")
    public WebElement clickableBookImageElement;
    
    @FindBy(xpath = "//*[@id=\"ap_customer_name\"]")
    public WebElement customerNameBox;
    
    @FindBy(xpath = "//*[@id=\"chartsBadge_feature_div\"]/div/a/span")
    public WebElement bestSellerBadge;
    
    @FindBy(xpath = "//*[@id=\"authorFollow_feature_div\"]/div[1]/div[2]/a")
    public WebElement authorNameTag;
    
    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    public WebElement emailBox;
    
    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    public WebElement passwordBox;
    
    @FindBy(xpath = "//*[@id=\"showMoreFormatsPrompt\"]")
    public WebElement allEditionFormatsLink;
    
    @FindBy(xpath = "//*[@id='twister']//table//tr/td[1]")
    public List<WebElement> allEditionFormats;
    
    @FindBy(xpath = "//*[@id=\"cvf-page-content\"]//div[1]/span")
    public WebElement realPersonMessage;
    
    @FindBy(xpath = "//*[@id=\"hlb-ptc-btn-native\"]")
    public WebElement proceedToCheckout;
    
    @FindBy(xpath = "//*[@id=\"createAccountSubmit\"]")
    public WebElement createYourAccount;
    
    @FindBy(xpath = "//*[@id=\"ap_register_form\"]/div//label")
    public List<WebElement> creatAccountLabels;
    
    

    
    public HarryPotterPage() {
        PageFactory.initElements(Driver.get(), this);
        
    }
}
