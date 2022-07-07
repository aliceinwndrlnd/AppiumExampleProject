package tests.demoversion;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pages.DebitCardPage;
import pages.DemoVersionPage;
import pages.PaymentsPage;
import pages.SalaryAccountPage;
import utils.mobile.Listener;
import сore.base.AndroidBasePage;
import сore.base.BaseTest;

@Listeners(Listener.class)
public class DemoVersionBaseTest extends BaseTest {

    protected AndroidBasePage androidBasePage = new AndroidBasePage();
    protected DemoVersionPage demoVersionPage = new DemoVersionPage();
    protected SalaryAccountPage salaryAccountPage = new SalaryAccountPage();
    protected DebitCardPage debitCardPage = new DebitCardPage();
    protected PaymentsPage paymentsPage = new PaymentsPage();

    @BeforeTest
    public void goToDemoVersionPage() {

        androidBasePage.clickDemoVersionPage();
    }
}
