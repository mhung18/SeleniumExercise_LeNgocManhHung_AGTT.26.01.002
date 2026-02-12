package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Utilities;
import Constant.Constant;

public class LoginPage extends GeneralPage{
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _txtLoginPageTitle = By.xpath("//h1[text()=\"Login page\"]");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By _linkForgotPassword = By.xpath("//a[text()=\"Forgot Password page\"]");
	
	public WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}
	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	public WebElement getBtnLogin() {
		return Constant.WEBDRIVER.findElement(_btnLogin);
	}
	public WebElement getLblLoginErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
	}
	public WebElement getLinkForgotPassword() {
		return Constant.WEBDRIVER.findElement(_linkForgotPassword);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends GeneralPage> T login (UserInfo userInfo) {
		Utilities.enter(_txtUsername, userInfo.getUserEmail());
		Utilities.enter(_txtPassword, userInfo.getUserPassword());
		Utilities.click(_btnLogin);
		
		boolean isLoginTitleExist = Utilities.isDisplayed(_txtLoginPageTitle);
		System.out.println("Boolean: " + isLoginTitleExist);
		if (!isLoginTitleExist) {
			return (T) new HomePage();
		} else {
			return (T) this;
		}
	}
	
	public ForgotPasswordPage gotoForgotPasswordPage() {
		this.getLinkForgotPassword().click();
		return new ForgotPasswordPage();
	}
	
	public String getLoginErrorMsg () {
		return Utilities.getTextOfElement(_lblLoginErrorMsg);
	}
}
