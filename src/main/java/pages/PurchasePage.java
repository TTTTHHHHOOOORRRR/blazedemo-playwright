package pages;

import com.microsoft.playwright.*;

public class PurchasePage {
    Page page;

    public PurchasePage(Page page) {
        this.page = page;
    }

    public void fillFormAndPurchase(String name, String address, String city, String state, String zip, String cardType, String cardNumber) {
        page.fill("#inputName", name);
        page.fill("#address", address);
        page.fill("#city", city);
        page.fill("#state", state);
        page.fill("#zipCode", zip);
        page.selectOption("#cardType", cardType);
        page.fill("#creditCardNumber", cardNumber);
        page.click("input[type='submit']");
    }
}
