package aom.annotations_prioritization;

import org.testng.annotations.*;

public class Annotaions 
{
	@BeforeSuite
	public void method1() {
		System.out.println("before suite is executed");
	}
	@AfterSuite
	public void method2() {
		System.out.println("After suite is executed");
	}
	@BeforeTest
	public void method3() {
		System.out.println("Before test is executed");
	}
	@AfterTest
	public void method4() {
		System.out.println("After test is executed");
	}
	@Test
	public void method5() {
		System.out.println(" test is executed");
	}
	@BeforeClass
	public void method6() {
		System.out.println(" before class is executed");
	}
	@AfterClass
	public void method7() {
		System.out.println(" After class is executed");
	}
	@BeforeMethod
	public void method8() {
		System.out.println(" Before method is executed");
	}
	@AfterMethod
	public void method9() {
		System.out.println(" Afetr method is executed");
	}
	
	
	
	

}
