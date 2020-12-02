package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;

public class NewEventPage extends BaseClass {
	
	
	public NewEventPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	 public NewEventPage ClickNewEvent() {
			driver.findElementByXPath("//button[text()='New Event']").click();
			return this;
	  }  
	    	  
	  public NewEventPage selectstarttime(String startTime) throws InterruptedException {
		  
			WebElement startdateinputfield = driver.findElementByXPath("(//input[@role=\"textbox\"])[3]");
		    //WebElement startdateelement = driver.findElementByXPath("(//span[text()='"+startTime+"'])[2]");
			startdateinputfield.click();
			startdateinputfield.clear();
			startdateinputfield.sendKeys(startTime);
		    Thread.sleep(1000);  
			driver.findElementByXPath("//span[@title='"+startTime+"']");
			return this;

		    }
	  
	  
	  public NewEventPage selectendtime(String endTime) throws InterruptedException {
		  	JavascriptExecutor js = (JavascriptExecutor) driver;        
	        js.executeScript("arguments[0].scrollIntoView();", driver.findElementByXPath("(//label[text()='Time'])[2]"));			
			Thread.sleep(2000);	    
		    //select end time as 11 am	
		    WebElement enddateinputfield =driver.findElementByXPath("(//input[@role=\"textbox\"])[4]");
		    enddateinputfield.click();
		    enddateinputfield.clear();
		    enddateinputfield.sendKeys(endTime);	
		    Thread.sleep(1000);  
		    driver.findElementByXPath("//span[@title='"+endTime+"']");
		    Thread.sleep(2000);		    
			return this;

	    }
	  
	  public NewEventPage entersubject(String subject) throws InterruptedException {
		  
		  	driver.findElementByXPath("(//input[@role=\"textbox\"]/..)[2]").click();
		    //driver.findElementByXPath("(//input[@role=\"textbox\"]/..)[2]").clear();
		    driver.findElementByXPath("(//input[@role=\"textbox\"])[2]").sendKeys(subject);
			
			Thread.sleep(2000);	
			return this;

	    }
	
	  public NewEventPage ClicksaveinNewEvent() throws InterruptedException   {

		driver.findElementByXPath("//span[text()='Save']").click();	
		Thread.sleep(2000);

		return this;
}
	  public NewEventPage DeleteEvent(String subject) throws InterruptedException   {

		  JavascriptExecutor js2 = (JavascriptExecutor) driver;        
			js2.executeScript("arguments[0].scrollIntoView();", driver.findElementByXPath("//span[text()='8am']"));			
			Thread.sleep(2000);		   
			WebElement element = driver.findElementByXPath("//div[text()='10–11am']/../..//a[text()='"+subject+"']");
			Actions  ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
			Thread.sleep(2000);
			WebElement element2 = driver.findElementByXPath("//a/div[text()='Delete']");
			//ac.moveToElement(element2).click().perform();
			element2.click();
		    Thread.sleep(5000);	   
			//Click delete
			driver.findElementByXPath("//button/span[text()='Delete']").click();
			return this;
	
}
	  public NewEventPage VerifyDeleteEvent(String subject) throws InterruptedException   {

	  
		if (driver.findElementByXPath("//span[contains(text(),'"+subject+"')]").isDisplayed()) {
			System.out.println("Event is deleted that was displayed between time 10 AM to 11AM-Verification Successful");	

		} else 
		{
			System.out.println("Event is not deleted");	
		}	
	  return this;
	  
}
	  
}
