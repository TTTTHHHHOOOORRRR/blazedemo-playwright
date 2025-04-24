package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BlazeDemoTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            .setHeadless(true)); // Important: Run in headless mode

        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    public void testFlightSearch() {
        page.navigate("https://blazedemo.com");

        // Select departure city
        page.selectOption("select[name='fromPort']", "Boston");

        // Select destination city
        page.selectOption("select[name='toPort']", "New York");

        // Click Find Flights
        page.click("input[type='submit']");

        // Assert that the results page contains expected text
        String title = page.textContent("h3");
        assert title.contains("Flights from Boston to New York") : "Flight search failed!";
    }

    @AfterClass
    public void teardown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
