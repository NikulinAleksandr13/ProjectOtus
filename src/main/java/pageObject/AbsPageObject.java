package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import waiters.Waiters;
import java.util.List;


public abstract class AbsPageObject extends Helper {
    protected Waiters waiters;
    JavascriptExecutor javascriptExecutor;

    public AbsPageObject(WebDriver driver) {
        super(driver);
        this.waiters = new Waiters(driver);
        this.javascriptExecutor = (JavascriptExecutor) driver;

        PageFactory.initElements(driver, this);
    }

    public void scrollPage(List<WebElement> elements) throws InterruptedException {
        int size = 0;
        do {
            size = elements.size();
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);
            elements = driver.findElements(By.xpath("//div[@class = 'dod_new-events__list js-dod_new_events']/a"));
        }
        while (elements.size() > size);


    }
}
