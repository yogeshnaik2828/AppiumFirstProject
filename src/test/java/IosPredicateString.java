import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.WebElement;

public class IosPredicateString {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("iOS");

        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type ==\"XCUIElementTypeStaticText\" AND name == \"Activity Indicators\""));
        System.out.println(element.getText());
    }
}
