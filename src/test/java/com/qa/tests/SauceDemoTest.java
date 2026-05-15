package com.qa.tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class SauceDemoTest {

	WebDriver driver;

	// Change browser here: chrome or edge
	
	String browser = "chrome";

	@BeforeMethod
	public void setup() {

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/");
	}

	@Test(priority = 1)
	public void verifyValidLogin() {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		String expectedUrl = "https://www.saucedemo.com/inventory.html";

		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);

		System.out.println("Login Test Passed");
	}

	@Test(priority = 2)
	public void verifyAddProductToCart() {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));

		String actualCount = cartBadge.getText();

		Assert.assertEquals(actualCount, "1");

		System.out.println("Add To Cart Test Passed");
	}

	@Test(priority = 3)
	public void verifySuccessfulCheckout() {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

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