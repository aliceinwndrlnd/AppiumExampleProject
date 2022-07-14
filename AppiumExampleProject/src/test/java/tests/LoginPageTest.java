package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import сore.base.BaseTest;

public class LoginPageTest extends BaseTest {

    private static final String EMAIL = "test@test.by";
    private static final String CARD_NUMBER = "5678";
    private static final String PASSWORD = "1234";

    @BeforeClass
    public void toGoToLoginPage() {

        androidBasePage.clickLoginPage();
    }

    @Description("Verification of Login Page's elements")
    @Test(priority = 1)
    public void verifyLoginPageElementsTest() {

        loginPage.elementsIsEnabled();
    }

    @Description("Check error message in notEnoughData case")
    @Test(priority = 2)
    public void notEnoughDataTest() {
        loginPage.tapAndInputDataOnLoginField(EMAIL)
                .tapLoginButton()
                .checkErrorMessageInNotEnoughDataCase()
                .tapOkButton();
    }

    @Description("Check Show password button is working")
    @Test(priority = 3)
    public void checkShowPasswordBtnWork() {
        loginPage.clearLoginField()
                .tapAndInputDataOnPasswordField(PASSWORD)
                .tapShowPasswordButton()
                .checkDataInPasswordFieldIsVisible(PASSWORD);
    }


    @Description("Tap to By Card Login and check length of cards number field")
    @Test(priority = 4)
    public void checkCardNumberLength() {
        loginPage.tapByCard()
                .inputCardData(CARD_NUMBER)
                .tapToCardPasswordField()
                .tapInformIcon()
                .checkInformationAboutCardNumber()
                .tapOkButton();
    }
}
