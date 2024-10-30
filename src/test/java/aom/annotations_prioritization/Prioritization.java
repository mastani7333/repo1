package aom.annotations_prioritization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Prioritization 
{
	WebDriver driver;
	@BeforeSuite
	public void openApplication()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
	}
	@Test(priority=3)
	public void loginFunctionality() throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys("mastanbi");
		driver.findElement(By.id("password")).sendKeys("mas123");
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void registartionFunctionality() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='New User Register Here']")).click();
		driver.findElement(By.id("username")).sendKeys("mastani");
		driver.findElement(By.id("password")).sendKeys("mastani@123");
		driver.navigate().back();
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void forgetPassword() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
		driver.findElement(By.id("emailadd_recovery")).sendKeys("mastani1234@gmail.com");
		driver.navigate().back();
		Thread.sleep(5000);
	}
	@AfterSuite
	public void close()
	{
		driver.close();
	}

}
