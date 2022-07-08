package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import сore.base.AndroidBasePage;

public class SalaryAccountPage extends AndroidBasePage {
    @AndroidFindBy(id = "cb.ibank:id/toolbar_title")
    MobileElement TOOLBAR_TITLE;
    @AndroidFindBy(accessibility = "Navigate up")
    MobileElement NAVIGATE_UP_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_account_details_name")
    MobileElement SALARY_ACCOUNT_NAME;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_account_details_number")
    MobileElement SALARY_ACCOUNT_NUMBER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_account_details_balance")
    MobileElement SALARY_ACCOUNT_BALANCE;
    @AndroidFindBy(xpath = "//*[@text='Пополнить']")
    MobileElement TOP_UP_BUTTON;
    @AndroidFindBy(xpath = "//*[@text = 'Оплатить']")
    MobileElement PAY_BUTTON;
    @AndroidFindBy(xpath = "//*[@text = 'Реквизиты']")
    MobileElement REQUISITES_BUTTON;
    @AndroidFindBy(xpath = "//*[@text = 'Карты']")
    MobileElement CARDS_TITLE;
    @AndroidFindBy(xpath = "//*[@text = 'Справки и выписки']")
    MobileElement REFERENCES_AND_EXTRACTS;
    @AndroidFindBy(xpath = "//*[@text = 'Справка о доступном остатке']")
    MobileElement CERTIFICATE_OF_AVAILABLE_BALANCE;
    @AndroidFindBy(xpath = "//*[@text = 'Выписка по счёту']")
    MobileElement ACCOUNT_STATEMENT;
    @AndroidFindBy(accessibility = "Переименовать")
    MobileElement EDIT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/card_image")
    MobileElement CARDS_IMAGES;
    @AndroidFindBy(id = "cb.ibank:id/card_name")
    MobileElement CARDS_NAMES;
    @AndroidFindBy(id = "cb.ibank:id/card_payment_system_logo")
    MobileElement CARDS_LOGOS;
    @AndroidFindBy(id = "cb.ibank:id/card_last_digits")
    MobileElement CARDS_LAST_DIGITS;
    @AndroidFindBy(xpath = "//*[@text = 'Со своего счёта']")
    MobileElement TOP_UP_FROM_YOUR_OWN_ACCOUNT;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    MobileElement TRANSFER_MONEY_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_amount")
    MobileElement ENTER_SUMM_FIELD;

    SoftAssert softAssert = new SoftAssert();

    @Step("Verify elements")
    public SalaryAccountPage verifyElements() {
        softAssert.assertEquals(elements.getTextFromElement(CARDS_TITLE), "Карты");
        softAssert.assertEquals(elements.getTextFromElement(TOOLBAR_TITLE), "Счёт");
        softAssert.assertEquals(elements.getTextFromElement(SALARY_ACCOUNT_NAME), "Зарплатный счет");
        softAssert.assertEquals(elements.getTextFromElement(TOP_UP_BUTTON), "Пополнить");
        softAssert.assertEquals(elements.getTextFromElement(PAY_BUTTON), "Оплатить");
        softAssert.assertEquals(elements.getTextFromElement(REQUISITES_BUTTON), "Реквизиты");
        softAssert.assertEquals(elements.getTextFromElement(REFERENCES_AND_EXTRACTS), "Справки и выписки");
        softAssert.assertEquals(elements.getTextFromElement(CERTIFICATE_OF_AVAILABLE_BALANCE), "Справка о доступном остатке");
        softAssert.assertEquals(elements.getTextFromElement(ACCOUNT_STATEMENT), "Выписка по счёту");
        softAssert.assertTrue(elements.isEnableElement(SALARY_ACCOUNT_BALANCE));
        softAssert.assertTrue(elements.isEnableElement(SALARY_ACCOUNT_NUMBER));
        softAssert.assertTrue(elements.isEnableElement(NAVIGATE_UP_BUTTON));
        softAssert.assertTrue(elements.isEnableElement(CARDS_TITLE));
        softAssert.assertTrue(elements.isEnableElement(CARDS_IMAGES));
        softAssert.assertTrue(elements.isEnableElement(CARDS_NAMES));
        softAssert.assertTrue(elements.isEnableElement(CARDS_LAST_DIGITS));
        softAssert.assertTrue(elements.isEnableElement(CARDS_LOGOS));
        softAssert.assertTrue(elements.isEnableElement(CARDS_TITLE));
        softAssert.assertTrue(elements.isEnableElement(EDIT_BUTTON));
        softAssert.assertAll();
        return this;
    }

    @Step("Tap to Top Up button")
    public SalaryAccountPage tapToTopUpButton() {
        buttons.searchAndClickButtonBy(TOP_UP_BUTTON);
        return this;
    }

    @Step("Choose top up account steps")
    public SalaryAccountPage chooseAccountDepositMethod() {
        buttons.searchAndClickButtonBy(TOP_UP_FROM_YOUR_OWN_ACCOUNT);
        return this;
    }

    @Step("Enter replenishment amount")
    public SalaryAccountPage enterSum(String sum) {
        buttons.searchAndClickButtonBy(ENTER_SUMM_FIELD);
        elements.sendKeyFromAction(sum);
        return this;
    }

    @Step("Tap Transfer money Button")
    public SalaryAccountPage tapTransferMoneyButton() {
        buttons.searchAndClickButtonBy(TRANSFER_MONEY_BUTTON);
        return this;
    }
}
