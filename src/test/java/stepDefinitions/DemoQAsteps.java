package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DemoQAsteps {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By elem = By.className("card-body");
    //By forms = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[2]/span/div");
    By textbox = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[1]");
    By webtablesLoc = By.id("item-3");
    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By submitButt = By.id("submit");

    public void setup(){
        driver.get("https://demoqa.com/");
    }

    public void textboxComponent() throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
        Assert.assertEquals(element.getText(),"Elements");
        element.click();
        System.out.println("Elements Clicked!");
        Thread.sleep(2000);

        Thread.sleep(2000);
        WebElement textBx = wait.until(ExpectedConditions.elementToBeClickable(textbox));
        Assert.assertEquals(textBx.getText(),"Text Box");
        textBx.click();
        System.out.println("Text Box Clicked!");
        //WebElement webTables = wait.until(ExpectedConditions.elementToBeClickable(webtablesLoc));
        //webTables.click();

        //Input the fields
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(fullName));
        name.sendKeys("TestUser");
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(email));
        emailInput.sendKeys("TestUser@gmail.com");
        WebElement currAddress = wait.until(ExpectedConditions.elementToBeClickable(currentAddress));
        currAddress.sendKeys("Al Reem Island Abu Dhabi");
        WebElement perAddress = wait.until(ExpectedConditions.elementToBeClickable(permanentAddress));
        perAddress.sendKeys("Al Reem Island Abu Dhabi");
        Thread.sleep(2000);
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButt));
        submit.submit();
    }

    @Given("The user is on the homepage")
    public void whenHome(){
        setup();
    }
    @When("The user clicks Elements")
    public void clickElements() throws InterruptedException {
        textboxComponent();
    }
    @Then("Input the Text")
    public void inputData() {
       WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(textbox));
        textBox.click();
    }

    @Then("Quit the Window")
    public void quitWindow() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
