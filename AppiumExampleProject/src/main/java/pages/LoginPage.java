package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import сore.base.AndroidBasePage;


public class LoginPage extends AndroidBasePage {
    SoftAssert softAssert = new SoftAssert();

    @AndroidFindBy(accessibility = "Navigate up")
    MobileElement NAVIGATE_UP_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_login_title")
    MobileElement LOGIN_PAGE_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_login_edit_text_layout")
    MobileElement LOGIN_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_password_edit_text_layout")
    MobileElement PASSWORD_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_button_forgot_login_or_password")
    MobileElement FORGOT_LOGIN_OR_PASS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_button_login")
    MobileElement LOGIN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    MobileElement LOGIN_BUTTON_TEXT;
    @AndroidFindBy(accessibility = "По Логину")
    MobileElement BY_LOGIN_SECTION;
    @AndroidFindBy(accessibility = "По карте")
    MobileElement BY_CARD_SECTION;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    MobileElement ERROR_MESSAGE_NOT_ENOUGH_DATA;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    MobileElement ERROR_MESSAGE_INVALID_DATA;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    MobileElement OK_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_cancel")
    MobileElement CANCEL_DIALOG_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sign_in_with_card_field_card")
    MobileElement SIGN_WITH_CARD_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/text_input_end_icon")
    MobileElement INFORMATION_ABOUT_CARDNUMBER_ICON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    MobileElement CARD_NUMBER_LENGHT_INFORMATION;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sign_in_with_card_field_password")
    MobileElement CARD_PASSWORD_FIELD;


    @Step("Verify elements")
    public LoginPage elementsIsEnabled() {
        softAssert.assertEquals(elements.getTextFromElement(LOGIN_PAGE_TITLE), "Вход в мобильный банк \n" +
                "по логину");
        softAssert.assertEquals(elements.getTextFromElement(LOGIN_BUTTON_TEXT), "Войти");
        softAssert.assertEquals(elements.getTextFromElement(FORGOT_LOGIN_OR_PASS_BUTTON), "Забыли логин\n" +
                "или пароль?");
        softAssert.assertTrue(elements.isElementExist(LOGIN_BUTTON));
        softAssert.assertTrue(elements.isElementExist(NAVIGATE_UP_BUTTON));
        softAssert.assertTrue(elements.isElementExist(LOGIN_FIELD));
        softAssert.assertTrue(elements.isElementExist(PASSWORD_FIELD));
        softAssert.assertEquals(BY_CARD_SECTION.getAttribute("content-desc"), "По карте");
        softAssert.assertEquals(BY_LOGIN_SECTION.getAttribute("content-desc"), "По Логину");
        softAssert.assertAll();
        return this;
    }

    @Step("Tap Login field and input data")
    public LoginPage tapAndInputDataOnLoginField(String loginData) {
        buttons.searchAndClickButtonBy(LOGIN_FIELD);
        elements.sendKeyFromAction(loginData);
        return this;
    }

    @Step("Tap Password field and input data")
    public LoginPage tapAndInputDataOnPasswordField(String password) {
        buttons.searchAndClickButtonBy(PASSWORD_FIELD);
        elements.sendKeyFromAction(password);
        return this;
    }


    @Step("Check error message in notEnoughData case")
    public LoginPage checkErrorMessageInNotEnoughDataCase() {
        Assert.assertEquals(ERROR_MESSAGE_NOT_ENOUGH_DATA.getText(), "Необходимо корректно заполнить все поля");
        return this;
    }

    @Step("Check error message in invalid dats case")
    public LoginPage checkErrorMessageInInvalidDataCase() {
        waiters.waitSomeSecond(80);
        Assert.assertEquals(ERROR_MESSAGE_INVALID_DATA.getText(), "Не удалось загрузить данные");
        return this;
    }

    @Step("Tap OK button")
    public LoginPage tapOkButton() {
        buttons.searchAndClickButtonBy(OK_BUTTON);
        return this;
    }

    @Step("Tap Login button")
    public LoginPage tapLoginButton() {
        buttons.searchAndClickButtonBy(LOGIN_BUTTON);
        return this;
    }

    @Step("Tap Cancel button")
    public LoginPage tapCancelButton() {
        buttons.searchAndClickButtonBy(CANCEL_DIALOG_BUTTON);
        return this;
    }

    @Step("Tap By card")
    public LoginPage tapByCard() {
        buttons.searchAndClickButtonBy(BY_CARD_SECTION);
        return this;
    }

    @Step("Input card number data")
    public LoginPage inputCardData(String cardNumber) {
        buttons.searchAndClickButtonBy(SIGN_WITH_CARD_FIELD);
        elements.sendKeyFromAction(cardNumber);
        return this;
    }

    @Step("Tap to card password field")
    public LoginPage tapToCardPasswordField() {
        buttons.searchAndClickButtonBy(CARD_PASSWORD_FIELD);
        return this;
    }

    @Step("Tap information icon")
    public LoginPage tapInformIcon() {
        buttons.searchAndClickButtonBy(INFORMATION_ABOUT_CARDNUMBER_ICON);
        return this;
    }

    @Step("Check card number length information")
    public LoginPage checkInformationAboutCardNumber() {
        Assert.assertEquals(elements.getTextFromElement(CARD_NUMBER_LENGHT_INFORMATION), "Номер карты должен содержать 15 символов");
        return this;
    }
}
