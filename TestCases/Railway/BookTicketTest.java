package Railway;

import org.testng.annotations.Test;
import Constant.Constant;
import Constant.MenuPage;

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
	public void TCXX() {
		System.out.println("User can book a ticket");
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		loginPage.login(
				userInfo.getUserEmail(), 
				userInfo.getUserPassword()
		);
		
		homePage.goToPage(MenuPage.BOOKTICKET, BookTicketPage.class);
				
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
