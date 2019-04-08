package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase{
   @FindBy(xpath="//input[@id=\"username\"]")
   WebElement UserName;
   @FindBy(xpath="//input[@name=\"password\"]")
   WebElement Password;
   @FindBy(xpath="//button[@name=\"login\"]")
   WebElement SignInButton;
   @FindBy(xpath="//img[@class=\"logo\"]")
   WebElement Logo;
   @FindBy(xpath="//div[@class=\"alert alert-danger fade in\"]")
   WebElement ErrorMessage;
   public LoginPage() {
	   PageFactory.initElements(driver, this);
   }
   public void verifyValidLogIn(String us,String ps)  {
	   UserName.sendKeys(us);
	   Password.sendKeys(ps);
	   SignInButton.click();
	  
   }
   
   public String verifyTitle() {
	   return driver.getTitle();
   }
   
   public boolean verifyLogo() {
	   return Logo.isDisplayed();
   }
}
