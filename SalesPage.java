package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;

public class SalesPage extends BaseClass{
	
	
	public SalesPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	  public SalesPage ClickMore() {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", driver.findElementByXPath("//a/span[text()='More']"));
			return this;
	  }  
	  public SalesPage ClickCalendar() throws InterruptedException {
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", driver.findElementByXPath("(//span[text()='Calendar'])[2]"));
			Thread.sleep(5000);
			return this;

	  } 
	  
	  public SalesPage ClickNewEvent() throws InterruptedException {
		  driver.findElementByXPath("//button[text()='New Event']").click();
			return this;

	  } 
	  public NewEventPage VerifyDeleteevent(String subject) throws InterruptedException   {

		  if (driver.findElementByXPath("//span[contains(text(),'"+subject+"')]").isDisplayed()) {
				System.out.println("Event is deleted that was displayed between time 10 AM to 11AM-Verification Successful");	

			} else 
			{
				System.out.println("Event is not deleted");	
			}	
		  return new NewEventPage(driver);
		  }
	
	
}
