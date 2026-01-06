import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Set;

public class AndroidWebViewAutomate {

    public static void main(String[] args) throws Exception {
        AndroidDriver driver = (AndroidDriver) DriverStartSessionOptions.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        Set<String> contextHandles = driver.getContextHandles();

        for (String context : contextHandles){
            System.out.println(context);
        }

       // driver.context("WEBVIEW");

        // Another Way by taking position because NATIVE_APP always is in the 0th position and 1th position
        driver.context(contextHandles.toArray()[1].toString());

        String text = driver.findElement(By.cssSelector("body > h1")).getText();
        System.out.println(text);
        driver.context("NATIVE_APP");

    }
}
