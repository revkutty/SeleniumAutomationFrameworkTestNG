package com.SalesForceApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Oppertunities extends SFLogin {

	public void Opper_1() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		List<String> expdropdownvalues = new ArrayList<String>();
		expdropdownvalues.add("All Opportunities");
		expdropdownvalues.add("Closing Next Month");
		expdropdownvalues.add("Closing This Month"); 
		expdropdownvalues.add("My Opportunities");
		expdropdownvalues.add("New Last Week");
		expdropdownvalues.add("New This Week");
		expdropdownvalues.add("Opportunity Pipeline");
		expdropdownvalues.add("Private");
		expdropdownvalues.add("Recently Viewed Opportunities");
		expdropdownvalues.add("Won");

		WebElement oppertab = driver.findElement(By.linkText("Opportunities"));
		oppertab.click();
		String actoppertitle = driver.getTitle();
		String expoppertitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		TitleMatch(expoppertitle, actoppertitle, "Opportunities: Home page");

		WebElement opperdropdown = driver.findElement(By.id("fcf"));
		Select select = new Select(opperdropdown);

		List<String> actdropdownvalues = new ArrayList<String>();
		List<WebElement> listoption = select.getOptions();
		for (WebElement opt : listoption) {
			actdropdownvalues.add(opt.getText());
			System.out.println("actdropdownvalues:" + actdropdownvalues);
			// System.out.println("size:" + actdropdownvalues.size());
		}

		for (int i = 0; i < actdropdownvalues.size(); i++) {
			if ((actdropdownvalues.get(i)).equals((expdropdownvalues).get(i))) {
				System.out.println("Actual Values: " + actdropdownvalues.get(i) + " & Expected values : "
						+ expdropdownvalues.get(i));
			} else {
				System.out.println("Actual dropdown Oppertunity values not matched with expected values");
			}
		}

		closeBrowser();
	}

	public void Opper_2() {
		// TODO Auto-generated method stub

		SalesForceLogin();
		WebElement oppertab = driver.findElement(By.linkText("Opportunities"));
		oppertab.click();
		String actoppertitle = driver.getTitle();
		String expoppertitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		TitleMatch(expoppertitle, actoppertitle, "Opportunities: Home page");

		WebElement recentoppnewbtn = driver.findElement(By.cssSelector("td.pbButton>input.btn"));
		recentoppnewbtn.click();

		WebElement oppname = driver.findElement(By.xpath("//input[@id='opp3']"));
		enterText(oppname, "Opper1", "Oppertunity name");

		// WebElement oppacctname = driver.findElement(By.xpath("//input[@id='opp4']"));
		// enterText(oppacctname, "OpperAcct1", "Oppertunity Account Name");

		/*
		 * WebElement oppclosedt = driver.findElement(By.xpath("//a[@tabindex='7']"));
		 * oppclosedt.click();
		 */

		OppCloseDate();

		WebElement oppstage = driver.findElement(By.xpath("//select[@id='opp11']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(oppstage));
		Select select = new Select(oppstage);
		select.selectByVisibleText("Value Proposition");

		WebElement oppprob = driver.findElement(By.xpath("//input[@id='opp12']"));
		if (oppprob.isDisplayed()) {
			System.out.println("Auto Probability: " + oppprob.getAttribute("value"));
		} else {
			enterText(oppprob, "50", "Oppertunity Probability");
		}

		WebElement oppleadsource = driver.findElement(By.xpath("//select[@id='opp6']"));
		Select select1 = new Select(oppleadsource);
		select1.selectByVisibleText("Purchased List");

		// WebElement oppprimarysrc =
		// driver.findElement(By.xpath("//input[@id='opp17']"));
		// enterText(oppprimarysrc, "xyz1", "Oppertunity Primary Campaign Source");

		WebElement oppsavebtn = driver.findElement(By.cssSelector("td#bottomButtonRow>input[name='save']"));
		oppsavebtn.click();

		String actoppdetailpg = driver.getTitle();
		String expoppdetailpg = "Opportunity: Opper1 ~ Salesforce - Developer Edition";
		TitleMatch(expoppdetailpg, actoppdetailpg, "Opportunity Detail Page : ");

		closeBrowser();
	}

	public void Opper_3() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement oppertab = driver.findElement(By.linkText("Opportunities"));
		oppertab.click();
		String actoppertitle = driver.getTitle();
		String expoppertitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		TitleMatch(expoppertitle, actoppertitle, "Opportunities: Home page");

		WebElement opperpipeline = driver.findElement(By.linkText("Opportunity Pipeline"));
		opperpipeline.click();

		String actopppipelinerpt = driver.getTitle();
		String expopppipelinerpt = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		TitleMatch(expopppipelinerpt, actopppipelinerpt, "Opportunity Pipeline Report Page : ");

		closeBrowser();

	}

	public void Opper_4() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement oppertab = driver.findElement(By.linkText("Opportunities"));
		oppertab.click();
		String actoppertitle = driver.getTitle();
		String expoppertitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		TitleMatch(expoppertitle, actoppertitle, "Opportunities: Home page");

		WebElement opperstuck = driver.findElement(By.linkText("Stuck Opportunities"));
		opperstuck.click();

		String actopperstuck = driver.getTitle();
		String expopperstuck = "Stuck Opportunities ~ Salesforce - Developer Edition";
		TitleMatch(expopperstuck, actopperstuck, "Stuck Opportunities Report Page : ");

		closeBrowser();

	}

	public void Opper_5() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement oppertab = driver.findElement(By.linkText("Opportunities"));
		oppertab.click();
		String actoppertitle = driver.getTitle();
		String expoppertitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		TitleMatch(expoppertitle, actoppertitle, "Opportunities: Home page");

		WebElement qtrinterval = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(qtrinterval));
		Select select = new Select(qtrinterval);
		select.selectByVisibleText("Current and Next FQ");

		WebElement qtrinclude = driver.findElement(By.xpath("//select[@id='open']"));
		wait.until(ExpectedConditions.visibilityOf(qtrinclude));
		Select select1 = new Select(qtrinclude);
		select1.selectByVisibleText("Open Opportunities");

		WebElement runreport = driver.findElement(By.xpath("//input[@value='Run Report']"));
		runreport.click();

		String actqtrrpt = driver.getTitle();
		String expqtrrpt = "Opportunity Report ~ Salesforce - Developer Edition";
		TitleMatch(expqtrrpt, actqtrrpt, "Quarterly Summary Report Page : ");

		WebElement oppreportrange = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		Select select2 = new Select(oppreportrange);
		WebElement actrptrange = select2.getFirstSelectedOption();
		System.out.println("actrptrange: " + actrptrange.getText());

		WebElement oppreportstatus = driver.findElement(By.xpath("//select[@id='open']"));
		Select select3 = new Select(oppreportstatus);
		WebElement status = select3.getFirstSelectedOption();
		System.out.println("Opportunity Status Report: " + status.getText());

		closeBrowser();

	}

	public void OppCloseDate() {
		// TODO Auto-generated method stub
		WebElement oppclosedt = driver.findElement(By.xpath("//input[@id='opp9']"));
		oppclosedt.click();

		WebElement closedt = driver.findElement(By.cssSelector("#calMonthPicker"));
		Select selectm = new Select(closedt);
		selectm.selectByVisibleText("July");

		WebElement yearpic = driver.findElement(By.cssSelector("#calYearPicker"));

		Select selecty = new Select(yearpic);
		selecty.selectByValue("2025");

		// column size ----- #datePickerCalendar > tbody > tr:nth-child(1) > th
		// Row size ----- //*[@id='datePickerCalendar']//tr
		// alldata ---- //*[@id='datePickerCalendar']//tr/td

		List<WebElement> allheaders = driver
				.findElements(By.cssSelector("#datePickerCalendar > tbody > tr:nth-child(1) > th"));
		int cols = allheaders.size();
		System.out.println("allheaders size:" + cols);

		List<WebElement> allrows = driver.findElements(By.xpath("//*[@id='datePickerCalendar']//tr"));
		int rowcnt = allrows.size();
		System.out.println("allrows size:" + rowcnt);

	//	Thread.sleep(2000);

		List<WebElement> columns = driver.findElements(By.xpath("//*[@id='datePickerCalendar']//tr/td"));

		for (WebElement cell : columns) {
			// Select 17th Date
			if (cell.getText().equals("17")) {
				cell.click();
				break;
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Oppertunities obj = new Oppertunities();
		// obj.Opper_1();
		 obj.Opper_2();
		// obj.Opper_3();
		// obj.Opper_4();
		// obj.Opper_5();
		

	}

}
