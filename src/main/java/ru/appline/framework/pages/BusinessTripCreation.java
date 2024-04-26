package ru.appline.framework.pages;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.SplittableRandom;

public class BusinessTripCreation extends BaseActions{

    @FindBy(xpath = "//select[contains(@data-name, 'field__business-unit')]")
    private WebElement departmentListButton;
    public void setDepartmentListClick(){
        departmentListButton.click();
    }

    @FindBy(xpath = "//select[contains(@data-name, 'field__business-unit')]/option")
    private List<WebElement> departmentList;

    /**
     * Выбрать отдел из списка
     * @param departmentName - название отдела
     */
    public void departmentChoose(String departmentName){
        for (WebElement element:departmentList) {
            if(element.getText().equals(departmentName)){
                element.click();
                return;
            }
        }
        Assert.fail("Отдел " + departmentName + " не найден");
    }

    @FindBy(xpath = "//a[text()='Открыть список']")
    private WebElement openListButton;
    public void openListButtonClick(){
        openListButton.click();
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    private WebElement chooseOrganization;
    public void setChooseOrganizationClick(){
        chooseOrganization.click();
    }


    @FindBy(xpath = "//input[@type = 'text' and @spellcheck]")
    private WebElement organizationInputField;

    /**
     * Ввод названия организации
     * @param organizationName - название организации
     */
    public void organizationInput(String organizationName){
        organizationInputField.sendKeys(organizationName);
    }

    @FindBy(xpath = "//div[@class = 'select2-result-label']")
    private WebElement organizationChoose;
    public void organizationClick(){
        organizationChoose.click();
    }

    @FindBy(xpath = "//div[@class = 'controls']/div[@class = 'horizontal validate-group']//input[@type = 'checkbox']")
    private List<WebElement> tasksList;
    public void taskChoose(String taskName){
        for (WebElement task:tasksList) {
            if(task.findElement(By.xpath("./../label")).getText().contains(taskName)){
                task.click();
                return;
            }
        }
        Assert.fail("Задача " + taskName + " не найдена");
    }

    @FindBy(xpath = "//input[contains(@data-name, 'departure-city')]")
    private WebElement departureCity;
    public void departureCityEnter(String nameDepartureCity){
        fillInputField(departureCity, nameDepartureCity);
    }

    @FindBy(xpath = "//input[contains(@data-name, 'arrival-city')]")
    private WebElement arrivalCity;
    public void arrivalCityEnter(String nameArrivalCity){
        fillInputField(arrivalCity, nameArrivalCity);
    }

    @FindBy(xpath = "//input[@placeholder = 'Укажите дату' and contains(@id, 'departure')]")
    private WebElement departureDateField;
    public void departureDateFieldClick(){
        departureDateField.click();
    }

    @FindBy(xpath = "//input[@placeholder = 'Укажите дату' and contains(@id, 'return')]")
    private WebElement arrivalDateField;
    public void arrivalDateFieldClick(){
        arrivalDateField.click();
    }

    @FindBy(xpath = "//select[@class = 'ui-datepicker-month']")
    private WebElement chooseMonth;
    public void chooseMonthClick(){
        chooseMonth.click();
    }

    @FindBy(xpath = "//select[@class = 'ui-datepicker-year']")
    private WebElement chooseYear;
    public void chooseYearClick(){
        chooseYear.click();
    }

    @FindBy(xpath = "//td[@data-handler = 'selectDay']")
    private List<WebElement> dayList;
    public void dayPick(String day){
        for (WebElement q:dayList) {
            if(q.getText().contains(day)){
                q.click();
            }
        }
    }

    @FindBy(xpath = "//select[@class = 'ui-datepicker-month']/option")
    private List<WebElement> monthList;
    public void monthPick(String month){
        for (WebElement q:monthList) {
            if(q.getText().contains(month)){
                q.click();
            }
        }
    }

    @FindBy(xpath = "//select[@class = 'ui-datepicker-year']/option")
    private List<WebElement> yearList;
    public void yearPick(String year){
        for (WebElement q:yearList) {
            if(q.getText().contains(year)){
                q.click();
            }
        }
    }


    @FindBy(xpath = "//button[contains(text(), 'Сохранить') and contains(@class, 'main')]")
    private WebElement savePageButton;
    public void savePage(){
        savePageButton.click();
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    private WebElement saveAndClosePageButton;
    public void saveAndClosePage(){
        saveAndClosePageButton.click();
    }

    @FindBy(xpath = "//span[contains(text(), 'Список командируемых')]")
    private List<WebElement> errorMessageList;
    public void checkErrorMessage(){
        for (WebElement q:errorMessageList) {
            Assert.assertNotEquals("Список командируемых сотрудников не может быть пустым", q.getText());
        }
    }


}