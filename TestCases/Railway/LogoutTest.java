package Railway;


import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
import Constant.MenuPage;

public class LogoutTest extends BaseTest{
	@Test
	public void TC06() {
		// Create Data Object
		UserInfo userInfo = new UserInfo(
				Constant.USERNAME, 
				Constant.PASSWORD, 
				Constant.PASSPORTID);
		
		// Expected Messages
	    String expectedTab = "Home";

	    // Main Test 
	    System.out.println("TC06: User is redirected to Home page after logging out");

	    System.out.println("1. Navigate to QA Railway Website");
	    HomePage homePage = new HomePage();
	    homePage.open();
	    
	    System.out.println("2. Login with valid Email and Password");
	    LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
	    loginPage.login(userInfo);

	    System.out.println("3. Enter username and password of account hasn't been activated.");
	    FAQPage faqPage = loginPage.goToPage(MenuPage.FAQ, FAQPage.class);

	    System.out.println("4. Click on \"Log out\" tab");
	    homePage = faqPage.goToPage(MenuPage.LOGOUT, HomePage.class);

	    String currentSelectedTab = homePage.getSelectedTabName();
	    
	    System.out.println("VP: Home page displays.\n"
	    		+ "VP: \"Log out\" tab is disappeared.");
	    Assert.assertEquals(
	        currentSelectedTab,
	        expectedTab,
	        "Current selected tab is not Home after logout"
	    );
	    
	    boolean isLogoutTabExist = homePage.isTabExist("Log out");
	    Assert.assertFalse(isLogoutTabExist, "Logout tab should not be displayed after logout");
	}
}
