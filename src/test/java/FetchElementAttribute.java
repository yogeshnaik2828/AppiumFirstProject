import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.DriverStartSessionOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FetchElementAttribute {

    public static void main(String[] args) throws Exception {
       /* AppiumDriver driver = DriverStartSessionOptions.initializeDriver("Android");

        By element = AppiumBy.accessibilityId("Accessibility");
        System.out.println("Text: " + driver.findElement(element).getText());
        System.out.println("content-desc:" + driver.findElement(element).getAttribute("content-desc"));
        System.out.println("checkable:" + driver.findElement(element).getAttribute("checkable"));
        System.out.println("checked:" + driver.findElement(element).getAttribute("checked"));
        System.out.println("clickable:" + driver.findElement(element).getAttribute("clickable"));
        System.out.println("enabled:" + driver.findElement(element).getAttribute("enabled"));
        System.out.println("displayed:" + driver.findElement(element).getAttribute("content-desc"));


        System.out.println("isDisplayed: " + driver.findElement(element).isDisplayed());
        System.out.println("isEnabled: " + driver.findElement(element).isEnabled());
        System.out.println("isSelected: " + driver.findElement(element).isSelected());

        driver.quit();*/

        AppiumDriver iosDriver = DriverStartSessionOptions.initializeDriver("iOS");

        By element1 = AppiumBy.accessibilityId("Activity Indicators");
        System.out.println("label: " + iosDriver.findElement(element1).getText());
        System.out.println("accessible:" + iosDriver.findElement(element1).getAttribute("accessible"));
        System.out.println("name:" + iosDriver.findElement(element1).getAttribute("name"));
        System.out.println("selected:" + iosDriver.findElement(element1).getAttribute("selected"));
        System.out.println("value:" + iosDriver.findElement(element1).getAttribute("value"));
        System.out.println("type:" + iosDriver.findElement(element1).getAttribute("type"));
        System.out.println("enabled:" + iosDriver.findElement(element1).getAttribute("enabled"));


        System.out.println("isDisplayed: " + iosDriver.findElement(element1).isDisplayed());
        System.out.println("isEnabled: " + iosDriver.findElement(element1).isEnabled());
        System.out.println("isSelected: " + iosDriver.findElement(element1).isSelected());

        iosDriver.quit();
    }
}
