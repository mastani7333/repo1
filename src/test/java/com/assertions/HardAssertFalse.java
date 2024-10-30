package com.assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HardAssertFalse
{
	public Select sc;
	public static WebDriver driver;
	@Test(priority=1)
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
	@Test(priority=2)
	public void loginFunctionality() 
	{
		driver.findElement(By.id("username")).sendKeys("mastanbi");
		driver.findElement(By.id("password")).sendKeys("mas123");
		driver.findElement(By.id("login")).click();

	}
	@Test(priority=3)
	public void verificationSearchHotelFunctionality()
	{
		String act_title=driver.getTitle();
		System.out.println(act_title);
		
		String exp_title="Adactin.com - Search Hotel111";
		if(act_title.equals(exp_title))
		{
			Assert.assertTrue(true);
			System.out.println("testcase is passes");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("testcase is fail");
		}
		WebElement location=driver.findElement(By.id("location"));
		sc=new Select(location);
		sc.selectByIndex(2);
		WebElement noOfRooms= driver.findElement(By.id("room_nos"));
		sc=new Select(noOfRooms);
		sc.selectByValue("2");
		driver.findElement(By.id("datepick_in")).sendKeys("08\10\2024");
		driver.findElement(By.id("datepick_out")).sendKeys("09\10\2024");
		WebElement adultperRoom=driver.findElement(By.id("adult_room"));
		sc=new Select(adultperRoom);
		sc.selectByVisibleText("2 - Two");
		driver.findElement(By.id("Submit")).click();
		
	}
	@Test(priority=4)
	public void selectHotel()
	{
		driver.findElement(By.id("radiobutton_1")).click();
		driver.findElement(By.id("continue")).click();
	}
	@Test(priority=5)
	public void close()
	{
		driver.close();
		}


}
