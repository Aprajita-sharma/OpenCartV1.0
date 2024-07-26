package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
public MyAccountPage(WebDriver driver)
{
	super(driver);
}
//Find the first element to validate the page
@FindBy(xpath="//div[contains(@class,'row')] //h2[1]") WebElement LblMyAccount ;
@FindBy(xpath="(//a[@class='list-group-item'])[13]") WebElement lnkLogout;
//@FindBy(xpath="//div[@class='list-group']//a[text()='Logout'") WebElement lnkLogout;

//Now we test whether the My Account label is displayed upon Login in the action method
 public boolean DoesMyAccountLabelDisplay() {
	 try {
		 return(LblMyAccount.isDisplayed());
		 
	 }//try closes
	 catch(Exception e) {
	 return false;
	 }//catch closes
 }//DoesMyAccountLabelDisplay() Action method closes

//clicking the logout btn
 public void clickLogout() {
	 lnkLogout.click();
 }

}//class closes
