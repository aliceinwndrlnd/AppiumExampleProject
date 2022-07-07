package tests.demoversion;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class DemoVersionPageTest extends DemoVersionBaseTest {

    @Description("Verification of DemoVersion page's elements")
    @Test
    public void verifyDemoVersionPageElementsTest() {

        demoVersionPage.verifyElements();
    }

}
