package Railway;

import org.openqa.selenium.*;
import Common.Utilities;
import Constant.Constant;
import Constant.MenuPage;

public class GeneralPage {
	private final By _lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
	private final By _tabSelected = By.xpath("//li[@class=\"selected\"]");
	private final String _dymTabXpath = "//div[@id=\"menu\"]//span[text()=\"%s\"]";
	
	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(_lblWelcomeMessage);
	}
	
	protected WebElement getSelectedTab() {
		return Constant.WEBDRIVER.findElement(_tabSelected);			
	}
	
	// Method
	public String getWelcomeMessage() {
		Utilities.waitForElementVisible(_lblWelcomeMessage, 10);
		return this.getLblWelcomeMessage().getText();
	}
	
	public String getSelectedTabName() {
		return this.getSelectedTab().getText();
	}
	
	public boolean isTabExist(String tabName) {
		String xpathString = String.format(_dymTabXpath, tabName);
		return Utilities.isDisplayed(xpathString);
	}
	
	public <T extends GeneralPage> T goToPage(MenuPage page, Class<T> pageClass) {
	    String xpath = String.format(_dymTabXpath, page.getPageName());
	    Utilities.waitForElementVisible(By.xpath(xpath), 10);
	    Utilities.click(By.xpath(xpath));

	    try {
	        return pageClass.getDeclaredConstructor().newInstance();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
