package Railway;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
	@Test
	public void TC06() {
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
	    String expectedTab = "Home";
	    
	    System.out.println("Verify that Home page displays");
	    Assert.assertEquals(
	        currentSelectedTab,
	        expectedTab,
	        "Current selected tab is not Home after logout"
	    );

	    System.out.println("Verify that Logout tab is disappeared");
	    boolean isLogoutTabExist = homePageAfterLogout.isElementExist("Logout");
	    Assert.assertFalse(isLogoutTabExist, "Logout tab should not be displayed after logout");
	}

}
