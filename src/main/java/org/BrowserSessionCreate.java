package org;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.net.URI;
import java.net.URL;

public class BrowserSessionCreate {
    public static AppiumDriver initializeDriver(String platformName) throws Exception {

        URL url = new URI("http://127.0.0.1:4723/").toURL();

        switch (platformName) {
            case "Android":
                UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
                uiAutomator2Options.setDeviceName("Pixel");
                uiAutomator2Options.setAutomationName("uiautomator2");
                uiAutomator2Options.setUdid("emulator-5554");
                uiAutomator2Options.setCapability("browserName", "Chrome");
                return new AndroidDriver(url, uiAutomator2Options);

            case "iOS":

                XCUITestOptions xcuiTestOptions = new XCUITestOptions();
                xcuiTestOptions.setDeviceName("iPhone 16e");
                xcuiTestOptions.setAutomationName("XCUITest");
                xcuiTestOptions.setUdid("1EDF0AF7-BC81-4729-BF4D-A6D2EF8EBC0A");
                return new IOSDriver(url, xcuiTestOptions);
            default:
                throw new Exception("Invalid platform");
        }
    }
}
