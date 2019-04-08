package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.TestUtil.TestUtil;

public class TestBase {
    public static Properties prop = new Properties();
    public static WebDriver driver ;
    public TestBase() {
    	try {
			FileInputStream file = new FileInputStream("C:\\Users\\luchengchao\\JAVA_Selenium\\mavenStudy.qa\\src\\main\\java\\com\\Config\\Config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void initial() {
    	String TestBrowser =prop.getProperty("browser");
    	if(TestBrowser.equalsIgnoreCase("chrome")) {
    		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}
    	else if(TestBrowser.equalsIgnoreCase("gecko")) {
    		System.setProperty("webdriver.gecko.driver", "‪C:\\Driver\\geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    }
}
