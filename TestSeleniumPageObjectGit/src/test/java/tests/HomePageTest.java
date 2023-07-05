package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {
    @Test
    public void registerNewAccountSuccessfully() {
        HomePage.goToHomePage();
        HomePage.clickOnDropdownMyAccountMenu();
        HomePage.clickRegisterInMyAccountMenu();
        HomePage.writeTextInFirstnameInputField("Desislava");
        HomePage.writeTextInLastnameInputField("Mircheva");
        HomePage.writeTextInTelephoneInputField("+359878227831");
        HomePage.randomEmailGenerator();
        HomePage.writeTextInEmailInputField(HomePage.getCustomerEmail());
        HomePage.writeTextInPasswordInputField("Ipaktaka1!");
        HomePage.writeTextInPasswordConfirmField("Ipaktaka1!");
        HomePage.clickOnCheckBox();
        HomePage.clickOnContinueButton();
        HomePage.verifyConfirmationMessage("Your Account Has Been Created!");

    }

    @Test
    public void registerNewAccountErrorInConfirmedEmail() {
        HomePage.goToHomePage();
        HomePage.clickOnDropdownMyAccountMenu();
        HomePage.clickRegisterInMyAccountMenu();
        HomePage.writeTextInFirstnameInputField("Desislava");
        HomePage.writeTextInLastnameInputField("Mircheva");
        HomePage.writeTextInTelephoneInputField("+359878227831");
        HomePage.randomEmailGenerator();
        HomePage.writeTextInEmailInputField(HomePage.getCustomerEmail());
        HomePage.writeTextInPasswordInputField("Ipaktaka1!");
        HomePage.writeTextInPasswordConfirmField("Ipaktaka1");
        HomePage.clickOnCheckBox();
        HomePage.clickOnContinueButton();
        HomePage.verifyErrorMessage("Password confirmation does not match password!");

    }
}
