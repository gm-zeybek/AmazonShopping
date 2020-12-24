package com.amazonShopping.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Utils {
    
    
    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }
    
    
    public static FluentWait<WebDriver> waitFor() {
        WebDriver driver;
        return new WebDriverWait(Driver.get(), 15).withTimeout(5, TimeUnit.SECONDS);
    }
    
    
    
    public static WebElement getElementWithFluentWait(WebElement element) {
        return Utils.waitFor().withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(element));
        
    }
    public static Actions moveToElement(WebElement element) {
        return new Actions(Driver.get()).
        moveToElement(element);
        
    }
    
    
    
    public static void verifyThatCategorySelected(WebElement selectElement, String category) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(category);
        String selectedCategory = select.getFirstSelectedOption().getText();
        Assert.assertEquals(category+" wasn't selected", selectedCategory, category);
        
    }
    
    public static void verifyText(WebElement element, String textToBeVerified) {
    
        boolean isVerified = element.getText().equalsIgnoreCase(textToBeVerified);
        
        Assert.assertTrue(textToBeVerified+" not equal", isVerified);
        
    }
    
    public static void verifyTextEntered(WebElement element, String textToBeVerified) {
       
       // waitFor().until(ExpectedConditions.elementSelectionStateToBe(element,true));
        
        element.sendKeys(textToBeVerified, Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        boolean isVerified = element.getText().equalsIgnoreCase(textToBeVerified);
        
        Assert.assertTrue(textToBeVerified+" not equal", isVerified);
    
    }
    
    
    
    public static WebElement getTheLink(String linkText) {
        try {
        return Driver.get().findElement(By.
                xpath("/html/body//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')," +
                        "'" + linkText.toLowerCase() + "')]"));
    } catch (Exception e) {
        e.printStackTrace();
    }
        return null;
    
}
    
    public static WebElement getTheElement(String elementText) {
        try {
        
            return Driver.get().findElement(By.
                    xpath("/html/body//div[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
                            "'abcdefghijklmnopqrstuvwxyz')," +
                            "'" + elementText.toLowerCase() + "')]"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static WebElement getTheButton(String buttonText) {
    
        try {
        
            return Driver.get().findElement(By.
                xpath("/html/body//input[contains(translate(@value,'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
                        "'abcdefghijklmnopqrstuvwxyz')," +
                        "'" + buttonText.toLowerCase() + "')]"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }
    
    public static WebElement getPartialText(String tag, String buttonText) {
    
        try {
        
            return Driver.get().findElement(By.
                xpath("/html/body//"+tag+"[contains(translate(@value,'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
                        "'abcdefghijklmnopqrstuvwxyz')," +
                        "'" + buttonText.toLowerCase() + "')]"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }
    
    public static WebElement getTextFromListElement(List<WebElement> webElements,String text) {
    
        try {
        
        
            List<WebElement> list = webElements;
            for (WebElement element : list) {
                if (element.getText().contains(text)) {
                    return element;
                }
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
}
