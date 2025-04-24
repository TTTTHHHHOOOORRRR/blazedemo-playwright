package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import pages.LandingPage;

public class BlazeDemoTest {
    Playwright playwright;
    Browser browser;
    Page page;
    BrowserContext context;
    LandingPage landingPage;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://blazedemo.com");
        landingPage = new LandingPage(page);
    }

    @Test
    public void testFlightBooking() {
        landingPage.selectCities("Boston", "New York");
        landingPage.clickFindFlights();
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
