package stetDefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import featurefile.ScreenRecorderUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Yahoo_account_Registration {

	public static WebDriver driver;

	@Given("launch application")
	public void launch_application() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//start recording
		ScreenRecorderUtil.startRecord("acoount_Creation");
		
		driver.get("https://login.yahoo.com/account/create?.intl=us&specId=yidReg&done=https%3A%2F%2Fwww.yahoo.com");
		driver.manage().window().maximize();
	}

	@When("Enter all Required Fields")
	public void enter_all_required_fields() {
		// Account Creation on Yahoo page
		driver.findElement(By.name("firstName")).sendKeys("Lkpallir");
		driver.findElement(By.cssSelector("#usernamereg-lastName")).sendKeys("Vedhas");
		driver.findElement(By.xpath("//input[@aria-label='Email']")).sendKeys("Vedha0417");

		// Dropdown for Yahoo email
		Select mail = new Select(driver.findElement(By.xpath("//select[@name='yidDomain']")));
		mail.selectByValue("myyahoo.com");

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Uvece@0417");

		// Dropdown for Birthday month
		Select month = new Select(driver.findElement(By.xpath("//select[@name='mm']")));
		month.selectByVisibleText("June");

		driver.findElement(By.name("dd")).sendKeys("24");

		driver.findElement(By.name("yyyy")).sendKeys("1998");

	}

	@When("Click on the Continue button")
	public void click_on_the_continue_button() {
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

	}

	@Then("I Navigate the Yahoo Secure your account page.")
	public void i_navigate_the_yahoo_secure_your_account_page() {
		String actual = driver.findElement(By.xpath("//*[@id='account-attributes-challenge']/h2")).getText();
		System.out.println(actual);

		if (actual.contains("Yahoo Secure your")) {
			System.out.println("naviagte is expected page"); 
		} else {
			System.out.println("naviagte is un-expected page");
		}

	}

	@When("I Enter the In-Valid Mobile Number Click On Send code button")
	public void i_enter_the_in_valid_mobile_number_click_on_send_code_button() {

		// moile number for recovery mail
		driver.findElement(By.xpath("//input[@placeholder=' ']")).sendKeys("87647726412");

		// click on send code button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("I see the Error message")
	public void i_see_the_error_message() {

		// Error message for invalid Mobile Number
		String errormsg = driver.findElement(By.id("reg-error-phone")).getText();
		System.out.println(errormsg);
	}

	@When("I clear textbox and enter valid Mobile Number and click on send code")
	public void i_clear_textbox_and_enter_valid_mobile_number_and_click_on_send_code() {
		// clear the mobile number in text box
		driver.findElement(By.xpath("//input[@placeholder=' ']")).clear();

		// Enter valid mobile number
		driver.findElement(By.xpath("//input[@placeholder=' ']")).sendKeys("9848540980");

		// click on send code button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("i see the Verify your mobile number Page")
	public void i_see_the_verify_your_mobile_number_page() {
		
		
		System.out.println("Prove you're not a robot");
		
	//	String actual = driver.findElement(By.xpath("//*[@id='recaptcha-anchor-label']")).getText();
	//	System.out.println(actual);

//		String actual = driver.findElement(By.className("txt-align-center")).getText();
//		if (actual.equals("Prove you're not a robot")) {
//			System.out.println("naviagte is expected page");
//		} else {
//			System.out.println("naviagte is un-expected page");
//		}
	}

	@Then("I Navigate the Yahoo account Registration Page")
	public void i_navigate_the_yahoo_account_registration_page() throws Throwable {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().back();
	}

	@When("I click Terms Link")
	public void i_click_terms_link() throws Throwable {

		// click on terms Link
		Thread.sleep(2000);
		driver.findElement(By.linkText("Terms")).click();
	}

	@Then("I see the Yahoo Terms of Service page")
	public void i_see_the_yahoo_terms_of_service_page() {
		
		String exp = "Yahoo Terms of Service";

		if (exp.equals("Yahoo Terms of Service")) {
			System.out.println("Navigate to expected Page");
		} else {
			System.out.println("Navigate to Un-expected Page");
		}

	}

	@Then("I switch the Yahoo account Registration Page")
	public void i_switch_the_yahoo_account_registration_page() throws Throwable {
		Set<String> allwindows = driver.getWindowHandles();
		Object[] temp = allwindows.toArray();
		String window1 = temp[0].toString();
		driver.switchTo().window(window1);
		
		//Stop recording
		ScreenRecorderUtil.stopRecord();
		
		driver.quit();
	}

}
