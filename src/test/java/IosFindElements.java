import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.WebElement;

public class IosFindElements {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("iOS");

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        System.out.println(element.getText());

        element = driver.findElements(AppiumBy.className("XCUIElementTypeStaticText")).get(1);
        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.name("Activity Indicators"));
        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.id("Activity Indicators"));
        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
        System.out.println(element.getText());

//        element = driver.findElement(AppiumBy.tagName("Activity Indicators"));
//        System.out.println(element.getText());
    }
}
