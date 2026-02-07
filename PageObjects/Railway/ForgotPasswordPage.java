package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class ForgotPasswordPage extends GeneralPage{
	private final By _txtEmailForgotPassword = By.xpath("//input[@id=\"email\"]");
	private final By _btnSendInstruction = By.xpath("//input[@value=\"Send Instructions\"]");
	private final By _txtForgotPasswordForm = By.xpath("//form//legend[text()=\"Password Change Form\"]");
	private final By _txtToken = By.xpath("//input[@id=\"resetToken\"]");
	private final By _txtNewPassword = By.id("newPassword");
	private final By _txtConfirmNewPassword = By.id("confirmPassword");
	private final By _btnResetPassword = By.xpath("//input[@value=\"Reset Password\"]");
	private final By _txtStateResetPassword = By.xpath("//div[@id=\"content\"]/p");
	
	public WebElement getTxtEmailForgotPassword() {
		return Constant.WEBDRIVER.findElement(_txtEmailForgotPassword);
	}
	
	public WebElement getBtnSendInstruction() {
		return Constant.WEBDRIVER.findElement(_btnSendInstruction);
	}
	
	public WebElement getTxtForgotPasswordForm() {
		return Constant.WEBDRIVER.findElement(_txtForgotPasswordForm);
	}
	
	public WebElement getTxtToken() {
		return Constant.WEBDRIVER.findElement(_txtToken);
	}
	
	public WebElement getTxtNewPassword () {
		return Constant.WEBDRIVER.findElement(_txtNewPassword);
	}
	public WebElement getTxtConfirmNewPassword () {
		return Constant.WEBDRIVER.findElement(_txtConfirmNewPassword);
	}
	public WebElement getBtnResetPassword () {
		return Constant.WEBDRIVER.findElement(_btnResetPassword);
	}
	public WebElement getTxtStateResetPassword () {
		return Constant.WEBDRIVER.findElement(_txtStateResetPassword);
	}
	
	public ForgotPasswordPage enterEmailForgotPassword(String email) {
		this.getTxtEmailForgotPassword().sendKeys(email);
		this.getBtnSendInstruction().click();
		return this;
	}
	
	public boolean checkTokenExist() {
		String token = this.getTxtToken().getAttribute("value");
		System.out.println("Token: " + token);
		if (token != null & !token.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public ForgotPasswordPage changePassword (String newPassword, String confirmNewPassword) {
		Utilities.waitForElementVisible(_txtNewPassword, 10);
		this.getTxtNewPassword().sendKeys(newPassword);
		this.getTxtConfirmNewPassword().sendKeys(confirmNewPassword);
		Utilities.scrollToElement(_btnResetPassword);
		this.getBtnResetPassword().click();
		return this;
	}
	
	public String getStateResetPassword() {
		Utilities.waitForElementVisible(_txtStateResetPassword, 10);
		return this.getTxtStateResetPassword().getText();
	}
}
