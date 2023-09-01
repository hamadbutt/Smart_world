package MVC;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FirstClass {
	public WebDriver driver;
	
  @Test 
  public void Login() throws InterruptedException {
	 WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
      driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(1000);

	String expectedurl="https://www.saucedemo.com/inventory.html";
	String actualur=driver.getCurrentUrl();
	if(expectedurl.contentEquals(actualur)) {
		System.out.println("User loggedin successfully");
	}else {
		
		System.out.println("Login failed");
		  cart();
	}}
	@Test  (priority=2)
	public void cart() throws InterruptedException {
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("first-name")).sendKeys("Hamad");
		
		driver.findElement(By.id("last-name")).sendKeys("Butt");
		driver.findElement(By.id("postal-code")).sendKeys("75760");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		Thread.sleep(1000);

		//Remove item from cart
		driver.get("https://www.saucedemo.com/inventory.html");
		Thread.sleep(1000);

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(1000);
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("remove-sauce-labs-backpack")));
		    element.click();

		    Thread.sleep(1000);
		    //Filter item
		    WebElement selectElement = driver.findElement(By.xpath("//div[@id='header_container']/div[2]/div/span/select"));
		    selectElement.click();
			Thread.sleep(1000);
             Select optionSelect = new Select(selectElement);
		    optionSelect.selectByValue("lohi");
		       Thread.sleep(1000);
		    //logout
		    driver.findElement(By.id("react-burger-menu-btn")).click();
	        Thread.sleep(2000);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
		    WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		    element2.click();
	}}

