package tests.demoversion;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaymentsPageTest extends DemoVersionBaseTest {
    protected final String bikSearchFieldValue = "Сбербанк";

    @BeforeClass
    public void toGoToPaymentsPage() {
        demoVersionPage.tapToPaymentsButton();
    }

    @Description("Verify page's elements")
    @Test(priority = 1)
    public void verifyElementsTest() {
        paymentsPage.checkViewMessage()
                .tapToNextButton()
                .verifyElements();
    }

    @Flaky
    @Description("Tap to Payments Of utility services and check error")
    @Test(priority = 2)
    public void tapToPaymentOfUtilityServicesAndCheckErrorTest() {
        paymentsPage.tapToPaymentOfUtilityServices()
                .checkErrorMessage()
                .tapOkButton();
    }

    @Description("Payments by requisites")
    @Test(priority = 3, dataProvider = "requisites")
    public void payingByRequisitesTest(String recipientName, String recipientAccount, String inn, String kpp, String transferSum) {
        paymentsPage.tapByRequisitesPayment();
        paymentByRequisitesPage.fillTheRecipientNameField(recipientName)
                .fillTheRecipientAccountField(recipientAccount)
                .fillTheInnField(inn)
                .fillTheKppField(kpp)
                .tapBikField()
                .fillTheBikField(bikSearchFieldValue)
                .chooseBank()
                .scrollToTheTransferSumField()
                .checkThePaymentAppointmentField()
                .fillTheTransferSumField(transferSum)
                .tapTransferButton()
                .checkErrorMessage()
                .tapOkButton();
    }

    @DataProvider(name = "requisites")
    private Object[][] getRequisites() {
        return new Object[][]{
                {"Tester", "123456", "111", "222", "1000"},
        };
    }
}

