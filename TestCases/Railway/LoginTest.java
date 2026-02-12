package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuPage;

public class LoginTest extends BaseTest{
	@Test
	public void TC01() {
		// Create Data Object
		UserInfo userInfo = new UserInfo(
				Constant.USERNAME, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		// Expected Messages
		String expectedMsg = "Welcome " + userInfo.getUserEmail();
		
		// Main Test 
		System.out.println("TC01: User can log into Railway with valid username and password");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		Utilities.waitForPageFullyLoad();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		System.out.println(Constant.WEBDRIVER.getTitle());
		
		System.out.println("3. Enter valid Email and Password");
		System.out.println("4. Click on \"Login\" button");
		String actualMsg = loginPage.login(userInfo).getWelcomeMessage();
		
		System.out.println("VP: User is logged into Railway. Welcome user message is displayed.");
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
		
	@Test
	public void TC02() {
		// Create Data Object
		UserInfo userInfo = new UserInfo(
				Constant.BLANKFIELD, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		// Expected Messages
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
		
		System.out.println("TC02: User cannot login with blank \"Username\" textbox");
		
		// Main Test 
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		
		System.out.println("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox ");
		System.out.println("4. Click on \"Login\" button");
		loginPage = loginPage.login(userInfo);
		String actualErrorMsg = Utilities.getTextOfElement(loginPage.getLblLoginErrorMsg());
		
		System.out.println("VP: User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
		Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMsg.trim(),"Error message is not displayed as expected");		
	}
	
	@Test
	public void TC03() {
		// Create Data Object
		UserInfo userInfo = new UserInfo(
				Constant.USERNAME, 
				Constant.INVALID_PASSWORD, 
				Constant.PASSPORTID);
		
		// Expected Messages
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";

		// Main Test 
		System.out.println("TC03: User cannot log into Railway with invalid password");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		
		System.out.println("3. Enter valid Email and invalid Password");
		System.out.println("4. Click on \"Login\" button");
		loginPage = loginPage.login(userInfo);
		String actualErrorMsg = Utilities.getTextOfElement(loginPage.getLblLoginErrorMsg());
		
		System.out.println("VP: Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed");
		Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC04(){
		// Create Data Object
		UserInfo userInfo = new UserInfo(
				Constant.USERNAME, 
				Constant.INVALID_PASSWORD, 
				Constant.PASSPORTID);
		
		// Expected Messages
		String expectedWarningMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

		// Main Test 
		System.out.println("TC04: System shows message when user enters wrong password many times");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		
		System.out.println("3. Enter valid information into \"Username\" textbox except \"Password\" textbox.");
		System.out.println("4. Click on \"Login\" button");
		loginPage = loginPage.login(userInfo);
		
		System.out.println("5. Repeat step 3 and 4 three more times.");
		int loginTimes = 3;
		for (int i = 0;i < loginTimes;i++) {
			loginPage = loginPage.login(userInfo);
		}
		
		System.out.println("VP: User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
		String actualErrorMsg = loginPage.getLoginErrorMsg();
		Assert.assertEquals(actualErrorMsg.trim(), expectedWarningMsg.trim(),"Error message is not displayed as expected");
	}
	
	@Test
	public void TC05() {
		// Create Data Object
		String emailString = Utilities.generateRandomEmail();
		UserInfo userInfo = new UserInfo(
				emailString, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		// Expected Messages
		String expectedWarningMsg = "Invalid username or password. Please try again.";

		// Main Test 
		System.out.println("TC05: User can't login with an account hasn't been activated");
		
		System.out.println("Pre-condition: a not-active account is existing");
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = homePage.goToPage(MenuPage.REGISTER, RegisterPage.class);
		registerPage.regiter(
				userInfo.getUserEmail(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassportId());
		
		System.out.println("1. Navigate to QA Railway Website");
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = registerPage.goToPage(MenuPage.LOGIN, LoginPage.class);
		
		System.out.println("3. Enter username and password of account hasn't been activated.");
		System.out.println("4. Click on \"Login\" button");
		loginPage = loginPage.login(userInfo);
		
		String actualErrorMsg = Utilities.getTextOfElement(loginPage.getLblLoginErrorMsg());
		
		System.out.println("VP: User can't login and message \"Invalid username or password. Please try again.\" appears.");
		Assert.assertEquals(actualErrorMsg.trim(), expectedWarningMsg.trim(),"Error message is not displayed as expected");
	}
}
