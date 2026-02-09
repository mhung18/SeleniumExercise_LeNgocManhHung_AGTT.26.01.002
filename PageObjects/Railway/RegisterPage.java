package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class RegisterPage extends GeneralPage {
	private final By _txtEmail = By.id("email");
	private final By _txtPassword = By.id("password");
	private final By _txtConfirmPassword = By.id("confirmPassword");
	private final By _txtPassportId = By.id("pid");
	private final By _btnRegister = By.xpath("//input[@value=\"Register\"]");
	private final By _lblRegisterErrorMsg = By.xpath("//p[@class=\"message error\"]");
	private final By _lblPasswordErrorMsg = By.xpath("//label[@for=\"password\" and @class=\"validation-error\"]");
	private final By _lblPassportIdErrorMsg = By.xpath("//label[@for=\"pid\" and @class=\"validation-error\"]");
	private final By _lblRegisterSuccessfully = By.xpath("//h1[text()=\"Thank you for registering your account\"]");
	private final By _lblRegisterConfirmMsg = By.xpath("//div[@id=\"content\"]/p");

	
	public WebElement getTxtEmai() {
		return Constant.WEBDRIVER.findElement(_txtEmail);
	}
	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	public WebElement getTxtConfirmPassword() {
		return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
	}
	public WebElement getTxtPassportId() {
		return Constant.WEBDRIVER.findElement(_txtPassportId);
	}
	public WebElement getBtnRegister() {
		return Constant.WEBDRIVER.findElement(_btnRegister);
	}
	
	
	public String getLblRegisterErrorMsg() {
		Utilities.waitForElementVisible(_lblRegisterErrorMsg, 10);
		return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg).getText();
	}
	public String getLblPasswordErrorMsg() {
		Utilities.waitForElementVisible(_lblPasswordErrorMsg, 10);
		return Constant.WEBDRIVER.findElement(_lblPasswordErrorMsg).getText();
	}
	public String getLblPassportIdErrorMsg() {
		Utilities.waitForElementVisible(_lblPassportIdErrorMsg, 10);
		return Constant.WEBDRIVER.findElement(_lblPassportIdErrorMsg).getText();
	}
	public String getLblRegisterSuccessfully() {
		Utilities.waitForElementVisible(_lblRegisterSuccessfully, 10);
		return Constant.WEBDRIVER.findElement(_lblRegisterSuccessfully).getText();
	}
	public String getRegisterConfirmMsg() {
		Utilities.waitForElementVisible(_lblRegisterConfirmMsg, 10);
		return Constant.WEBDRIVER.findElement(_lblRegisterConfirmMsg).getText();
	}
	
	public RegisterPage regiter(String email, String pass, String confirmPass, String passportId) {
		Utilities.enter(_txtEmail, email);
		Utilities.enter(_txtPassword, pass);
		Utilities.enter(_txtConfirmPassword, confirmPass);
		Utilities.enter(_txtPassportId, passportId);
		Utilities.click(_btnRegister);
		return this;
	}
	
	
}
