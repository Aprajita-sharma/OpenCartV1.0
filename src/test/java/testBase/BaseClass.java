  package testBase;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//Common class for all the testcases
public class BaseClass {
	static public  WebDriver driver; //instntiate a webdriver class object

//For logging the application info we create log files
public Logger logger;
public Properties propertyToLoad;
//Before the class is run we have to load the drivers, open the url , maximize it
@SuppressWarnings("deprecation")
@BeforeClass(groups= {"Sanity","Regression","Master"})
@Parameters({"os","browser"})
public void setup(String os, String browser) throws IOException
{
	//Loading the config.properties file
	FileReader fileReader= new FileReader("./src//test//resources//config.properties ") ;
	propertyToLoad=new Properties();
	propertyToLoad.load(fileReader);  
	//Is the execution on local machine or remote
	//REMOTE
/*	if(propertyToLoad.getProperty("execution_env").equalsIgnoreCase("remote"));
	{
		//Create Desired capabilitiies class
		DesiredCapabilities desiredObj=new DesiredCapabilities();
		//O.S
		if(os.equalsIgnoreCase("windows"))
		{
			desiredObj.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			desiredObj.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching O.S");
			return;
		}
		//For execution the browser remotely
		switch(browser.toLowerCase())
		{
		case "chrome":desiredObj.setBrowserName("chrome");break;
		case "edge":desiredObj.setBrowserName("MicrosoftEdge");break;
		case "firefox":desiredObj.setBrowserName("firefox");break;
		default:System.out.println("No matching browser!");return;
	}
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),desiredObj);
	
	
	
	}
	
	*/
	
	//If execution env is LOCAL
	if(propertyToLoad.getProperty("execution_env").equalsIgnoreCase("local"));
	{

	switch(browser.toLowerCase())
	{
	case "chrome":driver= new ChromeDriver();break; 
	case "edge":driver=new EdgeDriver(); break; 
	case "firefox": driver=new FirefoxDriver(); break; 
	default:System.out.println("Invalid browser");return; 
	// as none of the statments must be exectued now , we exit the whole execution as browser is invalid
	
	}
}
	//Setting the log file for the particular class that is being used
	//logger variable is used to generatre the logs for every testcase
	logger=LogManager.getLogger(this.getClass());
	logger.info("BaseClass");
	logger.info(driver.toString());
	

//Delete all the cookies 
driver.manage().deleteAllCookies();
//Set a wait time for stopping exception from occuring
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//open the webpage either by passing the url or using the config file
//driver.get("http://localhost/opencart/upload/index.php");
driver.get(propertyToLoad.getProperty("appURL"));
//Maximize page
driver.manage().window().maximize();
}
//To include Testng Jar files pls go to Project Explorer and then right click and select confiqure build paths., then go to build path libraries and  click on Add Library and Select TestNG
@AfterClass(groups= {"Sanity","Regression","Master"})
public void teardown() { 
driver.close();
}
/*
As the test will be run many times so the data has to be randomly generated
*/
public String randomStringsFnameLname() {
String generatedString=RandomStringUtils.randomAlphabetic(10);
return generatedString;
}
public String randomNumberTelephone() {
String generatedNumber=RandomStringUtils.randomNumeric(10);
return generatedNumber;
}
public String randomAlphanumericEmailPassword() {
String generateAlphanumeric=RandomStringUtils.randomAlphabetic(5);
String generateNumeric=RandomStringUtils.randomNumeric(3);
return (generateAlphanumeric+"_"+generateNumeric);
}
//These values generated will be passed to TC1_AccountRegistrationTest.java page for the setting up of the values

//Capturing the screen for the reports when there is an failure of the testcase execution
/*
public String captureScreen(String tname) throws IOException
{
	String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	TakesScreenshot takesScreenShot=(TakesScreenshot)driver;
	File sourceFile=takesScreenShot.getScreenshotAs(OutputType.FILE);
	//Setting the name of the screenshot and saving as .png image file 
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+"tname_"+timeStamp+".png";
	//copy the source file into the target file
	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);
	return targetFilePath;//return the target file path	
}
*/
public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;

}




}//close BaseClass