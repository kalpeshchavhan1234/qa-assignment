package com.qa.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SauceDemoTest {

	WebDriver driver;
	String browser = "chrome";

	@BeforeMethod
	public void setup() {

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);

			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/");
	}

	public void login() {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test(priority = 1)
	public void verifyValidLogin() {

		login();

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

		System.out.println("Login Test Passed");
	}

	@Test(priority = 2)
	public void verifyAddProductToCart() {

		login();

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));

		Assert.assertEquals(cartBadge.getText(), "1");

		System.out.println("Add To Cart Test Passed");
	}

	@Test(priority = 3)
	public void verifySuccessfulCheckout() {

		login();

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();

		driver.findElement(By.id("first-name")).sendKeys("Kalpesh");
		driver.findElement(By.id("last-name")).sendKeys("Chavan");
		driver.findElement(By.id("postal-code")).sendKeys("410203");

		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();

		String successMessage = driver.findElement(By.className("complete-header")).getText();

		Assert.assertEquals(successMessage, "Thank you for your order!");

		System.out.println("Checkout Test Passed");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}