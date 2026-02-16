package Guerrillamail;

import org.openqa.selenium.By;
import Common.Utilities;
import Constant.Constant;
import Railway.ForgotPasswordPage;
import Railway.RegisterPage;

public class MainPage {
	private final By _lblEmailName = By.id("inbox-id");
	private final By _lblEmailContent = By.xpath("//div[@class=\"email_body\"]");
	private final By _lblEmailConfirm = By.xpath("//tbody[@id='email_list']//tr[contains(., 'Please confirm your account')]");
	private final By _lblEmailResetPassword = By.xpath("//tbody[@id='email_list']//tr[contains(., 'Please reset your password')]");
	private final By _lnkConfirm = By.xpath("//div[contains(@class,'email_body')]//a");
	private final By _txtEmailName = By.xpath("//span[@id=\"inbox-id\"]/input[@type=\"text\"]");
	private final By _btnSetEmail = By.xpath("//span[@id=\"inbox-id\"]/button[text()=\"Set\"]");

	public MainPage open() {
		Constant.WEBDRIVER.navigate().to(Constant.GURERRILLAMAIL_URL);
		return this;
	}
	
	public MainPage setEmailName(String emailName) {
		Utilities.click(_lblEmailName);
		Utilities.enter(_txtEmailName, emailName);
		Utilities.click(_btnSetEmail);
		return this;
	}
	
	public RegisterPage activeAccount() {
		Utilities.click(_lblEmailConfirm);
		Utilities.click(_lnkConfirm);
		Utilities.switchToLatestTab();
		return new RegisterPage();
	}
	
	public ForgotPasswordPage resetPassword() {	
		try {
			Utilities.click(_lblEmailResetPassword);
		} catch (Exception e) {
			Constant.WEBDRIVER.navigate().refresh();
			Utilities.click(_lblEmailResetPassword);
		}
		Utilities.click(_lnkConfirm);
		Utilities.switchToLatestTab();
		return new ForgotPasswordPage();
	}
	
	public String getRegisterToken() {
	    String content = Utilities.getTextOfElement(_lblEmailContent);
	    String[] parts = content.split("The token is:");
	    String tokenPart = parts[1].trim();
	    String token = tokenPart.split("\\.")[0].trim();
	    return token;
	}
}
