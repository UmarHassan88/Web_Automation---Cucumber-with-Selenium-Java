package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ImplementedFunctions {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By elem = By.className("card-body");

    public ImplementedFunctions(WebDriver driver){
        this.driver = driver;
    }

    public void elementsclick(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
        Assert.assertEquals(element.getText(),"Elements");
        element.click();
    }
}
