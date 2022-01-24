package com.DD.Speedoy.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.DD.Speedoy.Base.BasePage;
import com.DD.Speedoy.utility.DataUtil;

public class VerifyTitle extends BasePage {
  
	@BeforeTest
	public void lauchbrowser() {
		super.setup();
		super.initializeBrowser(config.getProperty("Browser"), config.getProperty("url"));
		
		}
	
	@AfterTest
	public void Exitbrowser() {
		super.closebrowser();
		}
	
	@Test // Test to verify that the webpage is loading correctly.
	public void Homepage() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Reporter.log("Title is captured and validated by comparing it to expected title");
		String expectedTitle = config.getProperty("title");
		Assert.assertEquals( actualTitle, expectedTitle);
	}
	
// Test to Search by delivery or pickup.
	
@Test(dataProvider="getData", dataProviderClass= DataUtil.class)
public void searchbyDeliveryORPickup(String address, String ordertype) {
	
	super.searchRestaurant(address, ordertype);
	String actualTitle = driver.getTitle();
	System.out.println(actualTitle);
	Assert.assertEquals(actualTitle, "Restaurant Listing | SpeedOy - Upptäck och boka de bästa restaurangerna");
	driver.findElement(By.cssSelector("img[src='/Images/logo_sticky.png']")).click();
	
	}	
}


