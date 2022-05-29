import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

/**
 * Created by Jyoti on 06/05/2022
 *
 */
public class CreateDriverSessionLunchEmulator {

    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung_Galaxy_2");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5553");
        capabilities.setCapability("avd", "Samsung_Galaxy_2");
        capabilities.setCapability("avdLaunchTimeout", 150000);
        String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        capabilities.setCapability(MobileCapabilityType.APP, andAppUrl);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        AppiumDriver driver = new AndroidDriver(url, capabilities);
    }
}
