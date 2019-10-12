import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 05-Oct-2019
 */
public class RunTestOnChromeBrowser {

    public static void main(String[] args) {

        String baseUrl = "https://learn.letskodeit.com/p/practice";

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //find elements for login link
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.id("user_email"));
        emailField.sendKeys("abc@gmail.com");

        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.sendKeys("abcd123");

        WebElement loginBtn = driver.findElement(By.name("commit"));
        loginBtn.click();



    //    driver.quit();

    }
}
