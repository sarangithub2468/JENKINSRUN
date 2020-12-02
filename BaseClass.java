package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadDataFromExcel;

public class BaseClass {

public RemoteWebDriver driver;
public static String fileName;
public static Properties properties;

public static String userName;
public  static String passWord;
public  static String url;
public  static String browser;

public Properties loadpropertyfile() throws IOException {	
	FileInputStream file = new FileInputStream("./src/main/resources/Resource/properties");
	//Properties prop = new Properties();
	properties = new Properties();
	properties.load(file);	
	return properties;      	
}


@BeforeSuite
public void launchbrowser() throws InterruptedException, IOException {	
	loadpropertyfile();
	PropertyConfigurator.configure("./src/main/resources/Resource/properties");
	url = properties.getProperty("Url");
	System.out.println(url);
	 userName = properties.getProperty("username");
	System.out.println(userName);
	passWord  = properties.getProperty("password");
	System.out.println(passWord);	
	browser =properties.getProperty("browser");
	System.out.println(browser);
	//String url = "http://www.gmail.com";

	if (browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
	} else if (browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options);
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



}	
@AfterSuite
/*public void closebrowser() {
	driver.close();
}		*/

@DataProvider(name = "fetchdata")
public String[][] DataProvider() throws IOException {
	ReadDataFromExcel read = new ReadDataFromExcel();
	String[][] data = read.ReadData(fileName);
	return data;

}



}