import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.DriverStartSessionOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentWaysOfDefiningElements {

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]")
    private WebElement element1;

    public DifferentWaysOfDefiningElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = DriverStartSessionOptions.initializeDriver("Android");
        DifferentWaysOfDefiningElements page = new DifferentWaysOfDefiningElements(driver);

        // ❌ Not recommended (direct findElement)
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(element.getText());

        // ✅ Using Selenium By class (for hybrid/webview)
        By ele = By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(driver.findElement(ele).getText());

        // ✅ Using AppiumBy (for native apps)
        By ele1 = AppiumBy.accessibilityId("Accessibility");
        System.out.println(driver.findElement(ele1).getText());

        // ✅ Using PageFactory (recommended for large frameworks)
        System.out.println(page.element1.getText());

        driver.quit();
    }
}
