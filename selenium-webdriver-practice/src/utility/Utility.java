package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jay Vaghani on 12-Oct-2019
 */
public class Utility {
    WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void sendTextToElement(By by, String str){
        driver.findElement(by).sendKeys(str);
    }

    public Boolean isElementDisplayed(By by){
        if (driver.findElement(by).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

}
