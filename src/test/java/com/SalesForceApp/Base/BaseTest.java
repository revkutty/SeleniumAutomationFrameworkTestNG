package com.SalesForceApp.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.salesforce.utilities.Constants;
import com.salesforce.utilities.ExtentReportsUtility;
import com.salesforce.utilities.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.salesforce.utilities.SalesforceAppListnerUtility.class)
public class BaseTest {
	
	protected static WebDriver driver = null;
	protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();

	protected Logger baseTestlog=LogManager.getLogger();
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeMethod(@Optional("chrome") String name,ITestResult result) {
		
		baseTestlog.info(".........BeforeMethod setUpBeforeMethod executed---------------");
		LaunchBrowser(name);
		
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		baseTestlog.info("******tearDownAfterTestMethod executed***********");
	}
	

//	protected WebDriver driver = null;

	public void LaunchBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.manage().window().maximize();
			break;
		case "safari":
			// Safari does not require a seperate driver setup, as it is included with
			// macOS.
			driver = new SafariDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Unsupported Browser: " + browserName);

		}
	}

	public void goToUrl(String url) {
		driver.get(url);
		System.out.println(url + " is entered");
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void enterText(WebElement ele, String data, String objectName) {
		waitForVisibility(ele, 30,objectName);
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			System.out.println(objectName + " data is entered in " + objectName + " textbox");
		} else {
			System.out.println(objectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objectName + " button is clicked");

		} else {
			System.out.println(objectName + " element is not enabled");

		}
	}
	
	public void checkbox(WebElement ele, String objectName) {
		if (!ele.isSelected()) {
			ele.click();
			System.out.println(objectName + " checkbox is selected");

		} else {
			System.out.println(objectName + " checkbox is not enabled");

		}
	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		System.out.println("Text is extracted from : " + objectName);
		return data;
	}
	

	public void closeBrowser() {
		driver.close();
		System.out.println("Browser instance closed");
		driver = null;
	}

	public void CompareText(String exptext, String acttext, String objectName) {
				if (exptext.equals(acttext)) {
			System.out.println(objectName + " Successful and Testcase passed....");
		} else {
			System.out.println(objectName + " Unsuccessful and Testcase failed....");
		}
	}

	
	public void TitleMatch(String expTitle, String title,String objectName) {
			if (expTitle.equals(title)) {
			System.out.println(objectName + " Title matched");
		} else {
			System.out.println(objectName + " Title not matched");
		}

	} 
	
	public void waitForVisibility(WebElement ele, int i, String objectName) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOf(ele));
		baseTestlog.info(objectName + "is visible");
	}
	

	public Alert SwitchToAlert() {
		// TODO Auto-generated method stub
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public Actions Actions() {
		
		Actions action = new Actions(driver);
		return action;
		
	}
	
	public Alert switchToErrorAlert() {
		return SwitchToAlert();
	}
	public String extractTextFromAlert(Alert a) {
		return getAlertText(a,"LoginError Alert");
	}
	private String getAlertText(Alert a, String string) {
		// TODO Auto-generated method stub
		return a.getText();
	}

	public void acceptErrorAlert(Alert a) {
		AcceptAlert(a);
	}

	private void AcceptAlert(Alert a) {
		// TODO Auto-generated method stub
		a.accept();
	}
	
	
	
	

}
