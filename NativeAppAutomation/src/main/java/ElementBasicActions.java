import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

/**
 * Created by Jyoti on 08/05/2022
 * Implementation of click
 * sendKeys
 * clear
 */

public class ElementBasicActions {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = MobileBy.AccessibilityId("Views");
        By textFields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");

        Dimension size = driver.manage().window().getSize();
        driver.findElement(views).click();
        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        for(int i=0;i<3;i++)
          {
              (new TouchAction(driver))
                      .press(new PointOption().point(startX,startY))
                      .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                      .moveTo(new PointOption().point(endX,endY))
                      .release()
                      .perform();
          }

/*        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(507, 1679))
                .moveTo(new PointOption().withCoordinates(520, 625))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(494, 1713))
                .moveTo(new PointOption().withCoordinates(499, 560))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(503, 1713))
                .moveTo(new PointOption().withCoordinates(494, 525))
                .release()
                .perform();*/

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("my text");
        Thread.sleep(2000);
        driver.findElement(editText).clear();
    }
}

