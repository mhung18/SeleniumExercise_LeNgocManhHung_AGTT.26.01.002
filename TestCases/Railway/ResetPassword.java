package Railway;

import org.testng.annotations.Test;

import Common.Utilities;
import Constant.MenuPage;
import Guerrillamail.MainPage;

public class ResetPassword extends BaseTest {
	@Test
	public void TC10() {
		System.out.println("Reset password shows error if the new password is same as current");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);

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
		mainEmailPage.resetPassword();
	}
}
