package tests.demoversion;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DebitCardPageTest extends DemoVersionBaseTest {

    @BeforeClass
    public void toGoToDebitCartPage() {
        demoVersionPage.scrollToIssueDebitCardElement();
        demoVersionPage.tapToDebitCardPage();
    }

    @Description("Swipe and check visibility of Cards Images")
    @Test(priority = 1)
    public void swipeAndCheckImagesTest() {
        debitCardPage.swipeImages()
                .checkImagesExist();
    }

    @Description("Verification of Debit Card Page's elements")
    @Test(priority = 2)
    public void verifyDebitCardPageElementsTest() {
        debitCardPage.verifyElementsFirstPart()
                .scrollToOrderCardButton()
                .verifyElementsSecondPart();
    }

    @Description("Choose Checkbox option and check Error Message")
    @Test(priority = 3)
    public void orderDebitCardTest() {
        debitCardPage.chooseCheckBoxOption()
                .tapToOrderButton()
                .checkErrorMessage()
                .tapOkButton();
    }
}
