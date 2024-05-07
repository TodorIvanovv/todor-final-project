package frontend;

import base.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private static final String MAIN_PAGE_URL = "https://shop.pragmatic.bg/";

    private static final By MAIN_PAGE_FEATURED_TITLE = By.cssSelector(".col-sm-12 h3");

    public static void goToMainPage() {
        driver.get(MAIN_PAGE_URL);
    }

    public static String mainPageCheck() {
        return driver.findElement(MAIN_PAGE_FEATURED_TITLE).getText();
    }
}
