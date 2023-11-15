package pages;

import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;
public abstract class AbsBasePage extends AbsPageObject {

    public final String BASE_URL = System.getProperty("base.url", "http://otus.ru");
    private String path = "";

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private String configUrl() {
        return BASE_URL.endsWith("/") ? BASE_URL.replaceAll("/$", "") : BASE_URL;
    }

    public void open(String path) {
        driver.get(configUrl() + path);
    }


}
