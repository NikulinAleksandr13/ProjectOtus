package pages;

import components.CoursesComponent;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;

@Getter
public class CatalogPage extends AbsBasePage {
    CoursesComponent coursesComponent;

    public CatalogPage(WebDriver driver) {
        super(driver);
        coursesComponent = new CoursesComponent(driver);
    }

    @FindBy(css = ".sc-o4bnil-0.riKpM")
    private WebElement catalogSection;
    @FindBy(css = ".sc-18q05a6-1 .sc-zzdkm7-0")
    private List<WebElement> listCourseSelector;

    private final int countCourseExpected = 10;

    public void waitCatalogSection() {
        waiters.waitElementVisible(catalogSection);
    }

    public void viewingCourses() throws IOException {
        for (WebElement element : listCourseSelector) {
            Document doc = Jsoup.connect(element.getAttribute("href")).get();
            Elements nameCourse = doc.select(".sc-1og4wiw-0.sc-s2pydo-1.ifZfhS.diGrSa");
            System.out.println(nameCourse.get(0).text());
            Elements descriptionCourse = doc.select(".sc-1og4wiw-0.sc-s2pydo-3.gaEufI.dZDxRw");
            System.out.println(descriptionCourse.get(0).text());
            Elements durationCourse = doc.select("div.sc-3cb1l3-4:nth-child(3) > p:nth-child(2)");
            if (!durationCourse.isEmpty()){
                System.out.println(durationCourse.get(0).text());
            } else {
                System.out.println("У курса нет продолжительности");
            }
            Elements formatCourse = doc.select("div.sc-3cb1l3-4:nth-child(4) > p:nth-child(2)");
            if(!formatCourse.isEmpty()){
                System.out.println(formatCourse.get(0).text());
            } else {
                System.out.println("У курса нет формата");
            }

        }
    }


    public void assertCount(int actual, int expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }
}
