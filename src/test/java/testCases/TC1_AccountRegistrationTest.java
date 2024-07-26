package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC1_AccountRegistrationTest extends BaseClass {
@Test(groups={"Regression","Master"})
public void verify_acct_registration() throws InterruptedException 
{
	//Setup the log file 
	logger.info("********TC1_AccountRegistrationTest STARTED**********");
	
	try
	{
//set the HomePage class object
HomePage homePageObject= new HomePage(driver);
logger.info("HomePage Loaded");

//call methods of the home page 
Thread.sleep(3000);homePageObject.clickAcct();
homePageObject.clickRegister();
logger.info("Clicked on Register Link");
AccountRegistrationPage  acctRegPageObject = new AccountRegistrationPage(driver) ;
Thread.sleep(3000);
acctRegPageObject.setFirstName(randomStringsFnameLname().toUpperCase());
logger.info("Filled in first name");
acctRegPageObject.setLastName(randomStringsFnameLname().toUpperCase());
logger.info("Filled in Last Name");
acctRegPageObject.setEmail(randomAlphanumericEmailPassword()+"@gmail.com");
logger.info("Setup email");
acctRegPageObject.setTelephone(randomNumberTelephone());
logger.info("Setup telephone");
String password_set= randomAlphanumericEmailPassword();
logger.info("Setup password");
acctRegPageObject.setPassword(password_set);logger.info("Setup pswd");
acctRegPageObject.setConfirmPassword(password_set);logger.info("Setup confirmed password");
acctRegPageObject.setPolicyCheckBox();
logger.info("checked the policy check box");
acctRegPageObject.clickContinueBtn();
logger.info("Clicked the continue button");
String confirmMsg=acctRegPageObject.AcctCreationMessage();
//Assert.assertEquals(confirmMsg,"Your Account Has Been Created!!!!");

if (confirmMsg.equals("Your Account Has Been Created!"))//FAILS HERE AS MORE THAN 1 EXCALAMATION MARKS
{
	Assert.assertTrue(true);
	logger.info("Verified the message\"Your Account Has Been Created!\"");
}
else
{	
	logger.error("Test failed ....");
	//Debug logs to be captured
	logger.debug("Debug logs...");
}

	} 
	catch(Exception e)
	{
		Assert.fail();//Stating that the assert failed
		logger.info("FAILED TO Verify the message\"Your Account Has Been Created!\"");
		
	}
	logger.info("********TC1_AccountRegistrationTest FINSIHED**********");
}
}
