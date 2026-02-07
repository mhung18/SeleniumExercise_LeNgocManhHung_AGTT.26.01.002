package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;

public class LoginTest extends BaseTest{
	@Test
	public void TC01() {
		UserInfo userInfo = new UserInfo(
				Constant.USERNAME, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		String expectedMsg = "Welcome " + userInfo.getUserEmail();
		
		System.out.println("User can log into Railway with valid username and password");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage("Login", LoginPage.class);
		
		System.out.println("3. Enter valid Email and Password");
		System.out.println("4. Click on \"Login\" button");
		String actualMsg = loginPage.login(userInfo).getWelcomeMessage();
		
		System.out.println("VP: User is logged into Railway. Welcome user message is displayed.");
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
		
	@Test
	public void TC02() {
		UserInfo userInfo = new UserInfo(
				Constant.BLANKFIELD, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
		
		System.out.println("User cannot login with blank \"Username\" textbox");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage("Login", LoginPage.class);
		
		System.out.println("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox ");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());
		String actualErrorMsg = loginPage.getTextOfElement(loginPage.getLblLoginErrorMsg());
		
		System.out.println("VP: User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
		Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMsg.trim(),"Error message is not displayed as expected");		
	}
	
	@Test
	public void TC03() {
		UserInfo userInfo = new UserInfo(
				Constant.USERNAME, 
				Constant.INVALID_PASSWORD, 
				Constant.PASSPORTID);
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";

		System.out.println("User cannot log into Railway with invalid password");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage("Login", LoginPage.class);
		
		System.out.println("3. Enter valid Email and invalid Password");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());
		String actualErrorMsg = loginPage.getTextOfElement(loginPage.getLblLoginErrorMsg());
		
		System.out.println("VP: Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed");
		Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC04(){
		UserInfo userInfo = new UserInfo(
				Constant.USERNAME, 
				Constant.INVALID_PASSWORD, 
				Constant.PASSPORTID);
		
		String expectedWarningMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

		System.out.println("System shows message when user enters wrong password many times");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage("Login", LoginPage.class);
		
		System.out.println("3. Enter valid information into \"Username\" textbox except \"Password\" textbox.");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());
		
		System.out.println("5. Repeat step 3 and 4 three more times.");
		int loginTimes = 3;
		for (int i = 0;i < loginTimes;i++) {
			loginPage.login(
					userInfo.getUserEmail(),
					userInfo.getUserPassword());
		}
		String actualErrorMsg = loginPage.getTextOfElement(loginPage.getLblLoginErrorMsg());
		
		System.out.println("VP: User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
		Assert.assertEquals(actualErrorMsg.trim(), expectedWarningMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC05() {
		String emailString = Utilities.generateRandomEmail();
		UserInfo userInfo = new UserInfo(
				emailString, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		String expectedWarningMsg = "Invalid username or password. Please try again.";
		
		System.out.println("User can't login with an account hasn't been activated");
		
		System.out.println("Pre-condition: a not-active account is existing");
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = homePage.goToPage("Register", RegisterPage.class);
		registerPage.regiter(
				userInfo.getUserEmail(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassportId());
		
		System.out.println("1. Navigate to QA Railway Website");
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = registerPage.goToPage("Login", LoginPage.class);
		
		System.out.println("3. Enter username and password of account hasn't been activated.");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());
		
		String actualErrorMsg = loginPage.getTextOfElement(loginPage.getLblLoginErrorMsg());
		
		System.out.println("VP: User can't login and message \"Invalid username or password. Please try again.\" appears.");
		Assert.assertEquals(actualErrorMsg.trim(), expectedWarningMsg.trim(),"Error message is not displayed as expected");
	}
}
