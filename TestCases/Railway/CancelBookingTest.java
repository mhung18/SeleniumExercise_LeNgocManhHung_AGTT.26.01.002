package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import Constant.MenuPage;

public class CancelBookingTest extends BaseTest{
	@Test
	public void TC16() {
		TicketInfo ticketInfo = new TicketInfo(
				Constant.DEPARTDATE, 
				Constant.DEPARTSTATION, 
				Constant.ARRIVESTATION, 
				Constant.SEATTYPE, 
				Constant.TICKETAMOUNT);
		
		System.out.println("User can cancel a ticket");
		
		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		homePage = loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());

		System.out.println("3. Book a ticket");
		BookTicketPage bookTicketPage = bookTicket(ticketInfo);
		
		System.out.println("4. Click on \"My ticket\" tab");
		MyTicketPage myTicketPage = bookTicketPage.goToPage(MenuPage.MYTICKET, MyTicketPage.class);
		
		System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
		System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
		myTicketPage.cancelTicket(ticketInfo);
		
		System.out.println("VP: The canceled ticket is disappeared.");
		boolean isTicketExist = myTicketPage.checkIsTicketExist(ticketInfo);
		Assert.assertFalse(isTicketExist, "Ticket is not disappeared as expected");
	}
}
