import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AndroidUiAutomator {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("Android");

        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println(element.getText());

        element = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println(element.getText());

        element = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
        System.out.println(element.getText());

    }
}
