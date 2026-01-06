import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CreatDriverSessionAppPackageAndAppActivity {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

       /* desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Googlepixel");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        String androidAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        desiredCapabilities.setCapability("appium:app", androidAppPath);
        desiredCapabilities.setCapability("appium:appPackage","io.appium.android.apis");
        desiredCapabilities.setCapability("appium:appActivity","io.appium.android.apis.animation.CustomEvaluator");
        //URL url = new URL("http://0.0.0.0:4723");
        URI uri = new URI("http://127.0.0.1:4723/");
        URL url = uri.toURL();
        System.out.println(url);
        AppiumDriver androidDriver = new AndroidDriver(url, desiredCapabilities);
        androidDriver.quit();*/



        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 16e");
        desiredCapabilities.setCapability("appium:automationName", "XCUITest");
        desiredCapabilities.setCapability("appium:udid", "1EDF0AF7-BC81-4729-BF4D-A6D2EF8EBC0A");
        desiredCapabilities.setCapability("appium:bundleId","com.example.apple-samplecode.UICatalog");
        //URL url = new URL("http://0.0.0.0:4723");
        URI uriIOS = new URI("http://127.0.0.1:4723/");
        URL urlIOS = uriIOS.toURL();
        System.out.println(urlIOS);
        AppiumDriver iosDriver = new IOSDriver(urlIOS, desiredCapabilities);


    }
}
