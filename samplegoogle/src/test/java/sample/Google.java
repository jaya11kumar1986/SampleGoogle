package sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {
	WebDriver driver;
	
	@BeforeMethod
	public void tearUp() {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	@Test
	public void openGoogle() {
		
		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();
		System.out.println("Page Title :"+title);
		Assert.assertEquals(title,"Google");
		
		driver.findElement(By.name("q")).sendKeys("Tamil"+Keys.ENTER);
		System.out.println(driver.getTitle());
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
