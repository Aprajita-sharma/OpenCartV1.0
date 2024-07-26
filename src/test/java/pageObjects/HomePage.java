package pageObjects;
//This page is for intializing the web elements on the home page of open cart application'
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage  {
	WebDriver driver;
public HomePage (WebDriver driver) {
super(driver);
}//close constructor
//Now we find the elements on the home page
//Click on the Account link to open and click on Register
@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkAcct;//Find the MyAccount Link
@FindBy(xpath="//a[normalize-space()='Register']") WebElement  lnkRegister;//Find the Register Link
@FindBy(xpath="//ul[contains(@class,'dropdown')]//li[2]//a[1]") WebElement lnkLogin; //find the login Link


//Now we have to do the actions in terms of methods
public void clickRegister(){
	lnkRegister.click();//To Register
}
public void clickAcct() {

	lnkAcct.click();//To open the dropdown of My Account
}

public void clickLogin()
{
lnkLogin.click();	//Click on the Login link
}

}
