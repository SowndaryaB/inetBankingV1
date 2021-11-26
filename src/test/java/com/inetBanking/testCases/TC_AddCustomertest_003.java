package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddCustomerPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_AddCustomertest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("Username is entered");
		lp.setPassword(password);
		Logger.info("Password is entered");
		lp.clickSubmit();
		
		Thread.sleep(3000);	
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		Logger.info("Providing customer details");
		
		addcust.custName("Sowndarya");
		addcust.custgender("Female");
		addcust.custdob("12","06","2021");
		
		Thread.sleep(3000);
		
		addcust.custaddress("India");
		addcust.custcity("Mandya");
		addcust.custstate("Karnataka");   
		addcust.custpinno("571418");
		addcust.custtelephoneno("1234567890");     
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		Logger.info("validation is started");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("testcase is passed");
		}
		else
		{
			Logger.info("testcase is failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);

		}
		
		
	}
	
}
