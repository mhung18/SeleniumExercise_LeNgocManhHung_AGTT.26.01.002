package Railway;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Common.Utilities;
import Constant.Constant;
import Guerrillamail.MainPage;

public abstract class BaseTest {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}
	
	public UserInfo createAndActiveAccount() {		
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = homePage.goToRegisterPage();
		
		String randomEmail = Utilities.generateRandomEmail();
		registerPage.regiter(
				randomEmail, 
				Constant.PASSWORD, 
				Constant.PASSWORD, 
				Constant.PASSPORTID
		);
		
		Constant.WEBDRIVER.switchTo().newWindow(WindowType.TAB).get(Constant.GURERRILLAMAIL_URL);
		MainPage mainPageMailWeb = new MainPage();
		mainPageMailWeb.setEmailName(Utilities.getEmailPartName(randomEmail));
		mainPageMailWeb.activeAccount();
		
		return new UserInfo(
				randomEmail, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
	}
	
}
