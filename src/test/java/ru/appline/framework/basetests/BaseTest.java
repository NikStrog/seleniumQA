package ru.appline.framework.basetests;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.DriverManager;

import java.time.Duration;

public class BaseTest {
    private DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait;
    @Before
    public void before(){
        String baseUrl = "http://training.appline.ru/user/login";
        driverManager.getDriver().get(baseUrl);

    }

    @After
    public void after(){
        driverManager.getDriver().quit();
    }
}
