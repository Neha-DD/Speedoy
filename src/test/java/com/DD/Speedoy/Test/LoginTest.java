package com.DD.Speedoy.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.DD.Speedoy.Base.BasePage;
import com.DD.Speedoy.utility.DataUtil;

	
	public class LoginTest extends BasePage {
		  
		@BeforeTest
		 public void launchbrowser() {
			super.setup();
			super.initializeBrowser(config.getProperty("Browser"), config.getProperty("url"));
			
			}
		
		@AfterTest
		public void Exitbrowser() {
			super.closebrowser();
			}
		
	   @Test(dataProvider="getData", dataProviderClass= DataUtil.class, priority=1)
		public void Verify_ValidEmail_ValidPassword(String EmailID, String Password)  {
			
			super.login(EmailID, Password);
			
		    String ActualPage = driver.getCurrentUrl();
		    System.out.println(ActualPage);
			Assert.assertEquals(ActualPage, "https://spdevweb.azurewebsites.net/Login/Login");
			super.logout();
			
			}
		
     
	/*	@Test(dataProvider="getData", dataProviderClass= DataUtil.class, priority=2)
		public void Verify_ValidEmail_InvalidPwd(String EmailID, String Password)  {
			
			super.login(EmailID, Password);
			String errormsg = driver.findElement(By.xpath("//*[@id=\"passwordErrorMsg\"]")).getAttribute("innerHTML");
			System.out.println(errormsg);
			Assert.assertEquals(errormsg, "Ogiltiga uppgifter");
			
			}*/
		
		
		
	}
