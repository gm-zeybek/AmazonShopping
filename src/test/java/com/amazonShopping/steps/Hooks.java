package com.amazonShopping.steps;

import com.amazonShopping.utilities.ConfigurationReader;
import com.amazonShopping.utilities.Driver;
import com.amazonShopping.utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Hooks {
    
    
    @Before
    public void setUp(){
    
        // navigating the url
        Driver.get().get(ConfigurationReader.get("url"));
        // accepting cookies
        Utils.waitFor().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sp-cc-accept"))).click();
    }
    
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){

            // taking screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        
        // closing session
       Driver.closeDriver();
    }
    
  
}

