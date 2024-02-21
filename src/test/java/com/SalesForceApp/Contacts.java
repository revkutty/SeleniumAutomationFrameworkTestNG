package com.SalesForceApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Contacts extends SFLogin {
	
	public  void Contacts_1() {
		// TODO Auto-generated method stub
		SalesForceLogin();

		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		String actcontacttitle = driver.getTitle();
		System.out.println("contact title:" + actcontacttitle);
		String expcontacttitle = "Contacts: Home ~ Salesforce - Developer Edition";
		TitleMatch(expcontacttitle, actcontacttitle, "contacts: Home page");

		WebElement newbtn = driver.findElement(By.cssSelector("td.pbButton>input.btn"));
		newbtn.click();

		WebElement lastname = driver.findElement(By.id("name_lastcon2"));
		enterText(lastname, "lastname", "Last name for new contact");
		
		WebElement accname = driver.findElement(By.xpath("//input[@id='con4']"));
		enterText(accname, "king6", "Account Name for new contact");
		
		WebElement savebtn = driver.findElement(By.cssSelector("#bottomButtonRow > input:nth-child(1)"));
		savebtn.click();

		String actcontactpg = driver.getTitle();
		String expcontactpg = "Contact: lastname ~ Salesforce - Developer Edition";
		TitleMatch(expcontactpg, actcontactpg, "Contact Page : ");

		closeBrowser();
					
	}
	
	public void Contacts_2() throws InterruptedException {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		String actcontacttitle = driver.getTitle();
		System.out.println("contact title:" + actcontacttitle);
		String expcontacttitle = "Contacts: Home ~ Salesforce - Developer Edition";
		TitleMatch(expcontacttitle, actcontacttitle, "contacts: Home page");

		WebElement createnewview = driver.findElement(By.xpath("//span[@class='fFooter']"));
		createnewview.click();
		
		WebElement viewname = driver.findElement(By.id("fname"));
		enterText(viewname, "Prince view1", "Viewname");

		WebElement viewuniqname = driver.findElement(By.id("devname"));
		Thread.sleep(2000);
		enterText(viewuniqname, "Prince_view1", "View unique name");

		WebElement savebtn = driver.findElement(By.xpath("//input[@data-uidsfdc='3']"));
		savebtn.click();
		// Recently Created
		WebElement viewdetail = driver.findElement(By.cssSelector("select.title"));
		Select select = new Select(viewdetail);
		String actviewdetail = select.getFirstSelectedOption().getText();
		String expviewdetail = "Prince view1";
		System.out.println("Actviewdetail:" + actviewdetail);
		TitleMatch(expviewdetail, actviewdetail, "New View title:");
		closeBrowser();

	}
	
	
	public void Contacts_3() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		String actcontacttitle = driver.getTitle();
		System.out.println("contact title:" + actcontacttitle);
		String expcontacttitle = "Contacts: Home ~ Salesforce - Developer Edition";
		TitleMatch(expcontacttitle, actcontacttitle, "contacts: Home page");
		
		WebElement recentview = driver.findElement(By.xpath("//select[@id='hotlist_mode']/option[contains(text(),'Recently Created')]"));
		recentview.click();
		
		// Recently Created
				WebElement viewdetail = driver.findElement(By.xpath("//select[@id='fcf']"));
				Select select3 = new Select(viewdetail);
				String actviewdetail = select3.getFirstSelectedOption().getText();
				String expviewdetail = "Prince view1";
				System.out.println("Actviewdetail:" + actviewdetail);
				TitleMatch(expviewdetail, actviewdetail, "New View title:");
				closeBrowser();
	}

	
	public void Contacts_4() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		String actcontacttitle = driver.getTitle();
		System.out.println("contact title:" + actcontacttitle);
		String expcontacttitle = "Contacts: Home ~ Salesforce - Developer Edition";
		TitleMatch(expcontacttitle, actcontacttitle, "contacts: Home page");
		
		WebElement viewdetail = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select select4 = new Select(viewdetail);
		select4.selectByVisibleText("My Contacts");
		
		String actmycontact = driver.getTitle();
		System.out.println("actmycontact:" + actmycontact);
		String expmycontact = "Contacts: Home ~ Salesforce - Developer Edition";
		TitleMatch(expmycontact, actmycontact, "My Contact Detail Page : ");

		closeBrowser();
	}

	public void Contacts_5() {
		// TODO Auto-generated method stub
		SalesForceLogin();
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		String actcontacttitle = driver.getTitle();
		System.out.println("contact title:" + actcontacttitle);
		String expcontacttitle = "Contacts: Home ~ Salesforce - Developer Edition";
		TitleMatch(expcontacttitle, actcontacttitle, "contacts: Home page");
		
		WebElement recentcont = driver.findElement(By.xpath("//th[@scope='row']/a[contains(text(),\"XYZ\")]"));
		recentcont.click();
		
		WebElement selectedcont = driver.findElement(By.cssSelector("h2.topName"));
		System.out.println("selected contact:" + selectedcont.getText());
		String selectedcont1 = driver.getTitle();
		System.out.println("contact title:" + selectedcont1);
		String expselectedcont = "Contact: XYZ ~ Salesforce - Developer Edition";
		TitleMatch(expselectedcont, selectedcont1, "contacts: selected contact page");
		closeBrowser();
	}

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Contacts obj = new Contacts();
	//	obj.Contacts_1();
	//	obj.Contacts_2();
	//	obj.Contacts_3();
	//	obj.Contacts_4();
	//	obj.Contacts_5();
		obj.Contacts_6();
	}

	public void Contacts_6() throws InterruptedException {
		// TODO Auto-generated method stub
		
		SalesForceLogin();
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		String actcontacttitle = driver.getTitle();
		System.out.println("contact title:" + actcontacttitle);
		String expcontacttitle = "Contacts: Home ~ Salesforce - Developer Edition";
		TitleMatch(expcontacttitle, actcontacttitle, "contacts: Home page");

		WebElement createnewview = driver.findElement(By.xpath("//span[@class='fFooter']"));
		createnewview.click();
		
	//	WebElement viewname = driver.findElement(By.id("fname"));
	//	enterText(viewname, "Prince view1", "Viewname");

		WebElement viewuniqname = driver.findElement(By.id("devname"));
		Thread.sleep(2000);
		enterText(viewuniqname, "EFGH", "View unique name");

		WebElement savebtn = driver.findElement(By.xpath("//input[@data-uidsfdc='3']"));
		savebtn.click();
		
		WebElement errormsg = driver.findElement(By.xpath("//div[contains(text(),' You must enter a value')]"));
		String blankname = getTextFromElement(errormsg, "Enter Value:");
		System.out.println("Error Message:" + blankname);
		
			
		closeBrowser();
	}

	
	
	
	

}
