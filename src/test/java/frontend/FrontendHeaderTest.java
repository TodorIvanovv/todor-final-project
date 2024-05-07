package frontend;

import base.BaseTest;
import components.FrontendHeader;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WaitTool;

public class FrontendHeaderTest extends BaseTest {

    @Test
    public void searchForExistingProduct() {
        MainPage.goToMainPage();
        FrontendHeader.useSearch("iMac");
        WaitTool.waitForElementVisibility(By.cssSelector("#input-search"), 10);
        String actualSearchText = FrontendHeader.getSearchText();
        Assert.assertEquals(actualSearchText,"iMac");
    }

    @Test
    public void searchForExistingProduct2() {
        MainPage.goToMainPage();
        FrontendHeader.useSearch("htc");
        WaitTool.waitForElementVisibility(By.cssSelector("#input-search"), 10);
        String productNameAfterSearch = FrontendHeader.getProductNameAfterSearch();
        Assert.assertEquals(productNameAfterSearch, "HTC Touch HD");
    }

    @Test
    public void emptySearch() {
        MainPage.goToMainPage();
        FrontendHeader.useSearch("");
        WaitTool.waitForElementVisibility(By.cssSelector("#input-search"), 10);
        String searchText = FrontendHeader.getSearchText();
        Assert.assertEquals(searchText, "");
    }

    @Test
    public void emptySearch2() {
        MainPage.goToMainPage();
        FrontendHeader.useSearch("");
        WaitTool.waitForElementVisibility(By.xpath("//div[@id=\"content\"]//p[2]"), 10);
        String emptySearchMessage = FrontendHeader.getEmptySearchMessage();
        Assert.assertEquals(emptySearchMessage, "There is no product that matches the search criteria.");
    }

    @Test
    public void checkEmptyCart() {
        MainPage.goToMainPage();
        FrontendHeader.checkCartTotal();
        String emptyCartText = FrontendHeader.checkEmptyCart();
        Assert.assertEquals(emptyCartText, "Your shopping cart is empty!");
    }

    @Test
    public void returnToMainPageByOpencartLogo() {
        MainPage.goToMainPage();
        FrontendHeader.useSearch("");
        FrontendHeader.returnToMainPage();
        String mainPageCheckFeaturedText = MainPage.mainPageCheck();
        Assert.assertEquals(mainPageCheckFeaturedText, "Featured");
    }

    @Test
    public void dropdownTabletsButton() {
        MainPage.goToMainPage();
        FrontendHeader.clickTablets();
        WaitTool.waitForElementVisibility(By.cssSelector(".col-sm-3.hidden-xs"), 10);
        String tabletsText = FrontendHeader.getTabletsText();
        Assert.assertEquals(tabletsText, "Tablets");
    }

    @Test
    public void successfulRegistrationProcess() {
        MainPage.goToMainPage();
        FrontendHeader.fullRegistrationProcess("Todor", "Ivanov", RandomStringUtils.randomNumeric(10), "parola123!", "parola123!");
        String successfulRegistrationText = FrontendHeader.getSuccessfulRegistrationText();
        Assert.assertEquals(successfulRegistrationText, "Your Account Has Been Created!");
    }


}
