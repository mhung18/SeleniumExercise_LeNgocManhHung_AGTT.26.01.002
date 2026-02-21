package Railway;

import org.openqa.selenium.By;
import Common.Utilities;
import Common.WaitUtils;
import Constant.PageIdentifier;

public class LoginPage extends GeneralPage{
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By _lnkForgotPassword = By.xpath("//a[text()=\"Forgot Password page\"]");
	
	@SuppressWarnings("unchecked")
	public <T extends GeneralPage> T login(UserInfo userInfo) {
	    Utilities.enter(_txtUsername, userInfo.getUserEmail());
	    Utilities.enter(_txtPassword, userInfo.getUserPassword());
	    Utilities.click(_btnLogin);

	    try {
	    	WaitUtils.waitForTitleExist(PageIdentifier.HOME.getPageIdentifier());
	    	return (T) new HomePage();
		} catch (Exception e) {
			return (T) this;
		}
	}
	
	public ForgotPasswordPage gotoForgotPasswordPage() {
		Utilities.click(_lnkForgotPassword);
		return new ForgotPasswordPage();
	}
	
	public String getLoginErrorMsg () {
		return Utilities.getTextOfElement(_lblLoginErrorMsg);
	}
}
