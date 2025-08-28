package stepdefinitions;

import io.cucumber.java.en.*;
import io.percy.selenium.Percy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Step definitions for login feature using Selenium and Percy visual testing.
 */
public class LoginSteps {

    WebDriver driver;
    Percy percy;

    /**
     * Navigates to the login page, enters credentials, logs in, and initializes Percy.
     */
    @Given("User is on the login page")
    public void user_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        percy = new Percy(driver);
    }

    /**
     * Takes a Percy visual snapshot of the login page and quits the driver.
     */
    @Then("Take a visual snapshot of the login page")
    public void take_snapshot() {
    
        percy.snapshot("Login Page Snapshot");
        driver.quit();
    }
}