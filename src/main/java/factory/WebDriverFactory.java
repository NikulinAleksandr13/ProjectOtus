package factory;

import factory.drivers.ChromeWebDriver;
import factory.drivers.FirefoxWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory implements IDriverFactory {

    private final String BROWSER_NAME = System.getProperty("browser", "chrome");

    @Override
    public WebDriver getDriver() {
        switch (BROWSER_NAME) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                return new ChromeWebDriver().newDriver();
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxWebDriver().newDriver();
            }
        }
        return null;
    }
}
