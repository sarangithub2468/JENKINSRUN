package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;

public class TaskPage extends BaseClass {
	
	public TaskPage(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public TaskPage editcomments() {
		
		try {
			driver.findElementByXPath("//button[@title=\"Edit Comments\"]").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;

	}
	public TaskPage entercomments(String comments) {
		
		try {
			driver.findElementByXPath("(//*[@role=\"textbox\"])[3]").sendKeys(comments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return this;

	}
	
	public TaskPage ClickSaveInTaskPage() {
		
		driver.findElementByXPath("//button[@title=\"Save\"]").click();
		return this;

	}
	
	public TaskPage verifyErrorMessage(String subjectTextexpected) {
		String subjecttextactual = driver.findElementByXPath("//div[text()='Complete this field.']").getText();
		System.out.println(subjecttextactual);
		if(subjecttextactual.equals(subjectTextexpected)) {
			System.out.println("Expected Result Complete this field alert message is displayed for the Subject field-Verification Successful");
		}
		else{
			System.out.println("Expected Result Complete this field alert message is not displayed for the Subject field");
		}
		return this;
		
	}

}
