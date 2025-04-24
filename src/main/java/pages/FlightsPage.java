package pages;

import com.microsoft.playwright.*;

public class FlightsPage {
    Page page;

    public FlightsPage(Page page) {
        this.page = page;
    }

    public void chooseCheapestFlight() {
        Locator prices = page.locator("table tr td:nth-child(6)");
        Locator buttons = page.locator("input[value='Choose This Flight']");

        double minPrice = Double.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < prices.count(); i++) {
            String priceText = prices.nth(i).innerText().replace("$", "").trim();
            double price = Double.parseDouble(priceText);
            if (price < minPrice) {
                minPrice = price;
                minIndex = i;
            }
        }

        buttons.nth(minIndex).click();
    }
}
