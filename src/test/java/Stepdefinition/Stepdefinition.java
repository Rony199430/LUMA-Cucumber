package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition {
	
	WebDriver driver; 

	@Given("^I open the browser$")
	public void i_open_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
	}

	@Given("^I navigate to LUMA website$")
	public void i_navigate_to_LUMA_website() throws Throwable {
		driver.get("https://magento.softwaretestingboard.com");
	}

	@When("^I search Yoga Pants$")
	
	public void i_search_Yoga_Pants() throws Throwable {
		driver.findElement(By.id("search")).clear();
		driver.findElement(By.id("search")).sendKeys("Yoga Pants");
		driver.findElement(By.id("search")).sendKeys(Keys.RETURN);; 
	}

	@When("^I add Product from listing$")
	public void i_add_Product_from_listing() throws Throwable {
		driver.findElement(By.xpath("(//img[@class = 'product-image-photo'])[1]")).click();
		Thread.sleep(2000);
	}

	@When("^I go to checkout$")
	public void i_go_to_checkout() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label= 'S']")).click();
		driver.findElement(By.xpath("//div[@option-label= 'Blue']")).click();	
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("5");
		Thread.sleep(2000);
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='counter qty'])[1]")).click(); 
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		Thread.sleep(3000);
	  
	}

	@When("^I put my details$")
	public void i_put_my_details() throws Throwable {
		driver.findElement(By.id("customer-email")).sendKeys("johnsmith123@gmail.com"); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Smith");
		Thread.sleep(2000); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)", "");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("1 Broadway");
		driver.findElement(By.xpath("//input[@name='street[1]']")).sendKeys("apt 1");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Brooklyn");
		Select city = new Select (driver.findElement(By.xpath("//select[@name='region_id']")));
		city.selectByVisibleText("New York");  
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("11211");
		Select cntry = new Select (driver.findElement(By.xpath("//select[@name='country_id']")));
		cntry.selectByVisibleText("United States");
		js.executeScript("window.scrollBy(0, 1000)", ""); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("123-456-7890");
		Thread.sleep(2000); 
	    
		
		driver.findElement(By.id("label_method_flatrate_flatrate")).click();
		driver.findElement(By.xpath("//button[@data-role='opc-continue']")).click();
		
		
	}

	@Then("^I confirm placing the order$")
	public void i_confirm_placing_the_order() throws Throwable {
		Thread.sleep(3000); 
		driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click(); 
	}
	
}