package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

//Test cases tested
		/*
		 * 1. data is valid
		 * login successful ->Test pass-> logout
		 * login uncessful-> Test failed--> No need to log out as same login page is displayed
		 * 
		 * 2. data is invalid
		 * login is sucessful->Test failed-> logout
		 * login unsuccessful--> test passed No need to log out as same login page is displayed
		 * 
		 * 
		 * Now we test that the  combination of email and password are valid or invalid as given in the excel
		 * 
		 * and then we test Assert.assertTrue to make the testcase pass or fail
		 * 
		 * 
		 */
		public class TC3_LoginDataDrivenTest extends  BaseClass{
//create test
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups="DataDriven")
	public void verifyLoginDDT(String email, String password, String expectedOutput) throws InterruptedException
	{
logger.info("**** Starting TC3_LoginDDT *****");
		
		try {
	
		//Home page
			HomePage homePageObj=new HomePage(driver);
			homePageObj.clickAcct();
			homePageObj.clickLogin(); //Login link under MyAccount
			logger.info("Homepage exited ");				
			//Login page
			LoginPage loginPageObj=new LoginPage(driver);
			loginPageObj.setEmail(email);
			loginPageObj.setPassword(password);
			loginPageObj.clickLogin(); //Login button
			logger.info("Loginpage exited ");	
			//My Account Page
			MyAccountPage MyaccountPageObj=new MyAccountPage(driver);
			boolean targetPageVisibility=MyaccountPageObj.DoesMyAccountLabelDisplay();
			
			if(expectedOutput.equalsIgnoreCase("Valid"))
			{
				if(targetPageVisibility==true)
				{logger.info("Valid testcase logged in and logged out for :" +email+" "+password);
					MyaccountPageObj.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{logger.info("Valid testcase cannot login   for :" +email+" "+password);
					Assert.assertTrue(false);
				}
				Thread.sleep(5000);
			}
			
			if(expectedOutput.equalsIgnoreCase("Invalid"))
			{
				if(targetPageVisibility==true)
				{logger.info("InValid testcase but logged in   for :" +email+" "+password);
					MyaccountPageObj.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					logger.info("InValid testcase cannot login   for :" +email+" "+password);
					Assert.assertTrue(true);
				}Thread.sleep(5000);
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC3_LoginDDT *****");

		
		
		
	/*//Home Page
		logger.info("*****TC3_LoginDataDrivenTest  BEGINS******");
		try {
		// HomePage 
		//Class as the Login lnk is there to click
		HomePage homePageObj= new HomePage(driver);
		logger.info("Created Object of HomePage");
		homePageObj.clickAcct();//open dropdown
		//logger.info("My Account clicked on HomePage");
		homePageObj.clickLogin();//click Login
		//logger.info("Login clicked on HomePage");
		//logger.info("Home Page DONE!!");
		// Login Page
		logger.info("Starting the Login Page!");
		LoginPage loginPageObj=new LoginPage(driver);
		Thread.sleep(2000);
		//Now we call the methods for setting the email, password and then clicking the Login button
		//We will access the email and password from the config file which has object in the base class
		loginPageObj.setEmail(email);//set the email from the field email from the EXCEL file
		logger.info("Setting the email form excel file!");
		loginPageObj.setPassword(password);//set the password from the field password from the EXCEL file
		logger.info("Setting the password form excel file!");
		loginPageObj.clickLogin();//Click the login btn
		logger.info("Login Button clicked!");
		logger.info("DataDriven Validation starts!!");
	//My Account Page if the login is successful
	
		MyAccountPage myAccountPageObject= new MyAccountPage(driver);
		boolean isLoginPossible_MyAccountPageDispalyed= myAccountPageObject.DoesMyAccountLabelDisplay();
		//Case1 a. Correct username and password and login successful
		
		if(expectedOutput.equalsIgnoreCase("Valid"))
		{
			if(isLoginPossible_MyAccountPageDispalyed==true)//The My Account page is displayed after login 
			{
		//We logout of the page and the TestcAse is SUCCESSFUL 
			myAccountPageObject.clickLogout();
			logger.info("For Valid username and password , Logged out successfully and TestCase Passed for : "+ email+" "+password);
			Assert.assertTrue(true);//PAss the testcase for valid username and passwords
			}
		else//Case1 b. Valid username and password but login unsuccessful
		{
			logger.info("For Valid username and password , NO LOGIN and Test Case Failed for : "+email+" "+password);
			Assert.assertTrue(false);// Fail the test case

		}
			
		}//Close the testcase for valid username and password , with one test passing and the other failing
		
		//Case2 a. Invalid username and password cannot login -->PASS
	if(expectedOutput.equalsIgnoreCase("invalid"))
		//else
		{
			if (isLoginPossible_MyAccountPageDispalyed==true)//SHOULD NOT BE the case as with 
			{
				logger.info("For INVALID Username and Passord, LOGGEDIN HENCE TestCase FAILEd for : "+email+" "+password);
				//Invalid username and password we should not be showing the My Accounts page
				Assert.assertTrue(false);//Fail the test case 
		
		}
			else 
				{
				
				logger.info("INVALID Username and Password, canNOT login HENCE TestCase PASSED for : "+email+" "+password);
			
				Assert.assertTrue(true);//Cannot login with invalid user name ands passwords
				myAccountPageObject.clickLogout();//Logout of the app immediately
				}
		}
		
	}
		catch (Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
				logger.info("*****TC3_LoginDataDrivenTest  FINISHED******");
}*/

}
}