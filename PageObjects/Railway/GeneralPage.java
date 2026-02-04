package Railway;

import org.openqa.selenium.*;
import Constant.Constant;

public class GeneralPage {
	
	// Locators
	private final By tabLogin = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Login.cshtml\"]");
	private final By tabLogout = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Logout\"]");
	private final By tabRegister = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Register.cshtml\"]");
	private final By tabBookTicket = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Page/BookTicketPage.cshtml\"]");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
	
	// Elements
	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
				
	}
	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
				
	}
	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
				
	}
	protected WebElement getTabRegister() {
		return Constant.WEBDRIVER.findElement(tabRegister);
				
	}
	protected WebElement getTabBookTicket() {
		return Constant.WEBDRIVER.findElement(tabBookTicket);
				
	}
	
	
	// Method
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}
	
	public LoginPage goToLoginPage() {
		this.getTabLogin().click();
		return new LoginPage();
	}
	
	public RegisterPage goToRegisterPage() {
		this.getTabRegister().click();
		return new RegisterPage();
	}
	
	public BookTicketPage goToBookTicketPage() {
		this.getTabBookTicket().click();
		return new BookTicketPage();
	}
}
