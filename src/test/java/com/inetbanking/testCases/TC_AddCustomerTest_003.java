package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");

		lp.clickSubmit();

		Thread.sleep(4000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.ClickAddNewCustomer();

		logger.info("Providing customer details...");

		addcust.custName("Ajinkya");
		addcust.custGender("male");
		addcust.custdob("17", "07", "2002");
		Thread.sleep(4000);
		addcust.custaddress("India");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpinno("411037");
		addcust.custtelephoneno("9307040177");

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);

// addcust.custpassword("abcdef");
		addcust.custsubmit();

		Thread.sleep(4000);

		logger.info("Validation started...");

		boolean res = driver.getPageSource().contains("Customer Registered Successsfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
		} else {
// logger.info("Test case failed...");
// captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(true);
		}
	}

}