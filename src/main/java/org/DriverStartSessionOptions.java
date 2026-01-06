package org;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class DriverStartSessionOptions {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {

        URL url = new URI("http://127.0.0.1:4723/").toURL();

        switch (platformName) {
            case "Android":
                String androidAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                        File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                /*
                | Method                             | Description                             |
                | ---------------------------------- | --------------------------------------- |
                | `setDeviceName(String)`            | Device name or emulator ID              |
                | `setPlatformName(String)`          | Android (must be `"Android"`)           |
                | `setApp(String)`                   | Path to `.apk` file                     |
                | `setAppPackage(String)`            | App package name                        |
                | `setAppActivity(String)`           | Main activity name                      |
                | `setAutomationName(String)`        | `"UiAutomator2"`                        |
                | `setNoReset(boolean)`              | Keep app data between runs              |
                | `setFullReset(boolean)`            | Uninstall app each run                  |
                | `setUnlockType(String)`            | e.g. `"pin"`, `"password"`, `"pattern"` |
                | `setUnlockKey(String)`             | Actual unlock value                     |
                | `setUnlockStrategy(String)`        | Typically `"uiautomator2"`              |
                | `setAutoGrantPermissions(boolean)` | Auto-grant permissions on install       |

                 */
                UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
                uiAutomator2Options.setDeviceName("Pixel");
                uiAutomator2Options.setAutomationName("uiautomator2");
                uiAutomator2Options.setApp(androidAppPath);

//                uiAutomator2Options.setAvd("Googlepixel");
//                uiAutomator2Options.setAvdReadyTimeout(Duration.ofMinutes(1));
//                uiAutomator2Options.setAppPackage("io.appium.android.apis");
//                uiAutomator2Options.setAppActivity("io.appium.android.apis.ApiDemos");
//                uiAutomator2Options.setUnlockType("pin"); // pattern or password or fingerprint
//                uiAutomator2Options.setUnlockKey("1234");
                return new AndroidDriver(url, uiAutomator2Options);

            case "iOS":

                String iOSAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                        File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
                System.out.println(iOSAppPath);
                XCUITestOptions xcuiTestOptions = new XCUITestOptions();
                xcuiTestOptions.setDeviceName("iPhone 16e");
                xcuiTestOptions.setAutomationName("XCUITest");
                xcuiTestOptions.setUdid("1EDF0AF7-BC81-4729-BF4D-A6D2EF8EBC0A");
                //xcuiTestOptions.setNoReset(true);
                //xcuiTestOptions.setFullReset(false);
                xcuiTestOptions.setApp(iOSAppPath);
                return new IOSDriver(url, xcuiTestOptions);
            default:
                throw new Exception("Invalid platform");
        }
    }
}
