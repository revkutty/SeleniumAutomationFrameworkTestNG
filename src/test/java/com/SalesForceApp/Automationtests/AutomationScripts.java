package com.SalesForceApp.Automationtests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SalesForceApp.Login;
import com.SalesForceApp.Base.BaseTest;
import com.salesforce.utilities.Constants;
import com.salesforce.utilities.PropertiesUtility;

public class AutomationScripts extends BaseTest {
	// before->
	// beforeMethod->onTestStarts->automationscript->onTestSuccess->afetrMethod
	// after

	protected Logger AutomationScriptslog = LogManager.getLogger();
		
	@Test
	public void Login_1() throws InterruptedException {

		String expTitle = "Login | Salesforce", expErrormsg = "Please enter your password.";
		String expusername = "rev@att.com";
		AutomationScriptslog.info("******Login_to_Salesforce automation script started***********");
		String expected = "Home Page ~ Salesforce - Developer Edition";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		SoftAssert sftAsrt = new SoftAssert();
		extentReport.logTestInfo("soft assert object has created for validation");
		sftAsrt.assertEquals(getPageTitle(), expTitle, "title matched");
		extentReport.logTestInfo("Title of the Login Page:" + getPageTitle());

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, userName, "Username");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "", "Password");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickElement(login, "Login");

		WebElement error = driver.findElement(By.cssSelector("div#error.loginError"));
		String acterrormsg = getTextFromElement(error, "Invalid Password Error");
		AutomationScriptslog.info("Error Message: " + acterrormsg);
		Assert.assertEquals(acterrormsg, expErrormsg);
		// extentReport.logTestInfo("-------- Test Case 1 Execution ENDS ----------");

	}

	@Test
	public void Login_2() throws InterruptedException {

		String expTitle = "Login | Salesforce";
		AutomationScriptslog.info("******Login_to_Salesforce automation script started***********");
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		SoftAssert sftAsrt = new SoftAssert();
		extentReport.logTestInfo("soft assert object has created for validation");
		sftAsrt.assertEquals(getPageTitle(), expTitle, "title matched");
		extentReport.logTestInfo("Title of the Login Page:" + getPageTitle());

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, userName, "Username");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, passWord, "Password");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickElement(login, "Login");

		WebElement home = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		waitForVisibility(home, 30, "hometitle");
		String actHomeTitle = getPageTitle();
		String expHomeTitle = "Home Page ~ Salesforce - Developer Edition";
		AutomationScriptslog.info("Home page Title: " + actHomeTitle);
		Assert.assertEquals(actHomeTitle, expHomeTitle);
		AutomationScriptslog.info("-------- Test Case 2 Execution ENDS ----------");

	}

	@Test
	public void Login_3() throws InterruptedException {
		// TODO Auto-generated method stub

		String expLoginTitle = "Login | Salesforce";
		AutomationScriptslog.info("******Login_to_Salesforce automation script started***********");
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		SoftAssert sftAsrt = new SoftAssert();
		extentReport.logTestInfo("soft assert object has created for validation");
		sftAsrt.assertEquals(getPageTitle(), expLoginTitle, "title matched");
		extentReport.logTestInfo("Title of the Login Page:" + getPageTitle());

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, userName, "Username");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, passWord, "Password");

		WebElement remember = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		clickElement(remember, "Remember Me");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickElement(login, "Login");

		WebElement home = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		waitForVisibility(home, 30, "hometitle");
		String actHomeTitle = getPageTitle();
		String expHomeTitle = "Home Page ~ Salesforce - Developer Edition";
		AutomationScriptslog.info("Home page Title: " + actHomeTitle);
		Assert.assertEquals(actHomeTitle, expHomeTitle);

		WebElement usermenu = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		waitForVisibility(usermenu, 30, "usermenu");

		Actions action = Actions();
		action.moveToElement(usermenu).click().build().perform();

		WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		waitForVisibility(logout, 30, "usermenu logout");
		action.moveToElement(logout).click().build().perform();

		Thread.sleep(2000);
		WebElement loginpg = driver.findElement(By.xpath("//input[@id='Login']"));
		waitForVisibility(loginpg, 30, "loginpg");
		String actLoginTitle = getPageTitle();
		Assert.assertEquals(actLoginTitle, expLoginTitle);

		WebElement rememberusername = driver.findElement(By.xpath("//*[@id='idcard-identity']"));
		String actusername = getTextFromElement(rememberusername, "Remembered username");
		if (rememberusername.isDisplayed()) {
			AutomationScriptslog.info("Username is displayed" + actusername);
			Assert.assertEquals(actusername, userName);
		}

		WebElement rememberme = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		if (rememberme.isSelected()) {
			AutomationScriptslog.info("Remember me is selected");
		}
		AutomationScriptslog.info("-------- Test Case 3 Execution ENDS ----------");

	}

	@Test
	public void Login_4a() throws InterruptedException {
		// TODO Auto-generated method stub

		String expLoginTitle = "Login | Salesforce";
		AutomationScriptslog.info("******Login_to_Salesforce automation script started***********");
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		SoftAssert sftAsrt = new SoftAssert();
		extentReport.logTestInfo("soft assert object has created for validation");
		sftAsrt.assertEquals(getPageTitle(), expLoginTitle, "title matched");
		extentReport.logTestInfo("Title of the Login Page:" + getPageTitle());

		WebElement forgetpassword = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		clickElement(forgetpassword, "Forget password");

		String actforgetpasstitle = driver.getTitle();
		System.out.println("Title of Salesforce app:" + actforgetpasstitle);
		String expforgetpasstitle = "Forgot Your Password | Salesforce";
		TitleMatch(expforgetpasstitle, actforgetpasstitle, "Forget Password page title : ");

		WebElement forgetpassusername = driver.findElement(By.xpath("//input[@id='un']"));
		enterText(forgetpassusername, userName, "Username ");

		WebElement passcontinue = driver.findElement(By.xpath("//input[@id='continue']"));
		clickElement(passcontinue, "Continue in forget password ");

		String actemailTitle = driver.getTitle();
		System.out.println("Title of Salesforce app: " + actemailTitle);
		String expemailTitle = "Check Your Email | Salesforce";
		TitleMatch(expemailTitle, actemailTitle, "Check Your Email ");

		WebElement emailtext = driver.findElement(By.xpath("//div/p[@class='senttext mb12'][1]"));
		String actforgotpassemailmsg = getTextFromElement(emailtext, " Check Your Email error message ");
		AutomationScriptslog.info("Error Message :" + actforgotpassemailmsg);
		String expforgotpassemailmsg = "We’ve sent you an email with a link to finish resetting your password.";
		Assert.assertEquals(actforgotpassemailmsg, expforgotpassemailmsg);
		AutomationScriptslog.info("-------- Test Case 4A Execution ENDS ----------");

	}
	
	@Test
	public void Login_4b() throws InterruptedException {
			
		String expLoginTitle = "Login | Salesforce";
		AutomationScriptslog.info("******Login_to_Salesforce automation script started***********");
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		SoftAssert sftAsrt = new SoftAssert();
		extentReport.logTestInfo("soft assert object has created for validation");
		sftAsrt.assertEquals(getPageTitle(), expLoginTitle, "title matched");
		extentReport.logTestInfo("Title of the Login Page:" + getPageTitle());

		WebElement username = driver.findElement(By.id("username"));
		waitForVisibility(username, 20, "username");
		enterText(username, "123", "Username");
	
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "22131", "Password");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickElement(login, "Login");

		WebElement error = driver.findElement(By.cssSelector("div#error"));
		String errormsg = getTextFromElement(error, "Invalid username and password");
		AutomationScriptslog.info("Error message: " + errormsg);
		String expErrormsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		CompareText(expErrormsg, errormsg, "Test Case 4b - Invalid Username & Invalid Password ");

		AutomationScriptslog.info("-------- Test Case 4b Execution ENDS ----------");
	
	}

}
