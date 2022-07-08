package tests.demoversion;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaymentsPageTest extends DemoVersionBaseTest {

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
}

