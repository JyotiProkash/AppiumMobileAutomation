import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jyoti on 13/05/2022
 * Implementation of TAP
 */

class GesturesTap {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By accessibility = MobileBy.AccessibilityId("Accessibility");

        TouchAction t = new TouchAction(driver);
      //  t.tap(ElementOption.element(driver.findElement(accessibility))).perform();
       // t.tap(PointOption.point(538, 416)).perform();
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(accessibility)))).perform();
    }
}

