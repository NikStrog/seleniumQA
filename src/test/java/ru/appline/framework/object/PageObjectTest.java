package ru.appline.framework.object;


import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.appline.framework.basetests.BaseTest;
import ru.appline.framework.pages.Auth;
import ru.appline.framework.pages.BusinessTripCreation;
import ru.appline.framework.pages.BusinessTripsPage;
import ru.appline.framework.pages.StartPage;

public class PageObjectTest extends BaseTest {

    Auth auth = new Auth();
    StartPage startPage = new StartPage();
    BusinessTripsPage businessTrip = new BusinessTripsPage();
    BusinessTripCreation newBusinessTrip = new BusinessTripCreation();

    @Test
    public void pageObjectTest(){

        //Авторизация
        auth.checkOpenAuthPage();
        auth.setAuthInputFields("Prohorova Alla", "testing");
        auth.authButtonClick();

        startPage.checkOpenPage();
        startPage.selectMenuButton("Расходы");
        startPage.selectSubMenuButton("Командировки");
        startPage.loadCheckout();

        businessTrip.clickCreateBusinessTrip();
        businessTrip.loadCheckout();

        newBusinessTrip.setDepartmentListClick();
        newBusinessTrip.departmentChoose("Отдел проектных сервисов");
        newBusinessTrip.openListButtonClick();
        newBusinessTrip.setChooseOrganizationClick();
        newBusinessTrip.organizationInput("Aplana");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        newBusinessTrip.organizationClick();
        newBusinessTrip.taskChoose("Заказ билетов");
        newBusinessTrip.departureCityEnter("Россия, Москва");
        newBusinessTrip.arrivalCityEnter("Россия, Самара");

        //выбираем дату отправления
        newBusinessTrip.departureDateFieldClick();
        newBusinessTrip.chooseYearClick();
        newBusinessTrip.yearPick("2024");
        newBusinessTrip.chooseMonthClick();
        newBusinessTrip.monthPick("апр");
        newBusinessTrip.dayPick("24");

        //выбираем дату прибытия
        newBusinessTrip.arrivalDateFieldClick();
        newBusinessTrip.chooseYearClick();
        newBusinessTrip.yearPick("2024");
        newBusinessTrip.chooseMonthClick();
        newBusinessTrip.monthPick("апр");
        newBusinessTrip.dayPick("27");

        newBusinessTrip.savePage();
        newBusinessTrip.loadCheckout();
        newBusinessTrip.saveAndClosePage();
        newBusinessTrip.loadCheckout();
        newBusinessTrip.checkErrorMessage();
    }
}
