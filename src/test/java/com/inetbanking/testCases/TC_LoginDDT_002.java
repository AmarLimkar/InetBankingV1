package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		System.out.println(user + "    " + pwd);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");

		lp.setPassword(pwd);
		logger.info("password provided");

		lp.clickSubmit();

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent(); // navigate to main page
			Assert.assertTrue(false);
			logger.warn("Login Fail");
		} else {
			Assert.assertTrue(true);
			logger.info("Login Pass");

			lp.clickLogout();

			Thread.sleep(3000);

// handel window
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
		}
	}

// user defined method created to check alert present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\AJINKYA\\eclipse-workspace\\inetBankingV2\\src\\test\\java\\com\\inetbanking\\testData\\BankingProjectData.xlsx";

// another way
// String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/BankingProjectData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
