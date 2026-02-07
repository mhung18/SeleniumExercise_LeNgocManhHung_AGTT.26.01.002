package Railway;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Guerrillamail.MainPage;

public class CreateAccount extends BaseTest{
	@Test
	public void TC07() {
		UserInfo userInfo = new UserInfo(
			Constant.USERNAME, 
			Constant.PASSWORD, 
			Constant.PASSPORTID);
		
		String expectedMsg = "This email address is already in use.";

		System.out.println("User can't create account with an already in-use email");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Register\" tab");
		RegisterPage registerPage = homePage.goToPage("Register", RegisterPage.class);
		
		System.out.println("3. Enter information of the created account in Pre-condition");
		System.out.println("4. Click on \"Register\" button");
		registerPage.regiter(
				userInfo.getUserEmail(),
				userInfo.getUserPassword(),
				userInfo.getUserPassword(),
				userInfo.getUserPassportId());
		
		System.out.println("VP: Error message \"This email address is already in use.\" displays above the form.");
		String actualMsg = registerPage.getLblRegisterErrorMsg().getText();
		
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");		
	}
	
	@Test
	public void TC08() {
		String emailString = Utilities.generateRandomEmail();
		UserInfo userInfo = new UserInfo(
				emailString, 
				Constant.BLANKFIELD, 
				Constant.BLANKFIELD);
		
		System.out.println("User can't create account while password and PID fields are empty");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Register\" tab");
		RegisterPage registerPage = homePage.goToPage("Register", RegisterPage.class);
		
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
		String actualMsg = registerPage.getLblRegisterErrorMsg().getText();
		String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
		
		String actualPasswordErrorMsg = registerPage.getLblPasswordErrorMsg().getText();
		String expectedPasswordErrorMsg = "Invalid password length";
		Assert.assertEquals(actualPasswordErrorMsg, expectedPasswordErrorMsg, "Error message for password is not displayed as expected");
		
		String actualPassportIdErrorMsg = registerPage.getLblPassportIdErrorMsg().getText();
		String expectedPassportIdErrorMsg = "Invalid ID length";
		Assert.assertEquals(actualPassportIdErrorMsg, expectedPassportIdErrorMsg, "Error message for PID is not displayed as expected");
	}
	
	@Test
	public void TC09() {
		String emailString = Utilities.generateRandomEmail();
		UserInfo userInfo = new UserInfo(
				emailString, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		String expectedHref = "http://saferailway.somee.com/Account/Register.cshtml";
		String expectedMsg = "Thank you for registering your account";
		String expectedRegisterConfirmStringMsg = "Registration Confirmed! You can now log in to the site.";

		System.out.println("User create and activate account");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("VP: Home page is shown with guide containing href \"create an account\" to \"Register\" page");
		Utilities.scrollToEndPage();
		String actuallinkText = homePage.getLinkToCreateAccount().getText();
		String expectedLinkText = "create an account";
		Assert.assertEquals(actuallinkText, expectedLinkText, "Link text is not displayed as expected");
		
		String actualHref = homePage.getLinkToCreateAccount().getDomProperty("href");
		Assert.assertEquals(actualHref, expectedHref, "The link does not redirect to Register Page");
		
		System.out.println("2. Click on \"Create an account\"");
		homePage.getLinkToCreateAccount().click();
		RegisterPage registerPage = new RegisterPage();
		String actualCurrentPageString = registerPage.getSelectedTabName();
		Assert.assertEquals(actualCurrentPageString, "Register", "The link does not redirect to Register Page");
		
		System.out.println("3. Enter valid information into all fields");
		System.out.println("4. Click on \"Register\" button");
		registerPage.regiter(
				userInfo.getUserEmail(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassword(), 
				userInfo.getUserPassportId()
		);
		
		System.out.println("VP: \"Thank you for registering your account\" is shown");
		String actualMsg = registerPage.getLblRegisterSuccessfully().getText();
		Assert.assertEquals(actualMsg, expectedMsg, "The registered successful message is not displayed as expected");
		
		System.out.println("5. Get email information (webmail address, mailbox and password) and navigate to that webmail");
		System.out.println("6. Login to the mailbox");
//		Constant.WEBDRIVER.switchTo().newWindow(WindowType.TAB).get(Constant.GURERRILLAMAIL_URL);
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
