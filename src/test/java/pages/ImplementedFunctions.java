package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class ImplementedFunctions {
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

    public void setup() throws InterruptedException {
        driver.get("https://demoqa.com/");
        PageFactory.initElements(driver, this);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
        Assert.assertEquals(element.getText(),"Elements");
        element.click();
        System.out.println("Elements Clicked!");
        Thread.sleep(2000);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void quitWindow() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void textboxComponent() throws InterruptedException {
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


    @FindBy(xpath = "//li[@id = 'item-1']")
    WebElement checkBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div/ol/li/span/button")
    WebElement expandButton;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
    WebElement firstCheckbox;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
    WebElement expandDesktop;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]")
    WebElement notes;

    public void checkBoxImplementation() throws InterruptedException {
        Thread.sleep(2000);

        WebElement check = wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        check.click();
        System.out.println("Checkbox Component Clicked!");
        WebElement expand = wait.until(ExpectedConditions.elementToBeClickable(expandButton));
        expand.click();
        System.out.println("Expand Button Clicked!");
        Thread.sleep(1000);
        WebElement firstCheck = wait.until(ExpectedConditions.elementToBeClickable(firstCheckbox));
        firstCheck.click();
        System.out.println("Desktop Checkbox Clicked!");
        Thread.sleep(1500);

        wait.until(ExpectedConditions.elementToBeClickable(expandDesktop)).click();
        System.out.println("Desktop Expanded!");
        //wait.until(ExpectedConditions.elementToBeClickable(notes)).click();
        //System.out.println("Notes Clicked!");

        Thread.sleep(1500);
        System.out.println("Compressed the Checkbox list!");
        expand.click();
        //Starting with Documents Checkboxes
    }

    //Implementation for Web Tables
    By webtablesComponent = By.xpath("//li[@id = 'item-3']");

    public void webTablesImplementation(){
        WebElement component = wait.until(ExpectedConditions.elementToBeClickable(webtablesComponent));
        Assert.assertEquals((component).getText(),"Web Tables");
        component.click();
    }

    By rowsperPage = By.xpath("//select[@aria-label = 'rows per page']");
    By edit = By.xpath("//*[@id=\"edit-record-1\"]");
    By firstName = By.xpath("//input[@placeholder = 'First Name' and @id = 'firstName']");
    By lastName = By.xpath("//input[@placeholder = 'Last Name' and @id = 'lastName']");
    By emailAdd = By.xpath("//input[@placeholder = 'name@example.com' and @id = 'userEmail']");
    By age = By.xpath("//input[@placeholder = 'Age' and @id = 'age']");
    By salary = By.xpath("//input[@placeholder = 'Salary' and @id = 'salary']");
    By dept = By.xpath("//input[@placeholder = 'Department' and @id = 'department']");
    By submitButton = By.xpath("//button[@id = 'submit' and @type = 'submit']");

    public void webtablesSteps(WebElement elem, String x) throws InterruptedException {
        elem.clear();
        Thread.sleep(1000);
        elem.sendKeys(x);
    }

    public void webtablesActions() throws InterruptedException {
        //Selecting the number of rows to look for
        WebElement selectRows = wait.until(ExpectedConditions.elementToBeClickable(rowsperPage));
        Select selectrowsperpage = new Select(selectRows);
        selectrowsperpage.selectByIndex(4);

        WebElement editwebtable = wait.until(ExpectedConditions.elementToBeClickable(edit));
        editwebtable.click();
        //First Name
        WebElement getFirst = wait.until(ExpectedConditions.elementToBeClickable(firstName));
        webtablesSteps(getFirst,"Umar");

        //Last Name
        WebElement getLast = wait.until(ExpectedConditions.elementToBeClickable(lastName));
        webtablesSteps(getLast,"Hassan");

        //Email
        Random rand = new Random();
        int getRandom = rand.nextInt(100);
        WebElement getEmail = wait.until(ExpectedConditions.elementToBeClickable(emailAdd));
        webtablesSteps(getEmail, "umarhassanzia88@gmail.com");

        //Age
        WebElement getAge = wait.until(ExpectedConditions.elementToBeClickable(age));
        webtablesSteps(getAge, String.valueOf(getRandom));

        //Salary
        WebElement getSalary = wait.until(ExpectedConditions.elementToBeClickable(salary));
        webtablesSteps(getSalary,String.valueOf(getRandom));

        //Department
        WebElement getDept = wait.until(ExpectedConditions.elementToBeClickable(dept));
        webtablesSteps(getDept,"EE");

        //Submit
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submit.submit();
    }
}
