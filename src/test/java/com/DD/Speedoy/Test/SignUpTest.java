package com.DD.Speedoy.Test;

import org.testng.annotations.Test;
import org.testng.internal.Utils;
import com.DD.Speedoy.Base.BasePage;
import com.DD.Speedoy.utility.DataUtil;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class SignUpTest extends BasePage {
	
	@BeforeTest
	 public void launchbrowser() {
		super.setup();
		super.initializeBrowser(config.getProperty("Browser"), config.getProperty("url"));
		
		}
	
	@AfterTest
	public void Exitbrowser() {
		super.closebrowser();
		}
	
	// test to verify signup.
	
    @Test(dataProvider="getData", dataProviderClass= DataUtil.class)
	public void VerifySignUp(String EmailID, String FirstName, String Surname, String TelNo, String Password, String ConfirmPassword) {
		
	
		driver.findElement(By.id("sign-inn")).click();
		driver.findElement(By.id("continueWithEmail")).click();
		driver.findElement(By.id("checkEmail")).sendKeys(EmailID);
		driver.findElement(By.xpath("//body[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/input[1]")).click();
		driver.findElement(By.id("firstName")).sendKeys(FirstName);
		driver.findElement(By.id("lastName")).sendKeys(Surname);
		driver.findElement(By.id("phoneNumber")).sendKeys(Utils.toString(TelNo));
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("confirmpassword")).sendKeys(ConfirmPassword);
		driver.findElement(By.id("signupnow")).click();
	    Boolean Pagevisible = driver.findElement(By.xpath("//h3[normalize-space()='Verifiering']")).isDisplayed();
	     System.out.println(Pagevisible);
		
		
		
	}
	
}
