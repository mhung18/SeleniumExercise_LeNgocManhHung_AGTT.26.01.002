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
		
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;

		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
	
	@Test
	public void TC02() {
		System.out.println("User cannot login with blank \"Username\" textbox");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.login("",Constant.PASSWORD);
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
}
