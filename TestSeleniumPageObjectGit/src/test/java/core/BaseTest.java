package core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Browser;

public class BaseTest {

    @BeforeClass
    public void setupBrowser() {
        Browser.setup();
    }

    @AfterClass
    public void tearDownBrowser() {
        Browser.tearDown();
    }
}
