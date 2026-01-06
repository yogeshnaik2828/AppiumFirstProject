import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.WebElement;

public class AndroidFindElements {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("Android");


        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.id("android:id/text1"));
        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.className("android.widget.TextView"));
        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println(element.getText());

//        element = driver.findElement(AppiumBy.name("Accessibility"));
//        System.out.println(element.getText()); Not supported

//        element = driver.findElement(AppiumBy.tagName("android:id/text1"));
//        System.out.println(element.getText()); // Not supported

    }
}
