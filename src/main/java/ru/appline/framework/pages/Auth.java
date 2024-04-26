package ru.appline.framework.pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.DriverManager;

import java.time.Duration;
import java.util.List;

public class Auth extends BaseActions{

    @FindBy(xpath = "//h2")
    private WebElement startTitle;
    public void checkOpenAuthPage(){
        Assert.assertEquals("Страница авторизации не найдена", "Логин", startTitle.getText());
    }

    @FindBy(xpath = "//*[@id='_submit']")
    private WebElement authButton;
    public void authButtonClick(){
        authButton.click();
    }

    @FindBy(xpath = "//fieldset//input[contains(@id, 'prepended')]")
    private List<WebElement> authInputFields;

    public void setAuthInputFields(String login, String password){
        for (WebElement q:authInputFields) {
            if(q.getAttribute("placeholder").equals("Имя пользователя или Email")){
                fillInputField(q, "Prohorova Alla");
            }
            else if(q.getAttribute("placeholder").equals("Пароль")){
                fillInputField(q, "testing");
            }
        }
    }
}

