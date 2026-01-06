import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AndroidAndIOSLaunchAutomatically {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

       desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Googlepixel");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        String androidAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        desiredCapabilities.setCapability("appium:app", androidAppPath);
        desiredCapabilities.setCapability("appium:avd","Googlepixel");
        desiredCapabilities.setCapability("appium:avdLaunchTimeout",180000);
        desiredCapabilities.setCapability("appium:appPackage","io.appium.android.apis");
        desiredCapabilities.setCapability("appium:appActivity","io.appium.android.apis.animation.CustomEvaluator");
        //URL url = new URL("http://0.0.0.0:4723");
        URI uri = new URI("http://127.0.0.1:4723/");
        URL url = uri.toURL();
        System.out.println(url);
        AppiumDriver androidDriver = new AndroidDriver(url, desiredCapabilities);
        androidDriver.quit();

        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 17 Pro");
        desiredCapabilities.setCapability("appium:automationName", "XCUITest");
        desiredCapabilities.setCapability("appium:udid", "294438A8-D5F2-410E-BA6D-124A78EE156F");
        String iOSAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
//        desiredCapabilities.setCapability("appium:app", iOSAppPath);
        desiredCapabilities.setCapability("appium:SimulatorStartupTimeout", 180000);
        desiredCapabilities.setCapability("appium:bundleId", "com.example.apple-samplecode.UICatalog");
        //URL url = new URL("http://0.0.0.0:4723");
        URI uriForiOS = new URI("http://127.0.0.1:4723/");
        URL iOSurl = uriForiOS.toURL();
        System.out.println(iOSurl);
        AppiumDriver iosDriver = new IOSDriver(iOSurl, desiredCapabilities);
        iosDriver.quit();
    }
}
