package com.SalesForceApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Leads extends SFLogin {

	public void Leads_1() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement leadstab = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		leadstab.click();
		String actlinktitle = driver.getTitle();
		String explinktitle = "Leads: Home ~ Salesforce - Developer Edition";
		TitleMatch(explinktitle, actlinktitle, "Leads: Home  page");
		closeBrowser();

	}

	public void Leads_2() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		List<String> expdropdownvalues = new ArrayList<String>();
		expdropdownvalues.add("All Open Leads");
		expdropdownvalues.add("My Unread Leads");
		expdropdownvalues.add("Recently Viewed Leads");
		expdropdownvalues.add("Today's Leads");
		expdropdownvalues.add("View - Custom 1");
		expdropdownvalues.add("View - Custom 2");

		WebElement leadstab = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		leadstab.click();

		WebElement viewdropdown = driver.findElement(By.id("fcf"));
		Select select = new Select(viewdropdown);

		List<String> actdropdownvalues = new ArrayList<String>();
		for (WebElement alloptions : select.getOptions()) {
			actdropdownvalues.add(alloptions.getText());
		}

		for (int i = 0; i < actdropdownvalues.size(); i++) {
			if ((actdropdownvalues.get(i)).equals((expdropdownvalues).get(i))) {
				System.out.println("Actual Values: " + actdropdownvalues.get(i) + " & Expected values : "
						+ expdropdownvalues.get(i));
			} else {
				System.out.println("Actual dropdown Lead values not matched with expected values");
			}
		}
	}

	public void Leads_3() {

		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement leadstab = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		leadstab.click();
		String actlinktitle = driver.getTitle();
		String explinktitle = "Leads: Home ~ Salesforce - Developer Edition";
		TitleMatch(explinktitle, actlinktitle, "Leads: Home  page");

		WebElement viewdropdown = driver.findElement(By.id("fcf"));
		Select select = new Select(viewdropdown);
		select.selectByVisibleText("My Unread Leads");

		WebElement gobtn = driver.findElement(By.xpath("//input[@value=' Go! ' and @class='btn']"));
		gobtn.click();

		SalesForceLogout();
		SalesForceLogin();
		WebElement leadstab1 = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		leadstab1.click();
		String actlinktitle1 = driver.getTitle();
		String explinktitle1 = "Leads: Home ~ Salesforce - Developer Edition";
		TitleMatch(explinktitle1, actlinktitle1, "Leads: Home  page");

		WebElement gobtn1 = driver.findElement(By.xpath("//input[@value=' Go! ' and @class='btn']"));
		gobtn1.click();

		WebElement viewdropdown1 = driver.findElement(By.xpath("//select[@name='fcf' and @class='title']"));
		Select select1 = new Select(viewdropdown1);
		WebElement displayedLead = select1.getFirstSelectedOption();
		String displayvalue = displayedLead.getText();
		System.out.println("Default view :" + displayvalue);

	}

	public void Leads_4() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement leadstab = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		leadstab.click();
		String actlinktitle = driver.getTitle();
		String explinktitle = "Leads: Home ~ Salesforce - Developer Edition";
		TitleMatch(explinktitle, actlinktitle, "Leads: Home  page");

		WebElement viewdropdown = driver.findElement(By.id("fcf"));
		Select select = new Select(viewdropdown);
		select.selectByVisibleText("Today's Leads");

		WebElement gobtn = driver.findElement(By.xpath("//input[@value=' Go! ' and @class='btn']"));
		gobtn.click();

		WebElement viewdropdown1 = driver.findElement(By.xpath("//select[@name='fcf' and @class='title']"));
		Select select1 = new Select(viewdropdown1);
		WebElement displayedLead = select1.getFirstSelectedOption();
		String displayvalue = displayedLead.getText();
		System.out.println("Default view :" + displayvalue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leads obj = new Leads();
		obj.Leads_1();
		obj.Leads_2();
		obj.Leads_3();
		obj.Leads_4();
		obj.Leads_5();
	}

	public void Leads_5() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement leadstab = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		leadstab.click();
		String actlinktitle = driver.getTitle();
		String explinktitle = "Leads: Home ~ Salesforce - Developer Edition";
		TitleMatch(explinktitle, actlinktitle, "Leads: Home  page");

		WebElement recentleadsnewbtn = driver.findElement(By.cssSelector("td.pbButton>input.btn"));
		recentleadsnewbtn.click();

		WebElement lastname = driver.findElement(By.id("name_lastlea2"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(lastname));
		String actnewleadtitle = driver.getTitle();
		String expnewleadtitle = "Lead Edit: New Lead ~ Salesforce - Developer Edition";
		TitleMatch(expnewleadtitle, actnewleadtitle, "New Lead Title: ");

		enterText(lastname, "ABCD", "Last Name ");
		WebElement company = driver.findElement(By.id("lea3"));
		enterText(company, "ABCD", "Company Name ");
		WebElement savebtn = driver.findElement(By.cssSelector("td#bottomButtonRow>input[name='save']"));
		savebtn.click();

		String actLeaddetailpg = driver.getTitle();
		String expLeaddetailpg = "Lead: ABCD ~ Salesforce - Developer Edition";
		TitleMatch(expLeaddetailpg, actLeaddetailpg, "Lead Detail Page : ");

	}

}
