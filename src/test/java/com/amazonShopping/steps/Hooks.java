package com.amazonShopping.steps;

import com.amazonShopping.pages.HomePage;
import com.amazonShopping.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.amazonShopping.utilities.Utils.*;


public class Hooks {
    
    
    @Before
    public void setUp(){
    
        // navigating the url
        navigateUrl("url");
        
        // accepting cookies
        acceptCookies(new HomePage().acceptAllCookies);
        
        // maximizes window
        maximizeWindow();
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

