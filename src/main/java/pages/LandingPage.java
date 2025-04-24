package pages;

import com.microsoft.playwright.*;

public class LandingPage {
    private Page page;

    public LandingPage(Page page) {
        this.page = page;
    }

    public void selectDepartureAndDestinationCities(String departure, String destination) {
        // Replacing Selenium's Select with Playwright's Locator click method
        page.locator("select#departureCity").selectOption(departure);
        page.locator("select#destinationCity").selectOption(destination);
    }

    public void findFlights() {
        // Click the "Find Flights" button using Playwright
        page.locator("input[type='submit']").click();
    }

    public void chooseFlightWithLowestCost() {
        // Example of selecting a flight based on cost
        page.locator("tr.flight").locator("td.price").first().click();
    }

    public void fillAndSubmitForm(String name, String address, String city, String state, String zip) {
        // Fill the form using Playwright Locators
        page.locator("input[name='name']").fill(name);
        page.locator("input[name='address']").fill(address);
        page.locator("input[name='city']").fill(city);
        page.locator("input[name='state']").fill(state);
        page.locator("input[name='zip']").fill(zip);
        page.locator("input[type='submit']").click();
    }
}
