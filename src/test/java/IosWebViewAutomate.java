import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Set;

public class IosWebViewAutomate {

    public static void main(String[] args) throws Exception {

        AndroidDriver driver = (AndroidDriver) DriverStartSessionOptions.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Web View"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        element.click();
        Thread.sleep(2000);

       Set<String> context =  driver.getContextHandles();
       for (String contextHandles : context){
           System.out.println(contextHandles);
       }
    }
}
