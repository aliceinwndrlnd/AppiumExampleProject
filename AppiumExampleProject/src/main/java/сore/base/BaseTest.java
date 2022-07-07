package сore.base;

import org.testng.annotations.*;
import pages.LoginPage;
import utils.mobile.Listener;

import static сore.InitialDriver.*;


@Listeners(Listener.class)
public class BaseTest {
    protected AndroidBasePage androidBasePage = new AndroidBasePage();
    protected LoginPage loginPage = new LoginPage();

    @AfterClass
    public void afterMobileTests() {

        getAndroidDriver().resetApp();
    }
}