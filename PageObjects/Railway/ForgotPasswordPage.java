package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class ForgotPasswordPage {
	private final By _txtEmailForgotPassword = By.xpath("//input[@id=\"email\"]");
	private final By _btnSendInstruction = By.xpath("//input[@value=\"Send Instructions\"]");
	
	public WebElement getTxtEmailForgotPassword() {
		return Constant.WEBDRIVER.findElement(_txtEmailForgotPassword);
	}
	public WebElement getBtnSendInstruction() {
		return Constant.WEBDRIVER.findElement(_btnSendInstruction);
	}
	
	public ForgotPasswordPage enterEmailForgotPassword(String email) {
		this.getTxtEmailForgotPassword().sendKeys(email);
		this.getBtnSendInstruction().click();
		return this;
	}
}
