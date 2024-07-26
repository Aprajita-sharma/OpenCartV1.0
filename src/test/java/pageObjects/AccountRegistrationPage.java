package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;
public AccountRegistrationPage(WebDriver driver) {
super(driver);

}

//Find the elements using PageFactory
@FindBy(xpath="//input[@name=\"firstname\"]") WebElement txtFirstName;
@FindBy(xpath="//input[@name=\"lastname\"]") WebElement txtLastName;
@FindBy(xpath="//input[@name=\"email\"]") WebElement txtEmail;
@FindBy(xpath="//input[@name=\"telephone\"]") WebElement txtTelephone;
@FindBy(xpath="//input[@placeholder=\"Password\"]") WebElement txtPassword;
@FindBy(xpath="//input[@placeholder=\"Password Confirm\"]") WebElement txtConfirmPassword;
@FindBy(xpath="//input[@name=\"agree\"]") WebElement chkBoxPolicy;
@FindBy(xpath="//div[contains(@class,'col-sm-9')]//h1") WebElement lblAcctCreationConformation;
@FindBy(xpath="//input[@value=\"Continue\"]") WebElement btnContinue; 
//Write methods for the actions and the values are passed to these functions
public void setFirstName(String fname) {
	txtFirstName.sendKeys(fname);
	
}
public void setLastName(String lname) {
	txtLastName.sendKeys(lname);
}
public void setEmail(String email) {
	txtEmail.sendKeys(email);
}
public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);
	
}

public void setPassword(String pswd)
{
	txtPassword.sendKeys(pswd);
	}
public void setConfirmPassword(String confirmPswd)
{
	txtConfirmPassword.sendKeys(confirmPswd);
	}
public void setPolicyCheckBox() 
{
	chkBoxPolicy.click();
}

public void clickContinueBtn()
{
	btnContinue.click();
	}

public String AcctCreationMessage() {
	try {
		System.out.println(lblAcctCreationConformation.getText());
		return lblAcctCreationConformation.getText();
		
	}
	catch(Exception e) {
		return	e.getMessage();
	}
	}
}


