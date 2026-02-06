package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;

public class LoginTest extends BaseTest{
	UserInfo userInfo = new UserInfo(
			Constant.USERNAME, 
			Constant.PASSWORD, 
			Constant.PASSPORTID);

	@Test
	public void TC01() {
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
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
				Constant.BLANK_PASSWORD,
				Constant.PASSWORD);
		String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
		
		System.out.println("VP: User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
		Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMsg.trim(),"Error message is not displayed as expected");		
	}
	
	@Test
	public void TC03() {
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";

		System.out.println("User cannot log into Railway with invalid password");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage("Login", LoginPage.class);
		
		System.out.println("3. Enter valid Email and invalid Password");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(Constant.USERNAME,Constant.INVALID_PASSWORD);
		String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
		
		System.out.println("VP: Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed");
		Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC04() {
		String expectedWarningMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

		System.out.println("System shows message when user enters wrong password many times");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage("Login", LoginPage.class);
		
		System.out.println("3. Enter valid information into \"Username\" textbox except \"Password\" textbox.");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
		
		System.out.println("5. Repeat step 3 and 4 three more times.");
		int loginTimes = 3;
		for (int i = 0;i < loginTimes;i++) {
			loginPage.login(Constant.USERNAME,Constant.INVALID_PASSWORD);
		}
		String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
		
		System.out.println("VP: User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
		Assert.assertEquals(actualErrorMsg.trim(), expectedWarningMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC05() {
		String expectedWarningMsg = "Invalid username or password. Please try again.";
		
		System.out.println("User can't login with an account hasn't been activated");
		
		System.out.println("Pre-condition: a not-active account is existing");
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = homePage.goToPage("Register", RegisterPage.class);
				
		String emailString = Utilities.generateRandomEmail();
		registerPage.regiter(
				emailString, 
				Constant.PASSWORD, 
				Constant.PASSWORD, 
				Constant.PASSPORTID
		);
		System.out.println("1. Navigate to QA Railway Website");
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = registerPage.goToPage("Login", LoginPage.class);
		
		System.out.println("3. Enter username and password of account hasn't been activated.");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(emailString, Constant.PASSWORD);
		
		String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
		
		System.out.println("VP: User can't login and message \"Invalid username or password. Please try again.\" appears.");
		Assert.assertEquals(actualErrorMsg.trim(), expectedWarningMsg.trim(),"Error message is not displayed as expected");
	}
}
