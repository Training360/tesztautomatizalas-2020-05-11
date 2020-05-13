package locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatePageObject {

    private WebDriver driver;

    public CreatePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CreatePageObject typeName(String name) {
        driver.findElement(By.id("name-input")).click();
        driver.findElement(By.id("name-input")).sendKeys(name);
        return this;
    }

    public CreatePageObject typeCoordinates(String coords) {
        driver.findElement(By.id("coords-input")).click();
        driver.findElement(By.id("coords-input")).sendKeys(coords);
        return this;
    }

    // Default value tervezési minta
    public CreatePageObject typeCoordinates() {
        typeCoordinates("47.4979,19.0402");
        return this;
    }

    public CreatePageObject pushCreateLocationButton() {
        driver.findElement(By.cssSelector(".btn")).click();
        return this;
    }
}
