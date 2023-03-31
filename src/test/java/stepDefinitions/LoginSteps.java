package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.LoginPage;

public class LoginSteps {
	private WebDriver driver;
	private LoginPage loginPage;

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		driver.get("https://www.saucedemo.com/");
		loginPage = new LoginPage(driver);
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
	}

	@When("User enters invalid username and/or password")
	public void user_enters_invalid_username_and_password() {
		loginPage.enterUsername("invalid_user");
		loginPage.enterPassword("invalid_password");
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("User should be redirected to the products page")
	public void user_should_be_redirected_to_the_products_page() {
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
		driver.quit();
	}

	@Then("User should see an error message")
	public void user_should_see_an_error_message() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".error-button")).isDisplayed());
		driver.quit();
	}
}
