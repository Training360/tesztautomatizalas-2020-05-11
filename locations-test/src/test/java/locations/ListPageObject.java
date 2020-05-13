package locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListPageObject {

    private WebDriver driver;


    public ListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public ListPageObject go() {
        driver.get("http://localhost:8080/server");
        return this;
    }

    public ListPageObject clickToCreateLocation() {
        driver.findElement(By.linkText("Create location")).click();
        return this;
    }

    public ListPageObject rowMustContains(int rowNumber, String expectedName, String expectedCoordinates) {
        //
        return this;
    }
}
