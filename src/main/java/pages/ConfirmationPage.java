package pages;

import com.microsoft.playwright.*;

public class ConfirmationPage {
    Page page;

    public ConfirmationPage(Page page) {
        this.page = page;
    }

    public boolean isConfirmationDisplayed() {
        return page.locator("body").innerText().contains("Thank you for your purchase today!");
    }
}
