package components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.AbsPageObject;

@Getter
public class CoursesComponent extends AbsPageObject {

    public CoursesComponent(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h1[@class = 'sc-1og4wiw-0 sc-s2pydo-1 ifZfhS diGrSa']")
    private WebElement nameCourse;

    @FindBy(xpath = "//div[@class = 'sc-1og4wiw-0 sc-s2pydo-3 gaEufI dZDxRw']/p")
    private WebElement descriptionCourse;

    @FindBy(xpath = "(//div[@class = 'sc-3cb1l3-4 kGoYMV']/p)[3]")
    private WebElement durationCourse;

    @FindBy(xpath = "(//div[@class = 'sc-3cb1l3-4 kGoYMV']/p)[4]")
    private WebElement formatCourse;
}
