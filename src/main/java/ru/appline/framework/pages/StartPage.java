package ru.appline.framework.pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class StartPage extends BaseActions {

    @FindBy(xpath = "//h1[contains(@class, 'subtitle')]")
    private WebElement startPageTitle;
    /**
     * Проверка перехода на стартовую страницу
     */
    public void checkOpenPage(){
        Assert.assertEquals("Заголовок не найден", "Панель быстрого запуска", startPageTitle.getText());

    }

    @FindBy(xpath = "//ul[@class = 'nav nav-multilevel main-menu']/li/a/span")
    private List<WebElement> baseMenuButtons;

    /**
     * Клик по кнопке меню
     * @param menuSection - название блока меню
     *
     */
    public void selectMenuButton(String menuSection){
        for (WebElement menuElement:baseMenuButtons) {
            if(menuElement.getText().equals(menuSection)){
                menuElement.click();
                return;
            }
        }
        Assert.fail("Кнопка меню " + menuSection + " не найдена");
    }

    @FindBy(xpath = "//*[@id='main-menu']/ul/li/ul/li/a/span")
    private List<WebElement> subMenuButtons;

    /**
     * Клик по кнопке подменю
     * @param subMenuSection - название блока подменю
     *
     */
    public void selectSubMenuButton(String subMenuSection){
        for (WebElement subMenuElement:subMenuButtons) {
            if(subMenuElement.getText().equals(subMenuSection)){
                subMenuElement.click();
                return;
            }
        }
        Assert.fail("Кнопка подменю " + subMenuSection + " не найдена");
    }
}
