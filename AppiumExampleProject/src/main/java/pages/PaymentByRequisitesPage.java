package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.Assert;
import сore.base.AndroidBasePage;


public class PaymentByRequisitesPage extends AndroidBasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Получатель')]")
    protected MobileElement RECIPIENT_NAME;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Счет получателя')]")
    protected MobileElement RECIPIENT_ACCOUNT;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'ИНН')]")
    protected MobileElement INN;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'КПП')]")
    protected MobileElement KPP;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'БИК')]")
    protected MobileElement BIK;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_search_edit_text")
    protected MobileElement BIK_SEARCH_FIELD;
    @AndroidFindBy(xpath = "//android.widget.TextView/..")
    protected MobileElement BIK_SBERBANK;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[7]/android.widget.EditText")
    protected MobileElement PAYMENT_APPOINTMENT;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Сумма')]")
    protected MobileElement TRANSFER_SUM;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Перевести')]/..")
    protected MobileElement TRANSFER_BUTTON;


    @Step("Fill the Recipient Name field")
    public PaymentByRequisitesPage fillTheRecipientNameField(String recipientName) {
        elements.searchFieldAndSendKey(RECIPIENT_NAME, recipientName);
        return this;
    }

    @Step("Fill the Recipient Account field")
    public PaymentByRequisitesPage fillTheRecipientAccountField(String recipientAccount) {
        elements.searchFieldAndSendKey(RECIPIENT_ACCOUNT, recipientAccount);
        return this;
    }

    @Step("Fill the INN field")
    public PaymentByRequisitesPage fillTheInnField(String inn) {
        elements.searchFieldAndSendKey(INN, inn);
        return this;
    }

    @Step("Fill the KPP field")
    public PaymentByRequisitesPage fillTheKppField(String kpp) {
        elements.searchFieldAndSendKey(KPP, kpp);
        return this;
    }

    @Step("Tap BIK field")
    public PaymentByRequisitesPage tapBikField() {
        buttons.searchAndClickButtonBy(BIK);
        return this;
    }

    @Step("Fill the BIK field")
    public PaymentByRequisitesPage fillTheBikField(String bikSearchFieldValue) {
        elements.searchFieldAndSendKey(BIK_SEARCH_FIELD, bikSearchFieldValue);
        return this;
    }

    @Step("Choose bank option")
    public PaymentByRequisitesPage chooseBank() {
        buttons.searchAndClickButtonBy(BIK_SBERBANK);
        return this;
    }

    @Step("Check the Payment appointment field")
    public PaymentByRequisitesPage checkThePaymentAppointmentField() {
        Assert.assertEquals(elements.getTextFromElement(PAYMENT_APPOINTMENT),"Перевод по реквизитам");
        return this;
    }

    @Step("Scroll to the Transfer sum field")
    public PaymentByRequisitesPage scrollToTheTransferSumField() {
        screen.scrollToElementById("cb.ibank:id/view_progress_button_text");
        return this;
    }

    @Step("Fill the Transfer Sum field")
    public PaymentByRequisitesPage fillTheTransferSumField(String transferSum) {
        elements.searchFieldAndSendKey(TRANSFER_SUM, transferSum);
        return this;
    }

    @Step("Tap Transfer button")
    public PaymentByRequisitesPage tapTransferButton() {
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }
}
