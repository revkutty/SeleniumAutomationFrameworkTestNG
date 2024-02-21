package com.SalesForceApp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount extends SFLogin {

	public void CreateAccount_1() {
		// TC10a CreateAccount
		SalesForceLogin();

		WebElement plus = driver.findElement(By.xpath("//img[@alt='All Tabs']"));
		plus.click();

		WebElement custom = driver.findElement(By.cssSelector("input.btnImportant"));
		custom.click();

		try {
			WebElement availabletab = driver.findElement(By.xpath("//select[@id='duel_select_0']"));
			Select select = new Select(availabletab);
			select.selectByVisibleText("Accounts"); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("NoSuchElementException");
		}

		WebElement addbtn = driver.findElement(By.cssSelector("img.rightArrowIcon"));
		addbtn.click();

		WebElement selectedtab = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		Select select1 = new Select(selectedtab);
		select1.selectByVisibleText("Accounts");
		WebElement selectedtxt = select1.getFirstSelectedOption();
		System.out.println("Accounts tab selected:" + selectedtxt.getText());

		WebElement savebtn = driver.findElement(By.cssSelector("td#bottomButtonRow> input.btn.primary"));
		savebtn.click();

		String expalltabtitle = "All Tabs ~ Salesforce - Developer Edition";
		String actalltabtitle = driver.getTitle();
		TitleMatch(expalltabtitle, actalltabtitle, "All Tabs title:");

		SalesForceLogout();
		closeBrowser();
		SalesForceLogin();

		WebElement alltabbar = driver.findElement(By.cssSelector("li#Account_Tab > a "));
		String acctext = alltabbar.getText();
		String expaccttext = "Accounts";
		TitleMatch(expaccttext, acctext, "Accounts title present in all tabs");

		closeBrowser();
	}

	public void CreateAccount_2() {
		// TC11 Createnewview
		SalesForceLogin();

		WebElement alltabbar = driver.findElement(By.cssSelector("li#Account_Tab > a "));
		String acctext = alltabbar.getText();
		String expaccttext = "Accounts";
		TitleMatch(expaccttext, acctext, "Accounts title present in all tabs");
		alltabbar.click();

		WebElement Accusername = driver.findElement(By.id("fcf"));
		Select select = new Select(Accusername);
		String accusertext = select.getFirstSelectedOption().getText();
		System.out.println("User name in Account Page:" + accusertext);
		String expaccusertext = "Revaji Account view1";
		TitleMatch(expaccusertext, accusertext, "User name in Account Page: ");

		WebElement newbtn = driver.findElement(By.cssSelector("td.pbButton > input.btn"));
		newbtn.click();

		WebElement accname = driver.findElement(By.id("acc2"));
		enterText(accname, "King", "Account Name");

		WebElement type = driver.findElement(By.id("acc6"));
		Select select1 = new Select(type);
		// List<WebElement> opt = select1.getOptions();
		select1.selectByVisibleText("Technology Partner");

		WebElement custprty = driver.findElement(By.id("00Nan000000KDFe"));
		Select select2 = new Select(custprty);
		select2.selectByValue("High");

		// #bottomButtonRow > input:nth-child(1)
		// *[@id="bottomButtonRow"]/input[1]

		WebElement savebtn = driver.findElement(By.cssSelector("#bottomButtonRow > input:nth-child(1)"));
		savebtn.click();

		String expacctabtitle = "Account: King ~ Salesforce - Developer Edition";
		String actacctabtitle = driver.getTitle();
		TitleMatch(expacctabtitle, actacctabtitle, "Account Tab title:");
		closeBrowser();
	}

	public void CreateAccount_3() {
		// TC12 Editview
		SalesForceLogin();

		WebElement alltabbar = driver.findElement(By.cssSelector("li#Account_Tab > a "));
		String acctext = alltabbar.getText();
		String expaccttext = "Accounts";
		TitleMatch(expaccttext, acctext, "Accounts title present in all tabs");
		alltabbar.click();

		WebElement createnewview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createnewview.click();

		WebElement viewname = driver.findElement(By.id("fname"));
		enterText(viewname, "King view2", "Viewname");

		WebElement viewuniqname = driver.findElement(By.id("devname"));
		enterText(viewuniqname, "King_view2", "View unique name");

		WebElement savebtn = driver.findElement(By.xpath("//input[@data-uidsfdc='3']"));
		savebtn.click();

		// Recently Created
		WebElement viewdetail = driver.findElement(By.cssSelector("select.title"));
		Select select3 = new Select(viewdetail);
		String actviewdetail = select3.getFirstSelectedOption().getText();
		String expviewdetail = "King view2";
		System.out.println("Actviewdetail:" + actviewdetail);
		TitleMatch(expviewdetail, actviewdetail, "New View title:");
		closeBrowser();
	}

	public void CreateAccount_4() throws InterruptedException {
		// TODO Auto-generated method stub
		SalesForceLogin();

		WebElement alltabbar = driver.findElement(By.cssSelector("li#Account_Tab > a "));
		String acctext = alltabbar.getText();
		String expaccttext = "Accounts";
		TitleMatch(expaccttext, acctext, "Accounts title present in all tabs");
		alltabbar.click();

		// Select the <view name> from the view drop down list on the account page
		WebElement viewdetail = driver.findElement(By.cssSelector("select#fcf"));
		Select select1 = new Select(viewdetail);
		String actviewdetail = select1.getFirstSelectedOption().getText();
		String expviewdetail = "King view2";
		System.out.println("Actviewdetail:" + actviewdetail);
		TitleMatch(expviewdetail, actviewdetail, "New View title:");

		// Click on the Edit link the accounts page.
		WebElement editbtn = driver.findElement(By.cssSelector("span.fFooter > a:nth-child(1)"));
		editbtn.click();

		// Field = AccountName
		WebElement field = driver.findElement(By.cssSelector("#fcol1"));
		Select select2 = new Select(field);
		select2.selectByVisibleText("Account Name");

		// operator = contains
		WebElement operator = driver.findElement(By.cssSelector("#fop1"));
		Select select3 = new Select(operator);
		select3.selectByVisibleText("contains");

		// value = a
		WebElement value = driver.findElement(By.cssSelector("#fval1"));
		enterText(value, "c", "Value");

		// Last Activity
		WebElement selectfields = driver.findElement(By.id("colselector_select_0"));
		Select select5 = new Select(selectfields);
		select5.selectByVisibleText("Last Activity");

		WebElement addbtn = driver.findElement(By.cssSelector("a#colselector_select_0_right> img.rightArrowIcon"));
		addbtn.click();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOf(addbtn));

		WebElement savebtn = driver.findElement(By.xpath("//input[@data-uidsfdc='3']"));
		savebtn.click();

		WebElement lastactivity = driver.findElement(By.xpath("//div[@title='Last Activity']"));
		if (lastactivity.isDisplayed()) {
			System.out.println("Last activity column added");
		} else {
			System.out.println("Last activity column not displayed ");
		}

		// Recently Created
		WebElement viewdetail1 = driver.findElement(By.xpath("//div/select[@class='title']"));
		Select select6 = new Select(viewdetail1);
		String actviewdetail1 = select6.getFirstSelectedOption().getText();
		String expviewdetail1 = "xyz view1";
		System.out.println("Actviewdetail:" + actviewdetail1);
		TitleMatch(expviewdetail1, actviewdetail1, "New View title:");
		closeBrowser();
	}

	public void CreateAccount_5() {
		// Merge Accounts

		SalesForceLogin();

		WebElement alltabbar = driver.findElement(By.cssSelector("li#Account_Tab > a "));
		String acctext = alltabbar.getText();
		String expaccttext = "Accounts";
		TitleMatch(expaccttext, acctext, "Accounts title present in all tabs");
		alltabbar.click();

		WebElement mergeacc = driver.findElement(By.linkText("Merge Accounts"));
		mergeacc.click();

		// Titlecheck
		WebElement mergetitle = driver.findElement(By.xpath("//h1[contains(text(),'Merge My Accounts')]"));
		String accmergetitle = mergetitle.getText();
		String expmergetitle = "Merge My Accounts";
		TitleMatch(expmergetitle, accmergetitle, "Merge My Accounts");

		WebElement findacc = driver.findElement(By.cssSelector("#srch"));
		enterText(findacc, "King", "Account Names to merge");

		WebElement findaccbtn = driver.findElement(By.name("srchbutton"));
		findaccbtn.click();

		WebElement checkbox1 = driver.findElement(By.id("cid0"));
		checkbox(checkbox1, "Checkbox selected for first Account to Merge");

		WebElement checkbox2 = driver.findElement(By.id("cid1"));
		checkbox(checkbox2, "Checkbox selected for Second Account to Merge");

		WebElement nextbtn = driver.findElement(By.xpath("//div[@class='pbBottomButtons']/input[@name='goNext']"));
		clickElement(nextbtn, "Clicked Next button to Merge selected accpunts");

		WebElement mergebtn = driver.findElement(By.xpath("//div[@class='pbBottomButtons']/input[2]"));
		clickElement(mergebtn, "Clicked Merge button to Merge selected accpunts");

		Alert altext = SwitchToAlert();
		altext.accept();

		WebElement recentview = driver.findElement(By.id("hotlist_mode"));
		Select selectv = new Select(recentview);
		selectv.selectByVisibleText("Recently Viewed");

		List<WebElement> listtable = driver.findElements(By.xpath("//table[@class='list']/tbody/tr/th[1]"));
		for (WebElement listtab : listtable) {
			if (listtab.getText().equals("King")) {
				System.out.println("Recently merged account is displayed in Recently viewed page");
				break;
			}
		}

		closeBrowser();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CreateAccount obj = new CreateAccount();
		 obj.CreateAccount_1();
		 obj.CreateAccount_2();
		 obj.CreateAccount_3();
		 obj.CreateAccount_4();
		 obj.CreateAccount_5();
		 obj.CreateAccount_6();

	}

	public void CreateAccount_6() throws InterruptedException {
		// Accounts with last activity > 30 days
		SalesForceLogin();

		WebElement alltabbar = driver.findElement(By.cssSelector("li#Account_Tab > a "));
		String acctext = alltabbar.getText();
		String expaccttext = "Accounts";
		TitleMatch(expaccttext, acctext, "Accounts title present in all tabs");
		alltabbar.click();

		WebElement report = driver.findElement(By.linkText("Accounts with last activity > 30 days"));
		report.click();

		WebElement pagetitle = driver.findElement(By.cssSelector("h2.pageDescription"));
		String actpagetitle = pagetitle.getText();
		String exppagetitle = "Unsaved Report";
		TitleMatch(exppagetitle, actpagetitle, "Unsaved Report");

		Thread.sleep(2000);
		WebElement datecolumn = driver.findElement(By.id("ext-gen20"));
		datecolumn.click();
		Thread.sleep(2000);
		WebElement createddate = driver
				.findElement(By.xpath("//div[@id='ext-gen265']/div[contains(text(),'Created Date')]"));
		Actions action = new Actions(driver);
		action.moveToElement(createddate).click().build().perform();

		// From Date
		WebElement fromdt = driver.findElement(By.id("ext-gen152"));
		fromdt.click();
		Thread.sleep(1000);
		
		WebElement Fromtodaydt = driver.findElement(By.xpath("//table[@id='ext-comp-1112']/tbody/tr[2]/td[2]/em/button"));
		Fromtodaydt.click();
		
		// To Date
		WebElement todt = driver.findElement(By.id("ext-gen154"));
		todt.click();
		Thread.sleep(1000);
		WebElement totodaydt = driver.findElement(By.xpath("//table[@id='ext-comp-1114']/tbody/tr[2]/td[2]/em/button"));
		totodaydt.click();

		// save button
		WebElement savebtn = driver.findElement(By.id("ext-gen49"));
		savebtn.click();

		WebElement reportname = driver.findElement(By.xpath("//input[@name='reportName']"));
		enterText(reportname, "Created Date Report1", "Created Date Report1");

		WebElement reportuname = driver.findElement(By.xpath("//input[@name='reportDevName']"));
		reportuname.click();
		
		WebElement saveandrun = driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]"));
		clickElement(saveandrun, "Save and Run Report");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(saveandrun));

		WebElement reportpg = driver.findElement(By.xpath("//div[@class='content']/h1"));
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(reportpg));
		String actreptitle = reportpg.getText();
		String expreptitle = "Created Date Report";
		TitleMatch(expreptitle, actreptitle, "Report Detail Page");

		closeBrowser();   
		
	

	}

}
