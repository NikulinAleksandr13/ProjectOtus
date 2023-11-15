package pages;

import components.EventsComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@Getter
public class OpenWebinarPage extends AbsBasePage {
    EventsComponent eventsComponent;

    public OpenWebinarPage(WebDriver driver) {
        super(driver);
        eventsComponent = new EventsComponent(driver);
    }

    @FindBy(xpath = "//div[@class = 'dod_new-events__list js-dod_new_events']/a")
    private List<WebElement> listEventsOpenWebinar;

    public void assertTextOpenWebinar() {
        if (eventsComponent.getTextTypeEventsList().size() == listEventsOpenWebinar.size()) {
            System.out.println("На странице присутствуют только Открытые вебинары");
        } else {
            System.out.println("На странице присутствуют не только Открытые вебинары");
        }
    }
}

