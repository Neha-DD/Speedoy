package com.DD.Speedoy.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.DD.Speedoy.Base.BasePage;

public class VerifyLanguage extends BasePage {
 
	 @BeforeTest
		public void lauchbrowser() {
			super.setup();
			super.initializeBrowser(config.getProperty("Browser"), config.getProperty("url"));
			
			}
		
		@AfterTest
		public void Exitbrowser() {
			super.closebrowser();
			}
		
		@Test // Test to verify webpage is translating.
		public void LanguageTest() {
			
			driver.findElement(By.id("homemenu-language")).click();
			driver.findElement(By.linkText("Engelska")).click();
			String actualTranslated = driver.findElement(By.xpath("//input[@value='Delivery']")).getAttribute("value");
			System.out.println(actualTranslated);
			Assert.assertEquals(actualTranslated, "Delivery");
			
			}
		
		
}
