package locations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocationsTest {

  WebDriver driver;

  @BeforeEach
  void setUp() {
    //System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
    driver = new FirefoxDriver();
  }
  @AfterEach
  void tearDown() {
    // driver.quit();
  }

  @Test
  public void testCreateLocation() {
    driver.get("http://localhost:8080/server");
    driver.findElement(By.linkText("Create location")).click();
    driver.findElement(By.id("name-input")).click();
    driver.findElement(By.id("name-input")).sendKeys("Budapest");
    driver.findElement(By.id("coords-input")).click();
    driver.findElement(By.id("coords-input")).sendKeys("1,1");
    driver.findElement(By.cssSelector(".btn")).click();
    assertEquals("Location has been created.", driver.findElement(By.cssSelector(".alert")).getText());
    driver.findElement(By.linkText("Back to list")).click();
    }
  }
