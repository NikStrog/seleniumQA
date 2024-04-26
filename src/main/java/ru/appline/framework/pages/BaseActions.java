package ru.appline.framework.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.DriverManager;

import java.time.Duration;
import java.util.List;

public class BaseActions {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(2));

    public BaseActions(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    @FindBy(xpath = "/html/body/div[4]")
    private WebElement load;
    public void loadCheckout(){
        wait.until(ExpectedConditions.invisibilityOf(load));
    }

    protected void fillInputField(WebElement field, String value){
        field.clear();
        field.click();
        field.sendKeys(value);
    }

//    @FindBy(xpath = "//div[@id = 'ui-datepicker-div']//td/a")
//    private List<WebElement> dateList;
//    public void dateFillInputField(WebElement dateField, String value){
//        for (WebElement q:dateList) {
//            if(q.getText().contains(value)){
//                q.click();
//            }
//        }
//    }
}
