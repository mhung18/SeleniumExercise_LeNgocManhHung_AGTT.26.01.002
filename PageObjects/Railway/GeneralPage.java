package Railway;

import org.openqa.selenium.*;

import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;

import Common.Utilities;
import Constant.Constant;
import Guerrillamail.MainPage;

public class GeneralPage {
	
//	 Locators
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
	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(_lblWelcomeMessage);
	}
	
	protected WebElement getSelectedTab() {
		return Constant.WEBDRIVER.findElement(_tabSelected);			
	}
	
	// Method
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}
	
	public String getSelectedTabName() {
		return this.getSelectedTab().getText();
	}
	
	public boolean isTabExist(String tabName) {
		String xpathString = String.format(_dymTabXpath, tabName);
		return Utilities.isDisplayed(xpathString);
	}
	
	public String getTextOfElement (WebElement webElement) {
		return webElement.getText();
	}
}
