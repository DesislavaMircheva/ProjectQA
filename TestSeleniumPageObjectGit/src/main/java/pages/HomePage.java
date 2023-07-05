package pages;

import core.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "http://shop.pragmatic.bg";
    private static final By MY_ACCOUNT_DROPDOWN_MENU =  By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
    private static final By REGISTER_BUTTON =  By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    private static final By FIRST_NAME_INPUT_FIELD =  By.id("input-firstname");
    private static final By LAST_NAME_INPUT_FIELD =  By.id("input-lastname");
    private static final By EMAIL_INPUT_FIELD =  By.id("input-email");
    private static final By TELEPHONE_INPUT_FIELD =  By.id("input-telephone");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By PASSWORD_CONFIRMED_FIELD =  By.id("input-confirm");
    private static final By CONTINUE_BUTTON =  By.cssSelector("input.btn.btn-primary");
    private static final By CHECKBOX = By.cssSelector("input[type=checkbox]");
    private static final By REGISTER_CONFIRMATION_MESSAGE = By.cssSelector("h1");

    private static final By REGISTER_CUSTOMER_ERROR = By.cssSelector("div.text-danger");
    private static String customerEmail;
    public static String getCustomerEmail() {
        return customerEmail;
    }
    public static void goToHomePage() {
//        Browser.getDriver().get(HOME_PAGE_URL);
        driver.get(HOME_PAGE_URL);
    }
    public static void writeTextInFirstnameInputField(String firstname) {
        driver.findElement(FIRST_NAME_INPUT_FIELD).sendKeys(firstname);
    }

    public static void writeTextInLastnameInputField(String lastname) {
        driver.findElement(LAST_NAME_INPUT_FIELD).sendKeys(lastname);
    }

    public static void writeTextInTelephoneInputField(String telephone) {
        driver.findElement(TELEPHONE_INPUT_FIELD).sendKeys(telephone);
    }
    public static void writeTextInEmailInputField(String customerEmail) {
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys(customerEmail);
    }
    public static void writeTextInPasswordInputField(String password) {
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
    }

    public static void writeTextInPasswordConfirmField(String password) {
        driver.findElement(PASSWORD_CONFIRMED_FIELD).sendKeys(password);
    }

    public static void randomEmailGenerator (){
        String prefix = RandomStringUtils.randomAlphabetic(7);
        String sufix = RandomStringUtils.randomAlphabetic(5);
        String domain = RandomStringUtils.randomAlphabetic(3);
        customerEmail= prefix + "@" + sufix + "." + domain;

    }
    public static void clickOnDropdownMyAccountMenu() {
        clickOnElementByLocator(MY_ACCOUNT_DROPDOWN_MENU);
    }

    public static void clickRegisterInMyAccountMenu() {
        clickOnElementByLocator(REGISTER_BUTTON);
    }

    public static void clickOnCheckBox() {
        clickOnElementByLocator(CHECKBOX);
    }
    public static void clickOnContinueButton() {
        clickOnElementByLocator(CONTINUE_BUTTON);
    }

    public static void verifyConfirmationMessage(String expectedMessage) {
        String actualValidationMessage = driver.findElement(REGISTER_CONFIRMATION_MESSAGE).getText();
        Assert.assertTrue(actualValidationMessage.contains(expectedMessage));
    }

    public static void verifyErrorMessage(String expectedMessage) {
        String actualMessage = driver.findElement(REGISTER_CUSTOMER_ERROR).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }


}
