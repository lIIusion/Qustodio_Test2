package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

    WebDriver driver = null;
    WebDriverWait wait;

    @Given("^Web Browser is open$")
    public void webBrowserIsOpen() {
        System.out.println("Inside Step - browser is open");

        String projectPath = System.getProperty("user.dir");
        System.out.println("ProjectPath is " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

//        Open the Browser and Maximize
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("^User opens the url \\\"([^\\\"]*)\\\"$")
    public void userOpensTheUrl(String arg0) {

//        Navigate to URL
        System.out.println("Inside Step - open Qustodio URL");
        driver.navigate().to("https://" + arg0);
    }

    @When("^User set \\\"([^\\\"]*)\\\" to the inputfield \\\"([^\\\"]*)\\\"$")
    public void userSetToTheInputfield(String arg0, String arg1) {

//        set value to the input field
        driver.findElement(By.name(arg1)).sendKeys(arg0);
    }

    @And("^User click on the element \\\"([^\\\"]*)\\\"$")
    public void userClickOnTheElement(String arg0) {

//        Click on the button or clickable element
        driver.findElement(By.cssSelector(arg0)).click();
    }

    @And("^User waits on element \\\"([^\\\"]*)\\\" for 10000ms to be visible$")
    public void  userWaitsOnElementForToBeVisible(String arg0) {

//        explicit wait for 10000ms for element to be visible
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(arg0)));
        System.out.println("inside - wait until element is visible");
    }

    @Then("^User expect that element \\\"([^\\\"]*)\\\" does exist on the page$")
    public void userExpectThatElementDoesExist(String arg0) {

//        verifies whether element is displayed on the page
        WebElement elementFound = driver.findElement(By.id(arg0));
        Assert.assertEquals(true, elementFound.isDisplayed());
        System.out.println("Element found : " + elementFound); //delete
    }

    @Given("^there is an element \\\"([^\\\"]*)\\\" on the page$")
    public void thereIsAnElementOnThePage(String arg0) {

//        element is there on the page
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(arg0)));
    }

    @Then("User is  able to login {string}")
    public void userIsAbleToLogin(String arg0) {
    }

    @Then("^User expect that element \\\"([^\\\"]*)\\\" matches the text \\\"([^\\\"]*)\\\"$")
    public void userExpectThatElementMatchesTheText(String arg0, String arg1) {

//        get the text of the element and verify with the expected result
        WebElement actualTitle = driver.findElement(By.cssSelector(arg0));
        Assert.assertEquals(arg1, actualTitle.getText());
    }


    @Then("^User has \\\"([^\\\"]*)\\\" visible$")
    public void userHasFieldVisible(String arg0) {

//        Find element by using (by.name) locators
        WebElement ele = driver.findElement(By.name(arg0));
        Assert.assertEquals(true, ele.isDisplayed());
    }

    @After
    public void cleanUp() {
        driver.close();
    }
}
