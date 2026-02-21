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
		return Utilities.getTextOfElement(_lblRegisterErrorMsg);
	}
	public String getLblPasswordErrorMsg() {
		return Utilities.getTextOfElement(_lblPasswordErrorMsg);
	}
	public String getLblPassportIdErrorMsg() {
		return Utilities.getTextOfElement(_lblPassportIdErrorMsg);
	}
	public String getLblRegisterSuccessfully() {
		return Utilities.getTextOfElement(_lblRegisterSuccessfullyMsg);
	}
	public String getRegisterConfirmMsg() {
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
