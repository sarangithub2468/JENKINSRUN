package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {
	

	public LoginPage(RemoteWebDriver driver) {
		
		this.driver=driver;
	}
	
	
public LoginPage enterusername(String username) {	
	
	
	try {
			driver.findElementById("username").sendKeys(username);
			System.out.println("Username entered Successfully");
		} 
				
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Username incorrect");
			e.printStackTrace();
		}
	 return this;
 }

public LoginPage enterusername() {
	 enterusername(userName);
	 return this;
	
}

public LoginPage enterpassword(String password) {	
	try {
		driver.findElementById("password").sendKeys(password);
		System.out.println("Password entered Successfully");

	} catch (Exception e) {
		System.out.println("Password incorrect");
		e.printStackTrace();
	}
	 return this;

}	

public LoginPage enterpassword() {
	enterpassword(passWord);
	 return this;
	
}
	
public HomePage clicklogin() {		
		try {
			driver.findElementById("Login").click();
			System.out.println("Login Successful");

		} catch (Exception e) {
			System.out.println("Login Failed");
			e.printStackTrace();
		}
		//HomePage home=  new HomePage();
		 return new HomePage(driver);


	}
		
		
		
	

}
