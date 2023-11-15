package components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.AbsPageObject;

import java.util.List;
@Getter
public class EventsComponent extends AbsPageObject {
    public EventsComponent(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".dod_new-type__text")
    private List<WebElement> textTypeEventsList;
}
