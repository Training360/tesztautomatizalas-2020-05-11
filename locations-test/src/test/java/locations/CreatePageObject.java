package locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreatePageObject {

    private WebDriver driver;

    @FindBy(how = How.ID, id = "name-input")
    private WebElement nameInput;

    @FindBy(how = How.ID, id = "coords-input")
    private WebElement coordsInput;

    @FindBy(how = How.CSS, css = ".btn")
    private WebElement button;

    public CreatePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CreatePageObject typeName(String name) {
        nameInput.click();
        nameInput.sendKeys(name);
        return this;
    }

    public CreatePageObject typeCoordinates(String coords) {
        coordsInput.click();
        coordsInput.sendKeys(coords);
        return this;
    }

    // Default value tervezési minta
    public CreatePageObject typeCoordinates() {
        typeCoordinates("47.4979,19.0402");
        return this;
    }

    public CreatePageObject pushCreateLocationButton() {
        button.click();
        return this;
    }

    public CreatePageObject go() {
        driver.get("http://localhost:8080/server/create");
        return this;
    }
}
