package locations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

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
        PageFactory.initElements(driver, list);
        create = new CreatePageObject(driver);
        PageFactory.initElements(driver, create);
        details = new DetailsPageObject(driver);
        PageFactory.initElements(driver, details);
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

    @Test
    @ParameterizedTest
    @CsvFileSource(resources = "/MOCK_DATA.csv")
    public void testCreateBulkLocations(String name, double lat, double lon) {
        System.out.println(name + " " + lat + " "  + lon);

        create
                .go()
                .typeName(name)
                .typeCoordinates(lat + "," + lon)
                .pushCreateLocationButton();
    }

    // Teszteset módosításra

    // Teszteset törlésre

    // 15:15-ig
}
