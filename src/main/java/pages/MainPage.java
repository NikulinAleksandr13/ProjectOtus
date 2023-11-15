package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class MainPage extends AbsBasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[contains(text(), 'Тестирование')])[1]")
    private WebElement testingLink;

    public void openCatalog() {
        waiters.waitElementVisible(testingLink);
        testingLink.click();
        new CatalogPage(driver);
    }
}
