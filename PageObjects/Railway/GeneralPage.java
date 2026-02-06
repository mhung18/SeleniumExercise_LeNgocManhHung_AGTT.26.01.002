package Railway;

import org.openqa.selenium.*;

import Common.Utilities;
import Constant.Constant;
import Guerrillamail.MainPage;

public class GeneralPage {
	
//	 Locators
//	private final By _tabFAQ = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Page/FAQ.cshtml\"]");
//	private final By _tabLogin = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Login.cshtml\"]");
//	private final By _tabLogout = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Logout\"]");
//	private final By _tabRegister = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Account/Register.cshtml\"]");
//	private final By _tabBookTicket = By.xpath("//div[@id=\"menu\"]//a[@href=\"/Page/BookTicketPage.cshtml\"]");
	private final By _lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
	private final By _tabSelected = By.xpath("//li[@class=\"selected\"]");
	private final String _dymTabXpath = "//div[@id=\"menu\"]//span[text()=\"%s\"]";
	
	public <T extends GeneralPage> T goToPage(String pageName, Class<T> pageClass) {
	    String xpath = String.format(_dymTabXpath, pageName);
	    Utilities.waitForElementVisible(By.xpath(xpath), 10);
	    Constant.WEBDRIVER.findElement(By.xpath(xpath)).click();

	    try {
	        return pageClass.getDeclaredConstructor().newInstance();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	// Elements
//	protected WebElement getTabLogin() {
//		return Constant.WEBDRIVER.findElement(_tabLogin);
//				
//	}
//	protected WebElement getTabLogout() {
//		return Constant.WEBDRIVER.findElement(_tabLogout);
//				
//	}
	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(_lblWelcomeMessage);
				
	}
//	protected WebElement getTabRegister() {
//		return Constant.WEBDRIVER.findElement(_tabRegister);
//				
//	}
//	protected WebElement getTabBookTicket() {
//		return Constant.WEBDRIVER.findElement(_tabBookTicket);
//				
//	}
//	protected WebElement getTabFAQ() {
//		return Constant.WEBDRIVER.findElement(_tabFAQ);			
//	}
	
	protected WebElement getSelectedTab() {
		return Constant.WEBDRIVER.findElement(_tabSelected);			
	}
	
	
	// Method
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}
	
//	public LoginPage goToLoginPage() {
//		this.getTabLogin().click();
//		return new LoginPage();
//	}
//	
//	public HomePage goToLogoutPage() {
//		this.getTabLogout().click();
//		return new HomePage();
//	}
//	
//	public RegisterPage goToRegisterPage() {
//		this.getTabRegister().click();
//		return new RegisterPage();
//	}
//	
//	public BookTicketPage goToBookTicketPage() {
//		this.getTabBookTicket().click();
//		return new BookTicketPage();
//	}
//	public FAQPage goToFAQPage() {
//		this.getTabFAQ().click();
//		return new FAQPage();
//	}
	
	public String getSelectedTabName() {
		return this.getSelectedTab().getText();
	}
	
	public boolean isTabExist(String tabName) {
		String xpathString = String.format(_dymTabXpath, tabName);
		return Utilities.isDisplayed(xpathString);
	}
}
