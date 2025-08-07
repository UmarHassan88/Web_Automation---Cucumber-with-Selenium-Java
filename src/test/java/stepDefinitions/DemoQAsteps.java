package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.ImplementedFunctions;

import java.time.Duration;


public class DemoQAsteps extends ImplementedFunctions {
    WebDriver driver;
    WebDriverWait wait;

    //1st Test Case
    @Given("The user is on the homepage")
    public void whenHome() throws InterruptedException {
        setup();
    }
    @When("The user clicks Elements")
    public void clickCheckbox() throws InterruptedException {
        textboxComponent();
    }
    @Then("Input the Text")
    public void navigate() {
        navigateBack();
    }

    @Then("Quit the Window")
    public void quitWin() throws InterruptedException {
        quitWindow();
    }

    //2nd Test Case
    @Given("The user is on the homepage at checkbox")
    public void whenCheckbox() throws InterruptedException {
        setup();
    }
    @When("The user marks the checkbox")
    public void clickElements() throws InterruptedException {
        checkBoxImplementation();
    }
    @Then("Navigate Back")
    public void inputData() {
        navigateBack();
    }


    //3rd Test Case
    @Given("The user is on Homepage at Web Tables")
    public void givenWebTables() throws InterruptedException {
        setup();
    }

    @When("Implement the Web Tables functionalities")
    public void whenWebTables(){
        webTablesImplementation();
    }

    @Then("Trigger the Actions and Check the Edit and Delete Functionalities")
    public void thenWebTables() throws InterruptedException {
        //Editing a Web Table
        webtablesActions();

    }
}

