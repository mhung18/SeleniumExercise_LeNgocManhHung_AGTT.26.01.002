package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Utilities;
import Constant.Constant;
import Constant.MenuPage;
import Constant.PageIdentifier;
import Guerrillamail.MainPage;

public class CreateAccountTest extends BaseTest{
	@Test
	public void TC07() {
		// Create Data Object
		UserInfo userInfo = new UserInfo(
			Constant.USERNAME, 
			Constant.PASSWORD, 
			Constant.PASSPORTID);
		
		// Expected Messages
		String expectedMsg = "This email address is already in use.";
		
		// Main Test 	
		System.out.println("TC07: User can't create account with an already in-use email");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Register\" tab");
		RegisterPage registerPage = homePage.goToPage(MenuPage.REGISTER, PageIdentifier.REGISTER, RegisterPage.class);
		
		System.out.println("3. Enter information of the created account in Pre-condition");
		System.out.println("4. Click on \"Register\" button");
		registerPage.regiter(
				userInfo.getUserEmail(),
				userInfo.getUserPassword(),
				userInfo.getUserPassword(),
				userInfo.getUserPassportId());
		
		System.out.println("VP: Error message \"This email address is already in use.\" displays above the form.");
		String actualMsg = registerPage.getLblRegisterErrorMsg();
		
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");		
	}
	
	@Test
	public void TC08() {
		// Create Data Object
		String randomEmail = Utilities.generateRandomEmail();
		UserInfo userInfo = new UserInfo(
				randomEmail, 
				Constant.BLANKFIELD, 
				Constant.BLANKFIELD);
		
		// Expected Messages
		String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
		String expectedPasswordErrorMsg = "Invalid password length";
		String expectedPassportIdErrorMsg = "Invalid ID length";
		
		// Main Test 	
		System.out.println("TC08: User can't create account while password and PID fields are empty");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Register\" tab");
		RegisterPage registerPage = homePage.goToPage(MenuPage.REGISTER, PageIdentifier.REGISTER, RegisterPage.class);
		String nameString = Utilities.getTitle();
		System.out.println(nameString);
		
		System.out.println("3. Enter valid email address and leave other fields empty");
		System.out.println("4. Click on \"Register\" button");
		registerPage.regiter(
				userInfo.getUserEmail(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassportId());
		
		System.out.println("VP: Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.\n"
				+ "VP: Next to password fields, error message \"Invalid password length\" displays\n"
				+ "VP: Next to PID field, error message \"Invalid ID length\" displays");
		String actualMsg = registerPage.getLblRegisterErrorMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
		
		String actualPasswordErrorMsg = registerPage.getLblPasswordErrorMsg();
		Assert.assertEquals(actualPasswordErrorMsg, expectedPasswordErrorMsg, "Error message for password is not displayed as expected");
		
		String actualPassportIdErrorMsg = registerPage.getLblPassportIdErrorMsg();
		Assert.assertEquals(actualPassportIdErrorMsg, expectedPassportIdErrorMsg, "Error message for PID is not displayed as expected");
	}
	
	@Test
	public void TC09() throws InterruptedException {
		// Create Data Object
		String randomEmail = Utilities.generateRandomEmail();
		UserInfo userInfo = new UserInfo(
				randomEmail, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		// Expected Messages
		String expectedHref = "http://saferailway.somee.com/Account/Register.cshtml";
		String expectedMsg = "Thank you for registering your account";
		String expectedRegisterConfirmStringMsg = "Registration Confirmed! You can now log in to the site.";
		String expectedLinkText = "create an account";
		String expectedTab = MenuPage.REGISTER.getPageName();
		
		// Main Test 
		System.out.println("TC09: User create and activate account");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("VP: Home page is shown with guide containing href \"create an account\" to \"Register\" page");
		String actualLinkText = Utilities.getTextOfElement(homePage.getLinkToCreateAccount());
		Assert.assertEquals(actualLinkText, expectedLinkText, "Link text is not displayed as expected");
		
		String actualHref = homePage.getLinkToCreateAccount().getDomProperty("href");
		Assert.assertEquals(actualHref, expectedHref, "The link does not redirect to Register Page");
		
		System.out.println("2. Click on \"Create an account\"");
		RegisterPage registerPage = new RegisterPage();
		registerPage = homePage.goToCreateAccount();
		
		System.out.println("VP: Register page is shown");
		String actualCurrentPageString = registerPage.getSelectedTabName();
		System.out.println(actualCurrentPageString);
		String nameString = Constant.WEBDRIVER.getTitle();
		System.out.println(nameString);
		Assert.assertEquals(actualCurrentPageString, expectedTab, "The link does not redirect to Register Page");
		
		System.out.println("3. Enter valid information into all fields");
		System.out.println("4. Click on \"Register\" button");
		registerPage.regiter(
				userInfo.getUserEmail(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassportId()
		);
		
		System.out.println("VP: \"Thank you for registering your account\" is shown");
		String actualMsg = registerPage.getLblRegisterSuccessfully();
		Assert.assertEquals(actualMsg, expectedMsg, "The registered successful message is not displayed as expected");
		
		System.out.println("5. Get email information (webmail address, mailbox and password) and navigate to that webmail");
		System.out.println("6. Login to the mailbox");
		MainPage mainPageMailWeb = new MainPage();
		mainPageMailWeb.open();
		mainPageMailWeb.setEmailName(Utilities.getEmailPartName(userInfo.getUserEmail()));
		
		System.out.println("7. Open email with subject containing \"Please confirm your account\"  and the email of the new account at step 3");		
		System.out.println("8. Click on the activate link");
		registerPage = mainPageMailWeb.activeAccount();
		Utilities.switchToLatestTab();

		System.out.println("VP: Redirect to Railways page and message \"Registration Confirmed! You can now log in to the site\" is shown");
		String actualRegisterConfirmMsg = registerPage.getRegisterConfirmMsg();
		Assert.assertEquals(actualRegisterConfirmMsg, expectedRegisterConfirmStringMsg, "Register Confirmation is not displayed as expected");
	}
}
