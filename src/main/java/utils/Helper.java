package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public abstract class Helper {
    protected WebDriver driver;
    protected Actions actions;

    public Helper(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void moveAndClick(WebElement element) {
        actions.moveToElement(element).build().perform();
        element.click();
    }
}
