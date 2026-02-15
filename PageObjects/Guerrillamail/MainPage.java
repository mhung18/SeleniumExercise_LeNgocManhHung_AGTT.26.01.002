package Guerrillamail;

import org.openqa.selenium.By;
import Common.Utilities;
import Constant.Constant;
import Railway.RegisterPage;

public class MainPage {
	private final By _emailName = By.id("inbox-id");
	private final By _emailNameTextbox = By.xpath("//span[@id=\"inbox-id\"]/input[@type=\"text\"]");
	private final By _btnSetEmail = By.xpath("//span[@id=\"inbox-id\"]/button[text()=\"Set\"]");
	private final By _emailConfirm = By.xpath("//tbody[@id=\"email_list\"]//td[contains(text(),\"Please confirm your account\")]");
	private final By _linkConfirm = By.xpath("//div[contains(@class,'email_body')]//a");
	private final By _emailResetPassword = By.xpath("//tbody[@id=\"email_list\"]//a[contains(text(),\"Please reset your password\")]");
	private final By _emailContent = By.xpath("//div[@class=\"email_body\"]");
	
	public MainPage open() {
		Constant.WEBDRIVER.navigate().to(Constant.GURERRILLAMAIL_URL);
		return this;
	}
	
	public MainPage setEmailName(String emailName) {
		Utilities.click(_emailName);
		Utilities.enter(_emailNameTextbox, emailName);
		Utilities.click(_btnSetEmail);
		return this;
	}
	
	public RegisterPage activeAccount() {
		Utilities.click(_emailConfirm);
		Utilities.click(_linkConfirm);
		Utilities.switchToLatestTab();
		return new RegisterPage();
	}
	
	public MainPage resetPassword() {
		try {
			Utilities.waitForElementClickable(_emailResetPassword);
		} catch (Exception e) {
			Constant.WEBDRIVER.navigate().refresh();
		}
		Utilities.click(_emailResetPassword);
		Utilities.click(_linkConfirm);
		return this;
	}
	
	public String getRegisterToken() {
	    String content = Utilities.getTextOfElement(_emailContent);
	    String[] parts = content.split("The token is:");
	    String tokenPart = parts[1].trim();
	    String token = tokenPart.split("\\.")[0].trim();
	    return token;
	}
}
