package com.DD.Speedoy.Test;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.DD.Speedoy.Base.BasePage;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;

import org.testng.annotations.AfterTest;

public class VerifyCart extends BasePage {
    @BeforeTest
	public void lauchbrowser() {
		super.setup();
		super.initializeBrowser(config.getProperty("Browser"), config.getProperty("url"));
		
		}
	
	@AfterTest
	public void Exitbrowser() {
		super.closebrowser();
		
		}
	
	@Test
	public void VerifyCart_With_OneItems() {
		/*click("OrderNowBtn_ID");
		String errorMessage = driver.findElement(By.id(OR.getProperty("ErrorMSG_ID"))).getText();
		System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, "Lägg till minst ett menyalternativ.");*/
		
		driver.findElement(By.id("order_now")).click();
		String errorMessage = driver.findElement(By.id("noItemerror")).getText();
		System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, "Lägg till minst ett menyalternativ.");
		
		}
		
	
/*	@Test
	public void VerifyCart_With_OneItem() throws InterruptedException {
		
		
        driver.findElement(By.cssSelector("#\\36 11609095979c5918172abe3 > .options:nth-child(3) .icon_plus_alt2"));
		//Thread.sleep(3000);
		
	//Actions act = new Actions(driver);
        //driver.findElement(By.xpath("#\36 11609095979c5918172abe3 > .options:nth-child(3) .icon_plus_alt2")).click();
		var elem = driver.findElement(By.id("order_now"));
		JavascriptExecutor jse = (JavaScriptExecutor)driver;
		jse.executeScript("arguments[0].click();", elem);
		String LoginPage = driver.getCurrentUrl();
		
		System.out.println(LoginPage);
		AssertJUnit.assertEquals(LoginPage, "https://www.tido-lindorestaurang.se/Login/Login?isFromOrder=true");
		
	}*/

}
