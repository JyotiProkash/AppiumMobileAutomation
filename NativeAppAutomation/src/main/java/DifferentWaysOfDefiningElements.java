import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jyoti on 08/05/2022
 * Implementation of MobileElement
 * WebElement
 * By
 * MobileBy
 * @FindBy
 * @AndroidFindBy
 * @iOSXCUITFindBy
 */

public class DifferentWaysOfDefiningElements {
    @AndroidFindBy(xpath = "//*[@text=\"Accessibility\"]")
    @iOSXCUITFindBy(accessibility = "Accessibility")
    private static MobileElement myElement3;

    public DifferentWaysOfDefiningElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        DifferentWaysOfDefiningElements differentWaysOfDefiningElements = new DifferentWaysOfDefiningElements(driver);
        System.out.println(myElement3.getText());

        By myElement2 = MobileBy.AccessibilityId("Accessibility");
        System.out.println(driver.findElement(myElement2).getText());

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText());

        WebElement myElement1 = driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement1.getText());
    }
}
