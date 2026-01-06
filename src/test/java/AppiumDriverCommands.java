import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import org.DriverStartSessionOptions;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

public class AppiumDriverCommands {
    static AppiumDriver driver;

    public static void main(String[] args) throws Exception {
        driver = DriverStartSessionOptions.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        terminateApp();
//        installApp();

//        System.out.println(appInstalledStatus());

//        runAppInBackground();
//        activateApp();
//        getTheAppState();
        resetTheApp();
    }

    public static void terminateApp() {

        By view = AppiumBy.accessibilityId("Views");
        driver.findElement(view).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Terminate the app and app will be move from foreground to background
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
    }

    public static void installApp() {
        By view = AppiumBy.accessibilityId("Views");
        driver.findElement(view).click();
        String androidAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        AndroidInstallApplicationOptions class provides different method ex : Replace app enabled, Replace app enabled etc...
        ((AndroidDriver) driver).installApp(androidAppPath, new AndroidInstallApplicationOptions().withReplaceEnabled());

    }

    public static boolean appInstalledStatus() {
        return ((AndroidDriver) driver).isAppInstalled("io.appium.android.apis");
    }

    public static void runAppInBackground() {
        By view = AppiumBy.accessibilityId("Views");
        driver.findElement(view).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((AndroidDriver) driver).runAppInBackground(Duration.ofSeconds(5));
    }

    public static void activateApp() throws InterruptedException {
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        Thread.sleep(5000);

        ((AndroidDriver) driver).activateApp("com.android.settings");
        Thread.sleep(5000);
        ((AndroidDriver) driver).terminateApp("com.android.settings");
        Thread.sleep(5000);
        ((AndroidDriver) driver).activateApp("io.appium.android.apis");
    }

    public static void getTheAppState() {
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));// RUNNING_IN_FOREGROUND
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));//NOT_RUNNING
    }

    public static void resetTheApp() {
        By view = AppiumBy.accessibilityId("Views");
        driver.findElement(view).click();
    }
}
