package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Utilities;
import Common.WaitUtils;
import Constant.Constant;
import Constant.PageIdentifier;

public class HomePage extends GeneralPage{
	private static final By _lnkCreateAccount = By.xpath("//a[text()=\"create an account\"]");
	

	public WebElement getLinkToCreateAccount () {
		return Constant.WEBDRIVER.findElement(_lnkCreateAccount);
	}
	
	public RegisterPage goToCreateAccount() {
		Utilities.click(_lnkCreateAccount);
		WaitUtils.waitForTitleExist(PageIdentifier.REGISTER.getPageIdentifier());
		return new RegisterPage();
	}
	
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return new HomePage();
	}
}
