package Railway;

import org.openqa.selenium.*;
import Common.Utilities;
import Common.WaitUtils;
import Constant.MenuPage;
import Constant.PageIdentifier;

public class GeneralPage {
	private final By _lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
	private final By _tabSelected = By.xpath("//li[@class=\"selected\"]");
	private final String _tabLink = "//div[@id='menu']//a[span[text()='%s']]";
	
	public String getWelcomeMessage() {
		WaitUtils.waitForElementVisible(_lblWelcomeMessage);
		return Utilities.getTextOfElement(_lblWelcomeMessage);
	}
	
	public String getSelectedTabName() {
		return Utilities.getTextOfElement(_tabSelected);
	}
	
	public boolean isTabExist(String tabName) {
		String xpathTab = String.format(_tabLink, tabName);
		return Utilities.isDisplayed(By.xpath(xpathTab));
	}
	
	public <T extends GeneralPage> T goToPage(MenuPage page, PageIdentifier pageId, Class<T> pageClass) {
	    String xpath = String.format(_tabLink, page.getPageName());
	    WaitUtils.waitForElementLocated(By.xpath(xpath));
	    Utilities.click(By.xpath(xpath));
	    WaitUtils.waitForTitleExist(pageId.getPageIdentifier());

	    try {
	        return pageClass.getDeclaredConstructor().newInstance();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public HomePage logout() {
		this.goToPage(MenuPage.LOGOUT, PageIdentifier.HOME, HomePage.class);
		return new HomePage();		
	}

}
