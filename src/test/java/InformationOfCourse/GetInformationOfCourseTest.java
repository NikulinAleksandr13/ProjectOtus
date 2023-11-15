package InformationOfCourse;

import components.Header;
import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CatalogPage;
import pages.MainPage;
import pages.OpenWebinarPage;
import java.io.IOException;


public class GetInformationOfCourseTest {
    private final Logger logger = LogManager.getLogger(GetInformationOfCourseTest.class);
    protected WebDriver driver;
    private MainPage mainPage;
    private CatalogPage catalogPage;
    private Header header;
    private CalendarEventsPage calendarEvents;
private OpenWebinarPage openWebinarPage;
    @BeforeMethod
    public void init() {
        driver = new WebDriverFactory().getDriver();
        mainPage = new MainPage(driver);
        catalogPage = new CatalogPage(driver);
        header = new Header(driver);
        calendarEvents = new CalendarEventsPage(driver);
        openWebinarPage = new OpenWebinarPage(driver);

    }

    @Test
    public void getInformationOfCourseTest() throws InterruptedException, IOException {
        logger.info("Открытие сайта");
        mainPage.open("");
        logger.info("Переход в раздел Тестирования");
        mainPage.openCatalog();
        logger.info("Проверка на количество курсов");
        catalogPage.waitCatalogSection();
        logger.info("Количество курсов = " + catalogPage.getListCourseSelector().size());
        catalogPage.assertCount(catalogPage.getListCourseSelector().size(), catalogPage.getCountCourseExpected(), "Количество курсов не совпадает");
        logger.info("Проверка каждого курса");
        catalogPage.viewingCourses();
        header.goToPageFromHeader(header.getTraining(), header.getCalendar());
        calendarEvents.scrollPage(calendarEvents.getListEvents());
        logger.info("Количество мероприятий = " + calendarEvents.getListEvents().size());
        calendarEvents.dateComparison();
        logger.info("Дата не меньше текущей");
        logger.info("Открытие страницы Открытых вебинаров");
        calendarEvents.openEventDropdownAndClickEventGroup(calendarEvents.getAllEventDropdown(), calendarEvents.getOpenWebinar());
        openWebinarPage.scrollPage(openWebinarPage.getListEventsOpenWebinar());
        logger.info("Количество открытых вебинаров = " + openWebinarPage.getListEventsOpenWebinar().size());
        openWebinarPage.assertTextOpenWebinar();


    }

    @AfterMethod
    public void downDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
