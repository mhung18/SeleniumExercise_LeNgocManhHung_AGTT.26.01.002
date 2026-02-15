package Railway;

import org.openqa.selenium.By;
import Common.Utilities;
import Constant.Constant;

public class ForgotPasswordPage {
	private final By _txtEmailForgotPassword = By.xpath("//input[@id=\"email\"]");
	private final By _btnSendInstruction = By.xpath("//input[@value=\"Send Instructions\"]");
	private final By _txtForgotPasswordForm = By.xpath("//form//legend[text()=\"Password Change Form\"]");
	private final By _txtToken = By.xpath("//input[@id=\"resetToken\"]");
	private final By _txtNewPassword = By.id("newPassword");
	private final By _txtConfirmNewPassword = By.id("confirmPassword");
	private final By _btnResetPassword = By.xpath("//input[@value=\"Reset Password\"]");
	private final By _txtStateResetPassword = By.xpath("//div[@id=\"content\"]/p");
	
	public String getTextOfForgotPasswordForm() {
		return Utilities.getTextOfElement(_txtForgotPasswordForm);
	}
	
	
	public ForgotPasswordPage enterEmailForgotPassword(String email) {
		Utilities.enter(_txtEmailForgotPassword, email);
		Utilities.click(_btnSendInstruction);
		return this;
	}
	
	public boolean checkTokenExist() {
		String token = Constant.WEBDRIVER.findElement(_txtToken).getAttribute("value");
		if (token != null & !token.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public ForgotPasswordPage changePassword (String newPassword, String confirmNewPassword) {
		Utilities.waitForElementVisible(_txtNewPassword);
		Utilities.enter(_txtNewPassword, newPassword);
		Utilities.enter(_txtConfirmNewPassword, confirmNewPassword);
		Utilities.click(_btnResetPassword);
		return this;
	}
	
	public String getStateResetPassword() {
		Utilities.waitForElementVisible(_txtStateResetPassword);
		return Utilities.getTextOfElement(_txtStateResetPassword);
	}
}
