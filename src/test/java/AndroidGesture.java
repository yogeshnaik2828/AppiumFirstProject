import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.DriverStartSessionOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AndroidGesture {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("Android");
        AndroidGesture androidGesture = new AndroidGesture();
        //androidGesture.longClickGesture(driver);
        // androidGesture.clickGesture(driver);
        // androidGesture.dragAndDrop(driver);
        // zoomAndZoomIn();
         swipe(driver);
//        androidGesture.scrollGesture(driver);

    }

    public void longClickGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

       /* driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));*/

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 217,
                "y", 659,
                "duration", 1000
        ));
    }

    public void clickGesture(AppiumDriver driver) {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        /*driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));*/

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", 514,
                "y", 1715,
                "duration", 1000
        ));
    }

    public void dragAndDrop(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 624,
                "endY", 554
        ));
    }

    public static void zoomAndZoomIn() throws URISyntaxException, MalformedURLException {
        URL url = new URI("http://127.0.0.1:4723/").toURL();

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Googlepixel");
        uiAutomator2Options.setAutomationName("uiautomator2");

        uiAutomator2Options.setAvd("Googlepixel");
        uiAutomator2Options.setAvdReadyTimeout(Duration.ofMinutes(1));
        uiAutomator2Options.setAppPackage("com.google.android.apps.maps");
        uiAutomator2Options.setAppActivity("com.google.android.maps.MapsActivity");

        AppiumDriver driver = new AndroidDriver(url, uiAutomator2Options);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.findElement(AppiumBy.xpath("")).click();

        // Java
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200,
                "top", 446,
                "width", 600,
                "height", 600,
                "percent", 0.75
        ));

    }

    public static void swipe(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Map<String, Object> params = new HashMap<>();
        params.put("left", 100);
        params.put("top", 100);
        params.put("width", 200);
        params.put("height", 200);
        params.put("direction", "up");
        params.put("percent", 0.75);
        driver.executeScript("mobile: swipeGesture", params);
    }

    public void scrollGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Animation"));
        Map<String, Object> params = new HashMap<>();
        params.put("left", 100);
        params.put("top", 500);
        params.put("width", 800);
        params.put("height", 800);
        params.put("direction", "down");
        params.put("percent", 0.75);

        Map<String, Object> params1 = new HashMap<>();
        params1.put("elementId", ((RemoteWebElement) element).getId());
        params1.put("direction", "down");
        params1.put("percent", 1.0);

//        Boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", params);
        Boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", params1);

        System.out.println("Can scroll more? " + canScrollMore);

    }
}
