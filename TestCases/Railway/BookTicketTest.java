package Railway;

import org.testng.annotations.Test;
import Constant.Constant;

public class BookTicketTest extends BaseTest{
	UserInfo userInfo = new UserInfo(
			Constant.USERNAME, 
			Constant.PASSWORD, 
			Constant.PASSPORTID);
	
	TicketInfo ticketInfo = new TicketInfo(
			Constant.DEPARTDATE, 
			Constant.DEPARTSTATION, 
			Constant.ARRIVESTATION, 
			Constant.SEATTYPE, 
			Constant.TICKETAMOUNT);
	
	@Test
	public void TCXX() throws InterruptedException {
		System.out.println("User can book a ticket");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.login(
				userInfo.getUserEmail(), 
				userInfo.getUserPassword()
		);
		
		homePage.goToBookTicketPage();
				
		BookTicketPage bookTicketPage = new BookTicketPage();
		bookTicketPage.bookNewTicket(
				ticketInfo.getDepartDate(), 
				ticketInfo.getDepartStation(), 
				ticketInfo.getArriveStattion(), 
				ticketInfo.getSeatType(), 
				ticketInfo.getTicketAmount()
		);
	}
}
