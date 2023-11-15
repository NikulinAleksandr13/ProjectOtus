package components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.AbsPageObject;

@Getter
public class Header extends AbsPageObject {

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@title = 'Обучение']")
    private WebElement training;

    @FindBy(xpath = "//a[contains(text(), 'Календарь мероприятий')]")
    private WebElement calendar;

    public void goToPageFromHeader(WebElement element, WebElement element2) {
        actions.moveToElement(element).build().perform();
        moveAndClick(element2);

    }
}
