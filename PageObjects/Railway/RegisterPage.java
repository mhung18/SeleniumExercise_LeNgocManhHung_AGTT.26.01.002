package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class RegisterPage {
	private final By _txtEmail = By.id("email");
	private final By _txtPassword = By.id("password");
	private final By _txtConfirmPassword = By.id("confirmPassword");
	private final By _txtPassportId = By.id("pid");
	private final By _btnRegister = By.xpath("//input[@value=\"Register\"]");

	// Elements
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
	
	public HomePage register(UserInfo userInfo) {
		this.getTxtEmai().sendKeys(userInfo.getUserEmail());
		this.getTxtPassword().sendKeys(userInfo.getUserPassword());
		this.getTxtConfirmPassword().sendKeys(userInfo.getUserPassword());
		this.getTxtPassportId().sendKeys(userInfo.getUserPassportId());
		
		this.getBtnRegister().click();
		
		return new HomePage();
	}
	
	public HomePage regiter(String email, String pass, String confirmPass, String passportId) {
		this.getTxtEmai().sendKeys(email);
		this.getTxtPassword().sendKeys(pass);
		this.getTxtConfirmPassword().sendKeys(confirmPass);
		this.getTxtPassportId().sendKeys(passportId);
		
		this.getBtnRegister().click();
		
		return new HomePage();
	}
}
