package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;

public class RegisterTest extends BaseTest{
	
	@Test
	public void TC02() throws InterruptedException {
		System.out.println("User can register with valid information");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = new RegisterPage();
		homePage.goToRegisterPage();
				
		utils.scrollByPixel(Constant.WEBDRIVER, 300);
		
		registerPage.regiter(
				userInfo.getUserEmail(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassportId()
		);		
	}
}
