package com.TestPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.TestBase.TestBase;

public class ProductsNServicePage extends TestBase{
       @FindBy(xpath="//span[text()='Products & Services']")
       WebElement ProductsNService;
       @FindBy(xpath="//a[text()='New Service']")
       WebElement NewService;
       @FindBy(xpath="//input[@id=\"name\"]")
       WebElement Name ;
       @FindBy(xpath="//input[@id=\"sales_price\"]")
       WebElement SalesPrice;
       @FindBy(xpath="//input[@id=\"item_number\"]")
       WebElement ItemNumber ;
       @FindBy(xpath="//textarea[@id=\"description\"]")
       WebElement TextArea ;
       @FindBy(xpath="//button[@class=\"btn btn-sm btn-primary\"]")
       WebElement Submit;
       @FindBy(xpath="//div[@class=\"alert alert-success fade in\"]")
       WebElement SuccessfulMessage;
    public  ProductsNServicePage() {
    	PageFactory.initElements(driver, this);
    }  
    
    public void ProductsNServices() {
    	ProductsNService.click();
    }
    public void NewService() {
    	NewService.click();
    }
    public void AddService(String add_name,String add_salesPrice,String add_itemNumber,String add_drscription)  {
    	Name.sendKeys(add_name);
    	SalesPrice.sendKeys(add_salesPrice);
    	ItemNumber.sendKeys(add_itemNumber);
    	TextArea.sendKeys(add_drscription);
    	Submit.click();
    	
    }
    
    public boolean message() {
    	return SuccessfulMessage.isDisplayed();
    }
}
