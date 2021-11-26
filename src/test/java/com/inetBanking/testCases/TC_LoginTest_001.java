package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		Logger.info("Url is opened");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		Logger.info("Enter username");

		lp.setPassword(password);
		Logger.info("Enter password");


		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("Login test is passed");

		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			Logger.info("Login test is failed");


		}
	}

}
