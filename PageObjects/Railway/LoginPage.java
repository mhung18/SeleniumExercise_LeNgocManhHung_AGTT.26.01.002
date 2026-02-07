package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class LoginPage extends GeneralPage{
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By _linkForgotPassword = By.xpath("//a[text()=\"Forgot Password page\"]");
	
	// Elements
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
	
	
	public HomePage login(UserInfo userInfo) {
		this.getTxtUsername().sendKeys(userInfo.getUserEmail());
		this.getTxtPassword().sendKeys(userInfo.getUserPassword());
		this.getBtnLogin().click();
		
		return new HomePage();
	}
	
	public HomePage login(String username, String password) {
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		
		return new HomePage();
	}
	
	public ForgotPasswordPage gotoForgotPasswordPage() {
		this.getLinkForgotPassword().click();
		return new ForgotPasswordPage();
	}
}
