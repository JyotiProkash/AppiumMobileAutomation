import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
/**
 * Created by Jyoti on 07/05/2022
 *
 */
public class BasePage {
    AppiumDriver driver;

    public BasePage (){
        this.driver = DriverManager.getDriver();
    }

    public void click(By e){
        driver.findElement(e).click();
    }
}
