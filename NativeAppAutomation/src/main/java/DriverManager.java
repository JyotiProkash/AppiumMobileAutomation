import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Jyoti on 07/05/2022
 *
 */
public class DriverManager {
    static AppiumDriver driver;

    public static void initializeDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        driver = new AppiumDriver(capabilities);
    }

    public static AppiumDriver getDriver(){
        return driver;
    }
}
