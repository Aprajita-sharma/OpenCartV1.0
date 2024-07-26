package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
//constructed to instantiate the webdriver
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Finding the webelements  on the web page
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	
	//create methods for setting the email, password and clicking the login button on the web page
	
	public void setEmail(String email)
	{

		txtEmail.sendKeys(email);
	}
	public void setPassword(String pswd)
	{

		txtpassword.sendKeys(pswd);
	}
	public void clickLogin()
	{

	btnLogin.click();
	}
}
