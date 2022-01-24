package com.DD.Speedoy.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BasePage {

	//Creating object of properties class
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	
	public static FileInputStream fis;
	public static WebDriver driver= null;
	
	public void setup()  {
		
		
			try {
				fis =new FileInputStream("./src/test/resources/propertyfiles/config.properties");
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream("./src/test/resources/propertyfiles/OR.properties");
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	    //Invoking the browser based on the input provided from the properties file
		public void initializeBrowser(String Browser, String url) {
			
			if(Browser.equalsIgnoreCase("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
					}
			
			else if(Browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
					}
			else {
				System.out.println("Broswer not defined");
			}
			
			driver.get(url);
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/button[1]")).click();
			
		}
		
		//Method to close browser
		public void closebrowser()  {
			 driver.close();
		}
		
		//Method to perform click action with input provided from the properties file
		public void click(String locator) {
			
			if(locator.endsWith("_CSS")) {
				if(driver.findElement(By.cssSelector(OR.getProperty(locator)))!=null)
				driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			}
			else if(locator.endsWith("_Xpath")){
				if(driver.findElement(By.xpath(OR.getProperty(locator)))!=null)
				driver.findElement(By.xpath(OR.getProperty(locator))).click();	
			}
			else if(locator.endsWith("_ID")) {
				if(driver.findElement(By.id(OR.getProperty(locator)))!=null)
				driver.findElement(By.id(OR.getProperty(locator))).click();
			}
			else if(locator.endsWith("_NAME")) {
				if(driver.findElement(By.name(OR.getProperty(locator)))!=null)
				driver.findElement(By.name(OR.getProperty(locator))).click();
			}
			else if(locator.endsWith("_CLASSNAME")) {
				if(driver.findElement(By.className(OR.getProperty(locator)))!=null)
					driver.findElement(By.className(OR.getProperty(locator))).click();
			}
		}
		
		//Login method
		public Boolean login(String user, String pwd)
		{
			Boolean isLogin= false;
			
			driver.findElement(By.id("sign-inn")).click();
			driver.findElement(By.id("continueWithEmail")).click();
			driver.findElement(By.id("checkEmail")).click();
			driver.findElement(By.id("checkEmail")).sendKeys(user);
			driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/input[1]")).click();
			driver.findElement(By.id("password")).click();
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.xpath("//body[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[2]/form[1]/div[2]/input[1]")).click();
			
			return isLogin;
			
		}
        
		//Logout method
		public void logout()  {
			driver.findElement(By.id("homemenu")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Logga ut']")).click();
		    	
		}
		
		//Search Method
		public Boolean searchRestaurant(String add, String odrtype) {
			
			Boolean isSearch = false;
			WebElement searchinput = driver.findElement(By.id("addressSearch"));
			searchinput.clear();
			searchinput.sendKeys(add);
			if(odrtype == "Utkörning") {
				driver.findElement(By.xpath("//input[@value='Utkörning']")).click();
				
			}else
			{
				driver.findElement(By.xpath("//input[@value='Avhämtning']")).click();
			}
			driver.findElement(By.xpath("//input[@value='Sök']")).click();
			
			return isSearch;
			
			}
		
		public Boolean SelectRestaurant(String RestaurantName) {
			
			Boolean isSelect = false;
			
			
			
			return isSelect;
		}
		
		}
     

