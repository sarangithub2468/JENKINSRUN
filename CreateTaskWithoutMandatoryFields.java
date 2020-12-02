package testCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.TaskPage;

public class CreateTaskWithoutMandatoryFields extends BaseClass {
	
	
	@BeforeTest
	public void setData() {
		fileName = "TaskCreate";

	}

@Test(dataProvider = "fetchdata")
public void createtask(String username,String password,String contact,String comments,String subjectTextexpected) throws InterruptedException {
	
		LoginPage login = new LoginPage(driver);		
		login.enterusername().enterpassword().clicklogin();
		
		HomePage home = new HomePage(driver);
		home.ClickGlobalactions().ClickNewTask().searchcontactswithcontactname(contact).selectfirstcontactname(contact).
		clicksave().clickOnTaskCreatedLink();
		
		TaskPage task = new TaskPage(driver);
		task.editcomments().entercomments(comments).ClickSaveInTaskPage().verifyErrorMessage(subjectTextexpected);
		
		
		
		
	}



}
