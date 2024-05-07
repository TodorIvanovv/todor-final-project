package components;

import base.BasePage;
import frontend.MainPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

public class FrontendHeader extends MainPage {
    private static final By MY_ACCOUNT_BUTTON = By.cssSelector(".fa.fa-user");
    private static final By REGISTER_BUTTON = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[1]/a");
    private static final By FIRST_NAME_INPUT_FIELD = By.id("input-firstname");
    private static final By LAST_NAME_INPUT_FIELD = By.id("input-lastname");
    private static final By EMAIL_INPUT_FIELD = By.id("input-email");
    private static final By TELEPHONE_INPUT_FIELD = By.id("input-telephone");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By PASSWORD_CONFIRM_INPUT_FIELD = By.id("input-confirm");
    private static final By PRIVACY_POLICY_AGREEMENT_CHECKBOX = By.xpath("//input[@name='agree']");
    private static final By CONTINUE_REG_BUTTON = By.cssSelector(".btn.btn-primary");

    private static final By ACC_CREATED_MESSAGE = By.cssSelector("#content h1");


    private static final By OPENCART_LOGO = By.xpath("//img[@title='Your Store']");

    private static final By SEARCH_INPUT_FIELD = By.cssSelector(".form-control.input-lg");

    private static final By SEARCH_BUTTON = By.cssSelector(".fa.fa-search");

    private static final By CART_TOTAL_BUTTON = By.id("cart-total");

    private static final By EMPTY_CART = By.cssSelector("#cart p");

    private static final By PRODUCT_NAME = By.cssSelector(".caption a");

    private static final By NO_PRODUCT_MESSAGE = By.xpath("//div[@id=\"content\"]//p[2]");

    private static final By SEARCH_TEXT_VALUE = By.id("input-search");
    private static final By DESKTOPS_DROPDOWN_BUTTON = By.xpath("//ul[@class='nav navbar-nav']/li[1]");
    private static final By LAPTOPS_AND_NOTEBOOKS_DROPDOWN_BUTTON = By.xpath("//ul[@class='nav navbar-nav']/li[2]");
    private static final By COMPONENTS_DROPDOWN_BUTTON = By.xpath("//ul[@class='nav navbar-nav']/li[3]");
    private static final By TABLETS_DROPDOWN_BUTTON = By.xpath("//ul[@class='nav navbar-nav']/li[4]");
    private static final By TABLETS_DROPDOWN_TEXT = By.cssSelector(".col-sm-9 h2");
    private static final By SOFTWARE_DROPDOWN_BUTTON = By.xpath("//ul[@class='nav navbar-nav']/li[5]");
    private static final By PHONES_AND_PDAS_DROPDOWN_BUTTON = By.xpath("//ul[@class='nav navbar-nav']/li[6]");
    private static final By CAMERAS_DROPDOWN_BUTTON = By.xpath("//ul[@class='nav navbar-nav']/li[7]");
    private static final By MP3_PLAYERS_DROPDOWN_BUTTON = By.xpath("//ul[@class='nav navbar-nav']/li[8]");




    public static void useSearch(String searchText) {
        BasePage.textInputInElementByLocator(SEARCH_INPUT_FIELD, searchText);
        BasePage.clickOnElementByLocator(SEARCH_BUTTON);
    }

    public static void checkCartTotal() {
        BasePage.clickOnElementByLocator(CART_TOTAL_BUTTON);
    }

    public static String checkEmptyCart() {
        return driver.findElement(EMPTY_CART).getText();
    }

    public static void returnToMainPage() {
        BasePage.clickOnElementByLocator(OPENCART_LOGO);
    }

    public static String getSearchText() {
        return driver.findElement(SEARCH_TEXT_VALUE).getAttribute("value");
    }

    public static void clickTablets() {
        BasePage.clickOnElementByLocator(TABLETS_DROPDOWN_BUTTON);
    }
    public static String getTabletsText() {
        return driver.findElement(TABLETS_DROPDOWN_TEXT).getText();
    }

    public static String getProductNameAfterSearch() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public static String getEmptySearchMessage() {
        return driver.findElement(NO_PRODUCT_MESSAGE).getText();
    }

    private static void goToRegistrationPage() {
        BasePage.clickOnElementByLocator(MY_ACCOUNT_BUTTON);
        BasePage.clickOnElementByLocator(REGISTER_BUTTON);
    }

    private static String emailGenerator() {
        String emailPrefix = RandomStringUtils.randomAlphabetic(8);
        String emailSuffix = RandomStringUtils.randomAlphabetic(4);
        String emailAddress = emailPrefix + "@" + emailSuffix + ".com";
        return emailAddress;
    }

    private static void fillRegistrationForm(String firstName, String lastName, String telephone, String password, String passwordConfirm) {
        BasePage.textInputInElementByLocator(FIRST_NAME_INPUT_FIELD, firstName);
        BasePage.textInputInElementByLocator(LAST_NAME_INPUT_FIELD, lastName);
        BasePage.textInputInElementByLocator(EMAIL_INPUT_FIELD, emailGenerator());
        BasePage.textInputInElementByLocator(TELEPHONE_INPUT_FIELD, telephone);
        BasePage.textInputInElementByLocator(PASSWORD_INPUT_FIELD, password);
        BasePage.textInputInElementByLocator(PASSWORD_CONFIRM_INPUT_FIELD, passwordConfirm);
    }

    public static void fullRegistrationProcess(String firstName, String lastName, String telephone, String password, String passwordConfirm) {
        FrontendHeader.goToRegistrationPage();
        FrontendHeader.fillRegistrationForm(firstName, lastName, telephone, password, passwordConfirm);
        BasePage.clickOnElementByLocator(PRIVACY_POLICY_AGREEMENT_CHECKBOX);
        BasePage.clickOnElementByLocator(CONTINUE_REG_BUTTON);
    }

    public static String getSuccessfulRegistrationText() {
        return driver.findElement(ACC_CREATED_MESSAGE).getText();
    }

}
