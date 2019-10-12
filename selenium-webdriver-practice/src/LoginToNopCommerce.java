import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 12-Oct-2019
 */
public class LoginToNopCommerce {
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
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find elements for login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
//        js.executeScript("window.scrollBy(0, -600);");
        String expectedText = "Welcome, Please Sign In!";
        //actual text
        WebElement welcomeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        String actualText = welcomeText.getText();

        //verify text "Welcome, Please Sign In!"
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldLoginSuccessFully(){
        //find elements for login link
        /*WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();*/
        utility.clickOnElement(By.linkText("Log in"));

        //find element for Username field
        /*WebElement username = driver.findElement(By.id("Email"));
        username.sendKeys("abc@gmail.com");*/
        utility.sendTextToElement(By.id("Email"), "abcgffd@gmail.com");

        //find element for password field

        /*WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("abc123");*/
        utility.sendTextToElement(By.id("Password"),"abc123");

        /*WebElement loginBtn = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginBtn.submit();*/
        utility.clickOnElement(By.xpath("//input[@class='button-1 login-button']"));

//        String expectedText = "Welcome to our store";
//
//        String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).getText();
//
//        Assert.assertEquals(expectedText, actualText);

        try{
//            WebElement logOutBtn = driver.findElement(By.xpath("//a[@class='ico-logout']"));
            Assert.assertTrue("Logout button is not displayed", utility.isElementDisplayed(By.xpath("//a[@class='ico-logout']")));
        }catch (StaleElementReferenceException e){
            e.getMessage();
        }

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
