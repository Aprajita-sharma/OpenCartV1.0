package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * Page Factory is a design pattern used in Selenium for web automation testing that simplifies the process of creating Page Objects. It helps reduce the boilerplate code needed to create Page Objects and makes the automation code more maintainable and readable.
In Page Factory, the Page Object Model (POM) is combined with the @FindBy annotation to create Page Objects. The @FindBy annotation is used to locate and initialize web elements on a web page. It is used to find web elements based on their types, such as ID, name, class, or CSS selector.

The @FindBy annotation’s main advantage is that it lets you initialize page elements without using Selenium’s FindElement or FindElements.

Page Factory makes it easy to create Page Objects by allowing the automation developer to define the web elements more concisely. 

The benefits of using Page Factory include reduced code duplication, improved code readability, and improved test maintenance. By creating Page Objects with Page Factory, the automation developer can focus on the logic of the tests rather than the implementation details of the web elements. This can help to reduce errors and make the automation code more maintainable over time.

In summary, Page Factory is a powerful design pattern that simplifies the process of creating Page Objects in Selenium for web automation testing. It can improve the efficiency and maintainability of the automation code, making it easier to write and maintain test cases.

//Advantage of Page Factory in Selenium//
The advantages of using Page Factory in Selenium for web automation testing are:

Reduced code duplication: Page Factory allows for more concise and reusable Page Objects. This reduces the amount of boilerplate code required to create and maintain Page Objects, leading to less code duplication and better code maintainability.

Improved code readability: Page Factory makes the automation code more readable by separating the initialization of web elements from the test code. This makes it easier to understand the intent of the code and the interactions with the web page.

Improved test maintenance: Page Factory makes it easier to maintain the automation code by separating the Page Object initialization code from the test code. This makes it easier to update the code when changes are made to the web page, reducing the risk of errors and making test maintenance more efficient.

Better test performance: Page Factory can improve test performance by reducing the overhead of locating web elements on a web page. This is achieved by initializing the Page Object only once per test, rather than for each test method.
Overall, Page Factory is a powerful design pattern that can help improve the efficiency, maintainability, and scalability of automation code. 

//Initializing Web Components in Page Factory in Selenium//
In Page Factory, web elements can be initialized using the @FindBy annotation, which is used to locate and initialize web elements on a web page. The initElements method is used to initialize web elements.

1. @FindBy annotation 

The @FindBy annotation is a powerful feature in Selenium’s Page Factory that is used to find web elements using various types of locators, such as ID, name, class, tag name, link text, partial link text, and CSS selector. It is used to map a web element on a web page to a field in a Page Object so that it can be easily accessed and manipulated during test execution.
Method1:
@FindBy(how = How.ID, using=”username”)
private WebElement element-name;
Method2:
@FindBy(id = “search-box”)
private WebElement searchBox;
In this example, we are using the @FindBy annotation to locate a web element with the id attribute of “search-box”. The WebElement object named “searchBox” will be initialized with a reference to the web element found by the locator.

Using the @FindBy(id = “search-box”) annotation simplifies the process of locating and initializing web elements in Selenium’s Page Factory. Instead of writing code to find the web element using the By.id() method, we can use the @FindBy annotation to locate and initialize the web element with a single line of code.
2. initElements()

‘initElements()’ is a method provided by the Page Factory class to initialize elements defined in a Page Object.

The initElements() method takes two parameters: a WebDriver instance and a Page Object instance. It scans the Page Object for any fields that are annotated with the @FindBy annotation and initializes them with references to the corresponding web elements on the page. initElements() is an overloaded function which can be modified or used in multiple ways.

https://testsigma.com/blog/page-object-model-in-selenium/
*
*/
public class BasePage {
WebDriver driver;
//Constructor of the BasePage class to find the web driver of the browser type
public BasePage(WebDriver driver)
{
	this.driver=driver;
	//using PageFactory to locate the driver of the web brower
	//A WebDriver is a browser automation framework. It accepts commands and sends them to a browser.Selenium WebDriver is a programming interface that can be used to create and execute test cases. It allows you to test across all major programming languages, browsers, and operating systems.

//It can run across different platforms and because it is made up of different language bindings: it allows you to code in different languages.
	PageFactory.initElements(driver, this);
	//Page Factory is a built in Page object Model concept in selenium
	/*When you invoke PageFactory.initElements(driver, this) in a page class constructor, it initializes the WebElements declared using @FindBy annotations. One crucial aspect of this initialization is "lazy loading" or "lazy initialization." In the context of PageFactory, lazy initialization means that the elements are not immediately found and stored when the page class is instantiated.

Instead, these elements are initialized as “proxies” or placeholders. The actual finding of these elements from the web page happens only when an action or method is called upon those elements. The proxy element holds the information about how to locate the real element when the action is triggered. This lazy loading mechanism reduces the overhead of searching for elements when the page class is instantiated, enhancing efficiency.
*/
	}
 
}
