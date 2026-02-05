package Railway;

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
				
		Utilities.scrollByPixel(300);
		
		registerPage.register(userInfo);		
	}
}
