package actionsclass;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 12-Oct-2019
 */
public class MouseHoverActions {
    private WebDriver driver;
    private JavascriptExecutor js;
    private Utility utility;

    @Before
    public void setUp() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utility = new Utility(driver);
    }

    @Test
    public void testMouseHoverActions(){

        WebElement computer = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        Actions action = new Actions(driver);
        action.moveToElement(computer).perform();
    }
}
