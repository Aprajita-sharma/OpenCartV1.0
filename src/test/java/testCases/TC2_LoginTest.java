package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC2_LoginTest extends BaseClass {

	
	//Verify the login is successful or not
	@Test(groups={"Sanity","Master"})
	public void login() 
	{
	//Start by logging info
	logger.info("*****TC2_LoginTest  BEGINS******");
	try {
	// HomePage 
	//Class as the Login lnk is there to click
	HomePage homePageObj= new HomePage(driver);
	logger.info("Created Object of HomePage");
	homePageObj.clickAcct();//open dropdoen
	logger.info("My Account clicked on HomePage");
	homePageObj.clickLogin();//click Login
	logger.info("Login clicked on HomePage");
	logger.info("Home Page DONE!!");
	// Login Page
	logger.info("Starting the Login Page!");
	LoginPage loginPageObj=new LoginPage(driver);
	Thread.sleep(2000);
	//Now we call the methods for setting the email, password and then clicking the Login button
	//We will access the email and password from the config file which has object in the base class
	loginPageObj.setEmail(propertyToLoad.getProperty("email"));//set the email from the field email from the config file
	logger.info("Setting the email form config file!");
	loginPageObj.setPassword(propertyToLoad.getProperty("password"));//set the password from the field password from the config file
	logger.info("Setting the password form config file!");
	loginPageObj.clickLogin();//Click the login btn
	logger.info("Login Button clicked!");
	
	
	
//	Now we need to verify on My Accounts Page,the label : " My Account"
	MyAccountPage myAccountPageObj =new MyAccountPage(driver);
	
	boolean Isdisplayed=myAccountPageObj.DoesMyAccountLabelDisplay();
	//Now we need to assert that the My Account is displayed
	Assert.assertEquals(Isdisplayed, true,"Login Failed as My Account page not displayed!!");
	logger.info("My Account Page is displayed from the login Page!");
	logger.info("*****TC2_LoginTest  FINISH******");
	}//try closes
	catch (Exception e)
	{
		Assert.fail();
		logger.info(e.toString());
	}
	}//login() closes
	
}//TC2_LoginTest Class closes

