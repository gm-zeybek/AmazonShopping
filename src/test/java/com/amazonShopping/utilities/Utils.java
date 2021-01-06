package com.amazonShopping.utilities;

import org.assertj.core.api.AbstractStringAssert;
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

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public interface Utils {
    
    
    String isDisplayed = null;
    
    /**
     * clicks the clickable webelement and waits for page loading
     *
     * @param clickItem
     * @param pageloader
     */
    static void clickOnAndWaitForPageLoad(WebElement clickItem, WebElement pageloader) {
        
        clickItem.click();
        waitFor()
                .until(ExpectedConditions.visibilityOf(pageloader));
        
    }
    
    
    /**
     * navigates into predefinite url
     *
     * @param url
     */
    static void navigateUrl(String url) {
        // navigating the url
        Driver.get().get(ConfigurationReader.get(url));
    }
    
    
    /**
     * accepts all cookies by clicking the acceptall button
     *
     * @param acceptCookiesElement
     */
    static void acceptCookies(WebElement acceptCookiesElement) {
        
        // accepting cookies
        waitFor().until(ExpectedConditions.elementToBeClickable(acceptCookiesElement)).click();
        
    }
    
    /**
     * maximizes the condition
     */
    static void maximizeWindow() {
        // maximizes window
        Driver.get().manage().window().maximize();
        
    }
    
    
    /**
         * verifies the given weblement for given conditions accepting condition as a string
     *
     * @param element
     * @return
     */
    static AbstractStringAssert<?> verifyTextDisplayedAsExpected(WebElement element, String condition) {
        
        
        return assertThat(element + "." + condition + "()");
        
        
    }
    
    
    /**
     * checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    static void selectCheckBox(WebElement element, boolean check) {
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
     * uses fluentwait wait
     *
     * @return
     */
    public static FluentWait<WebDriver> waitFor() {
        
        return new WebDriverWait(Driver.get(), 5);
    }
    
    
    /**
     * moveto method taking webelement and returning Actions instance
     *
     * @param element
     * @return
     */
    static WebElement moveToElement(WebElement element) {
        
        new Actions(Driver.get()).
                moveToElement(element).build();
        return waitFor().until(ExpectedConditions.visibilityOf(element));
        
    }
    
    
    /**
     * Selecting dropdown by given word and verifying selected word
     * selected or not
     *
     * @param selectElement
     * @param category
     */
    static void verifyThatCategorySelected(WebElement selectElement, String category) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(category);
        String selectedCategory = select.getFirstSelectedOption().getText();
        Assert.assertEquals(category + " wasn't selected", selectedCategory, category);
        
    }
    
    
    /**
     * verifies the retrieving text is as expected
     * @param element
     * @param textToBeVerified
     */
    static void verifyText(WebElement element, String textToBeVerified) {
        
        assertThat(element.getText()).isEqualTo(textToBeVerified).withFailMessage("%s not equal",textToBeVerified);
        
    }
    
    
    /**
     * type the string into the box and verifies the string as expected
     * @param string
     * @param element
     */
    static void typeStringAndVerify(String string, WebElement element) {
        
        // waiting for page elements visible
        
        new WebDriverWait(Driver.get(), 20)
                .until(ExpectedConditions.visibilityOf(element));
        
        // filtering
        element.sendKeys(Keys.CLEAR, string, Keys.ENTER);
        
        // Assert that searchbox contains the sought String
        assertThat(element.getText().contains(string))
                .withFailMessage("resource box doesn't contain string %s", string);
        
    }
    
    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        
        return elemTexts;
    }
    
    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     *
     * @param locator
     * @return list of strings
     */
    static List<String> getElementsText(By locator) {
        
        List<WebElement> elems = Driver.get().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        
        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
    
    
    
    
    static WebElement getTheLink(String linkText) {
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
    
    static WebElement getTheElement(String elementText) {
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
    
    static WebElement getTheButton(String buttonText) {
        
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
    
    static WebElement getPartialText(String tag, String buttonText) {
        
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
    
    static WebElement getTextFromListElement(List<WebElement> webElements, String text) {
        
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