package сore.base;

import elements.Buttons;
import elements.Elements;
import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.DemoVersionPage;
import pages.LoginPage;
import pages.PaymentsPage;
import utils.mobile.Waiters;

import static utils.mobile.Waiters.getWaiters;
import static сore.InitialDriver.getAndroidDriver;

public class AndroidBasePage {
    private final AndroidDriver<MobileElement> androidDriver;
    protected Waiters waiters;
    protected Buttons buttons;
    protected Elements elements;
    protected Screen screen;

    SoftAssert softAssert = new SoftAssert();

    public AndroidBasePage() {
        this.androidDriver = getAndroidDriver();
        waiters = getWaiters();
        buttons = new Buttons(androidDriver, waiters);
        elements = new Elements(androidDriver, waiters);
        screen = new Screen(androidDriver, waiters);

        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "cb.ibank:id/view_controller_demo_version")
    protected MobileElement DEMO_VERSION_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_logo")
    protected MobileElement WELCOME_LOGO;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_title")
    protected MobileElement WELCOME_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_button_login")
    protected MobileElement LOGIN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    protected MobileElement LOGIN_BUTTON_TEXT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_button_become_client")
    protected MobileElement BECOME_CLIENT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/include_department_addresses")
    protected MobileElement DEPARTMENT_ADRESSES;
    @AndroidFindBy(id = "cb.ibank:id/include_currency_rates")
    protected MobileElement CURRENCY_RATES;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_test_settings")
    protected MobileElement TEST_SETTINGS;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    MobileElement ERROR_MESSAGE;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_ok")
    MobileElement OK_BUTTON;


    @Step("Verify elements")
    public AndroidBasePage verifyElements() {
        softAssert.assertEquals(elements.getTextFromElement(DEMO_VERSION_BUTTON), "Демо-версия");
        softAssert.assertEquals(elements.getTextFromElement(WELCOME_TITLE), "Приветствуем\n" +
                "в мобильном банке\n" +
                "УБРиР");
        softAssert.assertEquals(elements.getTextFromElement(LOGIN_BUTTON_TEXT), "Войти");
        softAssert.assertEquals(elements.getTextFromElement(BECOME_CLIENT_BUTTON), "Стать клиентом");
        softAssert.assertEquals(elements.getTextFromElement(DEPARTMENT_ADRESSES), "Адреса отделений");
        softAssert.assertEquals(elements.getTextFromElement(CURRENCY_RATES), "Курс валют");
        softAssert.assertTrue(elements.isElementExist(WELCOME_LOGO));
        softAssert.assertTrue(elements.isElementExist(TEST_SETTINGS));
        softAssert.assertAll();
        return this;
    }

    @Step("Tap Login button")
    public LoginPage clickLoginPage() {
        buttons.searchAndClickButtonBy(LOGIN_BUTTON);
        return new LoginPage();
    }

    @Step("Tap Demo-Version button")
    public DemoVersionPage clickDemoVersionPage() {
        buttons.searchAndClickButtonBy(DEMO_VERSION_BUTTON);
        return new DemoVersionPage();
    }

    @Step("Check Error message")
    public AndroidBasePage checkErrorMessage() {
        Assert.assertEquals(elements.getTextFromElement(ERROR_MESSAGE), "Недоступно в демо-режиме");
        return this;
    }

    @Step("Tap Ok button")
    public AndroidBasePage tapOkButton() {
        buttons.searchAndClickButtonBy(OK_BUTTON);
        return this;
    }

}
