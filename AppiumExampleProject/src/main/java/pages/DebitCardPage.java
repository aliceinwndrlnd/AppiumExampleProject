package pages;

import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import org.testng.asserts.SoftAssert;
import сore.base.AndroidBasePage;

public class DebitCardPage extends AndroidBasePage {
    SoftAssert softAssert = new SoftAssert();

    @AndroidFindBy(accessibility = "Navigate up")
    MobileElement NAVIGATE_UP_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/edit_quick")
    MobileElement TARIFFS;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_order_debit_card_card_view_pager")
    MobileElement IMAGES_OF_CARDS;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_order_debit_card_pager_indicator")
    MobileElement PAGES_INDICATOR;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_order_debit_card_main_advantages")
    MobileElement DEBIT_CARD_ADVANTAGES;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_order_debit_card_header_advantages")
    MobileElement HEADER_ADVANTAGES;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_order_debit_card_advantages_description")
    MobileElement ADVANTAGES_DESCRIPTION;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_order_debit_card_advantages")
    MobileElement ADVANTAGES_SUMMARY;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_order_debit_card_header_processing")
    MobileElement HEADER_PROCESSING;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_order_account_card_header")
    MobileElement ACCOUNT_CARD_HEADER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_order_account_card")
    MobileElement ORDER_ACCOUNT_CARD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_order_phone_header")
    MobileElement ORDER_PHONECALL_HEADER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_order_debit_phone_number")
    MobileElement PHONE_NUMBER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_order_city_picker")
    MobileElement CITY_PICKER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_order_card_deliver_header")
    MobileElement CARD_DELIVERU_HEADER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_order_radio_button_home_deliver")
    MobileElement HOME_DELIVERY_RADIO_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_order_radio_button_office_deliver")
    MobileElement OFFICE_DELIVERY_RADIO_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_order_office_delivery_picker")
    MobileElement OFFICE_DELIVERY_PICKER;
    @AndroidFindBy(id = "cb.ibank:id/item_condition_checkbox")
    MobileElement ACCEPT_CONDITIONS_CHECKBOX;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_debit_card_order_order_card_button")
    MobileElement ORDER_CARD_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    MobileElement ORDER_CARD_BUTTON_TEXT;
    @AndroidFindBy(id = "cb.ibank:id/item_condition_description")
    MobileElement CONDITIONS_DESCRIPTION;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout//android.view.ViewGroup//android.widget.ScrollView//android.widget.FrameLayout[1]//android.widget.FrameLayout")
    MobileElement FIRST_CARD_IMAGE;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout//android.view.ViewGroup//android.widget.ScrollView//android.widget.FrameLayout[2]//android.widget.FrameLayout")
    MobileElement SECOND_CARD_IMAGE;

    private final Point swipePoint = screen.setPointForSwipe( 4.1F,1.1F);


    @Step("Verify elements of first screen's part")
    public DebitCardPage verifyElementsFirstPart() {
        softAssert.assertTrue(elements.isElementExist(NAVIGATE_UP_BUTTON));
        softAssert.assertTrue(elements.isElementExist(IMAGES_OF_CARDS));
        softAssert.assertTrue(elements.isElementExist(PAGES_INDICATOR));
        softAssert.assertTrue(elements.isElementExist(DEBIT_CARD_ADVANTAGES));
        softAssert.assertEquals(elements.getTextFromElement(TARIFFS), "ТАРИФЫ");
        softAssert.assertEquals(elements.getTextFromElement(ADVANTAGES_DESCRIPTION), "Чем больше вы тратите на покупки в текущем месяце, тем больше преимуществ получаете в следующем.");
        softAssert.assertEquals(elements.getTextFromElement(HEADER_ADVANTAGES), "Преимущества");
        softAssert.assertTrue(elements.isVisibleElement(ADVANTAGES_SUMMARY));
        softAssert.assertAll();
        return this;
    }

    @Step("Verify elements of second screen's part")
    public DebitCardPage verifyElementsSecondPart() {
        softAssert.assertTrue(elements.isElementExist(ORDER_ACCOUNT_CARD));
        softAssert.assertTrue(elements.isElementExist(OFFICE_DELIVERY_PICKER));
        softAssert.assertTrue(elements.isElementExist(CITY_PICKER));
        softAssert.assertTrue(elements.isElementExist(ACCEPT_CONDITIONS_CHECKBOX));
        softAssert.assertEquals(elements.getTextFromElement(HEADER_PROCESSING), "Оформление");
        softAssert.assertEquals(elements.getTextFromElement(ACCOUNT_CARD_HEADER), "СЧЁТ ВЫПУСКА КАРТЫ");
        softAssert.assertEquals(elements.getTextFromElement(ORDER_PHONECALL_HEADER), "НОМЕР ДЛЯ SMS-БАНКА");
        softAssert.assertEquals(elements.getTextFromElement(PHONE_NUMBER), "+7 999 111-22-33");
        softAssert.assertEquals(elements.getTextFromElement(CARD_DELIVERU_HEADER), "ПОЛУЧЕНИЕ КАРТЫ");
        softAssert.assertEquals(elements.getTextFromElement(HOME_DELIVERY_RADIO_BUTTON), "Доставка карты на дом");
        softAssert.assertEquals(elements.getTextFromElement(OFFICE_DELIVERY_RADIO_BUTTON), "Получение в отделении УБРиР");
        softAssert.assertEquals(elements.getTextFromElement(ORDER_CARD_BUTTON_TEXT), "Оформить карту");
        softAssert.assertEquals(elements.getTextFromElement(CONDITIONS_DESCRIPTION), "Я подтверждаю актуальность моих паспортных данных, а также ознакомился и согласен правилами и тарифами открытия, обслуживания и операций по картам");
        softAssert.assertAll();
        return this;
    }

    @Step("Scroll to Order card button")
    public DebitCardPage scrollToOrderCardButton() {
        screen.scrollToElementById("cb.ibank:id/view_controller_debit_card_order_order_card_button");
        return new DebitCardPage();
    }

    @Step("Tap to Order button")
    public DebitCardPage tapToOrderButton() {
        buttons.searchAndClickButtonBy(ORDER_CARD_BUTTON);
        return this;
    }

    @Step("Choose Check-box option")
    public DebitCardPage chooseCheckBoxOption() {
        buttons.searchAndClickButtonBy(ACCEPT_CONDITIONS_CHECKBOX);
        return this;
    }

    @Step("Swiping and checking Cards images")
    public DebitCardPage swipeImages() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 400, swipePoint);
        return this;
    }

    @Step("Check images exist")
    public DebitCardPage checkImagesExist() {
        softAssert.assertTrue(elements.isVisibleElement(FIRST_CARD_IMAGE));
        softAssert.assertTrue(elements.isVisibleElement(SECOND_CARD_IMAGE));
        softAssert.assertAll();
        return this;
    }
}
