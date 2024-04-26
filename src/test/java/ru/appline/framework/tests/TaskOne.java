package ru.appline.framework.tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskOne {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        String baseUrl = "http://training.appline.ru/user/login";
        driver.get(baseUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){

        //Авторизация
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='prependedInput']"))));
        driver.findElement(By.xpath("//*[@id='prependedInput']")).sendKeys("Prohorova Alla");
        driver.findElement(By.xpath("//*[@id='prependedInput2']")).sendKeys("testing");
        driver.findElement(By.xpath("//*[@id='_submit']")).click();

        //Проверка заголовка Панель быстрого запуска
        wait.until(ExpectedConditions.
                visibilityOf(driver.findElement(By.xpath("//h1[contains(@class, 'subtitle')]"))));
        Assert.assertEquals("Заголовок не найден",
                "Панель быстрого запуска",
                driver.findElement(By.xpath("//h1[contains(@class, 'subtitle')]")).getText());

        //Расходы - Командировки
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span")).click();
        wait.until(ExpectedConditions.
                visibilityOf(driver.findElement(By.xpath("//span[text() = 'Командировки']"))));
        driver.findElement(By.xpath("//span[text() = 'Командировки']")).click();

        //Создать комнадировку
        wait.until(ExpectedConditions.
                invisibilityOf(driver.findElement(By.xpath("/html/body/div[4]"))));
        driver.findElement(By.xpath("//a[@href = '/business-trip/create/' and @title]")).click();

        //Переход на страницу Создать командировку
        wait.until(ExpectedConditions.
                invisibilityOf(driver.findElement(By.xpath("/html/body/div[4]"))));
        Assert.assertEquals("Заголовок Создать командировку не найден",
                "Создать командировку",
                driver.findElement(By.xpath("//h1[text() = 'Создать командировку']")).getText());

        //Заполнение полей
        WebElement department = driver.findElement(By.xpath("//select[contains(@data-name, 'field__business-unit')]"));
        department.click();
        department.findElement(By.xpath("//option[text()='Отдел проектных сервисов']")).click();

        driver.findElement(By.xpath("//a[text()='Открыть список']")).click();
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id = 'select2-drop']"))));
        driver.findElement(By.xpath("//input[@type = 'text' and @spellcheck]"))
                .sendKeys("Aplana");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.
//                xpath("//ul[@class = 'select2-results']/li/div/span[text() = 'Aplana']"))));
        driver.findElement(By.xpath("//span[text() = 'Aplana']")).click();

        WebElement checkbox = driver.findElement(By.xpath("//input[@data-ftid = 'crm_business_trip_tasks_1']"));
        checkbox.click();

        WebElement departureCity = driver.findElement(By.xpath("//input[contains(@name, 'departure')]"));
        WebElement arrivalCity = driver.findElement(By.xpath("//input[contains(@name, 'arrival')]"));
        departureCity.clear();
        departureCity.sendKeys("Москва, Россия");
        arrivalCity.clear();
        arrivalCity.sendKeys("Самара, Россия");

        WebElement departureTime = driver.findElement(By.
                xpath("//input[contains(@id, 'trip_departureDatePlan') and @placeholder = 'Укажите дату']"));
        WebElement arrivalTime = driver.findElement(By.
                xpath("//input[contains(@id, 'trip_returnDatePlan') and @placeholder = 'Укажите дату']"));

        departureTime.click();
        driver.findElement(By.xpath("//a[text() = '22']")).click();
        arrivalTime.click();
        driver.findElement(By.xpath("//a[text() = '28']")).click();

        departureCity.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.
                invisibilityOf(driver.findElement(By.xpath("/html/body/div[4]"))));
        WebElement arrivalCityAfterUpdate = driver.findElement(By.xpath("//input[contains(@name, 'arrival')]"));
        arrivalCityAfterUpdate.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.
                invisibilityOf(driver.findElement(By.xpath("/html/body/div[4]"))));


        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить') and contains(@class, 'main')]"))
                .click();
        wait.until(ExpectedConditions.
                invisibilityOf(driver.findElement(By.xpath("/html/body/div[4]"))));

        //Проверки правильности заполнения полей
        Assert.assertEquals("Выбрано неверное подразделение", "Отдел проектных сервисов",
                driver.findElement(By.xpath("//span[text() = 'Отдел проектных сервисов']")).getText());

        Assert.assertEquals("Указана неверная принимающая организация", "Aplana",
                driver.findElement(By.xpath("//input[@value = 'Aplana']")).
                        getAttribute("value"));

        WebElement newCheckbox = driver.findElement(By.xpath("//input[@data-ftid = 'crm_business_trip_tasks_1']"));
        Assert.assertEquals("Чекбокс не выставлен", newCheckbox.isSelected(), newCheckbox.isSelected());
        Assert.assertEquals("Неверно указан город отпраления", "Москва, Россия",
                driver.findElement(By.xpath("//input[@value = 'Москва, Россия']")).getAttribute("value"));
        Assert.assertEquals("Неверно указан город прибытия", "Самара, Россия",
                driver.findElement(By.xpath("//input[@value = 'Самара, Россия']")).getAttribute("value"));


        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();
        wait.until(ExpectedConditions.
                invisibilityOf(driver.findElement(By.xpath("/html/body/div[4]"))));

        Assert.assertNotEquals("Список командируемых сотрудников не может быть пустым",
                driver.findElement(By.xpath("//span[contains(text(), 'Список командируемых')]")).getText());

    }

    @After
    public void afterTest(){
        driver.quit();
    }
}


