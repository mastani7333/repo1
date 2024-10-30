package com.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataproviderTestcase 
{ 
	
	public static WebDriver driver;
	@BeforeClass
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URl);
		driver.manage().window().maximize();
	}
	@Test(dataProvider="data")
	public void loginFunctionality(String user,String pwd) 
	{
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
		}
	@DataProvider(name="data",indices= {0,1,2,3})
	String[][] logindata(){
		String data[][]=
			{
					{"mastas","mas133"},
					{"mastanii","mas123"},
					{"mastanbi","mus123"},
					{"mastanbi","mas123"}
					
					
			};
		return data;
		
	}
	
	
		
	}
		
	
	
  



