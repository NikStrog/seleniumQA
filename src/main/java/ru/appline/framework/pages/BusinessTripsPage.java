package ru.appline.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BusinessTripsPage extends BaseActions {

    @FindBy(xpath = "//a[@href = '/business-trip/create/' and @title]")
    private WebElement createBusinessTrip;

    /**
     * Клик по кнопке Создать командировку
     */
    public void clickCreateBusinessTrip(){
        createBusinessTrip.click();
    }
}