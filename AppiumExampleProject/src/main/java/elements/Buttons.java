package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.mobile.Waiters;


public class Buttons extends MobileElements {
    public Buttons(AppiumDriver<MobileElement> driver, Waiters waiters) {
        super(driver, waiters);
    }

    public void searchAndClickButtonBy(MobileElement mobileElement) {
        var waitedMobileElement = waiters.waitForElementClickable(mobileElement);
        waitedMobileElement.click();
    }

    public void clickButtonBackspaceOnKeyboardAndroid() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DEL));
    }
}
