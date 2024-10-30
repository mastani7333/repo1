package com.parallel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Parallel_Testing_Luma 
{
	public static WebDriver driver;
	@BeforeClass
	@Parameters({"browser","url"})
	public void openApploication(String br,String URL)
	{
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	public void loginFunctionality()
	{
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("shaikmastani7333@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Shannu@7333");
		driver.findElement(By.id("send2")).click();
	}
	@Test(priority=2)
	public void logutFunctionality()
	{
		driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
	}
	@Test(priority=3)
	public void reloginFunctinality()

	{
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("shaikmastani7333@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Shannu@7333");
		driver.findElement(By.id("send2")).click();
	}
	@AfterClass
	public void closeApplication()
	{
		driver.close();
	}
}
