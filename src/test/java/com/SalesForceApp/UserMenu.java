package com.SalesForceApp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMenu extends SFLogin {

	public void UserMenu_1() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		UserMenuDropDown();
		closeBrowser();
		SalesForceLogin();
		SalesForceLogout();

	}

	public void UserMenu_2() throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		SalesForceLogin();
		// UserMenuDropDown();

		WebElement usermenu = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(usermenu));

		Actions action = Actions();
		action.moveToElement(usermenu).click().build().perform();

		Thread.sleep(1000);

		WebElement myprofile = driver.findElement(By.xpath("//div[@id='userNav']/div[2]/div[3]/a[1]"));
		wait.until(ExpectedConditions.visibilityOf(myprofile));
		action.moveToElement(myprofile).click().build().perform();

		Thread.sleep(1000);

		WebElement useractionmenu = driver.findElement(By.cssSelector("#moderatorMutton >b"));
		useractionmenu.click();

		// edit profile
		WebElement editprofile = driver
				.findElement(By.xpath("//ul[@class='zen-options']/li[2]/a[@title='Edit Profile']"));
		action.moveToElement(editprofile).click().build().perform();

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='aboutMeContentId']"));
		driver.switchTo().frame(frame);

		WebElement about = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
		about.click();

		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		enterText(lastname, "lastname", "Profile Lastname");

		WebElement saveall = driver.findElement(By.xpath("//input[@value='Save All']"));
		saveall.click();

		driver.switchTo().defaultContent();

		// post link
		WebElement post = driver.findElement(By.cssSelector("#publisherAttachTextPost > span.publisherattachtext"));
		post.click();

		WebElement frame1 = driver.findElement(By.xpath("//*[@id='cke_43_contents']/iframe"));
		driver.switchTo().frame(frame1);

		WebElement ptext = driver
				.findElement(By.xpath("//body[contains(text(),'Share an update, @mention someone...')]"));
		enterText(ptext, "Salesforce project myprofilexxx", "myprofile text sharexx ");
		driver.switchTo().defaultContent();

		WebElement share = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		share.click();

		// file link
		WebElement file = driver.findElement(By.cssSelector("#publisherAttachContentPost> span.publisherattachtext"));
		file.click();

		WebElement fileupload = driver.findElement(By.cssSelector("#chatterUploadFileActionPanel"));
		// fileupload.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(fileupload).click().build().perform();

		Thread.sleep(5000);
		WebElement choosefile = driver.findElement(By.xpath("//input[@id='chatterFile']"));

		// choosefile.click();
		Thread.sleep(5000);
		// Upload file using sendkeys
		choosefile.sendKeys("C:\\Users\\vsaji\\OneDrive\\Desktop\\Kutty\\Rev Docs\\TekArch\\FileUpload\\File1.txt");

		/*
		 * //upload file using Robot class Robot rb = new Robot(); StringSelection str =
		 * new
		 * StringSelection("C:\\Users\\vsaji\\OneDrive\\Desktop\\Kutty\\Rev Docs\\TekArch\\FileUpload\\flower.jpg"
		 * ); Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 * 
		 * rb.keyPress(KeyEvent.VK_CONTROL); rb.keyPress(KeyEvent.VK_V);
		 * rb.keyRelease(KeyEvent.VK_V); rb.keyRelease(KeyEvent.VK_CONTROL);
		 * rb.keyPress(KeyEvent.VK_ENTER); rb.keyRelease(KeyEvent.VK_ENTER);
		 */

		Thread.sleep(2000);

		WebElement fileshare = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		fileshare.click();

		WebElement photo = driver.findElement(By.xpath("//*[@id='uploadLink']"));
		// Actions actions1 = new Actions(driver);
		actions.moveToElement(photo).click().build().perform();

		WebElement pframe = driver.findElement(By.id("uploadPhotoContentId"));
		driver.switchTo().frame(pframe);

		WebElement choosephoto = driver.findElement(By.xpath("//input[@class='fileInput']"));

		// Docs\\TekArch\\FileUpload\\flower.jpg");
		choosephoto.sendKeys("C:\\Users\\vsaji\\OneDrive\\Desktop\\Kutty\\Rev Docs\\TekArch\\FileUpload\\rose.jpg");

		WebElement savebtn = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
		savebtn.click();

		driver.switchTo().defaultContent();

		closeBrowser();
	}

	public void UserMenu_3() throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement usermenu = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(usermenu));

		Actions action = Actions();
		action.moveToElement(usermenu).click().build().perform();

		Thread.sleep(1000);

		WebElement mysettings = driver.findElement(By.linkText("My Settings"));
		wait.until(ExpectedConditions.visibilityOf(mysettings));
		action.moveToElement(mysettings).click().build().perform();

		Thread.sleep(1000);

		WebElement personal = driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
		action.moveToElement(personal).click().build().perform();

		WebElement loginhistory = driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		action.moveToElement(loginhistory).click().build().perform();

		WebElement downloadhist = driver.findElement(By.xpath("//div[@class='pShowMore']/a"));
		downloadhist.click();

		// download file using Robot class
		Robot rb = new Robot();

		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		// Display & Layout
		WebElement displaylayout = driver.findElement(By.xpath("//*[@id='DisplayAndLayout_font']"));
		action.moveToElement(displaylayout).click().build().perform();

		WebElement custmytab = driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		action.moveToElement(custmytab).click().build().perform();

		WebElement content = driver.findElement(By.xpath("//select[@id='p4']"));
		Select select = new Select(content);
		select.selectByVisibleText("Salesforce Chatter");

		// select Reports from availabletab
		WebElement availabletab = driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		Select select1 = new Select(availabletab);
		select1.selectByVisibleText("Reports");
		Thread.sleep(1000);

		// add button
		WebElement addbtn = driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		addbtn.click();

		// selected Reports
		WebElement selectedtab = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		Select select2 = new Select(selectedtab);
		select2.selectByVisibleText("Reports");
		WebElement selectedtxt = select2.getFirstSelectedOption();
		System.out.println("Reports tab selected:" + selectedtxt.getText());

		// save button
		Thread.sleep(1000);
		WebElement savebtn = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));
		savebtn.click();
		// Thread.sleep(1000);

		// Display & Layout
		WebElement email = driver.findElement(By.xpath("//*[@id='EmailSetup_font']"));
		action.moveToElement(email).click().build().perform();
		// my email setting link
		WebElement myemaillink = driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
		action.moveToElement(myemaillink).click().build().perform();

		WebElement emailname = driver.findElement(By.xpath("//input[@id='sender_name']"));
		enterText(emailname, "test email", "sender name");

		WebElement senderemail = driver.findElement(By.xpath("//input[@id='sender_email']"));
		enterText(senderemail, "revkutty@gmail.com", "sender email");

		WebElement bcc = driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
		if (!bcc.isSelected())
			bcc.click();

		// bcc save btn
		Thread.sleep(1000);
		WebElement bccsavebtn = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));
		bccsavebtn.click();

		// Calendar & Reminders
		WebElement calendar = driver.findElement(By.xpath("//*[@id='CalendarAndReminders_font']"));
		action.moveToElement(calendar).click().build().perform();

		// activity reminders link
		WebElement activity = driver.findElement(By.xpath("//span[@id='Reminders_font']"));
		action.moveToElement(activity).click().build().perform();

		System.out.println("current page before openreminder click:" + driver.getTitle());
		// open test reminder link
		WebElement openreminder = driver.findElement(By.xpath("//input[@id='testbtn']"));
		action.moveToElement(openreminder).click().build().perform();
		Thread.sleep(5000);

		String parentwindow = driver.getWindowHandle(); // current window handle
		System.out.println("parentwindow:" + parentwindow);
		System.out.println("current page after click:" + driver.getTitle());
		Set<String> listOfHandles = driver.getWindowHandles();
		System.out.println("No of windows:" + listOfHandles.size());
		for (String handle : listOfHandles) {
			if (!handle.equals(parentwindow)) {
				driver.switchTo().window(handle); // switching to the new window
				Thread.sleep(3000);
				System.out.println("Child window title:" + driver.getTitle());
				if (driver.getTitle().equals("** New **")) {
					System.out.println("Sample event pop window is dispayed");
				} else {
					System.out.println("Sample event pop window is not dispayed");
				}
				WebElement dimissall = driver.findElement(By.xpath("//*[@id='dismiss_all']"));
				clickElement(dimissall, "Dismiss all button clicked and child window closed");
			}

		}
		driver.switchTo().window(parentwindow);

		closeBrowser();
	}

	public void UserMenu_4() throws InterruptedException {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement usermenu = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(usermenu));

		Actions action = Actions();
		action.moveToElement(usermenu).click().build().perform();

		Thread.sleep(1000);

		WebElement devconsole = driver.findElement(By.linkText("Developer Console"));
		wait.until(ExpectedConditions.visibilityOf(devconsole));
		action.moveToElement(devconsole).click().build().perform();

		Thread.sleep(3000);

		String parentwindow = driver.getWindowHandle(); // current window handle
		System.out.println("parentwindow:" + parentwindow);
		System.out.println("current page after click:" + driver.getTitle());
		Set<String> listOfHandles = driver.getWindowHandles();
		System.out.println("No of windows:" + listOfHandles.size());
		for (String handle : listOfHandles) {
			if (!handle.equals(parentwindow)) {
				driver.switchTo().window(handle); // switching to the new window
				Thread.sleep(3000);
				System.out.println("Child window title:" + driver.getTitle());
				if (driver.getTitle().equals("Developer Console")) {
					System.out.println("Sample event pop window is dispayed");
				} else {
					System.out.println("Sample event pop window is not dispayed");
				}
				driver.quit();
			}

		}

		closeBrowser();
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		UserMenu obj = new UserMenu();
		obj.UserMenu_1();
		obj.UserMenu_2();
		obj.UserMenu_3();
		obj.UserMenu_4();
		obj.UserMenu_5();
	}

	public void UserMenu_5() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		UserMenuDropDown();
		closeBrowser();
		SalesForceLogin();
		SalesForceLogout();
		closeBrowser();
	}

}
