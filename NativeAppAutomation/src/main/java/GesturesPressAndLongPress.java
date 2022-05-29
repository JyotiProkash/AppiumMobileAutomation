import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jyoti on 11/05/2022
 * Implementation of
 * PRESS
 * LONGPRESS
 */
class GesturesPressAndLongPress {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By accessibility = MobileBy.AccessibilityId("Activity Indicators");

        TouchAction t = new TouchAction(driver);
        t.press(ElementOption.element(driver.findElement(accessibility)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).release().perform();
        t.longPress(ElementOption.element(driver.findElement(accessibility)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).release().perform();
    }
}

