package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

//		driver.get(baseURL);

		logger.info("URL Is Open ");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);

		logger.info("Entered Username");

		lp.setPassword(password);

		logger.info("Entered Password");

		lp.clickSubmit();

		if (driver.getTitle().equals("GTPL Bank Manager HomePage123")) {

			Assert.assertTrue(true);

			logger.info("Login Test Passed");

		} else {

			captureScreen(driver, "loginTest");

			Assert.assertTrue(false);

			logger.info("Login Test Failed");

		}

	}

}