package Railway;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuPage;
import Guerrillamail.MainPage;

public abstract class BaseTest {
	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(@Optional("chrome") String browser) {
		System.out.println("Pre-condition");
		if ("chrome".equalsIgnoreCase(browser)) {
			Constant.WEBDRIVER = new ChromeDriver();
		} else if ("firefox".equalsIgnoreCase(browser)) {
			Constant.WEBDRIVER = new FirefoxDriver();
		} else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}
	
	public UserInfo createAndActiveAccount() {		
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = homePage.goToPage(MenuPage.REGISTER, RegisterPage.class);
		
		String randomEmail = Utilities.generateRandomEmail();
		registerPage.regiter(
				randomEmail, 
				Constant.PASSWORD, 
				Constant.PASSWORD, 
				Constant.PASSPORTID
		);
		
		Constant.WEBDRIVER.switchTo().newWindow(WindowType.TAB).get(Constant.GURERRILLAMAIL_URL);
		MainPage mainPageMailWeb = new MainPage();
		mainPageMailWeb.setEmailName(Utilities.getEmailPartName(randomEmail));
		mainPageMailWeb.activeAccount();
				
		return new UserInfo(
				randomEmail, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
	}
	
	public BookTicketPage bookTicket (TicketInfo ticketInfo) {
		HomePage homePage = new HomePage();
		BookTicketPage bookTicketPage = homePage.goToPage(MenuPage.BOOKTICKET, BookTicketPage.class);
		bookTicketPage.bookNewTicket(ticketInfo);
		return new BookTicketPage();
	}
}
