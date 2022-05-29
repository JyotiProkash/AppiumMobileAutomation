import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
/**
 * Created by Jyoti on 05/05/2022
 *
 */
public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        switch(platformName){
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy M12");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability(MobileCapabilityType.UDID, "RF8R40CMCCF");
                /*capabilities.setCapability("avd", "samsung_galaxy");
                capabilities.setCapability("avdLaunchTimeout", 180000);*/
                String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                capabilities.setCapability("appPackage", "io.appium.android.apis");
                capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                capabilities.setCapability(MobileCapabilityType.APP, andAppUrl);
                /*capabilities.setCapability("chromedriverExecutableDir", "/Users/local/Downloads/chromedriver");
                capabilities.setCapability("unlockType", "pattern");
                capabilities.setCapability("unlockKey", "125478963");*/
                return new AndroidDriver(url, capabilities);
            case "iOS":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(MobileCapabilityType.UDID, "9527463259a2c083dfc8062535b699a52b9b3cf9");
                capabilities.setCapability("xcodeOrgId", "L8T9J4R323");
                capabilities.setCapability("xcodeSigningId", "iPhone Developer");
                String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
                //capabilities.setCapability(MobileCapabilityType.APP, iOSAppUrl);
                capabilities.setCapability("simulatorStartupTimeout", 180000);
                capabilities.setCapability("bundleId", "com.ubercab.UberClient");
                capabilities.setCapability("includeSafariInWebviews", true);
                capabilities.setCapability("webviewConnectTimeout", "90000");
                /*capabilities.setCapability("safariLogAllCommunication", true);
                capabilities.setCapability("fullContextList", true);
                capabilities.setCapability("additionalWebviewBundleIds", "process-SafariViewService");*/
                return new IOSDriver(url, capabilities);
            default:
                throw new Exception("invalid platform");
        }
    }
}
