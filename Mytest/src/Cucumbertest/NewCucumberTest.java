package Cucumbertest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
public class NewCucumberTest {
	
	WebDriver driver;
	
	@Given("^The user is viewing landing page$")
			public void the_user_is_in_landing_page() throws InterruptedException{
		String driverpath = System.getProperty("user.dir") + "\\driver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",driverpath);
		driver = new FirefoxDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		Thread.sleep(20000);
	}
	@Then("^User enters 1 for living expenses and click on the work out how much i could borrow button$")
	
		public void User_enters_1_for_living_expenses_and_click_on_the_work_out_how_much_i_could_borrow_button(){
	driver.findElement(By.cssSelector("#expenses")).click();
	driver.findElement(By.cssSelector("#expenses")).sendKeys("1");
	}
	@Then("^User validates the text$")
			public void User_validates_the_text() throws InterruptedException{
		driver.findElement(By.cssSelector(".btn--borrow__calculate")).click();
		String Actualtext = driver.findElement(By.cssSelector(".borrow__error__text")).getText();
		String Expectedtext = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
		Assert.assertEquals(Actualtext, Expectedtext);	
		System.out.println("Assert passed");
	}
	 @Then("^User enters values for other expenses and validate the values persists$")
	  public void User_enters_values_for_other_expenses(){
		 	driver.findElement(By.cssSelector("#homeloans")).click();
			driver.findElement(By.cssSelector("#homeloans")).sendKeys("0");
			driver.findElement(By.cssSelector("#otherloans")).click();
			driver.findElement(By.cssSelector("#otherloans")).sendKeys("100");
			driver.findElement(By.cssSelector("#credit")).click();
			driver.findElement(By.cssSelector("#credit")).sendKeys("10000");
			String otherloanstext = driver.findElement(By.cssSelector("#otherloans")).getAttribute("value");
			String credittext = driver.findElement(By.cssSelector("#credit")).getAttribute("value");
			String homeloanstext = driver.findElement(By.cssSelector("#homeloans")).getAttribute("value");
			String otherloan ="100";
			String credit ="10,000";
			String homeloans ="0";
			Assert.assertEquals(otherloanstext, otherloan);
			System.out.println("Assert passed");
			Assert.assertEquals(credittext, credit);
			System.out.println("Assert passed");
			Assert.assertEquals(homeloanstext, homeloans);
			System.out.println("Assert passed");
			driver.findElement(By.cssSelector("#application_type_single")).isEnabled();
			driver.findElement(By.cssSelector("#borrow_type_home")).isEnabled();
		 
	 }
	 
	 @Then("^User close the web driver instance$")
	 public void User_close_the_web_driver_instance(){
		 driver.close();
		 System.out.println("driver is closed");
	 }

}
