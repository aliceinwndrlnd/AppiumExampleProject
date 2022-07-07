package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import сore.base.AndroidBasePage;


public class DemoVersionPage extends AndroidBasePage {
    @AndroidFindBy(id = "cb.ibank:id/main_screen_toolbar_title")
    MobileElement TOOLBAR_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/main_screen_toolbar_notifications_icon")
    MobileElement NOTIFICATION_ICON;
    @AndroidFindBy(id = "cb.ibank:id/main_screen_accounts_and_deposits_header")
    MobileElement ACCOUNTS_AND_DEPOSITS_HEADER;
    @AndroidFindBy(id = "cb.ibank:id/main_screen_accounts_and_deposits_show_as_list")
    MobileElement SHOW_ALL_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/account_name")
    MobileElement SALARY_ACCOUNT_NAME;
    @AndroidFindBy(id = "cb.ibank:id/saving_account_name")
    MobileElement SAVING_ACCOUNT_NAME;
    @AndroidFindBy(id = "cb.ibank:id/main_screen_loans_header")
    MobileElement LOANS_HEADER;
    @AndroidFindBy(id = "cb.ibank:id/main_screen_products_header")
    MobileElement PRODUCTS_HEADER;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_home")
    MobileElement NAVIGATION_HOME;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_history")
    MobileElement NAVIGATION_HISTORY;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_main_action_button")
    MobileElement MAIN_ACTION_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_chat")
    MobileElement NAVIGATION_CHAT;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_chat_title")
    MobileElement NAVIGATION_CHAT_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_more")
    MobileElement NAVIGATION_MORE;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_payment_title")
    MobileElement PAYMENT_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/main_screen_order_debit_card_view")
    MobileElement DEBIT_CARD_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_main_action_button")
    MobileElement PAYMENTS_BUTTON;

    SoftAssert softAssert = new SoftAssert();

    @Step("Verify elements")
    public DemoVersionPage verifyElements() {
        softAssert.assertTrue(elements.isElementExist(NOTIFICATION_ICON));
        softAssert.assertTrue(elements.isElementExist(SHOW_ALL_BUTTON));
        softAssert.assertTrue(elements.isElementExist(NAVIGATION_HOME));
        softAssert.assertTrue(elements.isElementExist(NAVIGATION_HISTORY));
        softAssert.assertTrue(elements.isElementExist(MAIN_ACTION_BUTTON));
        softAssert.assertTrue(elements.isElementExist(NAVIGATION_CHAT));
        softAssert.assertTrue(elements.isElementExist(NAVIGATION_MORE));
        softAssert.assertEquals(elements.getTextFromElement(TOOLBAR_TITLE), "Мои финансы");
        softAssert.assertEquals(elements.getTextFromElement(ACCOUNTS_AND_DEPOSITS_HEADER), "Счета и вклады");
        softAssert.assertEquals(elements.getTextFromElement(SALARY_ACCOUNT_NAME), "Зарплатный счет");
        softAssert.assertEquals(elements.getTextFromElement(SAVING_ACCOUNT_NAME), "Накопительный счет");
        softAssert.assertEquals(elements.getTextFromElement(LOANS_HEADER), "Кредиты");
        softAssert.assertEquals(elements.getTextFromElement(PRODUCTS_HEADER), "Продукты");
        softAssert.assertEquals(elements.getTextFromElement(PAYMENT_TITLE), "Платежи");
        softAssert.assertEquals(elements.getTextFromElement(NAVIGATION_CHAT_TITLE), "Чат");
        softAssert.assertAll();
        return this;
    }

    @Step("Tap to Salary account")
    public DemoVersionPage tapToSalaryAccount() {
        buttons.searchAndClickButtonBy(SALARY_ACCOUNT_NAME);
        return this;
    }

        /*@Step("Tap to Saving Account")
        public DemoVersionPage tapToSavingAccount(){
        buttons.searchAndClickButtonBy(SAVING_ACCOUNT_NAME);
        return this;
        }*/

    @Step("Tap to Debit card page")
    public DemoVersionPage tapToDebitCardPage() {
        buttons.searchAndClickButtonBy(DEBIT_CARD_BUTTON);
        return this;
    }

    @Step("Scroll to Issue debit card")
    public DemoVersionPage scrollToIssueDebitCardElement() {
        screen.scrollToElementById("cb.ibank:id/main_screen_order_debit_card_view");
        return new DemoVersionPage();
    }

    @Step("Tap to Payments button")
    public DemoVersionPage tapToPaymentsButton() {
        buttons.searchAndClickButtonBy(PAYMENTS_BUTTON);
        return this;
    }
}
