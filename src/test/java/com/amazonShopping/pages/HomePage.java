package com.amazonShopping.pages;

import com.amazonShopping.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    
    
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;
    
    @FindBy(xpath = "//*[@id='searchDropdownBox']")
    public WebElement selectDropdown;
    
    @FindBy(xpath = "//*[@id='searchDropdownBox']//div")
    public WebElement bookSelect;
    
    @FindBy(css = ".a-aui_72554-c")
    public WebElement loaderMaskElement1;
    
    @FindBy(xpath = "//*[@id=\"search\"]//h1//div[1]//span[3]")
    public WebElement searchResult;
    
    

    
    
    
    
    
    public HomePage() {
        PageFactory.initElements(Driver.get(),this);
        
    }
    
    
}
