package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
public class CalendarEventsPage extends AbsBasePage {
    public CalendarEventsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'dod_new-events__list js-dod_new_events']/a")
    private List<WebElement> listEvents;

    @FindBy(xpath = "(//span[@class = 'dod_new-event__date-text'])[1]")
    private WebElement dateEvents;
    @FindBy(xpath = "(//div[@class = 'dod_new-events-dropdown__input']/span[@class = 'dod_new-events-dropdown__input-selected'])[1]")
    private WebElement allEventDropdown;
    @FindBy(xpath = "(//div[@class = 'dod_new-events-dropdown__list js-dod_new_events-dropdown']/a[@title = 'Открытый вебинар'])[1]")
    private WebElement openWebinar;

    public void dateComparison() {
        LocalDate localDate = LocalDate.now();
        String dataEvent = "2023 " + dateEvents.getText();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy d MMMM");
        LocalDate localDate1 = LocalDate.parse(dataEvent, dateTimeFormatter);
        if (localDate1.isBefore(localDate)) {
            System.out.println("Дата событий раньше текущей даты");
        } else {
            System.out.println("Дата событий равна или больше текущей даты");
        }

    }

    public void openEventDropdownAndClickEventGroup(WebElement element, WebElement element2){
        moveAndClick(element);
        waiters.waitElementVisible(element2);
        moveAndClick(element2);

    }

}
