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
    
    
    /**
     * wait method
     * @return
     */
    public static FluentWait<WebDriver> waitFor() {
       
        return new WebDriverWait(Driver.get(), 20);
    }
    
    
    /**
     * taking webelement as an argument and return clickable element
     * @param element
     * @return
     */
    public static WebElement getElementWithFluentWait(WebElement element) {
        return Utils.waitFor().withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(element));
        
    }
    
    /**
     * moveto method taking webelement and returning Actions instance
     * @param element
     * @return
     */
    public static Actions moveToElement(WebElement element) {
        return new Actions(Driver.get()).
                moveToElement(element);
        
    }
    
    
    /**
     * Selecting dropdown by given word and verifying selected word
     * selected or not
     * @param selectElement
     * @param category
     */
    public static void verifyThatCategorySelected(WebElement selectElement, String category) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(category);
        String selectedCategory = select.getFirstSelectedOption().getText();
        Assert.assertEquals(category + " wasn't selected", selectedCategory, category);
        
    }
    
    
    public static void verifyText(WebElement element, String textToBeVerified) {
        
        
        Assert.assertEquals(textToBeVerified + " not equal", element.getText(), textToBeVerified);
        
    }
    
    public static void verifyTextEntered(WebElement element, String textToBeVerified) {
        
        // waitFor().until(ExpectedConditions.elementSelectionStateToBe(element,true));
        
        element.sendKeys(textToBeVerified, Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        Assert.assertEquals(textToBeVerified + " not equal", element.getText(), textToBeVerified);
        
    }
    
    
    public static WebElement getTheLink(String linkText) {
        try {
            return Driver.get().findElement(By.
                    xpath("/html/body//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
                            "'abcdefghijklmnopqrstuvwxyz')," +
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
                    xpath("/html/body//" + tag + "[contains(translate(@value,'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
                            "'abcdefghijklmnopqrstuvwxyz')," +
                            "'" + buttonText.toLowerCase() + "')]"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public static WebElement getTextFromListElement(List<WebElement> webElements, String text) {
        
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