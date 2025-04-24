package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LandingPage {
    private final Page page;

    private final Locator fromCityDropdown;
    private final Locator toCityDropdown;
    private final Locator findFlightsButton;

    public LandingPage(Page page) {
        this.page = page;
        this.fromCityDropdown = page.locator("select[name='fromPort']");
        this.toCityDropdown = page.locator("select[name='toPort']");
        this.findFlightsButton = page.locator("input[type='submit']");
    }

    public void selectCities(String fromCity, String toCity) {
        fromCityDropdown.selectOption(fromCity);
        toCityDropdown.selectOption(toCity);
    }

    public void clickFindFlights() {
        findFlightsButton.click();
    }
}
