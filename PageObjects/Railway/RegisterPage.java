package Railway;

import org.openqa.selenium.By;
import Common.Utilities;

public class RegisterPage extends GeneralPage {
	private final By _txtEmail = By.id("email");
	private final By _txtPassword = By.id("password");
	private final By _txtConfirmPassword = By.id("confirmPassword");
	private final By _txtPassportId = By.id("pid");
	private final By _btnRegister = By.xpath("//input[@value=\"Register\"]");
	private final By _lblRegisterErrorMsg = By.xpath("//p[@class=\"message error\"]");
	private final By _lblPasswordErrorMsg = By.xpath("//label[@for=\"password\" and @class=\"validation-error\"]");
	private final By _lblPassportIdErrorMsg = By.xpath("//label[@for=\"pid\" and @class=\"validation-error\"]");
	private final By _lblRegisterSuccessfullyMsg = By.xpath("//h1[text()=\"Thank you for registering your account\"]");
	private final By _lblRegisterConfirmMsg = By.xpath("//div[@id=\"content\"]/p");
	
	public String getLblRegisterErrorMsg() {
		Utilities.waitForElementVisible(_lblRegisterErrorMsg);
		return Utilities.getTextOfElement(_lblRegisterErrorMsg);
	}
	public String getLblPasswordErrorMsg() {
		Utilities.waitForElementVisible(_lblPasswordErrorMsg);
		return Utilities.getTextOfElement(_lblPasswordErrorMsg);
	}
	public String getLblPassportIdErrorMsg() {
		Utilities.waitForElementVisible(_lblPassportIdErrorMsg);
		return Utilities.getTextOfElement(_lblPassportIdErrorMsg);
	}
	public String getLblRegisterSuccessfully() {
		Utilities.waitForElementVisible(_lblRegisterSuccessfullyMsg);
		return Utilities.getTextOfElement(_lblRegisterSuccessfullyMsg);
	}
	public String getRegisterConfirmMsg() {
		Utilities.waitForElementVisible(_lblRegisterConfirmMsg);
		return Utilities.getTextOfElement(_lblRegisterConfirmMsg);
	}
	
	public RegisterPage regiter(String email, String pass, String confirmPass, String passportId) {
		if (!email.isEmpty()) {
			Utilities.enter(_txtEmail, email);
		}
		if (!pass.isEmpty()) {
			Utilities.enter(_txtPassword, pass);
		}
		if (!confirmPass.isEmpty()) {
			Utilities.enter(_txtConfirmPassword, confirmPass);
		}
		if (!passportId.isEmpty()) {
			Utilities.enter(_txtPassportId, passportId);
		}
		Utilities.click(_btnRegister);
		return this;
	}
	
	
}
