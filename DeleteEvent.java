package testCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewEventPage;
import pages.SalesPage;

public class DeleteEvent  extends BaseClass {
	
	@BeforeClass
	public void setData() {
		fileName = "Deleteeventdata";

	}
	
	@Test(dataProvider = "fetchdata")
	public void createtask(String username,String password,String startTime,String endTime,String subject) throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);		
		login.enterusername().enterpassword(password).clicklogin();
		
		HomePage home = new HomePage(driver);
		home.Applauncher().viewall().Clicksales();
		
		
		SalesPage sales = new SalesPage(driver);
		sales.ClickMore().ClickCalendar();
		
		
		NewEventPage event = new NewEventPage(driver);
		event.ClickNewEvent().selectstarttime(startTime).entersubject(subject).selectendtime(endTime).
		ClicksaveinNewEvent().DeleteEvent(subject).VerifyDeleteEvent(subject);
		
		
		
		
	
}
	
}
