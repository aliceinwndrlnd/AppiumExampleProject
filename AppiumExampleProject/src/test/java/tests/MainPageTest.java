package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import сore.base.BaseTest;

public class MainPageTest extends BaseTest {

    @Description("Verification of Main screen's elements")
    @Test
    public void verifyMainPageElementsTest() {

        androidBasePage.verifyElements();
    }
}
