import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WebViewInspectorUsingAppiumInspector {

    public static void main(String[] args) throws Exception {
       /* AppiumDriver driver = DriverStartSessionOptions.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();
        Thread.sleep(3000);

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        By webView = AppiumBy.accessibilityId("WebView2");
        driver.findElement(webView).click();

        Thread.sleep(5000);
        System.out.println(driver.findElement(AppiumBy.xpath("(//android.webkit.WebView[@text=\"I am a page title\"]//android.widget.TextView)[1]")).getText());
*/


        AppiumDriver iosDriver = DriverStartSessionOptions.initializeDriver("iOS");
        iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//        Map<String,Object> params = new HashMap<>();
//        params.put("direction","up");
//        params.put("")
//        iosDriver.executeScript("mobile: swipeGesture",
//        ));

//        By webView = AppiumBy.accessibilityId("WebView2");
//        driver.findElement(webView).click();
//
//        Thread.sleep(5000);
//        System.out.println(driver.findElement(AppiumBy.xpath("(//android.webkit.WebView[@text=\"I am a page title\"]//android.widget.TextView)[1]")).getText());

    }
}
