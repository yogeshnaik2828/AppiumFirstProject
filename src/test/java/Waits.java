import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("iOS");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By alertViews = AppiumBy.accessibilityId("Alert Views");
        By okayOrCancel = AppiumBy.accessibilityId("Okay / Cancel");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertViews)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okayOrCancel)).click();
        driver.quit();
    }
}
