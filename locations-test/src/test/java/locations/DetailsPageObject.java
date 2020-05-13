package locations;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetailsPageObject {

    private WebDriver driver;

    public DetailsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public DetailsPageObject messageHasToBe(String expectedMessage) {
        var message = driver.findElement(By.cssSelector(".alert")).getText();
        assertEquals(expectedMessage, message);
        return this;
    }

    public DetailsPageObject clickToBackToListLink() {
        driver.findElement(By.linkText("Back to list")).click();
        return this;
    }

    public DetailsPageObject takeScreenshot(String filename) throws IOException {
        var file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.move(file.toPath(), Path.of(filename));
        return this;
    }
}
