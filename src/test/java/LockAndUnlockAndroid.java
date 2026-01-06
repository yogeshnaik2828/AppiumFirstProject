import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.DriverStartSessionOptions;

import java.time.Duration;

public class LockAndUnlockAndroid {
    static AppiumDriver driver;

    public static void main(String[] args) throws Exception {
        driver = DriverStartSessionOptions.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // https://appium.readthedocs.io/en/stable/en/writing-running-appium/caps/#android-only
        // When device not having pin and it will directly unlock the device and if device having pin we need to set the capabilities
        /*
            Capabilities are
            caps.setCapability("unlockType", "pin");
            caps.setCapability("unlockKey", "1234");
            caps.setCapability("unlockStrategy", "uiautomator2");

            caps.setCapability("unlockType", "password");
            caps.setCapability("unlockKey", "Test@123");

            caps.setCapability("unlockType", "pattern");
            caps.setCapability("unlockKey", "12589"); // pattern order on 3x3 grid

            // Works for emulator
            caps.setCapability("unlockType", "fingerprint");
            caps.setCapability("unlockKey", "1"); // Finger ID #1


         */
        ((AndroidDriver) driver).lockDevice();
//        Thread.sleep(5000);
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        Thread.sleep(5000);
        ((AndroidDriver) driver).unlockDevice();
        String currentApp = ((AndroidDriver) driver).getCurrentPackage();
        System.out.println("Current app: " + currentApp);
        ((AndroidDriver) driver).activateApp("io.appium.android.apis");
    }
}
