package locations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class LocationsTest {

    WebDriver driver;

    ListPageObject list;

    CreatePageObject create;

    DetailsPageObject details;

    @BeforeEach
    void setUp() {
        //System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
        driver = new FirefoxDriver();
        list = new ListPageObject(driver);
        create = new CreatePageObject(driver);
        details = new DetailsPageObject(driver);
    }

    @AfterEach
    void tearDown() {
        // driver.quit();
    }

    @Test
    public void testCreateLocation() throws IOException {
        list
                .go()
                .clickToCreateLocation();

        create
                .typeName("Budapest")
                .typeCoordinates()
                .pushCreateLocationButton();


        details
                .messageHasToBe("Location has been created.")
                .takeScreenshot("screenshot.png")
                .clickToBackToListLink();
    }

    // Teszteset módosításra

    // Teszteset törlésre

    // 15:15-ig
}
