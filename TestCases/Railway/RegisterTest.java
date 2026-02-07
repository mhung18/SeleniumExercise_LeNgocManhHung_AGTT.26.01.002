package Railway;

import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuPage;

public class RegisterTest extends BaseTest{
	UserInfo userInfo = new UserInfo(
			Constant.USERNAME, 
			Constant.PASSWORD, 
			Constant.PASSPORTID);
	
	@Test
	public void TC02(){
		System.out.println("User can register with valid information");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = new RegisterPage();
		homePage.goToPage(MenuPage.REGISTER, RegisterPage.class);
				
		Utilities.scrollByPixel(300);
		
		registerPage.regiter(
				userInfo.getUserEmail(),
				userInfo.getUserPassword(),
				userInfo.getUserPassword(),
				userInfo.getUserPassportId());		
	}
}