package Guerrillamail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;
import Railway.RegisterPage;

public class MainPage {
	private final By _emailName = By.id("inbox-id");
	private final By _emailNameTextbox = By.xpath("//span[@id=\"inbox-id\"]/input[@type=\"text\"]");
	private final By _btnSetEmail = By.xpath("//span[@id=\"inbox-id\"]/button[text()=\"Set\"]");
	private final By _emailConfirm = By.xpath("//tbody[@id=\"email_list\"]//td[contains(text(),\"Please confirm your account\")]");
	private final By _linkConfirm = By.xpath("//div[contains(@class,'email_body')]//a");
	private final By _emailResetPassword = By.xpath("//tbody[@id=\"email_list\"]//td[contains(text(),\"Please reset your password\")]");
	private final By _emailContent = By.xpath("//div[@class=\"email_body\"]");
	
	
	public WebElement getEmailName() {
		return Constant.WEBDRIVER.findElement(_emailName);
	}
	public WebElement getEmailNameTextbox() {
		return Constant.WEBDRIVER.findElement(_emailNameTextbox);
	}
	public WebElement getBtnSetEmail() {
		return Constant.WEBDRIVER.findElement(_btnSetEmail);
	}
	public WebElement getEmailConfirm() {
		return Constant.WEBDRIVER.findElement(_emailConfirm);
	}
	public WebElement getLinkConfirm() {
		return Constant.WEBDRIVER.findElement(_linkConfirm);
	}
	public WebElement getEmailResetPassword() {
		return Constant.WEBDRIVER.findElement(_emailResetPassword);
	}
	public WebElement getEmailContent() {
		return Constant.WEBDRIVER.findElement(_emailContent);
	}
	
	
	public MainPage open() {
		Constant.WEBDRIVER.navigate().to(Constant.GURERRILLAMAIL_URL);
		return this;
	}
	
	public MainPage setEmailName(String emailName) {
		Utilities.waitForElementVisible(_emailName, 10);
		Utilities.click(_emailName);
		Utilities.enter(_emailNameTextbox, emailName);
		Utilities.click(_btnSetEmail);
		return this;
	}
	
	public RegisterPage activeAccount() {
		Utilities.waitForElementClickable(_emailConfirm,20);
		Utilities.click(_emailConfirm);
		Utilities.waitForElementClickable(_linkConfirm,20);
		Utilities.scrollByPixel(200);
		Utilities.click(_linkConfirm);
		Utilities.switchToLatestTab();
		return new RegisterPage();
	}
	
	public MainPage resetPassword() {
		Utilities.waitForElementClickable(_emailResetPassword, 20);
		Utilities.click(_emailResetPassword);
		Utilities.waitForElementClickable(_linkConfirm, 10);
		Utilities.click(_linkConfirm);
		return this;
	}
	
	public String getRegisterToken() {
	    String content = this.getEmailContent().getText();
	    String[] parts = content.split("The token is:");
	    String tokenPart = parts[1].trim();
	    String token = tokenPart.split("\\.")[0].trim();
	    return token;
	}
}
