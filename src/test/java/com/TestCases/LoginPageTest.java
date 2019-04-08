package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage ;
	public LoginPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initial();
		loginpage = new LoginPage();
		
	}
	@Test(priority=3)
	public void verifyLoginSuccessful()  {
		loginpage.verifyValidLogIn(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	
	
	  @Test(priority=0) public void verifyLogoOfThePage() { boolean
	  b=loginpage.verifyLogo(); Assert.assertTrue(b); }
	  
	  @Test(priority=1) public void verifyTitleOfThePage() { String title =
	  loginpage.verifyTitle(); Assert.assertEquals(title,
	  "Login - TechFios Test Application - Billing"); }
	 
	 
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
   
}
