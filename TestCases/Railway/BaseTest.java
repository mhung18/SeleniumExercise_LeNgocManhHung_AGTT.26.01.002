package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Common.Utilities;
import Constant.Constant;

public abstract class BaseTest {
	UserInfo userInfo = new UserInfo(
			Constant.USERNAME, 
			Constant.PASSWORD, 
			Constant.PASSPORTID);
	
	TicketInfo ticketInfo = new TicketInfo(
			Constant.DEPARTDATE, 
			Constant.DEPARTSTATION, 
			Constant.ARRIVESTATION, 
			Constant.SEATTYPE, 
			Constant.TICKETAMOUNT);
	
	Utilities utils = new Utilities();

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
}
