package com.assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert 
{
	public static WebDriver driver;
	public Select sc;


	@Test(priority=1)
	@Parameters({"browser","url"})
	public void openApplication(String br, String URL) {

		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("Edge")) {

			driver=new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

	}

	@Test(priority=2)
	public void LoginFunctionality() {

		driver.findElement(By.id("username")).sendKeys("mastanbi");
		driver.findElement(By.id("password")).sendKeys("mas123");
		driver.findElement(By.id("login")).click();
	}

	@Test(priority=3)
	public void SearchHotelFunctionality() {


		WebElement Location=driver.findElement(By.id("location"));
		sc=new Select(Location);
		sc.selectByIndex(2);

		WebElement Hotels=driver.findElement(By.id("hotels"));
		sc=new Select(Hotels);
		sc.selectByVisibleText("Hotel Sunshine");

		WebElement NoofRooms=driver.findElement(By.id("room_nos"));

		sc=new Select(NoofRooms);
		sc.selectByIndex(3);

		driver.findElement(By.id("datepick_in")).sendKeys("05/09/2024");
		driver.findElement(By.id("datepick_out")).sendKeys("06/09/2024");

		WebElement AdultspRoom=  driver.findElement(By.id("adult_room"));

		sc=new Select(AdultspRoom);
		sc.selectByValue("2");

		driver.findElement(By.id("Submit")).click();

	}	
	
	@Test(priority=4)
	public void  VerificationOfSelectHotel() {
		
		String act_tittle=driver.getTitle();
		//String exp_tittle="Adactin.com - Select Hotel"; //Valid Tittle
		  String exp_tittle="Adactin.com - Select Hotel1223"; //In-valid tittle
		SoftAssert sa=new SoftAssert(); //soft assertion
		
		if(act_tittle.equals(exp_tittle)) {
			
			sa.assertTrue(true);
			System.out.println("Testcase is pass");
		}
		else {
			
			sa.assertTrue(false);
			System.out.println("Testcase is fail"); 
		}
		  
		driver.findElement(By.id("radiobutton_1")).click();
		driver.findElement(By.id("continue")).click();	
	}
	

	@Test(priority=5)
	public void closeApplication() {
		driver.close();
	}

}
