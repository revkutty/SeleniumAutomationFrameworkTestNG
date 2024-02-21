package com.SalesForceApp;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseTest {

	String expTitle = "Login | Salesforce", expErrormsg = "Please enter your password.";
	String expusername = "rev@att.com";

	public void Login_1() throws InterruptedException {
		// TODO Auto-generated method stub

		LaunchBrowser("chrome");
		goToUrl("https://attcom-dev-ed.develop.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("-------- Test Case 1 Execution STARTS ----------");
		String title = driver.getTitle();
		System.out.println("Title of firebase app:" + title);
		TitleMatch(expTitle, title, "Loginpage"); 

		WebElement username = driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
		enterText(username, "rev@att.com", "Username");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "", "Password");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickElement(login, "Login");

		WebElement error = driver.findElement(By.cssSelector("div#error.loginError"));
		String errormsg = error.getText();
		System.out.println("Error Message: " + errormsg);
		CompareText(expErrormsg, errormsg, "Test Case 1 - Valid Username & no password");
		System.out.println("-------- Test Case 1 Execution ENDS ----------");
		closeBrowser();

	}

	public void Login_2() throws InterruptedException {
		// TODO Auto-generated method stub

		LaunchBrowser("chrome");
		goToUrl("https://attcom-dev-ed.develop.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("-------- Test Case 2 Execution STARTS ----------");
		String title = driver.getTitle();
		System.out.println("Title of Salesforce app:" + title);
		TitleMatch(expTitle, title, "Loginpage : ");

		WebElement username = driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
		enterText(username, "rev@att.com", "Username");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "Winter@1", "Password");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickElement(login, "Login");

		WebElement home = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		wait.until(ExpectedConditions.visibilityOf(home));
		String actHomeTitle = driver.getTitle();
		String expHomeTitle = "Home Page ~ Salesforce - Developer Edition";
		TitleMatch(expHomeTitle, actHomeTitle, "Test Case 2 - Homepage");
		System.out.println("-------- Test Case 2 Execution ENDS ----------");
		closeBrowser();
	}

	public void Login_3() throws InterruptedException {
		// TODO Auto-generated method stub

		LaunchBrowser("firefox");
		goToUrl("https://attcom-dev-ed.develop.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("-------- Test Case 3 Execution STARTS ----------");
		String title = driver.getTitle();
		System.out.println("Title of firebase app:" + title);
		TitleMatch(expTitle, title, "Loginpage");

		WebElement username = driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
		enterText(username, "rev@att.com", "Username");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "Winter@1", "Password");

		WebElement remember = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		clickElement(remember, "Remember Me");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickElement(login, "Login");

		WebElement home = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		wait.until(ExpectedConditions.visibilityOf(home));
		String actHomeTitle = driver.getTitle();
		String expHomeTitle = "Home Page ~ Salesforce - Developer Edition";
		TitleMatch(expHomeTitle, actHomeTitle, "Homepage");

		WebElement usermenu = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		wait.until(ExpectedConditions.visibilityOf(usermenu));

		Actions action = Actions();
		action.moveToElement(usermenu).click().build().perform();

		WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		action.moveToElement(logout).click().build().perform();

		WebElement loginpg = driver.findElement(By.xpath("//input[@id='Login']"));
		wait.until(ExpectedConditions.visibilityOf(loginpg));
		String actTitle1 = driver.getTitle();
		TitleMatch(expTitle, actTitle1, "Login Page");

		WebElement username1 = driver.findElement(By.xpath("//*[@id='idcard-identity']"));
		String actusername = getTextFromElement(username1, "Remembered username");
		if (username1.isDisplayed()) {
			TitleMatch(expusername, actusername, "Login Page");
			System.out.println("Username is displayed");
		}

		WebElement remember1 = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		if (remember1.isSelected()) {
			System.out.println("Remember me is selected");
		}
		System.out.println("-------- Test Case 3 Execution ENDS ----------");
		closeBrowser();

	}

	public void Login_4a() throws InterruptedException {
		// TODO Auto-generated method stub

		LaunchBrowser("chrome");
		goToUrl("https://attcom-dev-ed.develop.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("-------- Test Case 4A Execution STARTS ----------");
		String title = driver.getTitle();
		System.out.println("Title of Salesforce app: " + title);
		TitleMatch(expTitle, title, "Login page");
		WebElement forgetpassword = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		clickElement(forgetpassword, "Forget password");

		String actforgetpasstitle = driver.getTitle();
		System.out.println("Title of Salesforce app:" + actforgetpasstitle);
		String expforgetpasstitle = "Forgot Your Password | Salesforce";
		TitleMatch(expforgetpasstitle, actforgetpasstitle, "Forget Password page title : ");

		WebElement forgetpassusername = driver.findElement(By.xpath("//input[@id='un']"));
		enterText(forgetpassusername, expusername, "Username ");

		WebElement passcontinue = driver.findElement(By.xpath("//input[@id='continue']"));
		clickElement(passcontinue, "Continue in forget password ");

		String actemailTitle = driver.getTitle();
		System.out.println("Title of Salesforce app: " + actemailTitle);
		String expemailTitle = "Check Your Email | Salesforce";
		TitleMatch(expemailTitle, actemailTitle, "Check Your Email ");

		WebElement emailtext = driver.findElement(By.xpath("//div/p[@class='senttext mb12'][1]"));
		String emailmsg = getTextFromElement(emailtext, " Check Your Email error message ");
		System.out.println("Error Message :" + emailmsg);
		System.out.println("-------- Test Case 4A Execution ENDS ----------");
		closeBrowser();
	}

	public void Login_4b() throws InterruptedException {
		// TODO Auto-generated method stub

		LaunchBrowser("firefox");
		goToUrl("https://attcom-dev-ed.develop.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("-------- Test Case 4b Execution STARTS ----------");
		String title = driver.getTitle();
		System.out.println("Title of firebase app:" + title);
		TitleMatch(expTitle, title, "Loginpage");
		

		WebElement username = driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
		enterText(username, "123", "Username");
	

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "22131", "Password");


		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickElement(login, "Login");

		WebElement error = driver.findElement(By.cssSelector("div#error"));
		String errormsg = error.getText();
		System.out.println("Error message: " + errormsg);
		String expErrormsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		CompareText(expErrormsg, errormsg, "Test Case 4b - Invalid Username & Invalid Password ");

		System.out.println("-------- Test Case 4b Execution ENDS ----------");
		closeBrowser();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Login obj = new Login();
		obj.Login_1();
		obj.Login_2();
		obj.Login_3();
		obj.Login_4a();
		obj.Login_4b();

	}

}
