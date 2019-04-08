package com.TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.ProductsNServicePage;
import com.TestUtil.TestUtil;

public class ProductsNServicePageTest extends TestBase{
      LoginPage loginpage;
      ProductsNServicePage PNS;
  
     String m = "AddNewOrderInfo";
      
	public ProductsNServicePageTest() {
		super();
	}
	@BeforeMethod
	public void SetUp() {
		initial();
		loginpage = new LoginPage();
		PNS = new ProductsNServicePage();
		loginpage.verifyValidLogIn(prop.getProperty("username"),prop.getProperty("password"));
	}
	@DataProvider(name = "dataneeded")
	
	public Object[][] provideData(){

		Object[][] data_holder = TestUtil.testData(m);
		return data_holder;
	}
	@Test(dataProvider="dataneeded")
	public void verifyAddService(String add_name,String add_salesPrice,String add_itemNumber,String add_drscription) {
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Products & Services']"))));
		PNS.ProductsNServices();
		WebDriverWait wait2 = new WebDriverWait(driver,10);
		wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='New Service']"))));
		PNS.NewService();
		WebDriverWait wait3 = new WebDriverWait(driver,10);
		wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"name\"]"))));
		PNS.AddService(add_name,add_salesPrice,add_itemNumber, add_drscription);
		WebDriverWait wait4 = new WebDriverWait(driver,10);
		wait4.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=\"alert alert-success fade in\"]"))));
		Assert.assertTrue(PNS.message());
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
