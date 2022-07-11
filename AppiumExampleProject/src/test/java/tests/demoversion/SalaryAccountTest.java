package tests.demoversion;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalaryAccountTest extends DemoVersionBaseTest {

    private static final String TRANSFER_SUM = "678908908765";

    @BeforeClass
    public void toGotoSalaryAccountPage() {
        demoVersionPage
                .tapToSalaryAccount();
    }

    @Description("Verification of Salary Account page's elements")
    @Test(priority = 1)
    public void verifySalaryAccountPageElementsTest() {
        salaryAccountPage
                .verifyElements();
    }

    @Description("Checking error message")
    @Test(priority = 2)
    public void topUpAccountTest() {
        salaryAccountPage.tapToTopUpButton()
                .chooseAccountDepositMethod()
                .enterSum(TRANSFER_SUM)
                .tapTransferMoneyButton()
                .checkErrorMessage()
                .tapOkButton();
    }
}
