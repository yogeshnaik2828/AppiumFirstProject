import io.appium.java_client.AppiumDriver;
import org.BrowserSessionCreate;
import org.openqa.selenium.By;

import java.time.Duration;

public class AndroidAutomateBrowser {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver =  BrowserSessionCreate.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.tesla.com/");

        driver.findElement(By.xpath("//*[@id=\"tsla-accept-cookie\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"mega-menu\"]/div[2]/div[2]/div/button[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"react-data-promotional_hero\"]/div/div/div/section/div/div/div/div/div[1]/div[4]/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"tds-main-modal\"]/section/div/div/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div[2]/div/div[13]/div/div/div/div[7]/div/div/div/div[1]/div/div[2]/div/div[1]/button[2]")).click();
        driver.findElement(By.xpath(" //*[@id=\"FIRST_NAME\"]")).sendKeys("Yogesh");

    }
}
