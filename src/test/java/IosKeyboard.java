import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class IosKeyboard {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("iOS");

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        element.click();

        Map<String, Object> params = new HashMap<>();
        params.put("bundleId", "com.example.apple-samplecode.UICatalog");
        boolean isInstalled = (Boolean) driver.executeScript("mobile:isAppInstalled", params);
        System.out.println(isInstalled);

        Thread.sleep(5000);
        ((IOSDriver) driver).terminateApp("com.example.apple-samplecode.UICatalog");
//        System.out.println(((IOSDriver) driver).queryAppState("com.example.apple-samplecode.UICatalog"));
        String iOSAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
//        ((IOSDriver) driver).installApp(iOSAppPath);
//        ((IOSDriver) driver).runAppInBackground(Duration.ofMillis(5000));
        ((IOSDriver) driver).activateApp("com.apple.Preferences");
        Thread.sleep(5000);
        ((IOSDriver) driver).activateApp("com.example.apple-samplecode.UICatalog");
//        System.out.println(((IOSDriver) driver).queryAppState("com.example.apple-samplecode.UICatalog"));


    }
}
