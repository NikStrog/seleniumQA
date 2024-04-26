package ru.appline.framework.managers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {
    private static DriverManager INSTANCE = null;

    private WebDriver driver;

    private DriverManager(){

    }

    public static DriverManager getDriverManager(){
        if(INSTANCE == null){
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver(){
        if(driver == null){
            initeDriver();
        }
        return driver;
    }

    public void initeDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
