package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Utilities;
import Constant.MenuPage;
import Constant.PageIdentifier;
import Guerrillamail.MainPage;

public class ResetPasswordTest extends BaseTest {
	@Test
	public void TC10() {
		// Expected Messages
		String expectedFormName = "Password Change Form";
		String expectedResetPasswordMsg = "The new password cannot be the same with the current password";
		
		// Main Test
		System.out.println("TC10: Reset password shows error if the new password is same as current");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, PageIdentifier.LOGIN, LoginPage.class);

		System.out.println("2. Click on \"Forgot Password page\" link");
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
		forgotPasswordPage = loginPage.gotoForgotPasswordPage();

		System.out.println("3. Enter the email address of the activated account");
		System.out.println("4. Click on \"Send Instructions\" button");
		forgotPasswordPage.enterEmailForgotPassword(userInfo.getUserEmail());

		System.out.println("5. Login to the mailbox (the same mailbox when creating account) ");
		MainPage mainEmailPage = new MainPage();
		mainEmailPage.open().setEmailName(Utilities.getEmailPartName(userInfo.getUserEmail()));

		System.out.println("6. Open email with subject contaning \"Please reset your password\" and the email of the account at step 3");
		System.out.println("7. Click on reset link");
		forgotPasswordPage = mainEmailPage.resetPassword();
		
		System.out.println("VP: Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token");
		String formName = forgotPasswordPage.getTextOfForgotPasswordForm();
		Assert.assertEquals(formName, expectedFormName, "Form name is not display as expected");
		
		boolean isTokenExist = forgotPasswordPage.checkTokenExist();
		Assert.assertTrue(isTokenExist, "The token does not exist");
		
		System.out.println("8. Input same password into 2 fields  \"new password\" and \"confirm password\"");
		System.out.println("9. Click Reset Password");
		forgotPasswordPage.changePassword(userInfo.getUserPassword(), userInfo.getUserPassword());
		
		System.out.println("VP: Message \"The new password cannot be the same with the current password\" is shown");
		String actualResetPasswordMsg = forgotPasswordPage.getStateResetPassword();
		Assert.assertEquals(actualResetPasswordMsg, expectedResetPasswordMsg, "Error message when reset password is not displayed as expected");
	}
	
	@Test
	public void TC11() {
		// Expected Messages
		String expectedFormName = "Password Change Form";
		String expectedResetPasswordMsg = "Could not reset password. Please correct the errors and try again.";
		
		// Main Test 
		System.out.println("TC11: Reset password shows error if the new password and confirm password doesn't match");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, PageIdentifier.LOGIN, LoginPage.class);

		System.out.println("2. Click on \"Forgot Password page\" link");
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
		forgotPasswordPage = loginPage.gotoForgotPasswordPage();

		System.out.println("3. Enter the email address of the activated account");
		System.out.println("4. Click on \"Send Instructions\" button");
		forgotPasswordPage.enterEmailForgotPassword(userInfo.getUserEmail());

		System.out.println("5. Login to the mailbox (the same mailbox when creating account) ");
		MainPage mainEmailPage = new MainPage();
		mainEmailPage.open();
		mainEmailPage.setEmailName(Utilities.getEmailPartName(userInfo.getUserEmail()));

		System.out.println("6. Open email with subject contaning \"Please reset your password\" and the email of the account at step 3");
		System.out.println("7. Click on reset link");
		mainEmailPage.resetPassword();
		
		System.out.println("VP: Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token");
		Utilities.switchToLatestTab();
		String formName = forgotPasswordPage.getTextOfForgotPasswordForm();
		Assert.assertEquals(formName, expectedFormName, "Form name is not display as expected");
		
		boolean isTokenExist = forgotPasswordPage.checkTokenExist();
		Assert.assertTrue(isTokenExist, "The token does not exist");
		
		System.out.println("8. Input different input into 2 fields  \"new password\" and \"confirm password\"");
		System.out.println("9. Click Reset Password");
		forgotPasswordPage.changePassword(userInfo.getUserPassword(), "new" + userInfo.getUserPassword());
		
		System.out.println("VP: Error message \"Could not reset password. Please correct the errors and try again.\" displays above the form.\n"
				+ "VP: Error message \"The password confirmation did not match the new password.\" displays next to the confirm password field.");
		String actualResetPasswordMsg = forgotPasswordPage.getStateResetPassword();
		Assert.assertEquals(actualResetPasswordMsg, expectedResetPasswordMsg, "Error message when reset password is not displayed as expected");
	}
}
