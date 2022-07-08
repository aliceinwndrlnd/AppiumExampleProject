package pages;

import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import org.testng.asserts.SoftAssert;
import сore.base.AndroidBasePage;


public class PaymentsPage extends AndroidBasePage {

    private final Point leftSwipePointForPaymentsLocation = screen.setPointForSwipe(1.4F, 1.2F);
    private final Point rightSwipePointForPaymentsLocation = screen.setPointForSwipe(7.3F, 1.2F);

    SoftAssert softAssert = new SoftAssert();

    @AndroidFindBy(id = "cb.ibank:id/tutorial_view_message")
    MobileElement VIEW_MESSAGE;
    @AndroidFindBy(id = "cb.ibank:id/tutorial_view_title")
    MobileElement VIEW_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_header_text")
    MobileElement TRANSFER_HEADER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_header_text")
    MobileElement PAYMENTS_HEADER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_toolbar")
    MobileElement PAYMENTS_TOOLBAR;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_settings")
    MobileElement PAYMENTS_SETTINGS;
    @AndroidFindBy(accessibility = "Navigate up")
    MobileElement NAVIGATE_UP_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_search")
    MobileElement PAYMENTS_SEARCH;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_search_edit_text")
    MobileElement PAYMENTS_SEARCH_TEXT;
    @AndroidFindBy(id = "cb.ibank:id/tutorial_view_next_button")
    MobileElement NEXT_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Оплата услуг ЖКХ')]")
    MobileElement PAYMENTS_OF_UTILITY_SERVICES;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'По реквизитам')]")
    MobileElement PAYMENT_BY_REQUISITES;


    @Step("Verify elements")
    public PaymentsPage verifyElements() {
        softAssert.assertEquals(elements.getTextFromElement(TRANSFER_HEADER), "Переводы");
        softAssert.assertEquals(elements.getTextFromElement(PAYMENTS_HEADER), "Платежи");
        softAssert.assertEquals(elements.getTextFromElement(PAYMENTS_SEARCH_TEXT), "Поиск по названию или ИНН");
        softAssert.assertTrue(elements.isElementExist(PAYMENTS_TOOLBAR));
        softAssert.assertTrue(elements.isElementExist(PAYMENTS_SETTINGS));
        softAssert.assertTrue(elements.isElementExist(NAVIGATE_UP_BUTTON));
        softAssert.assertTrue(elements.isElementExist(PAYMENTS_SEARCH));
        softAssert.assertAll();
        return this;
    }

    @Step("Check view message")
    public PaymentsPage checkViewMessage() {
        softAssert.assertEquals(elements.getTextFromElement(VIEW_TITLE), "Быстрые платежи");
        softAssert.assertEquals(elements.getTextFromElement(VIEW_MESSAGE), "Все успешно выполненные операции временно сохраняются в меню быстрых платежей. По нажатию на ярлык быстрого платежа можно перейти к оплате без необходимости заполнять данные заново.");
        softAssert.assertAll();
        return this;
    }

    @Step("Tap to Next button two times")
    public PaymentsPage tapToNextButton() {
        buttons.searchAndClickButtonBy(NEXT_BUTTON);
        buttons.searchAndClickButtonBy(NEXT_BUTTON);
        return this;
    }

    @Step("Tap to Payment of utility services")
    public PaymentsPage tapToPaymentOfUtilityServices() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 900, leftSwipePointForPaymentsLocation);
        waiters.isElementExist(PAYMENTS_OF_UTILITY_SERVICES);
        buttons.searchAndClickButtonBy(PAYMENTS_OF_UTILITY_SERVICES);
        return this;
    }

    @Step("Swipe to the right side on Payments section")
    public PaymentsPage swipeToTheRightSide() {
        screen.swipeScreenWithPressTime(Screen.Direction.RIGHT, 800, rightSwipePointForPaymentsLocation);
        return this;
    }

    @Step("Tap By requisites payment")
    public PaymentsPage tapByRequisitesPayment() {
        buttons.searchAndClickButtonBy(PAYMENT_BY_REQUISITES);
        return this;
    }
}


