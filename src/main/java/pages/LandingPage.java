package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCities(String from, String to) {
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText(from);
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText(to);
    }

    public void clickFindFlights() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
