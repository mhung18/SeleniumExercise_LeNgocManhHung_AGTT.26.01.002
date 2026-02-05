package Railway;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
	@Test
	public void TC06() {
	    String expectedTab = "Home";

	    System.out.println("User is redirected to Home page after logging out");

	    System.out.println("1. Navigate to QA Railway Website");
	    HomePage homePage = new HomePage();
	    homePage.open();
	    
	    System.out.println("2. Login with valid Email and Password");
	    LoginPage loginPage = homePage.goToLoginPage();
	    loginPage.login(userInfo);

	    System.out.println("3. Enter username and password of account hasn't been activated.");
	    FAQPage faqPage = loginPage.goToFAQPage();

	    System.out.println("4. Click on \"Log out\" tab");
	    HomePage homePageAfterLogout = faqPage.goToLogoutPage();

	    String currentSelectedTab = homePageAfterLogout.getSelectedTabName();
	    
	    System.out.println("VP: Home page displays.\n"
	    		+ "VP: \"Log out\" tab is disappeared.");
	    Assert.assertEquals(
	        currentSelectedTab,
	        expectedTab,
	        "Current selected tab is not Home after logout"
	    );

	    boolean isLogoutTabExist = homePageAfterLogout.isTabExist("Logout");
	    Assert.assertFalse(isLogoutTabExist, "Logout tab should not be displayed after logout");
	}
}
