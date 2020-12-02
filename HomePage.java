package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import base.BaseClass;

@Test(dataProvider = "fetchdata")	
public class HomePage extends BaseClass  {
	
	public HomePage(RemoteWebDriver driver) {
		
		this.driver=driver;
		
	}	
	
	public HomePage ClickGlobalactions() {	 
		try {
			driver.findElementByXPath("//ul[@class=\"slds-global-actions\"]//li[3]//a").click();
			System.out.println("Globalactions clicked Successfully");

		} catch (Exception e) {
			System.out.println("Globalactions clicking failed");
			e.printStackTrace();
		}
		return this;

	}
	
	public HomePage ClickNewTask() {	 

		try {
			driver.findElementByXPath("//span[text()='New Task']").click();
			System.out.println("NewTask button clicked ");

		} catch (Exception e) {
			System.out.println("Unable to Click New Task Button ");
			e.printStackTrace();
		}  
		return this;

	
	}
	
	public HomePage searchcontactswithcontactname(String Contact) {
		
		try {
			driver.findElementByXPath("//input[@placeholder='Search Contacts...']").sendKeys(Contact);
			System.out.println("Searching contact name in Input filed");

		} catch (Exception e) {
			System.out.println("Search Contact name failed");
			e.printStackTrace();
		}
		//return String;
		return this;

	}
	
	public HomePage selectfirstcontactname(String contact) {
		
		try {
			driver.findElementByXPath("(//div[@title='"+contact+"'])[1]").click();
			System.out.println("Selected first contact name displayed");

		} catch (Exception e) {
			System.out.println("First contact name not displayed");
			e.printStackTrace();
		}
		return this;

	}
	public HomePage clicksave() throws InterruptedException {
		try {
			driver.findElementByXPath("(//span[text()='Save'])[2]").click();
			System.out.println("Save button clicked");

		} catch (Exception e) {
			System.out.println("Save button not clicked");
			e.printStackTrace();
		}
		return this;
	}
	
  public TaskPage clickOnTaskCreatedLink() {
	  
		try {
			driver.findElementByXPath("//a[@title=\"Task\"]").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return new TaskPage(driver);
  }
 public HomePage Applauncher() {

driver.findElementByXPath("//span[contains(text(),'App Launcher')]/parent::div").click();
return this;

  }
	
 public HomePage viewall() {
driver.findElementByXPath("//button[text()='View All']").click();
return this;


	  }
 public HomePage Clicksales() throws InterruptedException {
	driver.findElementByXPath("//span/p[text()='Sales']").click();
	Thread.sleep(10000);
	return this;

	  }
	  
 

}

