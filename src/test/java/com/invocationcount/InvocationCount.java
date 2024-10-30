package com.invocationcount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InvocationCount
{
	public static WebDriver driver;
	@BeforeSuite
	@Parameters({"browser","url"})
	public void openApplication(String br,String URl)
	{
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
			}
		else if(br.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URl);
		driver.manage().window().maximize();
		
	}
	@Test(invocationCount=5)
	public void loginFunctionality() 
	{
		driver.findElement(By.id("username")).sendKeys("mastanbi");
		driver.findElement(By.id("password")).sendKeys("mas123");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.findElement(By.xpath("//a[text()='Click here to login again']")).click();

	}

}
