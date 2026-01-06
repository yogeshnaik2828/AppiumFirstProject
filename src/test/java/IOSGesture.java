import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSGesture {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("iOS");
//        swipeGesture(driver);
//        scrollGesture(driver);
//        touchAndHold(driver);
//        tap(driver);
//        pickerWheel(driver);
        slider(driver);
    }

    public static void swipeGesture(AppiumDriver driver) {

//        WebElement element = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
// If we use this element it will swipe on that element and move to next page

        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();

        /**
         * Below is the scroll where we are not using element id and only direction we are using
         */
        /*  params.put("direction", "up");
            driver.executeScript("mobile:swipe", params);*/

        /**
         * Below is the scroll where we are using element id with direction
         */
        params.put("direction", "up");
//        params.put("velocity", 2500);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile:swipe", params);
    }

    public static void scrollGesture(AppiumDriver driver) {
        WebElement parentElement = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        WebElement childElement1 = driver.findElement(AppiumBy.accessibilityId("Web View"));
        WebElement childElement2 = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        Map<String, Object> params1 = new HashMap<>();

        /**
         * Below is the swipe where we are not using element id and only direction we are using
         */
      /*  params.put("direction", "down");
        driver.executeScript("mobile:scroll", params);*/

        /**
         * Below is the scroll where we are using element id and only direction we are using
         * Whenever we are using parent element ex: type == "XCUIElementTypeTable\ we should add "direction"
         * Whenever we are using child element should not add "direction" and we should add the child element ex: "Web View"
         */
        params1.put("direction", "down");
        driver.executeScript("mobile:scroll", params1);

        Map<String, Object> params2 = new HashMap<>();
//        params.put("velocity", 2500);
        params2.put("element", ((RemoteWebElement) childElement2).getId());
        // we can specify the name or predicate string or direction
//        params.put("name","Web View");
//        params.put("predicateString", "label == \"Web View\"");
        params2.put("toVisible", true);
        driver.executeScript("mobile:scroll", params2);
    }

    public static void touchAndHold(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        // press and hold plus symbol
        WebElement element1 = driver.findElement(AppiumBy.
                iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][1]"));
        Map<String, Object> params1 = new HashMap<>();
        params1.put("element", ((RemoteWebElement) element1).getId());
        params1.put("duration", 5);
        driver.executeScript("mobile:touchAndHold", params1);

        // press and hold minus symbol
        WebElement element2 = driver.findElement(AppiumBy.
                iOSClassChain("**/XCUIElementTypeButton[`name == \"Decrement\"`][1]"));
        Map<String, Object> params2 = new HashMap<>();
        params2.put("element", ((RemoteWebElement) element2).getId());
        params2.put("duration", 5);
        driver.executeScript("mobile:touchAndHold", params2);
    }

    public static void tap(AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Steppers"));

        params.put("element", ((RemoteWebElement) element).getId());
        params.put("x", 0);
        params.put("y", 0);
        driver.executeScript("mobile:tap", params);
    }

    public static void pickerWheel(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        boolean flag = false;
        int iteration = 10;
        while (!flag && iteration > 0) {
            WebElement redPickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("name == \"Red color component value\""));

            Map<String, Object> params = new HashMap<>();

            params.put("order", "next");
            params.put("offset", 0.15); // it will wheel the one move if we use higher value like 0.30 it will move more than 1
            params.put("element", ((RemoteWebElement) redPickerWheel).getId());
            driver.executeScript("mobile:selectPickerWheelValue", params);
            iteration--;
            if (redPickerWheel.getText().equals("100")) {
                flag = true;
            }
        }

        flag = false;
        iteration = 10;
        while (!flag && iteration > 0) {
            WebElement greenPickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("name == \"Green color component value\""));

            Map<String, Object> params = new HashMap<>();

            params.put("order", "previous"); // "previous"
            params.put("offset", 0.15); // it will wheel the one move if we use higher value like 0.30 it will move more than 1
            params.put("element", ((RemoteWebElement) greenPickerWheel).getId());
            driver.executeScript("mobile:selectPickerWheelValue", params);
            iteration--;
            if (greenPickerWheel.getText().equals("190")) {
                flag = true;
            }
        }

        flag = false;
        iteration = 10;
        while (!flag && iteration > 0) {
            WebElement greenPickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("name == \"Blue color component value\""));

            Map<String, Object> params = new HashMap<>();

            params.put("order", "next");
            params.put("offset", 0.15); // it will wheel the one move if we use higher value like 0.30 it will move more than 1
            params.put("element", ((RemoteWebElement) greenPickerWheel).getId());
            driver.executeScript("mobile:selectPickerWheelValue", params);
            iteration--;
            if (greenPickerWheel.getText().equals("130")) {
                flag = true;
            }
        }
    }

    public static void slider(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"42%\""));
        element.sendKeys("0");

        // Range should be 0 to 1
        element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"0%\""));
        System.out.println(element.getText());
        element.sendKeys("1");
    }
}
