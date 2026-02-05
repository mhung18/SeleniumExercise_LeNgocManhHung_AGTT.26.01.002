package Railway;

import org.openqa.selenium.*;

import Common.Utilities;
import Constant.Constant;
import Guerrillamail.MainPage;

public class GeneralPage {
	
//	 Locators
	private final By tabFAQ = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Page/FAQ.cshtml\"]");
	private final By tabLogin = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Login.cshtml\"]");
	private final By tabLogout = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Logout\"]");
	private final By tabRegister = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Register.cshtml\"]");
	private final By tabBookTicket = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Page/BookTicketPage.cshtml\"]");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
	private final By tabSelected = By.xpath("//li[@class=\"selected\"]");
	private final String dymTabXpath = "//div[@id=\"menu\"]//span[text()=\"%s\"]";
	
//	@SuppressWarnings("unchecked")
//	protected T seft() {
//		return (T) this;
//	}
	
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
	protected WebElement getTabFAQ() {
		return Constant.WEBDRIVER.findElement(tabFAQ);			
	}
	
	protected WebElement getSelectedTab() {
		return Constant.WEBDRIVER.findElement(tabSelected);			
	}
	
	
	// Method
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}
	
	public LoginPage goToLoginPage() {
		this.getTabLogin().click();
		return new LoginPage();
	}
	
	public HomePage goToLogoutPage() {
		this.getTabLogout().click();
		return new HomePage();
	}
	
	public RegisterPage goToRegisterPage() {
		this.getTabRegister().click();
		return new RegisterPage();
	}
	
	public BookTicketPage goToBookTicketPage() {
		this.getTabBookTicket().click();
		return new BookTicketPage();
	}
	public FAQPage goToFAQPage() {
		this.getTabFAQ().click();
		return new FAQPage();
	}
	
//	public <P extends GeneralPage<P>> P goToPage (String pageName) {
//		String xpathString = String.format(dymTabXpath, pageName);
//		Constant.WEBDRIVER.findElement(By.xpath(xpathString)).click();
//		
//		switch (pageName) {
//		case "Login":
//			return new LoginPage();
//
//		case "Logout":
//			return new HomePage();
//
//		case "Register":
//			return new RegisterPage();
//
//		case "Book ticket":
//			return new BookTicketPage();
//
//		case "FAQ":
//			return new FAQPage();
//
//		default:
//			return new GeneralPage();
//		}
//	}
	
	
	public String getSelectedTabName() {
		return this.getSelectedTab().getText();
	}
	
	public boolean isTabExist(String tabName) {
		String xpathString = String.format("//a[span[text()='%s']]", tabName);
		return Utilities.isDisplayed(xpathString);
	}
}
