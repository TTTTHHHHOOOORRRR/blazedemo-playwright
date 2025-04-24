package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import pages.*;

import static org.testng.Assert.assertTrue;

public class BlazeDemoTest {
    Playwright playwright;
    Browser browser;
    Page page;

    LandingPage landingPage;
    FlightsPage flightsPage;
    PurchasePage purchasePage;
    ConfirmationPage confirmationPage;

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://blazedemo.com/index.php");

        landingPage = new LandingPage(page);
        flightsPage = new FlightsPage(page);
        purchasePage = new PurchasePage(page);
        confirmationPage = new ConfirmationPage(page);
    }

    @Test
    public void testFlightBooking() {
        landingPage.selectCities("Boston", "New York");
        landingPage.clickFindFlights();

        flightsPage.chooseCheapestFlight();

        purchasePage.fillFormAndPurchase("John Doe", "123 Elm St", "Boston", "MA", "12345", "visa", "4111111111111111");

        assertTrue(confirmationPage.isConfirmationDisplayed(), "Confirmation message not found!");
    }

    @AfterMethod
    public void teardown() {
        page.close();
        browser.close();
        playwright.close();
    }
}
