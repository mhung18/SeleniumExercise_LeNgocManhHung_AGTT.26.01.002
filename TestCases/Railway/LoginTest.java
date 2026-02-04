package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class LoginTest extends BaseTest{

	@Test
	public void TC01() {
		System.out.println("User can log into Railway with valid username and password");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.goToLoginPage();
		
		String actualMsg = loginPage.login(userInfo).getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;

		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
	
	@Test
	public void TC02() {
		System.out.println("User cannot login with blank \"Username\" textbox");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.login(
				"",
				Constant.PASSWORD);
		String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
		
		Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC03() {
		System.out.println("User cannot log into Railway with invalid password");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.login(Constant.USERNAME,"invalid-password");
		String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
		
		Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC04() {
		System.out.println("System shows message when user enters wrong password many times");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.login(Constant.USERNAME,"invalid-password");
		
		loginPage.login(Constant.USERNAME,"invalid-password");
		loginPage.login(Constant.USERNAME,"invalid-password");
		loginPage.login(Constant.USERNAME,"invalid-password");
		
		String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
		String expectedWarningMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		
		Assert.assertEquals(actualErrorMsg.trim(), expectedWarningMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC05() {
		System.out.println("User can't login with an account hasn't been activated");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = homePage.goToRegisterPage();
		
//		utils.scrollByPixel(Constant.WEBDRIVER, 300);
		
		registerPage.regiter(
				"logigear123@agest.vn", 
				"123456789", 
				"123456789", 
				"E20001244"
		);
		
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.login("logigear123@agest.vn", "123456789");
		
		String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
		String expectedWarningMsg = "Invalid username or password. Please try again.";
		
		Assert.assertEquals(actualErrorMsg.trim(), expectedWarningMsg.trim(),"Error message is not displayed as expected");
	}
}
