package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest {

    @BeforeMethod
    public static void browserSetup() {
        Browser.setup();
    }

    @AfterMethod
    public static void browserTearDown() {
        Browser.tearDown();
    }
}
