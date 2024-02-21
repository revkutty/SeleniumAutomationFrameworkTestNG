package com.SalesForceApp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFLogin extends BaseTest {
	String expTitle = "Login | Salesforce";

	public void SalesForceLogin() {
		LaunchBrowser("chrome");
		goToUrl("https://attcom-dev-ed.develop.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

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
		TitleMatch(expHomeTitle, actHomeTitle, "Homepage");

	}

	public void SalesForceLogout() {
		WebElement usermenu = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(usermenu));

		Actions action = Actions();
		action.moveToElement(usermenu).click().build().perform();

		WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		wait.until(ExpectedConditions.visibilityOf(logout));
		action.moveToElement(logout).click().build().perform();

		WebElement loginpg = driver.findElement(By.xpath("//input[@id='Login']"));
		wait.until(ExpectedConditions.visibilityOf(loginpg));
		String actTitle1 = driver.getTitle();
		TitleMatch(expTitle, actTitle1, "Login Page");
	}

	public void UserMenuDropDown() {
		// TODO Auto-generated method stub
	//	SalesForceLogin();

		WebElement usermenu = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(usermenu));

		Actions action = Actions();
		action.moveToElement(usermenu).click().build().perform();

		List<String> explist = new ArrayList<>();
		explist.add("My Profile");
		explist.add("My Settings");
		explist.add("Developer Console");
		explist.add("Switch to Lightning Experience"); 
		explist.add("Logout");

		List<WebElement> items = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		
	/*	for(WebElement useritems : items) {
			for(String exitems : explist) {
				if(useritems.getText().equals(exitems)) {
					System.out.println("User menu items are matching:" + useritems.getText());
				//	break;
				} else {
					System.out.println("User menu items are not matching");
					break;
				   }	
			}  
		}      */
		

		for (int j = 0; j < items.size(); j++) {
			String actitems = items.get(j).getText().toString();

			for (int k = j; k < explist.size(); k++) {
				String item = explist.get(k);

				if (actitems.equalsIgnoreCase(item)) {
					System.out.println("User menu items are matching:" + actitems);
					break;
				}    else {
					System.out.println("User menu items are not matching");
					break;
				}   
			}

		}   
		
		System.out.println("User Menu drop down validation completed");	
		System.out.println("Title:" + driver.getTitle());
		
	}

}
